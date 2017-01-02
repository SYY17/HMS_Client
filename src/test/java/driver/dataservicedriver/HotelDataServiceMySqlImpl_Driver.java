package driver.dataservicedriver;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.hoteldataservice.HotelDataService;
import po.HotelPO;

public class HotelDataServiceMySqlImpl_Driver {
	
	public void drive(HotelDataService hotelDataService) throws RemoteException{
		int id = 20905110;
		String name = "hotel";
		HotelPO hpo = new HotelPO(id, name, "address", "area", "description", 5, 5.0, "staff", "110");
		String field = "workername";
		String value = "staff";
		ArrayList<HotelPO> hotelList = new ArrayList<HotelPO>(); 
		
		//初始化HotelDataService
		hotelDataService.initHotelDataService();
		System.out.println("HotelDataService initialized\n");
		
		//删除Hotel对象
		hotelDataService.deleteHotel(id);
		System.out.println("Hotel deleted\n");
		
		//插入Hotel对象
		hotelDataService.insertHotel(hpo);
		System.out.println("Hotel inserted\n");
		
		//更新Hotel对象
		hotelDataService.updateHotel(hpo);
		System.out.println("Hotel updated\n");
		
		//按酒店名查找Hotel对象
		hpo = hotelDataService.findHotel(name);
		if(hpo != null) System.out.println("Hotel found\n");
		
		//查找所有Hotel对象
		hotelList = hotelDataService.findsHotel();
		if(hotelList != null) System.out.println("Hotels found\n");
		
		//根据范围和值查找Hotel对象
		hotelList = hotelDataService.findsHotel(field, value);
		if(hotelList != null) System.out.println("Hotels found\n");
		
		//结束HotelDataService
		hotelDataService.finishHotelDataService();
		System.out.println("HotelDataService finished\n");
	}
}
