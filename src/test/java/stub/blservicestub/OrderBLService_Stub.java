package stub.blservicestub;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

import businesslogicservice.ResultMessage;
import businesslogicservice.orderblservice.OrderBLService;
import vo.CreditMovement;
import vo.OrderStatus;
import vo.OrderVO;
import vo.RoomType;

public class OrderBLService_Stub implements OrderBLService {
	int orderID;
	OrderStatus orderStatus;
	int price;
	String userName;
	int userID;
	Timestamp setTime;
	Date checkIn;
	Date checkOut;
	int roomNumber;
	String hotelName;
	RoomType roomType;
	Timestamp deadline;
	int predictNumber;
	boolean haveChild;
	String room;

	public OrderBLService_Stub() {
		orderID = 1;
		orderStatus = OrderStatus.Unfilled;
		price = 1000;
		userName = "user";
		userID = 10101001;
		setTime = new Timestamp(System.currentTimeMillis());
		checkIn = new Date(setTime.getTime() + 1000 * 60 * 60 * 24 * 3);
		checkOut = new Date(setTime.getTime() + 1000 * 60 * 60 * 24 * 4);
		roomNumber = 1;
		hotelName = "hotel";
		roomType = RoomType.SINGLE_ROOM;
		deadline = new Timestamp(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 3);
		predictNumber = 1;
		haveChild = false;
		room = "123";
	}

	/**
	 * 添加用户
	 */
	@Override
	public ArrayList<OrderVO> reviewOrder(int id, OrderStatus orderStatus) {
		ArrayList<OrderVO> list = new ArrayList<OrderVO>();
		if (id == 10101001 && orderStatus.toString().equals(OrderStatus.Unfilled.toString())) {
			list.add(new OrderVO(orderID, userName, hotelName, orderStatus, price, roomType, roomNumber, setTime,
					checkIn, checkOut, deadline, predictNumber, haveChild, room));
		}
		return list;
	}

	/**
	 * 删除订单
	 */
	@Override
	public ResultMessage cancelOrder(int id) {
		if (id == 100) {
			return ResultMessage.TRUE;
		}
		return ResultMessage.FALSE;
	}

	/**
	 * 创建订单
	 */
	@Override
	public OrderVO create(String userName, String hotelName, RoomType roomType, int roomNumber, Timestamp setTime,
			java.sql.Date checkIn, java.sql.Date checkOut, Timestamp deadline, int predictNumber, boolean haveChild) {
		return new OrderVO(100, userName, hotelName, OrderStatus.Unfilled, 1000, roomType, roomNumber, setTime, checkIn,
				checkOut, deadline, predictNumber, haveChild, "");
	}

	/**
	 * 改变订单状态
	 */
	@Override
	public ResultMessage changeOrderStatus(int id, OrderStatus status, CreditMovement creditMovement) {
		if (id == 100) {
			orderStatus = status;
			return ResultMessage.TRUE;
		}
		return ResultMessage.FALSE;
	}

	/**
	 * 分配房间
	 */
	@Override
	public ResultMessage assignRoom(int id, String room) {
		if (id == 100) {
			this.room = room;
			return ResultMessage.TRUE;
		}
		return ResultMessage.FALSE;
	}

	/**
	 * 浏览订单列表
	 */
	@Override
	public ArrayList<OrderVO> reviewOrder(int id) {
		ArrayList<OrderVO> list = new ArrayList<OrderVO>();
		if (id == 10101001) {
			list.add(new OrderVO(orderID, userName, hotelName, orderStatus, price, roomType, roomNumber, setTime,
					checkIn, checkOut, deadline, predictNumber, haveChild, room));
		}
		return list;
	}

}
