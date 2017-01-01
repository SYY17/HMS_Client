//package stub.dataservicestub;
//
//import java.rmi.RemoteException;
//import java.util.ArrayList;
//
//import dataservice.hoteldataservice.HotelDataService;
//import po.HotelPO;
//
//public class HotelDataServiceMySqlImpl_Stub implements HotelDataService{
//
//	@Override
//	public void delete(HotelPO hpo) throws RemoteException {
//		// TODO Auto-generated method stub
//		System.out.println("Delete Succeeded!");
//	}
//
//	@Override
//	public void insert(HotelPO hpo) throws RemoteException {
//		// TODO Auto-generated method stub
//		System.out.println("Insert Succeeded!");
//	}
//
//	@Override
//	public void update(HotelPO hpo) throws RemoteException {
//		// TODO Auto-generated method stub
//		System.out.println("Update Succeeded!");
//	}
//
//	@Override
//	public HotelPO find(String name) throws RemoteException {
//		// TODO Auto-generated method stub
//		HotelPO hotel = new HotelPO(0, name, name, name, name, 0, 0, 0, name, false, 0, null);
//		return hotel;
//	}
//
//	@Override
//	public void init() throws RemoteException {
//		// TODO Auto-generated method stub
//		System.out.println("Initialed!");
//	}
//
//	@Override
//	public void finish() throws RemoteException {
//		// TODO Auto-generated method stub
//		System.out.println("Finished!");
//	}
//
//	@Override
//	public ArrayList<HotelPO> finds(String field, String value) throws RemoteException {
//		// TODO Auto-generated method stub
//		ArrayList<HotelPO> hotelList = new ArrayList<HotelPO>();
//		return hotelList;
//	}
//
//	@Override
//	public ArrayList<HotelPO> finds() throws RemoteException {
//		// TODO Auto-generated method stub
//		ArrayList<HotelPO> hotelList = new ArrayList<HotelPO>();
//		return hotelList;
//	}
//
//}
