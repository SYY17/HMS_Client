package vo;

import java.io.*;
import java.sql.Date;
import java.sql.Timestamp;

import vo.OrderStatus;
import vo.RoomType;

public class OrderVO implements Serializable {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int orderID;
	OrderStatus orderStatus;
	int price;
	int userID;
	Timestamp setTime;
	Date checkIn;
	Date checkOut;
	int roomNumber;
	int hotelID;
	RoomType roomType;

	public OrderVO(int orderid, int i, int hID, OrderStatus orderstatus, int pr, RoomType rT, int rn, Timestamp s,
			Date ci, Date co) {
		orderID = orderid;
		orderStatus = orderstatus;
		price = pr;
		userID = i;
		setTime = s;
		checkIn = ci;
		checkOut = co;
		roomNumber = rn;
		hotelID = hID;
		roomType = rT;
	}

	/**
	 * 
	 * @return 获得订单对应订单ID
	 */
	public int getOrderID() {
		return orderID;
	}

	/**
	 * 
	 * @return 获得订单对应订单状态
	 */
	public OrderStatus getOrderStatus() {
		return orderStatus;
	}

	/**
	 * 
	 * @return 获得订单对应订单总价
	 */
	public int getPrice() {
		return price;
	}

	/**
	 * 
	 * @return 获得订单对应用户ID
	 */
	public int getUserID() {
		return userID;
	}

	/**
	 * 
	 * @return 获得订单对应下单时间
	 */
	public Timestamp getSetTime() {
		return setTime;
	}

	/**
	 * 
	 * @return 获得订单对应入住时间
	 */
	public Date getCheckIn() {
		return checkIn;
	}

	/**
	 * 
	 * @return 获得订单对应离开时间
	 */
	public Date getCheckOut() {
		return checkOut;
	}

	/**
	 * 
	 * @return 获得订单对应入住时间
	 */
	public int getRoomNumber() {
		return roomNumber;
	}

	/**
	 * 
	 * @return 获得订单对应酒店ID
	 */
	public int getHotelID() {
		return hotelID;
	}

	/**
	 * 
	 * @return 获得订单对应房间类型
	 */
	public RoomType getRoomType() {
		return roomType;
	}
}
