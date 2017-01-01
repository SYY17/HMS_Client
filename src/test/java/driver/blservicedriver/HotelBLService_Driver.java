//package driver.blservicedriver;
//
//import java.util.ArrayList;
//
//import businesslogicservice.ResultMessage;
//import businesslogicservice.hotelBLService.HotelBLService;
//import vo.HotelVO;
//
//public class HotelBLService_Driver {
//	
//	public void drive(HotelBLService hotelBLService){
//		String name = null;
//		String type = null;
//		
//		HotelVO hvo = new HotelVO(0, null, null, null, null, 0, 0, 0, null, false, 0, null);
//		ResultMessage result = hotelBLService.createHotel(hvo);
//		if(result == ResultMessage.TRUE) System.out.println("Hotel created!");
//		result = hotelBLService.deleteHotel(hvo);
//		if(result == ResultMessage.TRUE) System.out.println("Hotel deleted!");
//		result = hotelBLService.gradeHotel(hvo);
//		if(result == ResultMessage.TRUE) System.out.println("Hotel graded!");
//		result = hotelBLService.modifyHotel(hvo);
//		if(result == ResultMessage.TRUE) System.out.println("Hotel modified!");
//		ArrayList<HotelVO> hotelInfo = hotelBLService.reviewHotelInfo(name);
//		if(hotelInfo != null) System.out.println("Hotel Info got!");
//		ArrayList<HotelVO> hotelList = hotelBLService.reviewHotelList();
//		if(hotelList != null) System.out.println("Hotel List got!");
//		ArrayList<HotelVO> hotel = hotelBLService.searchHotel(name);
//		if(hotel != null) System.out.println("Hotel got!");
//		ArrayList<HotelVO> rooms = hotelBLService.searchRoom(type);
//		if(rooms != null) System.out.println("Rooms got!");
//	}
//}
