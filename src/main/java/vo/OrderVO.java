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
	String userName;
	Timestamp setTime;
	Date checkIn;
	Date checkOut;
	int roomNumber;
	String hotelName;
	RoomType roomType;
	Timestamp deadline;
	int predictNumber;
	boolean haveChild;
	String room;

	public OrderVO(int orderid, String un, String hn, OrderStatus orderstatus, int pr, RoomType rT, int rn, Timestamp s,
			Date ci, Date co, Timestamp dl, int pn, boolean hc, String r) {
		orderID = orderid;
		orderStatus = orderstatus;
		price = pr;
		userName = un;
		setTime = s;
		checkIn = ci;
		checkOut = co;
		roomNumber = rn;
		hotelName = hn;
		roomType = rT;
		deadline = dl;
		predictNumber = pn;
		haveChild = hc;
		room = r;
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
	public String getUserName() {
		return userName;
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
	public String getHotelName() {
		return hotelName;
	}

	/**
	 * 
	 * @return 获得订单对应房间类型
	 */
	public RoomType getRoomType() {
		return roomType;
	}

	/**
	 * 
	 * @return 获得订单对应最晚订单执行时间
	 */
	public Timestamp getDeadline() {
		return deadline;
	}

	/**
	 * 
	 * @return 获得订单对应预计入住人数
	 */
	public int getPredictNumber() {
		return predictNumber;
	}

	/**
	 * 
	 * @return 获得订单对应是否有儿童
	 */
	public boolean getHaveChild() {
		return haveChild;
	}

	/**
	 * 
	 * @return 获得订单对应房间号
	 */
	public String getRoom() {
		return room;
	}
}
