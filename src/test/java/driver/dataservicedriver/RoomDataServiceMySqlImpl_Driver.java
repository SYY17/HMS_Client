package driver.dataservicedriver;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.roomdataservice.RoomDataService;
import po.RoomPO;
import po.RoomType;

public class RoomDataServiceMySqlImpl_Driver {

	public void drive(RoomDataService roomDataService) throws RemoteException{
		int id = 20905110;
		RoomType type = RoomType.SINGLE_ROOM;
		int price = 350;
		int remain = 30;
		int total = 50;
		RoomPO rpo = new RoomPO(id, RoomType.SUITE, 40, 40, 300);
		ArrayList<RoomPO> rooms = new ArrayList<RoomPO>();
		
		//初始化RoomDataService
		roomDataService.initRoomDataService();
		System.out.println("RoomDataService initialized\n");
		
		//删除所有Room对象
		roomDataService.deleteAllRooms(id);
		System.out.println("Hotels deleted\n");
		
		//删除Room对象
		roomDataService.deleteRoom(id, type);
		System.out.println("Hotel deleted\n");
		
		//插入Room对象
		roomDataService.insertRoom(rpo);
		System.out.println("Hotel inserted\n");
		
		//更新Room对象的price
		roomDataService.updatePrice(id, type, price);
		System.out.println("Price modified\n");
		
		//更新Room对象的remainSum
		roomDataService.updateRemainSum(id, type, remain);
		System.out.println("Remain modified\n");				
		
		//更新Room对象的totalSum
		roomDataService.updateTotalSum(id, type, total);
		System.out.println("Total modified\n");
		
		//查找Room对象
		rpo = roomDataService.findRoom(id, type);
		System.out.println("Room found\n");

		//查找Room对象
		rooms = roomDataService.findRooms(id);
		System.out.println("Rooms found\n");
		
		//结束RoomDataService
		roomDataService.finishRoomDataService();
		System.out.println("RoomDataService finished\n");
	}
}
