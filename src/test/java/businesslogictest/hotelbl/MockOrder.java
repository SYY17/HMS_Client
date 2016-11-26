package businesslogictest.hotelbl;

import java.util.Date;
import businesslogic.orderbl.OrderBLService_Stub;
import businesslogicservice.ResultMessage;
import vo.HotelVO;
import vo.OrderStatus;
import vo.RoomType;

public class MockOrder extends OrderBLService_Stub {

	public MockOrder(int orderID, OrderStatus orderStatus, int price, int userID, Date setTime, Date checkIn,
			Date checkOut, int roomNumber, int hotelID, RoomType roomType) {
		super(orderID, orderStatus, price, userID, setTime, checkIn, checkOut, roomNumber, hotelID, roomType);
	}

	public ResultMessage modifyHotelRoomList(int flag, HotelVO hotelVO) {
		return ResultMessage.TRUE;
	}

}