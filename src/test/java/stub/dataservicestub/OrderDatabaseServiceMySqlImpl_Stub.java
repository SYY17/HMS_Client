package stub.dataservicestub;

import java.rmi.RemoteException;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

import dataservice.orderdataservice.OrderDataService;
import po.OrderPO;
import po.OrderStatus;
import po.RoomType;

public class OrderDatabaseServiceMySqlImpl_Stub implements OrderDataService {

	@Override
	public void insertOrder(OrderPO po) throws RemoteException {
		// TODO Auto-generated method stub
		if (po.getOrderID() == 100) {
			System.out.println("Insert Finished!");
		} else {
			System.out.println("Failed!");
		}
	}

	@Override
	public void deleteOrder(int id) throws RemoteException {
		// TODO Auto-generated method stub
		if (id == 100) {
			System.out.println("Delete Finished!");
		} else {
			System.out.println("Failed!");
		}
	}

	@Override
	public void updateOrder(int id, OrderStatus status) throws RemoteException {
		// TODO Auto-generated method stub
		if (id == 100) {
			System.out.println("Update Finished!");
		} else {
			System.out.println("Failed!");
		}
	}

	@Override
	public void updateOrder(int id, String room) throws RemoteException {
		// TODO Auto-generated method stub
		if (id == 100) {
			System.out.println("Update Finished!");
		} else {
			System.out.println("Failed!");
		}
	}

	@Override
	public ArrayList<OrderPO> findOrder() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Insert Finished!");
		ArrayList<OrderPO> list = new ArrayList<OrderPO>();
		list.add(new OrderPO(100, "user", "hotel", OrderStatus.Unfilled, 1000, RoomType.SINGLE_ROOM, 1,
				new Timestamp(System.currentTimeMillis()), new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24),
				new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 2),
				new Timestamp(System.currentTimeMillis() + 1000 * 60 * 60 * 24), 1, false, "123"));
		return list;
	}

	@Override
	public OrderPO findOrderByOrderID(int id) throws RemoteException {
		// TODO Auto-generated method stub
		if (id == 100) {
			System.out.println("Order Found!");
			return new OrderPO(100, "user", "hotel", OrderStatus.Unfilled, 1000, RoomType.SINGLE_ROOM, 1,
					new Timestamp(System.currentTimeMillis()),
					new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24),
					new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 2),
					new Timestamp(System.currentTimeMillis() + 1000 * 60 * 60 * 24), 1, false, "123");
		} else {
			System.out.println("Failed!");
			return null;
		}
	}

	@Override
	public ArrayList<OrderPO> findOrderByUserName(String userName) throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<OrderPO> list = new ArrayList<OrderPO>();
		if (userName.equals("user")) {
			System.out.println("Order Found!");
			list.add(new OrderPO(100, "user", "hotel", OrderStatus.Unfilled, 1000, RoomType.SINGLE_ROOM, 1,
					new Timestamp(System.currentTimeMillis()),
					new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24),
					new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 2),
					new Timestamp(System.currentTimeMillis() + 1000 * 60 * 60 * 24), 1, false, "123"));
			return list;
		} else {
			System.out.println("Failed!");
			return list;
		}
	}

	@Override
	public ArrayList<OrderPO> findOrderByHotelName(String hotelName) throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<OrderPO> list = new ArrayList<OrderPO>();
		if (hotelName.equals("hotel")) {
			System.out.println("Order Found!");
			list.add(new OrderPO(100, "user", "hotel", OrderStatus.Unfilled, 1000, RoomType.SINGLE_ROOM, 1,
					new Timestamp(System.currentTimeMillis()),
					new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24),
					new Date(System.currentTimeMillis() + 1000 * 60 * 60 * 24 * 2),
					new Timestamp(System.currentTimeMillis() + 1000 * 60 * 60 * 24), 1, false, "123"));
			return list;
		} else {
			System.out.println("Failed!");
			return list;
		}
	}

	@Override
	public void initOrderDataService() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Init Finished!");
	}

	@Override
	public void finishOrderDataService() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Finish Finished!");
	}
}
