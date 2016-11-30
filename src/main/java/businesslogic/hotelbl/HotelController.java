package businesslogic.hotelbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogicservice.ResultMessage;
import businesslogicservice.hotelBLService.HotelBLService;
import po.HotelPO;
import po.RoomPO;
import po.RoomType;
import rmi.RemoteController;
import runner.DataServiceClientRunner;
import vo.HotelVO;
import vo.RoomVO;

public class HotelController implements HotelBLService{

	/**
	 * 
	 * @param name
	 * @return 浏览酒店信息
	 */
	@Override
	public HotelVO reviewHotelInfo(String name) {
		// TODO Auto-generated method stub
		//待修改，初始化服务可以提取到LogFrame中
		DataServiceClientRunner cr = new DataServiceClientRunner();
		cr.start();
		RemoteController rc = cr.getRemoteController();
		HotelPO hpo = null;
		try {
			rc.getHotelDataService().initHotelDataService();
			hpo = rc.getHotelDataService().findHotel(name);
			rc.getHotelDataService().finishHotelDataService();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		HotelVO hvo = HotelPOtoHotelVO(hpo);
		
		return hvo;
	}

	/**
	 * 
	 * @param 
	 * @return 浏览酒店列表
	 */
	@Override
	public ArrayList<HotelVO> reviewHotelList() {
		// TODO Auto-generated method stub
		//待修改，初始化服务可以提取到LogFrame中
		DataServiceClientRunner cr = new DataServiceClientRunner();
		cr.start();
		RemoteController rc = cr.getRemoteController();
		ArrayList<HotelPO> hpoList = null;
		try {
			rc.getHotelDataService().initHotelDataService();
			hpoList = rc.getHotelDataService().findsHotel();
			rc.getHotelDataService().finishHotelDataService();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<HotelVO> hvoList = new ArrayList<HotelVO>();
		for(int i=0;i<hpoList.size();i++){
			hvoList.add(HotelPOtoHotelVO(hpoList.get(i)));
		}
		
		return hvoList;
	}

	/**
	 * 
	 * @param hvo
	 * @return 创建酒店
	 */
	@Override
	public ResultMessage createHotel(HotelVO hvo) {
		// TODO Auto-generated method stub
		//待修改，初始化服务可以提取到LogFrame中
		DataServiceClientRunner cr = new DataServiceClientRunner();
		cr.start();
		RemoteController rc = cr.getRemoteController();
		ResultMessage result;
		try {
			rc.getHotelDataService().insertHotel(HotelVOtoHotelPO(hvo));
			rc.getHotelDataService().finishHotelDataService();
			result = ResultMessage.TRUE;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = ResultMessage.FALSE;
		}
		return result;
	}

	/**
	 * 
	 * @param hvo
	 * @return 删除酒店
	 */
	@Override
	public ResultMessage deleteHotel(int id) {
		// TODO Auto-generated method stub
		//待修改，初始化服务可以提取到LogFrame中
		DataServiceClientRunner cr = new DataServiceClientRunner();
		cr.start();
		RemoteController rc = cr.getRemoteController();
		ResultMessage result = null;
		try {
			rc.getHotelDataService().initHotelDataService();
			rc.getHotelDataService().deleteHotel(id);
			rc.getHotelDataService().finishHotelDataService();
			result = ResultMessage.TRUE;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = ResultMessage.FALSE;
		}
		return result;
	}

	/**
	 * 
	 * @param hvo
	 * @return 修改酒店基本信息
	 */
	@Override
	public ResultMessage modifyHotel(HotelVO hvo) {
		// TODO Auto-generated method stub
		//待修改，初始化服务可以提取到LogFrame中
		DataServiceClientRunner cr = new DataServiceClientRunner();
		cr.start();
		RemoteController rc = cr.getRemoteController();
		ResultMessage result = null;
		try {
			rc.getHotelDataService().initHotelDataService();
			rc.getHotelDataService().updateHotel(HotelVOtoHotelPO(hvo));
			rc.getHotelDataService().finishHotelDataService();
			result = ResultMessage.TRUE;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = ResultMessage.FALSE;
		}
		return result;
	}

	/**
	 * 
	 * @param hvo
	 * @return 评价酒店
	 */
	@Override
	public ResultMessage gradeHotel(HotelVO hvo) {
		// TODO Auto-generated method stub
		//待修改，初始化服务可以提取到LogFrame中
		DataServiceClientRunner cr = new DataServiceClientRunner();
		cr.start();
		RemoteController rc = cr.getRemoteController();
		ResultMessage result = null;
		try {
			rc.getHotelDataService().initHotelDataService();
			rc.getHotelDataService().updateHotel(HotelVOtoHotelPO(hvo));
			rc.getHotelDataService().finishHotelDataService();
			result = ResultMessage.TRUE;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			result = ResultMessage.FALSE;
		}
		return result;
	}

	/**
	 * 
	 * @param name
	 * @return 按酒店名称搜索酒店基本信息
	 */
	@Override
	public ArrayList<HotelVO> searchHotel(String name) {
		// TODO Auto-generated method stub
		//待修改，初始化服务可以提取到LogFrame中
		DataServiceClientRunner cr = new DataServiceClientRunner();
		cr.start();
		RemoteController rc = cr.getRemoteController();
		ArrayList<HotelPO> hpoList = null;
		try {
			rc.getHotelDataService().initHotelDataService();
			hpoList = rc.getHotelDataService().findsHotel("hotelName", name);
			rc.getHotelDataService().finishHotelDataService();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		ArrayList<HotelVO> hvoList = new ArrayList<HotelVO>();
		if(hpoList != null){
		for(int i=0;i<hpoList.size();i++){
			hvoList.add(HotelPOtoHotelVO(hpoList.get(i)));
		}
		}
		return hvoList;
	}
	
	/**
	 * 
	 * @param id
	 * @param type
	 * @return 按类型搜索房间
	 */
	@Override
	public RoomVO searchRoom(int id, RoomType type) {
		// TODO Auto-generated method stub
		//待修改，初始化服务可以提取到LogFrame中
		DataServiceClientRunner cr = new DataServiceClientRunner();
		cr.start();
		RemoteController rc = cr.getRemoteController();
		RoomPO rpo = null;
		try {
			rc.getRoomDataService().initRoomDataService();
			rpo = rc.getRoomDataService().findRoom(id, type);
			rc.getHotelDataService().finishHotelDataService();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		RoomVO rvo = new RoomVO(rpo.getHotelID(), (vo.RoomType)(Object)rpo.getRoomType(), 
				rpo.getTotalSum(), rpo.getRemainSum(), rpo.getPrice());
		return rvo;
	}

	//待修改，不提供给外界的方法应声明为private，且可采用委托式风格将该职责委托给其他类以满足单一职责原则
	public HotelPO HotelVOtoHotelPO(HotelVO hvo){
		//待修改，应改写为两个方法，一个为单独的VO,PO转换，另一种为多个PO转换为多个VO
		ArrayList<RoomPO> rpoList = new ArrayList<RoomPO>();
		ArrayList<RoomVO> rvoList = hvo.getRooms();
		if(rvoList != null){
		for(int i=0;i<rvoList.size();i++){//change enums in vo to po?
			RoomPO rpo = new RoomPO(rvoList.get(i).getHotelID(), (po.RoomType)(Object)rvoList.get(i).getRoomType(), 
					rvoList.get(i).getTotalSum(), rvoList.get(i).getRemainSum(), rvoList.get(i).getPrice());
			rpoList.add(rpo);
		}
		}
		HotelPO hpo = new HotelPO(hvo.getHotelID(),hvo.getHotelName(), hvo.getHotelAddress(), 
				hvo.getBusinessArea(), hvo.getHotelDescription(), hvo.getStarLevel(), hvo.getRoomNumber(), 
				rpoList, hvo.getRating(), hvo.getStaffName(), hvo.getPhoneNumber());
		return hpo;
	}
	
	//待修改，不提供给外界的方法应声明为private，且可采用委托式风格将该职责委托给其他类以满足单一职责原则
	public HotelVO HotelPOtoHotelVO(HotelPO hpo){
		//待修改，应改写为两个方法，一个为单独的VO,PO转换，另一种为多个VO转换为多个PO
		ArrayList<RoomVO> rvoList = new ArrayList<RoomVO>();
		ArrayList<RoomPO> rpoList = hpo.getRooms();
		if(rpoList != null){
			for(int i=0;i<rpoList.size();i++){//??????????change enums in po to vo???????????????
				RoomVO rvo = new RoomVO(rpoList.get(i).getHotelID(), (vo.RoomType)(Object)rpoList.get(i).getRoomType(), 
						rpoList.get(i).getTotalSum(), rpoList.get(i).getRemainSum(), rpoList.get(i).getPrice());
				rvoList.add(rvo);
			}
		}
		HotelVO hvo = new HotelVO(hpo.getHotelID(),hpo.getHotelName(), hpo.getHotelAddress(), 
				hpo.getBusinessArea(), hpo.getHotelDescription(), hpo.getStarLevel(), hpo.getRoomNumber(), 
				rvoList, hpo.getRating(), hpo.getStaffName(), hpo.getPhoneNumber());
		return hvo;
	}
}
