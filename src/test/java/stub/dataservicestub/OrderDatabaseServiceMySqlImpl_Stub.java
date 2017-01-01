//package stub.dataservicestub;
//
//import java.rmi.RemoteException;
//
//import dataservice.orderdataservice.OrderDataService;
//import po.OrderPO;
//
//public class OrderDatabaseServiceMySqlImpl_Stub implements OrderDataService{
//
//	@Override
//	public void insert(OrderPO po)  throws RemoteException {
//		System.out.println("Insert Succeed!");		
//	}
//
//	@Override
//	public void delete(OrderPO po)  throws RemoteException {
//		System.out.println("Delete Succeed!");	
//	}
//
//	@Override
//	public void upate(OrderPO po)  throws RemoteException {
//		System.out.println("Update Succeed!");	
//	}
//
//	@Override
//	public OrderPO find(int id)  throws RemoteException {
//		System.out.println("find Succeed!");
//		OrderPO opo=new OrderPO(id, null, null, null, id, id, null);
//		return opo;
//	}
//
//	@Override
//	public void init() throws RemoteException {
//		System.out.println("Initialed!");
//	}
//
//	@Override
//	public void finish() throws RemoteException {
//		System.out.println("Finished!");
//	}
//
//}
