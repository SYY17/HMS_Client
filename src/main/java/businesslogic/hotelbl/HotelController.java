package businesslogic.hotelbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Date;

import businesslogicservice.ResultMessage;
import businesslogicservice.hotelBLService.HotelBLService;
import dataservice.hoteldataservice.HotelDataService;
import dataservice.orderdataservice.OrderDataService;
import dataservice.roomdataservice.RoomDataService;
import po.HotelPO;
import po.OrderPO;
import po.RoomPO;
import po.RoomType;
import rmi.RemoteController;
import runner.DataServiceClientRunner;
import vo.HotelVO;
import vo.RoomVO;

public class HotelController implements HotelBLService {

	private RemoteController remoteController;
	private HotelDataService hotelDataService;
	private RoomDataService roomDataService;
	private OrderDataService orderDataService;
	// private HotelLineItem hotelLineItem;

	public HotelController() {
		// TODO Auto-generated constructor stub
		DataServiceClientRunner runner = new DataServiceClientRunner();
		runner.start();
		remoteController = runner.getRemoteController();
		hotelDataService = remoteController.getHotelDataService();
		roomDataService = remoteController.getRoomDataService();

		// hotelLineItem = new HotelLineItem();
	}

	/**
	 * 查看酒店信息
	 */
	@Override
	public HotelVO reviewHotelInfo(String name) {
		// TODO Auto-generated method stub
		HotelPO hpo = null;
		try {
			hotelDataService.initHotelDataService();
			hpo = hotelDataService.findHotel(name);
			hotelDataService.finishHotelDataService();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HotelVO hvo = HotelPOtoHotelVO(hpo);

		return hvo;
	}

	/**
	 * 根据id查找并返回酒店信息
	 */
	@Override
	public HotelVO searchHotelByID(int id) {
		// TODO Auto-generated method stub
		HotelPO hpo = null;
		try {
			hotelDataService.initHotelDataService();
			hpo = hotelDataService.findsHotel("id", String.valueOf(id)).get(0);
			hotelDataService.finishHotelDataService();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HotelVO hvo = HotelPOtoHotelVO(hpo);

		return hvo;
	}

	/**
	 * 查看酒店评分列表
	 */
	@Override
	public ArrayList<HotelVO> reviewHotelList() {
		// TODO Auto-generated method stub
		ArrayList<HotelPO> hpoList = null;
		try {
			hotelDataService.initHotelDataService();
			hpoList = hotelDataService.findsHotel();
			hotelDataService.finishHotelDataService();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		//对表内每一对象进行转换
		ArrayList<HotelVO> hvoList = new ArrayList<HotelVO>();
		for (int i = 0; i < hpoList.size(); i++) {
			hvoList.add(HotelPOtoHotelVO(hpoList.get(i)));
		}

		return hvoList;
	}

	/**
	 * 创建酒店
	 */
	@Override
	public ResultMessage createHotel(HotelVO hvo) {
		// TODO Auto-generated method stub
		ResultMessage result;
		try {
			hotelDataService.initHotelDataService();
			hotelDataService.insertHotel(HotelVOtoHotelPO(hvo));
			hotelDataService.finishHotelDataService();
			result = ResultMessage.TRUE;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = ResultMessage.FALSE;
		}
		return result;
	}

	/**
	 * 删除酒店
	 */
	@Override
	public ResultMessage deleteHotel(int id) {
		// TODO Auto-generated method stub
		ResultMessage result = null;
		try {
			hotelDataService.initHotelDataService();
			hotelDataService.deleteHotel(id);
			hotelDataService.finishHotelDataService();
			result = ResultMessage.TRUE;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = ResultMessage.FALSE;
		}
		return result;
	}

	/**
	 * 维护酒店基本信息
	 */
	@Override
	public ResultMessage modifyHotel(HotelVO hvo) {
		// TODO Auto-generated method stub
		ResultMessage result = null;
		try {
			hotelDataService.initHotelDataService();
			hotelDataService.updateHotel(HotelVOtoHotelPO(hvo));
			hotelDataService.finishHotelDataService();
			result = ResultMessage.TRUE;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = ResultMessage.FALSE;
		}
		return result;
	}

	/**
	 * 酒店评分
	 */
	@Override
	public ResultMessage gradeHotel(HotelVO hvo) {
		// TODO Auto-generated method stub
		ResultMessage result = null;
		try {
			hotelDataService.initHotelDataService();
			hotelDataService.updateHotel(HotelVOtoHotelPO(hvo));
			hotelDataService.finishHotelDataService();
			result = ResultMessage.TRUE;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = ResultMessage.FALSE;
		}
		return result;
	}

	/**
	 * 按酒店名称查找并返回所有房间信息
	 */
	@Override
	public ArrayList<HotelVO> searchHotel(String name) {
		// TODO Auto-generated method stub
		ArrayList<HotelPO> hpoList = null;
		try {
			hotelDataService.initHotelDataService();
			hpoList = hotelDataService.findsHotel("hotelName", name);
			hotelDataService.finishHotelDataService();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<HotelVO> hvoList = new ArrayList<HotelVO>();
		if (hpoList != null) {
			for (int i = 0; i < hpoList.size(); i++) {
				hvoList.add(HotelPOtoHotelVO(hpoList.get(i)));
			}
		}
		return hvoList;
	}

	/**
	 * 按照id和房间类型查找并返回房间信息
	 */
	@Override
	public RoomVO searchRoom(int id, RoomType type) {
		// TODO Auto-generated method stub
		RoomPO rpo = null;
		try {
			roomDataService.initRoomDataService();
			rpo = roomDataService.findRoom(id, type);
			roomDataService.finishRoomDataService();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} // po, vo转换
		RoomVO rvo = new RoomVO(rpo.getHotelID(), vo.RoomType.valueOf(rpo.getRoomType().toString()), rpo.getTotalSum(),
				rpo.getRemainSum(), rpo.getPrice());
		return rvo;
	}

	/**
	 * 更新客房信息
	 */
	@Override
	public ResultMessage ModifyRoom(RoomVO rvo) {
		// TODO Auto-generated method stub
		ResultMessage result = null;
		try {
			roomDataService.initRoomDataService();
			
			//分别对剩余数量, 总数量和价格进行更新
			roomDataService.updateRemainSum(rvo.getHotelID(), po.RoomType.valueOf(rvo.getRoomType().toString()),
					rvo.getRemainSum());
			
			roomDataService.updateTotalSum(rvo.getHotelID(), po.RoomType.valueOf(rvo.getRoomType().toString()),
					rvo.getTotalSum());
			
			roomDataService.updatePrice(rvo.getHotelID(), po.RoomType.valueOf(rvo.getRoomType().toString()),
					rvo.getPrice());
			
			roomDataService.finishRoomDataService();
			result = ResultMessage.TRUE;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = ResultMessage.FALSE;
		}
		return result;
	}

	/**
	 * 根据id查找并返回所有房间信息
	 */
	@Override
	public ArrayList<RoomVO> SearchRooms(int id) {
		// TODO Auto-generated method stub
		ArrayList<RoomPO> rpoList = new ArrayList<RoomPO>();
		try {
			roomDataService.initRoomDataService();
			rpoList = roomDataService.findRooms(id);
			roomDataService.finishRoomDataService();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		ArrayList<RoomVO> rvoList = new ArrayList<RoomVO>();
		
		//将表中每一个对象进行转换
		if (rpoList != null) {
			for (int i = 0; i < rpoList.size(); i++) {
				RoomPO rpo = rpoList.get(i);
				rvoList.add(new RoomVO(id, vo.RoomType.valueOf(rpo.getRoomType().toString()), rpo.getTotalSum(),
						rpo.getRemainSum(), rpo.getPrice()));
			}
		}
		return rvoList;
	}

	/**
	 * 获取剩余房间数
	 */
	@Override
	public int getRemainRooms(int hotelid, RoomType roomtype, Date checkin, Date checkout) {
		// TODO Auto-generated method stub
		RoomPO rpo = null ;
		int remainRooms = 0;
		try {
			roomDataService.initRoomDataService();
			rpo = roomDataService.findRoom(hotelid, roomtype);
			roomDataService.finishRoomDataService();
			
			remainRooms = rpo.getRemainSum();
			
			HotelBLService hotel = new HotelController();
			String hotelName = hotel.searchHotelByID(hotelid).getHotelName();
			//OrderBLService order = new OrderController();
			
			orderDataService.initOrderDataService();
			ArrayList<OrderPO> orderList = orderDataService.findOrderByHotelName(hotelName);
			orderDataService.finishOrderDataService();
			
			if(orderList!=null){
			for(int i=0;i<orderList.size();i++){
				Date in = orderList.get(i).getCheckIn();
				Date out = orderList.get(i).getCheckOut();
				
				//对checkin和checkout时间进行判断并更新剩余数目
				if((in.compareTo(checkin)>0 && in.compareTo(checkout)<0) || 
						(out.compareTo(checkin)>0 && out.compareTo(checkout)<0) ||
						(in.compareTo(checkin)<0 && out.compareTo(checkout)>0) || 
						(in.compareTo(checkin)>0 && out.compareTo(checkout)<0)){
					remainRooms = remainRooms - 1;
					}
				}
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return remainRooms;
	}
	
	/**
	 *  
	 * @param hvo
	 * @return VO转PO的方法
	 */
	public HotelPO HotelVOtoHotelPO(HotelVO hvo) {
		HotelPO hpo = new HotelPO(hvo.getHotelID(), hvo.getHotelName(), hvo.getHotelAddress(), hvo.getBusinessArea(),
				hvo.getHotelDescription(), hvo.getStarLevel(),
				hvo.getRating(), hvo.getStaffName(), hvo.getPhoneNumber());
		return hpo;
	}

	/**
	 * 
	 * @param hpo
	 * @return PO转VO的方法
	 */
	public HotelVO HotelPOtoHotelVO(HotelPO hpo) {
		HotelVO hvo = new HotelVO(hpo.getHotelID(), hpo.getHotelName(), hpo.getHotelAddress(), hpo.getBusinessArea(),
				hpo.getHotelDescription(), hpo.getStarLevel(), 
				hpo.getRating(), hpo.getStaffName(), hpo.getPhoneNumber());
		return hvo;
	}

}
