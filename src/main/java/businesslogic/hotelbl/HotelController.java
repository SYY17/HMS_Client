package businesslogic.hotelbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogicservice.ResultMessage;
import businesslogicservice.hotelBLService.HotelBLService;
import dataservice.hoteldataservice.HotelDataService;
import dataservice.roomdataservice.RoomDataService;
import po.HotelPO;
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
		ArrayList<HotelVO> hvoList = new ArrayList<HotelVO>();
		for (int i = 0; i < hpoList.size(); i++) {
			hvoList.add(HotelPOtoHotelVO(hpoList.get(i)));
		}

		return hvoList;
	}

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
		} // change enum from po to vo????
		RoomVO rvo = new RoomVO(rpo.getHotelID(), vo.RoomType.valueOf(rpo.getRoomType().toString()), rpo.getTotalSum(),
				rpo.getRemainSum(), rpo.getPrice());
		return rvo;
	}

	@Override
	public ResultMessage ModifyRoom(RoomVO rvo) {
		// TODO Auto-generated method stub
		ResultMessage result = null;
		try {
			roomDataService.initRoomDataService();// change enum from vo to
													// po???
			roomDataService.updateRemainSum(rvo.getHotelID(), po.RoomType.valueOf(rvo.getRoomType().toString()),
					rvo.getRemainSum());
			roomDataService.updateTotalSum(rvo.getHotelID(), po.RoomType.valueOf(rvo.getRoomType().toString()),
					rvo.getTotalSum());
			roomDataService.finishRoomDataService();
			result = ResultMessage.TRUE;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = ResultMessage.FALSE;
		}
		return result;
	}

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
		if (rpoList != null) {
			for (int i = 0; i < rpoList.size(); i++) {
				RoomPO rpo = rpoList.get(i); // change enum from po to vo????
				rvoList.add(new RoomVO(id, vo.RoomType.valueOf(rpo.getRoomType().toString()), rpo.getTotalSum(),
						rpo.getRemainSum(), rpo.getPrice()));
			}
		}
		return rvoList;
	}

	public HotelPO HotelVOtoHotelPO(HotelVO hvo) {
		// ArrayList<RoomPO> rpoList = new ArrayList<RoomPO>();
		// ArrayList<RoomVO> rvoList = hvo.getRooms();
		// if(rvoList != null){
		// for(int i=0;i<rvoList.size();i++){//change enums in vo to po?
		// RoomPO rpo = new RoomPO(rvoList.get(i).getHotelID(),
		// po.RoomType.valueOf(rvoList.get(i).getRoomType().toString()),
		// rvoList.get(i).getTotalSum(), rvoList.get(i).getRemainSum(),
		// rvoList.get(i).getPrice());
		// rpoList.add(rpo);
		// }
		// }
		HotelPO hpo = new HotelPO(hvo.getHotelID(), hvo.getHotelName(), hvo.getHotelAddress(), hvo.getBusinessArea(),
				hvo.getHotelDescription(), hvo.getStarLevel(),
				/*
				 * hvo.getRoomNumber(), rpoList,
				 */ hvo.getRating(), hvo.getStaffName(), hvo.getPhoneNumber());
		return hpo;
	}

	public HotelVO HotelPOtoHotelVO(HotelPO hpo) {
		// ArrayList<RoomVO> rvoList = new ArrayList<RoomVO>();
		// ArrayList<RoomPO> rpoList = hpo.getRooms();
		// if(rpoList != null){
		// for(int i=0;i<rpoList.size();i++){//??????????change enums in po to
		// vo???????????????
		// RoomVO rvo = new RoomVO(rpoList.get(i).getHotelID(),
		// vo.RoomType.valueOf(rpoList.get(i).getRoomType().toString()),
		// rpoList.get(i).getTotalSum(), rpoList.get(i).getRemainSum(),
		// rpoList.get(i).getPrice());
		// rvoList.add(rvo);
		// }
		// }
		HotelVO hvo = new HotelVO(hpo.getHotelID(), hpo.getHotelName(), hpo.getHotelAddress(), hpo.getBusinessArea(),
				hpo.getHotelDescription(), hpo.getStarLevel(),
				/*
				 * hpo.getRoomNumber(), rvoList,
				 */hpo.getRating(), hpo.getStaffName(), hpo.getPhoneNumber());
		return hvo;
	}
}
