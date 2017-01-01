//package driver.dataservicedriver;
//
//import java.rmi.RemoteException;
//import dataservice.orderdataservice.OrderDataService;
//import po.OrderPO;
//
//public class OrderDatabaseServiceMySqlImpl_Driver {
//	public void drive(OrderDataService orderDataService) throws RemoteException {
//		OrderPO opo = new OrderPO(0, null, null, null, 0, 0, null);
//		orderDataService.init();
//		orderDataService.finish();
//		orderDataService.delete(opo);
//		OrderPO orderPO = orderDataService.find(0);
//		if (orderPO != null) {
//			System.out.println("Order got!");
//		}
//		orderDataService.insert(opo);
//		orderDataService.upate(opo);
//	}
//}
