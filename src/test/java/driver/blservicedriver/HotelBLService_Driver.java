package driver.blservicedriver;

import java.util.ArrayList;

import businesslogicservice.ResultMessage;
import businesslogicservice.hotelBLService.HotelBLService;
import po.RoomType;
import vo.HotelVO;
import vo.RoomVO;

public class HotelBLService_Driver {
	
	public void drive(HotelBLService hotelBLService){
		String name = "hotel";
		int id = 20905110;
		RoomType type = RoomType.SUITE;
		HotelVO hvo = new HotelVO(id, name, "address", "area", "description", 5, 5.0, "staff", "110");
		RoomVO rvo = new RoomVO(id, vo.RoomType.SUITE, 20, 20, 300);
		
		//添加酒店
		ResultMessage result = hotelBLService.createHotel(hvo);
		if(result == ResultMessage.TRUE) System.out.println("Hotel created\n");
		
		//通过全名查看酒店信息
		HotelVO hotelInfo = hotelBLService.reviewHotelInfo(name);
		if(hotelInfo != null) System.out.println("Hotel Info got!\n");
		
		//通过id查找酒店
		HotelVO hotel = hotelBLService.searchHotelByID(id);
		if(hotel != null) System.out.println("Hotel got\n");
			
		//查找所有酒店
		ArrayList<HotelVO> hotelList = hotelBLService.reviewHotelList();
		if(hotelList != null) System.out.println("Hotels got\n");
		
		//评价酒店
		result = hotelBLService.gradeHotel(hvo);
		if(result == ResultMessage.TRUE) System.out.println("Hotel graded\n");
		
		//修改酒店
		result = hotelBLService.modifyHotel(hvo);
		if(result == ResultMessage.TRUE) System.out.println("Hotel modified\n");
		
		//通过名称查找酒店
		hotelList = hotelBLService.searchHotel(name);
		if(hotelList != null) System.out.println("Hotel List got\n");
		
		//按类型搜索房间
		RoomVO room = hotelBLService.searchRoom(id, type);
		if(room != null) System.out.println("Room got\n");
		
		//修改房间
		result = hotelBLService.ModifyRoom(rvo);
		if(result == ResultMessage.TRUE) System.out.println("Room Modified\n");
		
		//搜索房间
		ArrayList<RoomVO> rooms = hotelBLService.SearchRooms(id);
		if(rooms != null) System.out.println("Rooms got\n");
		
		//删除酒店
		result = hotelBLService.deleteHotel(id);
		if(result == ResultMessage.TRUE) System.out.println("Hotel deleted!");
	}
}
