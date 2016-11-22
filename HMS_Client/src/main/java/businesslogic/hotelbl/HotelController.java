package businesslogic.hotelbl;

import java.util.ArrayList;

import businesslogicservice.ResultMessage;
import businesslogicservice.hotelBLService.HotelBLService;
import vo.HotelVO;
import vo.RoomVO;

public class HotelController implements HotelBLService{

	@Override
	public ArrayList<HotelVO> reviewHotelInfo(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<HotelVO> reviewHotelList() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage createHotel(HotelVO hvo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage deleteHotel(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage modifyHotel(HotelVO hvo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage gradeHotel(HotelVO hvo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<HotelVO> searchHotel(String name) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<RoomVO> searchRoom(String type) {
		// TODO Auto-generated method stub
		return null;
	}

}
