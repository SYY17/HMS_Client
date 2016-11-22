package presentation.hotelui;

import java.util.ArrayList;

import businesslogicservice.ResultMessage;
import businesslogicservice.hotelBLService.HotelBLService;
import vo.HotelVO;
import vo.RoomVO;

public class HotelBLService_Driver {
	public void drive(HotelBLService hotelBLService){
		String name = null;
		String type = null;
		int id = 0;
		ArrayList<RoomVO> rs = new ArrayList<RoomVO>();
		
		HotelVO hvo = new HotelVO(0, null, null, null, null, 0, 0, rs, 0, null, null);
		ResultMessage result = hotelBLService.createHotel(hvo);
		if(result == ResultMessage.TRUE) System.out.println("Hotel created!");
		result = hotelBLService.deleteHotel(id);
		if(result == ResultMessage.TRUE) System.out.println("Hotel deleted!");
		result = hotelBLService.gradeHotel(hvo);
		if(result == ResultMessage.TRUE) System.out.println("Hotel graded!");
		result = hotelBLService.modifyHotel(hvo);
		if(result == ResultMessage.TRUE) System.out.println("Hotel modified!");
		ArrayList<HotelVO> hotelInfo = hotelBLService.reviewHotelInfo(name);
		if(hotelInfo != null) System.out.println("hotel info got!");
		ArrayList<HotelVO> hotelList = hotelBLService.reviewHotelList();
		if(hotelList != null) System.out.println("hotel list got!");
		ArrayList<HotelVO> hotel = hotelBLService.searchHotel(name);
		if(hotel != null) System.out.println("hotel got!");
		ArrayList<RoomVO> rooms = hotelBLService.searchRoom(type);
		if(rooms != null) System.out.println("rooms got!");
	}
}
