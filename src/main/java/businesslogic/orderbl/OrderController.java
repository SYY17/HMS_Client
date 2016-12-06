package businesslogic.orderbl;

import java.rmi.RemoteException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

import businesslogic.creditbl.CreditInfoImpl;
import businesslogic.hotelbl.HotelInfoImpl;
import businesslogic.promotionbl.PromotionInfoImpl;
import businesslogic.userbl.UserInfoImpl;
import businesslogicservice.ResultMessage;
import businesslogicservice.orderblservice.OrderBLService;
import dataservice.orderdataservice.OrderDataService;
import po.OrderPO;
import vo.RoomType;
import rmi.RemoteController;
import runner.DataServiceClientRunner;
import vo.OrderStatus;
import vo.OrderVO;
import vo.PromotionVO;

public class OrderController implements OrderBLService {
	RemoteController remoteController;
	OrderDataService orderDataService;
	CreditInfo creditinfo;
	HotelInfo hotelInfo;
	PromotionInfo promotionInfo;
	UserInfo userInfo;
	// UserDataService userDataService;
	// HotelDataService hotelDataService;

	public OrderController() {
		DataServiceClientRunner runner = new DataServiceClientRunner();
		runner.start();
		remoteController = runner.getRemoteController();
		orderDataService = remoteController.getOrderDataService();
		creditinfo = new CreditInfoImpl();
		hotelInfo = new HotelInfoImpl();
		promotionInfo = new PromotionInfoImpl();
		userInfo = new UserInfoImpl();
	}

	private OrderVO POToVO(OrderPO opo) {
		return new OrderVO(opo.getOrderID(), opo.getUserName(), opo.getHotelName(),
				OrderStatus.valueOf(opo.getOrderStatus().toString()), opo.getPrice(),
				RoomType.valueOf(opo.getRoomType().toString()), opo.getRoomNumber(), opo.getSetTime(), opo.getCheckIn(),
				opo.getCheckOut());
	}

	private ArrayList<OrderVO> getOrderByUserID(int id) throws RemoteException {
		orderDataService.initOrderDataService();
		ArrayList<OrderPO> listPO = new ArrayList<OrderPO>();
		if (id >= 30000000) {
			
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

	@Override
	public OrderVO create(String username, String hotelname, OrderStatus orderstatus, RoomType roomtype, int roomNumber,
			PromotionVO pvo, Timestamp settime, Date checkin, Date checkout) {
		return new OrderVO(0, username, hotelname, OrderStatus.Unfilled, calculatePrice(roomtype, roomNumber, pvo),
				roomtype, roomNumber, settime, checkin, checkout);
	}

	private int calculatePrice(RoomType roomType, int roomNumber, PromotionVO pvo) {
		// TODO calculate the order price
		return 0;
	}

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
