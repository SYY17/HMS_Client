package businesslogic.orderbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import businesslogicservice.ResultMessage;
import businesslogicservice.orderblservice.OrderBLService;
import dataservice.hoteldataservice.HotelDataService;
import dataservice.orderdataservice.OrderDataService;
import dataservice.userdataservice.UserDataService;
import po.OrderPO;
import vo.RoomType;
import rmi.RemoteController;
import vo.HotelVO;
import vo.OrderStatus;
import vo.OrderVO;
import vo.PromotionVO;

public class OrderController implements OrderBLService {
	RemoteController remoteController;
	OrderDataService orderDataService;
	UserDataService userDataService;
	HotelDataService hotelDataService;

	public OrderController() {
		remoteController = RemoteController.getInstance();
		orderDataService = remoteController.getOrderDataService();
		userDataService = remoteController.getUserDataService();
		hotelDataService = remoteController.getHotelDataService();
	}

	private OrderVO POToVO(OrderPO opo) {
		return new OrderVO(opo.getOrderID(), opo.getUserID(), opo.getHotelID(),
				OrderStatus.valueOf(opo.getOrderStatus().toString()), opo.getPrice(),
				RoomType.valueOf(opo.getRoomType().toString()), opo.getRoomNumber(), opo.getSetTime(), opo.getCheckIn(),
				opo.getCheckOut());
	}

	private ArrayList<OrderVO> getOrderByUserID(int id) throws RemoteException {
		ArrayList<OrderPO> listPO = orderDataService.findOrderByUserID(id);
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
	public ArrayList<OrderVO> reviewAbnormalOrder(int id) {
		ArrayList<OrderVO> list = new ArrayList<OrderVO>();
		try {
			list = getOrderByUserID(id);
			for (int i = 0; i < list.size(); i++) {
				if (list.get(i).getOrderStatus().toString().equals("Abnormal")) {
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
			orderDataService.deleteOrder(ovo.getOrderID());
			return ResultMessage.TRUE;
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.FALSE;
		}
	}

	@Override
	public OrderVO create(int userid, int hotelid, OrderStatus orderstatus, RoomType roomType, int roomNumber,
			PromotionVO pvo, Date settime, Date checkin, Date checkout) {
		return new OrderVO(0, userid, hotelid, OrderStatus.Unfilled, calculatePrice(roomType, roomNumber, pvo),
				roomType, roomNumber, settime, checkin, checkout);
	}

	private int calculatePrice(RoomType roomType, int roomNumber, PromotionVO pvo) {
		// TODO calculate the order price
		return 0;
	}

	@Override
	public ResultMessage addOrder(OrderVO ovo) {
		try {
			orderDataService.insertOrder(null);
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
			orderDataService.updateOrder(id, orderStatus);
			return ResultMessage.TRUE;
		} catch (RemoteException e) {
			e.printStackTrace();
			return ResultMessage.FALSE;
		}
	}

}
