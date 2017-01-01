package driver.blservicedriver;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.sql.Date;

import businesslogicservice.ResultMessage;
import businesslogicservice.orderblservice.OrderBLService;
import vo.CreditMovement;
import vo.OrderStatus;
import vo.OrderVO;
import vo.RoomType;

public class OrderBLService_Driver {

	public void drive(OrderBLService orderBLService) {
		int orderID;
		OrderStatus orderStatus;
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

		orderID = 1;
		orderStatus = OrderStatus.Unfilled;
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

		OrderVO orderVO = orderBLService.create(userName, hotelName, roomType, roomNumber, setTime, checkIn, checkOut,
				deadline, predictNumber, haveChild);
		if (orderVO != null) {
			System.out.println("Order created!");
		}
		ArrayList<OrderVO> list = orderBLService.reviewOrder(userID);
		if (list != null) {
			System.out.println("All Orders got!");
		}
		list = orderBLService.reviewOrder(userID,OrderStatus.Unfilled);
		if (list != null) {
			System.out.println("Unfilled Orders got!");
		}
		ResultMessage result = orderBLService.assignRoom(orderID, "124");
		if (result == ResultMessage.TRUE) {
			System.out.println("Room assigned!");
		}
		result = orderBLService.changeOrderStatus(orderID, orderStatus, CreditMovement.AbnormalOrder);
		if (result == ResultMessage.TRUE) {
			System.out.println("Orderstatus changed!");
		}
		result = orderBLService.cancelOrder(orderID);
		if (result == ResultMessage.TRUE) {
			System.out.println("Order canceled!");
		}
	}
}
