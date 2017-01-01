package stub.dataservicestub;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.hoteldataservice.HotelDataService;
import po.HotelPO;

public class HotelDataServiceMySqlImpl_Stub implements HotelDataService{
	int hotelID;
	String hotelName;
	String hotelAddress;
	String businessArea;
	String hotelDescription;
	int starLevel;
	double rating;
	String staffName;
	String phoneNumber;
	
	public HotelDataServiceMySqlImpl_Stub (int hid,String hn,String ha,String ba,
			String hd, int sl, double r, String sn, String pn){
		hotelID=hid;
		hotelName=hn;
		hotelAddress=ha;
		businessArea = ba;
		hotelDescription = hd;
		starLevel = sl;
		rating =r;
		staffName = sn;
		phoneNumber = pn;
	}

	/**
	 * 删除hotel对象
	 */
	@Override
	public void deleteHotel(int id) throws RemoteException {
		// TODO Auto-generated method stub
		if(id>=20000000 && id<30000000){
			System.out.println("Delete succeed!");
		}
		else System.out.println("Delete failed!");
	}

	/**
	 * 插入hotel对象
	 */
	@Override
	public void insertHotel(HotelPO hpo) throws RemoteException {
		// TODO Auto-generated method stub
		if(hpo.getHotelID()>=20000000 && hpo.getHotelID()<=30000000){
			System.out.println("Insert succeed!");
		}
		else System.out.println("Insert failed!");
	}

	/**
	 * 更新hotel对象
	 */
	@Override
	public void updateHotel(HotelPO hpo) throws RemoteException {
		// TODO Auto-generated method stub
		if(hpo.getHotelID()>=20000000 && hpo.getHotelID()<=30000000){
			System.out.println("Update succeed!");
		}
		else System.out.println("Update failed!");
	}

	/**
	 * 查找hotel对象
	 */
	@Override
	public HotelPO findHotel(String name) throws RemoteException {
		// TODO Auto-generated method stub
		if(name!=null){
			return new HotelPO(hotelID, hotelName, hotelAddress, businessArea, hotelDescription, starLevel, rating, staffName, phoneNumber);
		}
		else return null;
	}

	/**
	 * 查找hotel对象
	 */
	@Override
	public ArrayList<HotelPO> findsHotel(String field, String value) throws RemoteException {
		// TODO Auto-generated method stub
		if(field != null && value != null){
			return new ArrayList<HotelPO>();
		}else return null;
	}

	/**
	 * 查找hotel对象
	 */
	@Override
	public ArrayList<HotelPO> findsHotel() throws RemoteException {
		// TODO Auto-generated method stub
		return new ArrayList<HotelPO>();
	}

	/**
	 * 初始化
	 */
	@Override
	public void initHotelDataService() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Init Finished!");
	}

	/**
	 * 结束
	 */
	@Override
	public void finishHotelDataService() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Finish Finished!");
	}

}
