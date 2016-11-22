package businesslogic.orderbl;

import java.rmi.RemoteException;
import dataservice.orderdataservice.OrderDataService;
import po.OrderPO;
import po.OrderStatus;

public class OrderDataService_Driver {
	public void drive(OrderDataService orderDatabaseService) throws RemoteException {
		OrderPO opo = new OrderPO(0, null, 0, 0, null, null, null, 0, 0, null);
		int id = 0;
		OrderStatus status = OrderStatus.Unfilled;
		orderDatabaseService.initOrderDataService();
		orderDatabaseService.finishOrderDataService();
		orderDatabaseService.deleteOrder(id);
		OrderPO orderPO = orderDatabaseService.findOrder(0);
		if (orderPO != null) {
			System.out.println("Order got!");
		}
		orderDatabaseService.insertOrder(opo);
		orderDatabaseService.updateOrder(id, status);
	}
}
