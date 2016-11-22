package businesslogic.hotelbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import dataservice.hoteldataservice.HotelDataService;
import po.HotelPO;

public class HotelDataService_Driver {
	
	public void drive(HotelDataService hotelDataService) throws RemoteException{
		HotelPO hpo = new HotelPO(0, null, null, null, null, 0, 0, null, 0, null, null);
		String name = null;
		String field = null;
		String value = null;
		int id = 0;
		ArrayList<HotelPO> hotelList = new ArrayList<HotelPO>(); 
		
		hotelDataService.initHotelDataService();
		hotelDataService.insertHotel(hpo);
		hotelDataService.updateHotel(hpo);
		hotelDataService.deleteHotel(id);
		hpo = hotelDataService.findHotel(name);
		if(hpo != null) {
			System.out.println("Hotel found!");
		}
		hotelList = hotelDataService.findsHotel();
		if(hotelList != null) {
			System.out.println("Hotels found!");
		}
		hotelList = hotelDataService.findsHotel(field, value);
		if(hotelList != null) {
			System.out.println("Hotels found!");
		}
		hotelDataService.finishHotelDataService();
	}
}
