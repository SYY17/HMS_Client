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
import vo.CreditMovement;
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
				opo.getCheckOut(), opo.getDeadline(), opo.getPredictNumber(), opo.getHaveChild(), opo.getRoom());
	}

	private OrderPO VOToPO(OrderVO ovo) {
		return new OrderPO(ovo.getOrderID(), ovo.getUserName(), ovo.getHotelName(),
				po.OrderStatus.valueOf(ovo.getOrderStatus().toString()), ovo.getPrice(),
				po.RoomType.valueOf(ovo.getRoomType().toString()), ovo.getRoomNumber(), ovo.getSetTime(),
				ovo.getCheckIn(), ovo.getCheckOut(), ovo.getDeadline(), ovo.getPredictNumber(), ovo.getHaveChild(),
				ovo.getRoom());
	}

	/**
	 * 
	 * @param id
	 * @return 根据id返回相应订单
	 */
	private ArrayList<OrderVO> getOrderByUserID(int id) throws RemoteException {
		orderDataService.initOrderDataService();
		
		//创建存储订单的数据结构
		ArrayList<OrderPO> listPO = new ArrayList<OrderPO>();
		ArrayList<OrderPO> listTemp = new ArrayList<OrderPO>();
		listTemp = orderDataService.findOrder();
		
		//根据时间来触发订单状态转换
		for (int i = 0; i < listTemp.size(); i++) {
			OrderVO ovo = POToVO(orderDataService.findOrderByOrderID(listTemp.get(i).getOrderID()));
			if (System.currentTimeMillis() > ovo.getDeadline().getTime()
					&& ovo.getOrderStatus().toString().equals(OrderStatus.Unfilled.toString())) {
				changeOrderStatus(ovo.getOrderID(), OrderStatus.Abnormal, CreditMovement.AbnormalOrder);
			}
		}
		
		//对订单对应用户进行判断
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
		
		//po, vo转换
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
				//降低隐式访问耦合
				OrderVO ovo = listTemp.get(i);
				OrderStatus status = ovo.getOrderStatus();
				
				if (status.toString().equals(orderStatus.toString())) {
					list.add(ovo);
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
			//定义id, 减少隐式访问耦合
			int id = userInfo.searchByUserName(userName);
			if (creditinfo.getCreditByUserID(id) >= 0) {
				orderDataService.initOrderDataService();
				
				//listTemp用于存储订单信息
				int maxOrderID = 0;
				ArrayList<OrderPO> listTemp = orderDataService.findOrder();
				
				//获得当前最新的orderID
				for (int i = 0; i < listTemp.size(); i++) {
					//定义opo与orderID, 减少隐式访问耦合
					OrderPO opo = listTemp.get(i);
					int orderID = opo.getOrderID();
					
					if (maxOrderID < orderID) {
						maxOrderID = orderID;
					}
				}
				
				//创建订单ID为当前最新ID+1的新订单
				OrderVO ovoTemp = new OrderVO(maxOrderID + 1, userName, hotelName, OrderStatus.Unfilled,
						promotionInfo.getFinalPrice(userInfo.searchByUserName(userName), roomNumber, hotelName, setTime,
								hotelInfo.getPrice(hotelName, roomType) * roomNumber),
						roomType, roomNumber, setTime, checkIn, checkOut, deadline, predictNumber, haveChild, null);
				
				//利用抽象出的转换方法进行vo,po转换
				orderDataService.insertOrder(VOToPO(ovoTemp));
				orderDataService.finishOrderDataService();
				
				//返回创建出的订单信息
				return ovoTemp;
			}
		} catch (RemoteException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		return null;
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

	/**
	 * 
	 * @param id
	 * @param room
	 * @return 分配房间号
	 */
	@Override
	public ResultMessage assignRoom(int id, String room) {
		try {
			orderDataService.updateOrder(id, room);
			return ResultMessage.TRUE;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResultMessage.FALSE;
	}

	/**
	 * 
	 * @param cvo
	 * @param id
	 * @return 处理异常订单
	 */
	@Override
	public ResultMessage changeOrderStatus(int id, OrderStatus status, CreditMovement creditMovement) {
		po.OrderStatus orderStatus;
		if (status.toString().equals("HalfCanceled")) {
			orderStatus = po.OrderStatus.valueOf("Canceled");
		} else {
			orderStatus = po.OrderStatus.valueOf(status.toString());
		}

		try {
			orderDataService.initOrderDataService();
			orderDataService.updateOrder(id, orderStatus);
			
			//查找订单信息
			OrderVO ovo = POToVO(orderDataService.findOrderByOrderID(id));
			int userID = userInfo.searchByUserName(ovo.getUserName());

			//根据订单不同状态进行不同处理
			if (creditMovement.toString().equals(CreditMovement.AbnormalOrder.toString())) {
				
				//对异常订单的处理
				creditinfo.updateCreditByUserID(userID, (-1) * ovo.getPrice(), creditMovement);
			}else if (creditMovement.toString().equals(CreditMovement.CancelOrder.toString())) {
				
				//对未执行订单的处理
				if (ovo.getOrderStatus().toString().equals(OrderStatus.Unfilled.toString())) {
					
					if (ovo.getDeadline().getTime() - System.currentTimeMillis() < 6 * 1000 * 60 * 60) {
						
						creditinfo.updateCreditByUserID(userID, (-1) * ovo.getPrice() / 2, creditMovement);
					}
				}else if (ovo.getOrderStatus().toString().equals(OrderStatus.Abnormal.toString())) {
					if (orderStatus.toString().equals(OrderStatus.Canceled.toString())) {
						
						//对撤销订单的处理
						creditinfo.updateCreditByUserID(userID, ovo.getPrice(), creditMovement);
					}else if (orderStatus.toString().equals(OrderStatus.HalfCanceled.toString())) {
						
						creditinfo.updateCreditByUserID(userID, ovo.getPrice() / 2, creditMovement);
					}
				}
			}else if (creditMovement.toString().equals(CreditMovement.ExecuteOrder.toString())) {
				if (orderDataService.findOrderByOrderID(id).getOrderStatus().toString().equals(OrderStatus.Abnormal)) {
					
					//对已执行订单的处理
					creditinfo.updateCreditByUserID(userID, ovo.getPrice(), creditMovement);
				}
				creditinfo.updateCreditByUserID(userID, ovo.getPrice(), creditMovement);
			}

			orderDataService.finishOrderDataService();
			return ResultMessage.TRUE;
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.FALSE;
		}
	}

	public static void main(String[] args) throws RemoteException {
		System.out.println(new OrderController().reviewOrder(40000000).get(0).getUserName());
	}

}
