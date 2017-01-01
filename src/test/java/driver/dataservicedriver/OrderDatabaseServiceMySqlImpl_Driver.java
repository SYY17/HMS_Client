package driver.dataservicedriver;

import java.rmi.RemoteException;
import java.sql.Date;
import java.sql.Timestamp;

import dataservice.orderdataservice.OrderDataService;
import po.OrderPO;
import po.OrderStatus;
import po.RoomType;

public class OrderDatabaseServiceMySqlImpl_Driver {
	public void drive(OrderDataService orderDataService) throws RemoteException {
		OrderPO opo = new OrderPO(100, "user", "hotel", OrderStatus.Unfilled, 1000, RoomType.SINGLE_ROOM, 1,
				new Timestamp(System.currentTimeMillis()), new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24),
				new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 2),
				new Timestamp(System.currentTimeMillis() + 1000 * 60 * 60 * 24), 1, false, "123");
		orderDataService.initOrderDataService();
		System.out.println("Service start!");
		
		orderDataService.insertOrder(opo);
		System.out.println("Order inserted!");
		
		orderDataService.deleteOrder(100);
		System.out.println("Order deleted!");
		
		int size = orderDataService.findOrder().size();
		if (size != 0) {
			System.out.println("All Order got!");
		}
		
		size = orderDataService.findOrderByHotelName("hotel").size();
		if (size != 0) {
			System.out.println("Hotel Order got!");
		}
		
		int orderid = orderDataService.findOrderByOrderID(100).getOrderID();
		if (orderid == 100) {
			System.out.println("Order got!");
		}
		
		size = orderDataService.findOrderByUserName("user").size();
		if (size != 0) {
			System.out.println("User Order got!");
		}
		
		orderDataService.finishOrderDataService();
		System.out.println("Service finished!");
	}
}
