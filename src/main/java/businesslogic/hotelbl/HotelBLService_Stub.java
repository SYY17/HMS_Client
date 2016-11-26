package businesslogic.hotelbl;

import java.util.ArrayList;

import businesslogicservice.ResultMessage;
import businesslogicservice.hotelBLService.HotelBLService;
import businesslogictest.hotelbl.MockOrder;
import businesslogictest.hotelbl.MockPromotion;
import po.RoomType;
import vo.HotelVO;
import vo.RoomVO;

public class HotelBLService_Stub implements HotelBLService{
	int hotelID;
	String hotelName;
	String hotelAddress;
	String businessArea;
	String hotelDescription;
	int starLevel;
	int roomNumber;
	ArrayList<RoomVO> wholeRooms;
	double rating;
	String staffName;
	String phoneNumber;
	MockPromotion mockPromorion;
	MockOrder mockOrder;
	
	public HotelBLService_Stub(){
		
	}
	
	public HotelBLService_Stub (int hid,String hn,String ha,String ba,String hd,int sl,int rn,ArrayList<RoomVO> rooms,double r,String sn,String pn){
		hotelID=hid;
		hotelName=hn;
		hotelAddress=ha;
		businessArea = ba;
		hotelDescription = hd;
		starLevel = sl;
		roomNumber=rn;
		wholeRooms = rooms;
		rating =r;
		staffName = sn;
		phoneNumber = pn;
	}
	
	/**
	 * 浏览酒店信息
	 * @param name
	 * @return hotelInfoList
	 */
	public HotelVO reviewHotelInfo(String name){
		//ArrayList<HotelVO> hotelInfoList = new ArrayList<HotelVO>();
		HotelVO hvo = new HotelVO(hotelID, hotelName, hotelAddress, businessArea, hotelDescription, 
				starLevel, roomNumber, wholeRooms, rating, staffName, phoneNumber);
		//hotelInfoList.add(vo);
		return hvo;
	}
	
	/**
	 * 浏览酒店列表
	 * @param 
	 * @return hotelList
	 */
	public ArrayList<HotelVO> reviewHotelList(){
		ArrayList<HotelVO> hotelList = new ArrayList<HotelVO>();
		//HotelVO vo = new HotelVO(hotelID, businessArea, businessArea, businessArea, businessArea, hotelID, hotelID, roomPrice, businessArea, roomCondition, hotelID);
		//hotelList.add(vo);
		return hotelList;
	}

	/**
	 * 创建酒店
	 * @param hvo
	 * @return ResultMessage
	 */
	public ResultMessage createHotel(HotelVO hvo){
		if(hvo != null){
			return ResultMessage.TRUE;
		}
		else return ResultMessage.FALSE;
	}

	/**
	 * 删除酒店
	 * @param hvo
	 * @return ResultMessage
	 */
	public ResultMessage deleteHotel(int id){
		if(id != 0){
			return ResultMessage.TRUE;
		}
		else return ResultMessage.FALSE;
	}

	/**
	 * 修改酒店基本信息
	 * @param hvo
	 * @return ResultMessage
	 */
	public ResultMessage modifyHotel(HotelVO hvo){
		if(hvo != null){
			if((mockPromorion.modifyHotelPrice(0, null) == ResultMessage.TRUE)
					&& (mockOrder.modifyHotelRoomList(0, null) == ResultMessage.TRUE)){
				return ResultMessage.TRUE;
			}else{
				return ResultMessage.FALSE;
			}
			
		}
		else return ResultMessage.FALSE;
	}

	/**
	 * 评价酒店
	 * @param hvo
	 * @return ResultMessage
	 */
	public ResultMessage gradeHotel(HotelVO hvo){
		if(hvo != null){
			return ResultMessage.TRUE;
		}
		else return ResultMessage.FALSE;
	}

	/**
	 * 按酒店名称搜索酒店基本信息
	 * @param name
	 * @return hotelInfoList
	 */
	public ArrayList<HotelVO> searchHotel(String name){
		ArrayList<HotelVO> hotelInfoList = new ArrayList<HotelVO>();
		return hotelInfoList;
	}

	/**
	 * 按类型搜索房间
	 * @param type
	 * @return RoomInfoList
	 */
	public RoomVO searchRoom(int id, RoomType type) {
		// TODO Auto-generated method stub
		RoomVO rvo = new RoomVO(id, null, 0, 0, 0);
		return rvo;
	}
	
}
