package stub.dataservicestub;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.roomdataservice.RoomDataService;
import po.RoomPO;
import po.RoomType;

public class RoomDataServiceMySql_Stub implements RoomDataService{
	int hotelID;
	RoomType roomType;
	int totalSum;
	int remainSum;
	int price;
	
	public RoomDataServiceMySql_Stub(int hid, RoomType rt, int ts, int rs, int p){
		hotelID = hid;
		roomType = rt;
		totalSum = ts;
		remainSum = rs;
		price = p;
	}
	
	/**
	 * 插入room对象
	 */
	@Override
	public void insertRoom(RoomPO rpo) throws RemoteException {
		// TODO Auto-generated method stub
		if(rpo.getHotelID()>=20000000 && rpo.getHotelID()<=30000000){
			System.out.println("Insert succeed!");
		}
		else System.out.println("Insert failed!");
	}

	/**
	 * 删除room对象
	 */
	@Override
	public void deleteAllRooms(int id) throws RemoteException {
		// TODO Auto-generated method stub
		if(id>=20000000 && id<=30000000){
			System.out.println("Delete succeed!");
		}
		else System.out.println("Delete failed!");
	}

	/**
	 * 删除room对象
	 */
	@Override
	public void deleteRoom(int id, RoomType type) throws RemoteException {
		// TODO Auto-generated method stub
		if(id>=20000000 && id<=30000000){
			System.out.println("Delete succeed!");
		}
		else System.out.println("Delete failed!");
	}

	/**
	 * 更新room对象
	 */
	@Override
	public void updatePrice(int id, RoomType type, int price) throws RemoteException {
		// TODO Auto-generated method stub
		if(id>=20000000 && id<=30000000){
			System.out.println("Update succeed!");
		}
		else System.out.println("Update failed!");
	}

	/**
	 *  更新room对象
	 */
	@Override
	public void updateRemainSum(int id, RoomType type, int remain) throws RemoteException {
		// TODO Auto-generated method stub
		if(id>=20000000 && id<=30000000){
			System.out.println("Update succeed!");
		}
		else System.out.println("Update failed!");		
	}

	/**
	 *  更新room对象
	 */
	@Override
	public void updateTotalSum(int id, RoomType type, int total) throws RemoteException {
		// TODO Auto-generated method stub
		if(id>=20000000 && id<=30000000){
			System.out.println("Update succeed!");
		}
		else System.out.println("Update failed!");		
	}

	/**
	 * 查找room对象
	 */
	@Override
	public RoomPO findRoom(int id, RoomType type) throws RemoteException {
		// TODO Auto-generated method stub
		if(id>=20000000 && id<=30000000){
			return new RoomPO(hotelID, roomType, totalSum, remainSum, price);
		}
		else return null;
	}

	/**
	 * 查找room对象
	 */
	@Override
	public ArrayList<RoomPO> findRooms(int id) throws RemoteException {
		// TODO Auto-generated method stub
		if(id>=20000000 && id<=30000000){
			return new ArrayList<RoomPO>();
		}
		else return null;
	}

	/**
	 * 初始化
	 */
	@Override
	public void initRoomDataService() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Init Finished!");
	}

	/**
	 * 结束
	 */
	@Override
	public void finishRoomDataService() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Finish Finished!");
	}

}
