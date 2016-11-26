package presentation.hotelui;

import java.util.ArrayList;
import businesslogicservice.ResultMessage;
import po.RoomType;
import vo.HotelVO;
import vo.RoomVO;

public interface HotelControllerService {
	/**
	 * 浏览酒店信息
	 * @param name
	 * @return hotelInfoList
	 */
	public HotelVO reviewHotelInfo(String name);
	
	/**
	 * 浏览酒店列表
	 * @param 
	 * @return hotelList
	 */
	public ArrayList<HotelVO> reviewHotelList();
	
	/**
	 * 创建酒店
	 * @param hvo
	 * @return ResultMessage
	 */
	public ResultMessage createHotel(HotelVO hvo);
	
	/**
	 * 删除酒店
	 * @param id
	 * @return ResultMessage
	 */
	public ResultMessage deleteHotel(int id);
	
	/**
	 * 修改酒店基本信息
	 * @param hvo
	 * @return ResultMessage
	 */
	public ResultMessage modifyHotel(HotelVO hvo);
	
	/**
	 * 评价酒店
	 * @param hvo
	 * @return ResultMessage
	 */
	public ResultMessage gradeHotel(HotelVO hvo);
	
	/**
	 * 按酒店名称搜索酒店基本信息
	 * @param name
	 * @return hotelInfoList
	 */
	public ArrayList<HotelVO> searchHotel(String name);
	
	/**
	 * 按类型搜索房间
	 * @param type
	 * @return RoomInfoList
	 */
	public RoomVO searchRoom(int id, RoomType type);

	
}
