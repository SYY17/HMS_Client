//package stub.blservicestub;
//
//import java.util.ArrayList;
//import java.util.Date;
//
//import businesslogicservice.ResultMessage;
//import businesslogicservice.orderblservice.OrderBLService;
//import vo.HotelVO;
//import vo.OrderVO;
//import vo.PromotionVO;
//import vo.RoomVO;
//
//public class OrderBLService_Stub implements OrderBLService {
//	int userID;
//	Date setTime;
//	Date checkIn;
//	Date checkOut;
//	int roomNumber;
//	int hotelID;
//	ArrayList<RoomVO> rooms;
//
//	public OrderBLService_Stub(int userID, Date setTime, Date checkIn, Date checkOut, int roomNumber, int hotelID,
//			ArrayList<RoomVO> rooms) {
//		this.userID = userID;
//		this.setTime = setTime;
//		this.checkIn = checkIn;
//		this.checkOut = checkOut;
//		this.roomNumber = roomNumber;
//		this.hotelID = hotelID;
//		this.rooms = rooms;
//	}
//
//	public ArrayList<OrderVO> reviewOrder(int id) {
//		ArrayList<OrderVO> OrderVOList = new ArrayList<OrderVO>();
//		OrderVOList.add(new OrderVO(userID, setTime, checkIn, checkOut, roomNumber, hotelID, rooms));
//		return OrderVOList;
//	}
//
//	@Override
//	public ArrayList<OrderVO> reviewAbnormalOrder() {
//		ArrayList<OrderVO> AbnormalOrderVOList = new ArrayList<OrderVO>();
//		AbnormalOrderVOList.add(new OrderVO(userID, setTime, checkIn, checkOut, roomNumber, hotelID, rooms));
//		return AbnormalOrderVOList;
//	}
//
//	@Override
//	public ResultMessage cancelOrder(OrderVO ovo) {
//		if (ovo.getCheckInTime() == checkIn && ovo.getCheckOutTime() == checkOut && ovo.getHotelID() == hotelID
//				&& ovo.getRoomNumber() == roomNumber&&ovo.getRooms()==rooms&&ovo.getSetTime()==setTime&&ovo.getUserID()==userID){
//			return ResultMessage.TRUE;
//		}else{
//			return ResultMessage.FALSE;
//		}
//	}
//
//	@Override
//	public ResultMessage addOrder(OrderVO ovo) {
//		if(ovo.getUserID()!=00000000){
//			return ResultMessage.FALSE;
//		}else{
//			return ResultMessage.TRUE;
//		}
//	}
//
//	@Override
//	public ResultMessage complainOrder(OrderVO ovo) {
//		if(ovo.getUserID()!=00000000){
//			return ResultMessage.FALSE;
//		}else{
//			return ResultMessage.TRUE;
//		}
//	}
//
//	@Override
//	public OrderVO create(HotelVO hvo, int id, PromotionVO pvo) {
//		return new OrderVO(userID, setTime, checkIn, checkOut, roomNumber, hotelID, rooms);
//	}
//
//
//}
