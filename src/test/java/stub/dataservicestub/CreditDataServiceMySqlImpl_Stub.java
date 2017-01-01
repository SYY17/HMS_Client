//package stub.dataservicestub;
//
//import java.rmi.RemoteException;
//
//import dataservice.creditdataservice.CreditDataService;
//import po.CreditPO;
//
//public class CreditDataServiceMySqlImpl_Stub implements CreditDataService{
//	int id = 0;
//	int credit = 0;
//	
//	@Override
//	public void insert(CreditPO cpo) throws RemoteException {
//		// TODO Auto-generated method stub
//		System.out.println("Insert Succeed!");
//	}
//	@Override
//	public void delete(int id) throws RemoteException {
//		// TODO Auto-generated method stub
//		System.out.println("Delete Succeed!");
//	}
//	@Override
//	public void update(CreditPO cpo) throws RemoteException {
//		// TODO Auto-generated method stub
//		System.out.println("Update Succeed!");
//	}
//	@Override
//	public CreditPO find(int id) throws RemoteException {
//		// TODO Auto-generated method stub
//		CreditPO Credit = new CreditPO(id, credit);
//		return Credit;
//	}
//	@Override
//	public void init() throws RemoteException {
//		// TODO Auto-generated method stub
//		System.out.println("Initialed!");
//	}
//	@Override
//	public void finish() throws RemoteException {
//		// TODO Auto-generated method stub
//		System.out.println("Finished!");
//	}
//}
