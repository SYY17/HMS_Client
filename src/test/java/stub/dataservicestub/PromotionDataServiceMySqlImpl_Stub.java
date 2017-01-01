//package stub.dataservicestub;
//
//import java.rmi.RemoteException;
//import java.util.ArrayList;
//import java.util.Date;
//
//import dataservice.promotiondataservice.PromotionDataService;
//import po.PromotionPO;
//
//public class PromotionDataServiceMySqlImpl_Stub implements PromotionDataService{
//	String content = "";
//	Date start = null;
//	int id = 0;
//	
//	@Override
//	public ArrayList <PromotionPO> finds() throws RemoteException {
//		// TODO Auto-generated method stub
//		ArrayList <PromotionPO> list = new ArrayList<>();
//		PromotionPO promotion = new PromotionPO(content, start, id);
//		list.add(promotion);
//		return list;
//	}
//	
//	@Override
//	public ArrayList <PromotionPO> finds(Date start) throws RemoteException {
//		// TODO Auto-generated method stub
//		ArrayList <PromotionPO> list = new ArrayList<>();
//		PromotionPO promotion = new PromotionPO(content, start, id);
//		list.add(promotion);
//		return list;
//	}
//
//	@Override
//	public ArrayList <PromotionPO> finds(String content) throws RemoteException {
//		// TODO Auto-generated method stub
//		ArrayList <PromotionPO> list = new ArrayList<>();
//		PromotionPO promotion = new PromotionPO(content, start, id);
//		list.add(promotion);
//		return list;
//	}
//
//	@Override
//	public void insert(PromotionPO ppo) throws RemoteException {
//		// TODO Auto-generated method stub
//		System.out.println("Insert Succeed!");
//	}
//
//	@Override
//	public void delete(PromotionPO ppo) throws RemoteException {
//		// TODO Auto-generated method stub
//		System.out.println("Delete Succeed!");
//	}
//
//	@Override
//	public void update(PromotionPO ppo) throws RemoteException {
//		// TODO Auto-generated method stub
//		System.out.println("Update Succeed!");
//	}
//
//	@Override
//	public void init() throws RemoteException {
//		// TODO Auto-generated method stub
//		System.out.println("Initialed!");
//		
//	}
//
//	@Override
//	public void finish() throws RemoteException {
//		// TODO Auto-generated method stub
//		System.out.println("Finished!");
//	}
//
//}
