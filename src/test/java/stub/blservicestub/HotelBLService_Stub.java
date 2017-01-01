//package stub.blservicestub;
//
//import java.util.ArrayList;
//
//import businesslogicservice.ResultMessage;
//import businesslogicservice.hotelBLService.HotelBLService;
//import vo.HotelVO;
//import vo.RoomVO;
//
//public class HotelBLService_Stub implements HotelBLService{
//	int hotelID;
//	String hotelName;
//	String hotelAddress;
//	String businessArea;
//	String hotelDescription;
//	int starLevel;
//	int roomNumber;
//	double roomPrice;
//	String roomType;
//	boolean roomCondition;
//	int rating;
//	ArrayList<RoomVO> wholeRooms;
//	
//	public HotelBLService_Stub (int hid,String hn,String ha,String ba,String hd,int sl,int rn,double rp,String rt,boolean rc,int r, ArrayList<RoomVO> rooms){
//		hotelID=hid;
//		hotelName=hn;
//		hotelAddress=ha;
//		businessArea = ba;
//		hotelDescription = hd;
//		starLevel = sl;
//		roomNumber=rn;
//		roomPrice=rp;
//		roomType = rt;
//		roomCondition=rc;
//		rating =r;
//		wholeRooms=rooms;
//	}
//	
//	//������оƵ������Ϣ�б�
//	@Override
//	public ArrayList<HotelVO> reviewHotelInfo(String name){
//		// TODO Auto-generated constructor stub
//		ArrayList <HotelVO> hotelInfoList = new ArrayList<HotelVO>();
//		HotelVO vo = new HotelVO(hotelID, businessArea, businessArea, businessArea, businessArea, hotelID, hotelID, roomPrice, businessArea, roomCondition, hotelID, wholeRooms);
//		hotelInfoList.add(vo);
//		return hotelInfoList;
//	}
//	
//	//������оƵ���б�
//	@Override
//	public ArrayList<HotelVO> reviewHotelList(){
//		// TODO Auto-generated constructor stub
//		ArrayList <HotelVO> hotelList = new ArrayList<HotelVO>();
//		HotelVO vo = new HotelVO(hotelID, businessArea, businessArea, businessArea, businessArea, hotelID, hotelID, roomPrice, businessArea, roomCondition, hotelID, wholeRooms);
//		hotelList.add(vo);
//		return hotelList;
//	}
//
//	@Override
//	public ResultMessage createHotel(HotelVO hvo){
//		// TODO Auto-generated constructor stub
//		if(hvo != null){
//			return ResultMessage.TRUE;
//		}
//		else return ResultMessage.FALSE;
//	}
//
//	@Override
//	public ResultMessage deleteHotel(HotelVO hvo){
//		// TODO Auto-generated constructor stub
//		if(hvo != null){
//			return ResultMessage.TRUE;
//		}
//		else return ResultMessage.FALSE;
//	}
//
//	@Override
//	public ResultMessage modifyHotel(HotelVO hvo){
//		// TODO Auto-generated constructor stub
//		if(hvo != null){
//			return ResultMessage.TRUE;
//		}
//		else return ResultMessage.FALSE;
//	}
//
//	//�Ƶ�����
//	@Override
//	public ResultMessage gradeHotel(HotelVO hvo){
//		// TODO Auto-generated constructor stub
//		if(hvo != null){
//			return ResultMessage.TRUE;
//		}
//		else return ResultMessage.FALSE;
//	}
//
//	@Override
//	public ArrayList<HotelVO> searchHotel(String name){
//		// TODO Auto-generated constructor stub
//		ArrayList<HotelVO> hotelInfoList = new ArrayList<HotelVO>();
//		return hotelInfoList;
//	}
//
//	@Override
//	public ArrayList<HotelVO> searchRoom(String type){
//		// TODO Auto-generated constructor stub
//		ArrayList<HotelVO> RoomInfoList = new ArrayList<HotelVO>();
//		return RoomInfoList;
//	}
//	
//}
