package businesslogic.hotelbl;

import java.util.ArrayList;
import java.util.Date;

import vo.RoomVO;

public interface OrderInfo {
	
	/**
	 * 
	 * @return 获得订单对应入住时间
	 */
	public Date getCheckIn();
	
	/**
	 * 
	 * @return 获得订单对应离开时间
	 */
	public Date getCheckOut();
	
	/**
	 * 
	 * @return 获得订单对应房间号
	 */
	public int getRoomNumber();
	
	/**
	 * 
	 * @return 获得订单对应酒店ID
	 */
	public int getHotelID();
	
	/**
	 * 
	 * @return 获得订单对应房间列表
	 */
	public ArrayList<RoomVO> getRooms();
	
}
