package businesslogic.orderbl;

import java.rmi.RemoteException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

import businesslogic.creditbl.CreditInfoForOrder;
import businesslogic.hotelbl.HotelInfoForOrder;
import businesslogic.promotionbl.PromotionInfoForOrder;
import businesslogic.userbl.UserInfoForOrder;
import businesslogicservice.ResultMessage;
import businesslogicservice.orderblservice.OrderBLService;
import dataservice.orderdataservice.OrderDataService;
import po.OrderPO;
import vo.RoomType;
import rmi.RemoteController;
import runner.DataServiceClientRunner;
import vo.OrderStatus;
import vo.OrderVO;

public class OrderController implements OrderBLService {
	RemoteController remoteController;
	OrderDataService orderDataService;
	CreditInfo creditinfo;
	HotelInfo hotelInfo;
	PromotionInfo promotionInfo;
	UserInfo userInfo;

	public OrderController() {
		DataServiceClientRunner runner = new DataServiceClientRunner();
		runner.start();
		remoteController = runner.getRemoteController();
		orderDataService = remoteController.getOrderDataService();
		creditinfo = new CreditInfoForOrder();
		hotelInfo = new HotelInfoForOrder();
		promotionInfo = new PromotionInfoForOrder();
		userInfo = new UserInfoForOrder();
	}

	private OrderVO POToVO(OrderPO opo) {
		return new OrderVO(opo.getOrderID(), opo.getUserName(), opo.getHotelName(),
				OrderStatus.valueOf(opo.getOrderStatus().toString()), opo.getPrice(),
				RoomType.valueOf(opo.getRoomType().toString()), opo.getRoomNumber(), opo.getSetTime(), opo.getCheckIn(),
				opo.getCheckOut(), opo.getDeadline(), opo.getPredictNumber(), opo.getHaveChild());
	}

	private OrderPO VOToPO(OrderVO ovo) {
		return new OrderPO(ovo.getOrderID(), ovo.getUserName(), ovo.getHotelName(),
				po.OrderStatus.valueOf(ovo.getOrderStatus().toString()), ovo.getPrice(),
				po.RoomType.valueOf(ovo.getRoomType().toString()), ovo.getRoomNumber(), ovo.getSetTime(),
				ovo.getCheckIn(), ovo.getCheckOut(), ovo.getDeadline(), ovo.getPredictNumber(), ovo.getHaveChild());
	}

	/**
	 * 
	 * @param id
	 * @return 根据id返回相应订单
	 */
	private ArrayList<OrderVO> getOrderByUserID(int id) throws RemoteException {
		orderDataService.initOrderDataService();
		ArrayList<OrderPO> listPO = new ArrayList<OrderPO>();
		ArrayList<OrderPO> listTemp = new ArrayList<OrderPO>();
		listTemp = orderDataService.findOrder();
		for (int i = 0; i < listTemp.size(); i++) {
			checkAbnormal(listTemp.get(i).getOrderID());
		}
		if (id >= 30000000) {
			listPO = orderDataService.findOrder();
		} else {
			String name = userInfo.searchByUserID(id);
			if (id < 20000000) {
				listPO = orderDataService.findOrderByUserName(name);
			} else {
				listPO = orderDataService.findOrderByHotelName(name);
			}
		}

		orderDataService.finishOrderDataService();
		ArrayList<OrderVO> listVO = new ArrayList<OrderVO>();
		for (int i = 0; i < listPO.size(); i++) {
			listVO.add(POToVO(listPO.get(i)));
		}
		return listVO;
	}

	/**
	 * 
	 * @param id
	 * @return 浏览全部订单
	 */
	@Override
	public ArrayList<OrderVO> reviewOrder(int id) {
		ArrayList<OrderVO> list = new ArrayList<OrderVO>();
		try {
			list = getOrderByUserID(id);
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 
	 * @param id,orderStatus
	 * @return 浏览相应状态的订单
	 */
	@Override
	public ArrayList<OrderVO> reviewOrder(int id, OrderStatus orderStatus) {
		ArrayList<OrderVO> list = new ArrayList<OrderVO>();
		try {
			ArrayList<OrderVO> listTemp = getOrderByUserID(id);
			for (int i = 0; i < listTemp.size(); i++) {
				if (listTemp.get(i).getOrderStatus().toString().equals(orderStatus.toString())) {
					list.add(listTemp.get(i));
				}
			}
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 
	 * @param userName,hotelName,roomType,roomNumber,setTime,checkIn,checkOut
	 * @param id
	 * @param pvo
	 * @return 创建订单
	 */
	@Override
	public OrderVO create(String userName, String hotelName, RoomType roomType, int roomNumber, Timestamp setTime,
			Date checkIn, Date checkOut, Timestamp deadline, int predictNumber, boolean haveChild) {
		try {
			orderDataService.initOrderDataService();
			boolean mark = true;
			int maxOrderID = 0;
			ArrayList<OrderPO> list = new ArrayList<OrderPO>();
			ArrayList<OrderPO> listTemp = new ArrayList<OrderPO>();
			listTemp = orderDataService.findOrder();
			list = orderDataService.findOrderByHotelName(hotelName);
			for (int i = 0; i < listTemp.size(); i++) {
				if (maxOrderID < listTemp.get(i).getOrderID()) {
					maxOrderID = listTemp.get(i).getOrderID();
				}
			}
			for (int i = 0; i < list.size(); i++) {
				if (conflictTime(list.get(i), checkIn, checkOut)) {
					mark = false;
					break;
				}
			}
			if (mark) {
				OrderVO ovoTemp = new OrderVO(maxOrderID + 1, userName, hotelName, OrderStatus.Unfilled,
						/*
						 * promotionInfo.getFinalPrice(hotelName, setTime,
						 * hotelInfo.getPrice(hotelName, roomType) * roomNumber)
						 */1, roomType, roomNumber, setTime, checkIn, checkOut, deadline, predictNumber, haveChild);
				orderDataService.insertOrder(VOToPO(ovoTemp));
				return ovoTemp;
			}
			orderDataService.finishOrderDataService();
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return null;
	}

	// TODO finish the method
	private boolean conflictTime(OrderPO orderPO, Date checkIn, Date checkOut) {
		boolean mark = false;
		return mark;
	}

	/**
	 * 
	 * @param ovo
	 * @return 取消订单
	 */
	@Override
	public ResultMessage cancelOrder(int id) {
		try {
			orderDataService.initOrderDataService();
			orderDataService.deleteOrder(id);
			orderDataService.finishOrderDataService();
			return ResultMessage.TRUE;
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.FALSE;
		}
	}

	private ResultMessage checkAbnormal(int id) {
		try {
			OrderVO ovo = POToVO(orderDataService.findOrderByOrderID(id));
			if (System.currentTimeMillis() > ovo.getDeadline().getTime()) {
				changeOrderStatus(id, OrderStatus.Abnormal);
			}
			return ResultMessage.TRUE;
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.FALSE;
		}
	}

	/**
	 * 
	 * @param cvo
	 * @param id
	 * @return 处理异常订单
	 */
	@Override
	public ResultMessage changeOrderStatus(int id, OrderStatus status) {
		po.OrderStatus orderStatus = po.OrderStatus.valueOf(status.toString());
		try {
			orderDataService.initOrderDataService();
			orderDataService.updateOrder(id, orderStatus);
			OrderVO ovo = POToVO(orderDataService.findOrderByOrderID(id));
			int userID = userInfo.searchByUserName(ovo.getUserName());
			if (orderStatus.toString().equals(OrderStatus.Canceled.toString())) {
				if (ovo.getDeadline().getTime() - System.currentTimeMillis() < 6 * 1000 * 60 * 60) {
					creditinfo.updateCreditByUserID(userID, (-1) * ovo.getPrice() / 2);
				}
			} else if (orderStatus.toString().equals(OrderStatus.Abnormal.toString())) {
				creditinfo.updateCreditByUserID(userID, (-1) * ovo.getPrice());
			} else if (orderStatus.toString().equals(OrderStatus.Finished.toString())) {
				if (orderDataService.findOrderByOrderID(id).getOrderStatus().toString().equals(OrderStatus.Abnormal)) {
					creditinfo.updateCreditByUserID(userID, ovo.getPrice());
				}
				creditinfo.updateCreditByUserID(userID, ovo.getPrice());
			}
			orderDataService.finishOrderDataService();
			return ResultMessage.TRUE;
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.FALSE;
		}
	}

	public static void main(String[] args) {
		try {
			System.out.println(new OrderController().getOrderByUserID(21214001).get(0).getUserName());
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

}
