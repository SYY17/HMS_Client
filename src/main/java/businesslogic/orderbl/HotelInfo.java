package businesslogic.orderbl;

import vo.RoomType;

public interface HotelInfo {
	/**
	 * 
	 * @param hotelName,roomType,changedRoomNum
	 * @return 查询用户ID(changedRoomNum为正时，表示用户离开，房间数变多；为负时表示用户入住，房间数变少)
	 */
	public void updateRoomInfo(String hotelName, RoomType roomType, int changedRoomNum);
	
	
	/**
	 * 
	 * @param hotelName,roomType
	 * @return 查询酒店特定房间的剩余数量
	 */
	public int getRemainedRoomNum(String hotelName, RoomType roomType);
}
