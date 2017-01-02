package stub.blservicestub;

import java.util.ArrayList;
import java.util.Date;

import businesslogicservice.ResultMessage;
import businesslogicservice.hotelBLService.HotelBLService;
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
	int roomPrice;
	RoomType roomType;
	boolean roomCondition;
	double rating;
	String staffName;
	String phoneNumber;
	int totalSum;
	int remainSum;
	ArrayList<RoomVO> wholeRooms;
	
	public HotelBLService_Stub (int hid,String hn,String ha,String ba,String hd,int sl,int rn,int rp,RoomType rt,boolean rc,double r, ArrayList<RoomVO> rooms, String sn, String pn, int ts, int rs){
		hotelID=hid;
		hotelName=hn;
		hotelAddress=ha;
		businessArea = ba;
		hotelDescription = hd;
		starLevel = sl;
		roomNumber=rn;
		roomPrice=rp;
		roomType = rt;
		roomCondition=rc;
		rating =r;
		wholeRooms=rooms;
		staffName = sn;
		phoneNumber = pn;
		totalSum = ts;
		remainSum = rs;
	}
	
	/**
	 * 添加酒店对象
	 */
	@Override
	public ResultMessage createHotel(HotelVO hvo) {
		// TODO Auto-generated method stub
		if(hvo != null){
			return ResultMessage.TRUE;
		}
		else return ResultMessage.FALSE;
	}
	
	/**
	 * 查看酒店对象
	 */
	@Override
	public HotelVO reviewHotelInfo(String name){
		// TODO Auto-generated constructor stub
		HotelVO hvo = new HotelVO(hotelID, hotelName, hotelAddress, businessArea, hotelDescription, starLevel, rating, staffName, phoneNumber);
		return hvo;
	}
	
	/**
	 * 查看所有酒店对象
	 */
	@Override
	public ArrayList<HotelVO> reviewHotelList(){
		// TODO Auto-generated constructor stub
		ArrayList <HotelVO> hotelList = new ArrayList<HotelVO>();
		HotelVO hvo = new HotelVO(hotelID, hotelName, hotelAddress, businessArea, hotelDescription, starLevel, rating, staffName, phoneNumber);
		hotelList.add(hvo);
		return hotelList;
	}

	/**
	 * 删除酒店对象
	 */
	@Override
	public ResultMessage deleteHotel(int id){
		// TODO Auto-generated constructor stub
		if(id != -1){
			return ResultMessage.TRUE;
		}
		else return ResultMessage.FALSE;
	}

	/**
	 * 修改酒店对象
	 */
	@Override
	public ResultMessage modifyHotel(HotelVO hvo){
		// TODO Auto-generated constructor stub
		if(hvo != null){
			return ResultMessage.TRUE;
		}
		else return ResultMessage.FALSE;
	}

	/**
	 * 评价酒店
	 */
	@Override
	public ResultMessage gradeHotel(HotelVO hvo){
		// TODO Auto-generated constructor stub
		if(hvo != null){
			return ResultMessage.TRUE;
		}
		else return ResultMessage.FALSE;
	}

	/**
	 * 查找酒店对象
	 */
	@Override
	public ArrayList<HotelVO> searchHotel(String name){
		// TODO Auto-generated constructor stub
		ArrayList<HotelVO> hotelInfoList = new ArrayList<HotelVO>();
		HotelVO hvo = new HotelVO(hotelID, hotelName, hotelAddress, businessArea, hotelDescription, starLevel, rating, staffName, phoneNumber);
		hotelInfoList.add(hvo);
		return hotelInfoList;
	}

	/**
	 * 查找酒店对象
	 */
	@Override
	public HotelVO searchHotelByID(int id) {
		// TODO Auto-generated method stub
		HotelVO hvo = new HotelVO(hotelID, hotelName, hotelAddress, businessArea, hotelDescription, starLevel, rating, staffName, phoneNumber);
		return hvo;
	}

	/**
	 * 查找房间对象
	 */
	@Override
	public RoomVO searchRoom(int id, RoomType type) {
		// TODO Auto-generated method stub
		RoomVO rvo = new RoomVO(hotelID, vo.RoomType.valueOf(roomType.toString()), totalSum, remainSum, roomPrice);
		return rvo;
	}

	/**
	 * 修改房间对象
	 */
	@Override
	public ResultMessage ModifyRoom(RoomVO rvo) {
		// TODO Auto-generated method stub
		if(rvo != null){
			return ResultMessage.TRUE;
		}
		else return ResultMessage.FALSE;
	}

	/**
	 * 查找房间对象
	 */
	@Override
	public ArrayList<RoomVO> SearchRooms(int id) {
		// TODO Auto-generated method stub
		RoomVO rvo = new RoomVO(hotelID, vo.RoomType.valueOf(roomType.toString()), totalSum, remainSum, roomPrice);
		ArrayList<RoomVO> rooms = new ArrayList<RoomVO>();
		rooms.add(rvo);
		return rooms;
	}

	/**
	 * 返回剩余房间数
	 */
	@Override
	public int getRemainRooms(int hotelid, RoomType roomtype, Date checkin, Date checkout) {
		// TODO Auto-generated method stub
		int remain = 0;
		return remain;
	}
	
}