package presentation.userui.user;

import vo.HotelVO;
import vo.RoomType;
public class HotelDataHelper {
	
	public HotelData toHotelData(HotelVO hvo) {
		return new HotelData(RoomType.KING_SIZE_ROOM, 50, 30,"brief", 200);
	}

}
