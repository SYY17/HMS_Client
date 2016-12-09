package businesslogic.hotelbl;

import businesslogic.orderbl.HotelInfo;
import businesslogicservice.hotelBLService.HotelBLService;
import vo.HotelVO;
import vo.RoomType;
import vo.RoomVO;

public class HotelInfoForOrder implements HotelInfo {

	HotelBLService hotelController;

	/**
	 * 
	 * @param hotelName,roomType
	 * @return 查询房间价格
	 */
	public int getPrice(String hotelName, RoomType roomType) {
		HotelVO hvo = hotelController.reviewHotelInfo(hotelName);
		RoomVO room = hotelController.searchRoom(hvo.getHotelID(), po.RoomType.valueOf(roomType.toString()));
		int price = room.getPrice();

		return price;
	}

	/**
	 * 
	 * @param hotelName,roomType,changedRoomNum
	 * @return 更新房间入住信息(changedRoomNum为正时，表示用户离开，房间数变多；为负时表示用户入住，房间数变少)
	 */
	@Override
	public void updateRoomInfo(String hotelName, RoomType roomType, int changedRoomNum) {
		// TODO Auto-generated method stub
		HotelVO hvo = hotelController.reviewHotelInfo(hotelName);
		RoomVO room = hotelController.searchRoom(hvo.getHotelID(), po.RoomType.valueOf(roomType.toString()));
		RoomVO rvo = new RoomVO(room.getHotelID(), roomType, room.getTotalSum(), room.getRemainSum() + changedRoomNum,
				room.getPrice());
		hotelController.ModifyRoom(rvo);
	}

	/**
	 * 
	 * @param hotelName,roomType
	 * @return 查询酒店特定房间的剩余数量
	 */
	@Override
	public int getRoomNum(String hotelName, RoomType roomType) {
		// TODO Auto-generated method stub
		HotelVO hvo = hotelController.reviewHotelInfo(hotelName);
		RoomVO room = hotelController.searchRoom(hvo.getHotelID(), po.RoomType.valueOf(roomType.toString()));
		int roomNum = room.getTotalSum();

		return roomNum;
	}

}
