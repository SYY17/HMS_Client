//package driver.dataservicedriver;
//
//import java.rmi.RemoteException;
//import java.util.ArrayList;
//
//import dataservice.hoteldataservice.HotelDataService;
//import po.HotelPO;
//
//public class HotelDataServiceMySqlImpl_Driver {
//	
//	public void drive(HotelDataService hotelDataService) throws RemoteException{
//		HotelPO hpo = new HotelPO(0, null, null, null, null, 0, 0, 0, null, false, 0, null);
//		String name = null;
//		String field = null;
//		String value = null;
//		ArrayList<HotelPO> hotelList = new ArrayList<HotelPO>(); 
//		
//		hotelDataService.init();
//		hotelDataService.insert(hpo);
//		hotelDataService.update(hpo);
//		hotelDataService.delete(hpo);
//		hpo = hotelDataService.find(name);
//		if(hpo != null) {
//			System.out.println("Hotel found!");
//		}
//		hotelList = hotelDataService.finds();
//		if(hotelList != null) {
//			System.out.println("Hotels found!");
//		}
//		hotelList = hotelDataService.finds(field, value);
//		if(hotelList != null) {
//			System.out.println("Hotels found!");
//		}
//		hotelDataService.finish();
//	}
//}
