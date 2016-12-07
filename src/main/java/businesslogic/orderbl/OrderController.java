package businesslogic.orderbl;

import java.rmi.RemoteException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

import businesslogic.creditbl.CreditInfoImpl;
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
		creditinfo = new CreditInfoImpl();
		hotelInfo = new HotelInfoForOrder();
		promotionInfo = new PromotionInfoForOrder();
		userInfo = new UserInfoForOrder();
	}

	private OrderVO POToVO(OrderPO opo) {
		return new OrderVO(opo.getOrderID(), opo.getUserName(), opo.getHotelName(),
				OrderStatus.valueOf(opo.getOrderStatus().toString()), opo.getPrice(),
				RoomType.valueOf(opo.getRoomType().toString()), opo.getRoomNumber(), opo.getSetTime(), opo.getCheckIn(),
				opo.getCheckOut());
	}

	/**
	 * 
	 * @param id
	 * @return 根据id返回相应订单
	 */
	private ArrayList<OrderVO> getOrderByUserID(int id) throws RemoteException {
		orderDataService.initOrderDataService();
		ArrayList<OrderPO> listPO = new ArrayList<OrderPO>();
		if (id >= 30000000) {
			listPO = orderDataService.findOrder();
		} else {
			String name = userInfo.searchByUserID(id);
			if (id >= 20000000) {
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
			list = getOrderByUserID(id);
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getOrderStatus().toString().equals(orderStatus.toString())) {
					list.remove(i);
					i--;
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
			Date checkIn, Date checkOut) {
		return new OrderVO(0, userName, hotelName, OrderStatus.Unfilled,
				promotionInfo.getFinalPrice(hotelName,setTime,hotelInfo.getPrice(hotelName, roomType)* roomNumber), roomType, roomNumber, setTime, checkIn,
				checkOut);
	}

	/**
	 * 
	 * @param ovo
	 * @return 取消订单
	 */
	@Override
	public ResultMessage cancelOrder(OrderVO ovo) {
		try {
			orderDataService.initOrderDataService();
			orderDataService.deleteOrder(ovo.getOrderID());
			orderDataService.finishOrderDataService();
			return ResultMessage.TRUE;
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.FALSE;
		}
	}

	/**
	 * 
	 * @param ovo
	 * @return 增加订单
	 */
	@Override
	public ResultMessage addOrder(OrderVO ovo) {
		try {
			orderDataService.initOrderDataService();
			orderDataService.insertOrder(null);
			orderDataService.finishOrderDataService();
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
	public ResultMessage complainOrder(int id, OrderStatus status) {
		po.OrderStatus orderStatus = po.OrderStatus.valueOf(status.toString());
		try {
			orderDataService.initOrderDataService();
			orderDataService.updateOrder(id, orderStatus);
			orderDataService.finishOrderDataService();
			return ResultMessage.TRUE;
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.FALSE;
		}
	}
	
	private int getOrderID(){
		return 0;
	}

	// public static void main(String[] args) {
	// try {
	// System.out.println(new
	// OrderController().getOrderByUserID(20905098).get(0).getUserID());
	// } catch (RemoteException e) {
	// // TODO Auto-generated catch block
	// e.printStackTrace();
	// }
	// }

}
