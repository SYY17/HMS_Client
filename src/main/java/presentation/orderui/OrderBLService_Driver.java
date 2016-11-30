package presentation.orderui;

import java.sql.Date;
import java.util.ArrayList;

import businesslogicservice.ResultMessage;
import businesslogicservice.orderblservice.OrderBLService;
import vo.HotelVO;
import vo.OrderStatus;
import vo.OrderVO;
import vo.PromotionVO;

public class OrderBLService_Driver {

	public void drive(OrderBLService orderBLService) {
		int orderID = 0;
		OrderStatus orderStatus = null;
		int userID = 0;
		Date checkOut = null;
		int roomNumber = 0;
		int hotelID = 0;
		OrderVO ovo=new OrderVO(hotelID, hotelID, hotelID, null, hotelID, null, hotelID, checkOut, checkOut, checkOut);
		new HotelVO(userID, null, null, null, null, roomNumber, 0, null, hotelID, null, null);
		PromotionVO pvo=new PromotionVO(null, null, 0);
		
		ArrayList<OrderVO> list=orderBLService.reviewOrder(userID);
		if (list != null) System.out.println("All Orders got!");
		ResultMessage result = orderBLService.cancelOrder(ovo);
		if (result == ResultMessage.TRUE) System.out.println("Order canceled!");
		OrderVO orderVO= orderBLService.create(hotelID, hotelID, orderStatus, null, hotelID, pvo, checkOut, checkOut, checkOut);
		if (orderVO != null) System.out.println("Order created!");
		result=orderBLService.addOrder(ovo);
		if (result == ResultMessage.TRUE) System.out.println("Order added!");
		result=orderBLService.complainOrder(orderID, orderStatus);
		if (result == ResultMessage.TRUE) System.out.println("Order complained!");
	}
}
