package businesslogic.orderbl;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import businesslogicservice.ResultMessage;
import businesslogicservice.orderblservice.OrderBLService;
import businesslogictest.orderbl.MockHotel;
import businesslogictest.orderbl.MockUser;
import vo.OrderStatus;
import vo.OrderVO;
import vo.PromotionVO;
import vo.RoomType;

public class OrderBLService_Stub implements OrderBLService {
	int orderID;
	OrderStatus orderStatus;
	int price;
	int userID;
	Timestamp setTime;
	Date checkIn;
	Date checkOut;
	int roomNumber;
	int hotelID;
	RoomType roomType;
	MockHotel mockHotel;
	MockUser mockUser;

	public OrderBLService_Stub(int orderID, OrderStatus status, int price, int userID, Timestamp setTime, Date checkIn,
			Date checkOut, int roomNumber, int hotelID, RoomType roomType) {
		this.orderID = orderID;
		this.orderStatus = status;
		this.price = price;
		this.userID = userID;
		this.setTime = setTime;
		this.checkIn = checkIn;
		this.checkOut = checkOut;
		this.roomNumber = roomNumber;
		this.hotelID = hotelID;
		this.roomType = roomType;
	}

	/**
	 * 
	 * @param id
	 * @return 浏览全部订单
	 */
	@Override
	public ArrayList<OrderVO> reviewOrder(int id) {
		ArrayList<OrderVO> OrderVOList = new ArrayList<OrderVO>();
		OrderVOList.add(new OrderVO(0, 0, 0, null, id, null, id, setTime, checkIn, checkIn));
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
		AbnormalOrderVOList.add(new OrderVO(id, id, id, null, id, null, id, setTime, checkIn, checkIn));
		return AbnormalOrderVOList;
	}

	/**
	 * 
	 * @param ovo
	 * @return 取消订单
	 */
	@Override
	public ResultMessage cancelOrder(OrderVO ovo) {
		if (ovo.getCheckIn() == checkIn && ovo.getCheckOut() == checkOut && ovo.getHotelID() == hotelID
				&& ovo.getRoomNumber() == roomNumber && ovo.getRoomType().toString().equals(roomType.toString())
				&& ovo.getSetTime() == setTime && ovo.getUserID() == userID) {
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
	public OrderVO create(int userid, int hotelid, OrderStatus orderstatus, RoomType rT, int rn, PromotionVO pvo,
			Timestamp s, Date ci, Date co) {
		// TODO Auto-generated method stub
		return null;
	}

}
