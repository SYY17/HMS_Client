package businesslogic.orderbl;

import java.util.ArrayList;
import java.util.Date;
import businesslogicservice.ResultMessage;
import businesslogicservice.orderblservice.OrderBLService;
import businesslogictest.orderbl.MockHotel;
import businesslogictest.orderbl.MockUser;
import vo.HotelVO;
import vo.OrderStatus;
import vo.OrderVO;
import vo.PromotionVO;
import vo.RoomVO;

public class OrderBLService_Stub implements OrderBLService {
	int orderID;
	OrderStatus orderStatus;
	int price;
	int userID;
	Date setTime;
	Date checkIn;
	Date checkOut;
	int roomNumber;
	int hotelID;
	ArrayList<RoomVO> rooms;
	MockHotel mockHotel;
	MockUser mockUser;

	public OrderBLService_Stub(int orderID, OrderStatus status, int price, int userID, Date setTime, Date checkIn, Date checkOut, int roomNumber, int hotelID,
			ArrayList<RoomVO> rooms) {
		this.orderID = orderID;
		this.orderStatus = status;
		this.price = price;
		this.userID = userID;
		this.setTime = setTime;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.roomNumber = roomNumber;
		this.hotelID = hotelID;
		this.rooms = rooms;
	}

	/**
	 * 
	 * @param id
	 * @return 浏览全部订单
	 */
	@Override
	public ArrayList<OrderVO> reviewOrder(int id) {
		ArrayList<OrderVO> OrderVOList = new ArrayList<OrderVO>();
		OrderVOList.add(new OrderVO(orderID, orderStatus, price, userID, setTime, checkIn, checkOut, roomNumber,
				hotelID, rooms));
		return OrderVOList;
	}

	/**
	 * 
	 * @param id
	 * @return 浏览异常订单
	 */
	@Override
	public ArrayList<OrderVO> reviewAbnormalOrder(int id) {
		ArrayList<OrderVO> AbnormalOrderVOList = new ArrayList<OrderVO>();
		AbnormalOrderVOList.add(new OrderVO(orderID, orderStatus, price, userID, setTime, checkIn, checkOut, roomNumber,
				hotelID, rooms));
		return AbnormalOrderVOList;
	}

	/**
	 * 
	 * @param ovo
	 * @return 取消订单
	 */
	@Override
	public ResultMessage cancelOrder(OrderVO ovo) {
		if (ovo.getCheckInTime() == checkIn && ovo.getCheckOutTime() == checkOut && ovo.getHotelID() == hotelID
				&& ovo.getRoomNumber() == roomNumber && ovo.getRooms() == rooms && ovo.getSetTime() == setTime
				&& ovo.getUserID() == userID) {
			if ((mockHotel.modifyOrderList(0, null) == ResultMessage.TRUE)
					&& (mockUser.modifyOrderList(0, null) == ResultMessage.TRUE)) {
				return ResultMessage.TRUE;
			} else {
				return ResultMessage.FALSE;
			}
		} else {
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
		if (ovo.getUserID() != 00000000) {
			if ((mockHotel.modifyOrderList(0, null) == ResultMessage.TRUE)
					&& (mockUser.modifyOrderList(0, null) == ResultMessage.TRUE)) {
				return ResultMessage.TRUE;
			} else {
				return ResultMessage.FALSE;
			}
		} else {
			return ResultMessage.TRUE;
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
		if (id != 00000000) {
			return ResultMessage.FALSE;
		} else {
			if ((mockUser.modifyOrderList(0, null) == ResultMessage.TRUE)) {
				return ResultMessage.TRUE;
			} else {
				return ResultMessage.FALSE;
			}
		}
	}

	/**
	 * 
	 * @param hvo
	 * @param id
	 * @param pvo
	 * @return 创建订单
	 */
	@Override
	public OrderVO create(HotelVO hvo, int id, PromotionVO pvo) {
		return new OrderVO(orderID, orderStatus, price, userID, setTime, checkIn, checkOut, roomNumber, hotelID, rooms);
	}

}
