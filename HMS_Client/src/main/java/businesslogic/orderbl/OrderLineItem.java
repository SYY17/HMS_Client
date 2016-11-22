package businesslogic.orderbl;

import java.util.ArrayList;
import java.util.Date;

import vo.OrderStatus;
import vo.RoomVO;

public class OrderLineItem{
	int orderID;
	OrderStatus orderStatus;
	int price;
	int userID;
	Date setTime;
	Date checkIn;
	Date checkOut;
	int roomNumber;
	int hotelID;
	ArrayList<RoomVO> rooms;

	
	public OrderLineItem(int orderid, OrderStatus orderstatus, int pr,int i,Date s,Date ci,Date co,int rn,int hID,ArrayList<RoomVO> rt){
		orderID = orderid;
		orderStatus = orderstatus;
		price = pr;
		userID=i;
		setTime=s;
		checkIn=ci;
		checkOut=co;
		roomNumber=rn;
		hotelID=hID;
		rooms=rt;
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
	 * @return 获得订单对应价格
	 */
	public int getPrice() {
		return price;
	}
	
	/**
	 * 
	 * @return 获得订单对应用户ID
	 */
	public int getUserID(){
		return userID;
	}
	
	/**
	 * 
	 */
	public void setUserID(int userID) {
		this.userID = userID;
	}
	
	/**
	 * 
	 * @return 获得订单对应下单时间
	 */
	public Date getSetTime(){
		return setTime;
	}
	
	/**
	 * 
	 */
	public void setSetTime(Date setTime) {
		this.setTime = setTime;
	}
	
	/**
	 * 
	 * @return 获得订单对应入住时间
	 */
	public Date getCheckIn(){
		return checkIn;
	}
	
	/**
	 * 
	 */
	public void setCheckIn(Date checkIn) {
		this.checkIn = checkIn;
	}
	
	/**
	 * 
	 * @return 获得订单对应离开时间
	 */
	public Date getCheckOut(){
		return checkOut;
	}
	
	/**
	 * 
	 */
	public void setCheckOut(Date checkOut) {
		this.checkOut = checkOut;
	}
	
	/**
	 * 
	 * @return 获得订单对应入住时间
	 */
	public int getRoomNumber(){
		return roomNumber;
	}
	
	/**
	 * 
	 */
	public void setRoomNumber(int roomNumber) {
		this.roomNumber = roomNumber;
	}
	
	/**
	 * 
	 * @return 获得订单对应酒店ID
	 */
	public int getHotelID(){
		return hotelID;
	}
	
	/**
	 * 
	 */
	public void setHotelID(int hotelID) {
		this.hotelID = hotelID;
	}
	/**
	 * 
	 * @return 获得订单对应房间列表
	 */
	public ArrayList<RoomVO> getRooms(){
		return rooms;
	}
	
	/**
	 * 
	 */
	public void setRooms(ArrayList<RoomVO> rooms) {
		this.rooms = rooms;
	}
}
