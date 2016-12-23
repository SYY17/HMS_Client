package presentation.hotelui;

import java.util.ArrayList;
import java.util.Date;

import businesslogicservice.ResultMessage;
import po.RoomType;
import vo.HotelVO;
import vo.RoomVO;

public interface HotelControllerService {
	/**
	 * 浏览酒店信息
	 * 
	 * @param name
	 * @return hotelInfoList
	 */
	public HotelVO reviewHotelInfo(String name);

	/**
	 * 通过id搜索酒店
	 * 
	 * @param id
	 * @return hotel
	 */
	public HotelVO searchHotelByID(int id);
	/**
	 * 浏览酒店列表
	 * 
	 * @param
	 * @return hotelList
	 */
	public ArrayList<HotelVO> reviewHotelList();

	/**
	 * 创建酒店
	 * 
	 * @param hvo
	 * @return ResultMessage
	 */
	public ResultMessage createHotel(HotelVO hvo);

	/**
	 * 删除酒店
	 * 
	 * @param id
	 * @return ResultMessage
	 */
	public ResultMessage deleteHotel(int id);

	/**
	 * 修改酒店基本信息
	 * 
	 * @param hvo
	 * @return ResultMessage
	 */
	public ResultMessage modifyHotel(HotelVO hvo);

	/**
	 * 评价酒店
	 * 
	 * @param hvo
	 * @return ResultMessage
	 */
	public ResultMessage gradeHotel(HotelVO hvo);

	/**
	 * 按酒店名称搜索酒店基本信息
	 * 
	 * @param name
	 * @return hotelInfoList
	 */
	public ArrayList<HotelVO> searchHotel(String name);

	/**
	 * 按类型搜索房间
	 * 
	 * @param type
	 * @return RoomInfoList
	 */
	public RoomVO searchRoom(int id, RoomType type);

	/**
	 * 更新客房信息
	 * 
	 * @param rvo
	 * @return ResultMessage
	 */
	public ResultMessage modifyRoom(RoomVO rvo);

	/**
	 * 查找所有客房
	 * 
	 * @param id
	 * @return roomList
	 */
	public ArrayList<RoomVO> searchRooms(int id);
	
	/**
	 * 获得指定时间段指定房型剩余数量
	 * 
	 * @param hotelid
	 * @param roomtype
	 * @param checkin
	 * @param checkout
	 * @return remainRooms
	 */
	public int getRemainRooms(int hotelid, RoomType roomtype, Date checkin, Date checkout);
}
