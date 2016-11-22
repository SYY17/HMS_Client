package businesslogic.hotelbl;

import java.util.ArrayList;

import vo.RoomVO;

public class HotelLineItem {
	int hotelID;
	String hotelName;
	String hotelAddress;
	String businessArea;
	String hotelDescription;
	int starLevel;
	int roomNumber;
	ArrayList<RoomVO> wholeRooms;
	double rating;
	String staffName;
	String phoneNumber;
	
	public HotelLineItem (int hid,String hn,String ha,String ba,String hd,int sl,int rn,ArrayList<RoomVO> rooms,double r,String sn,String pn){
		hotelID=hid;
		hotelName=hn;
		hotelAddress=ha;
		businessArea = ba;
		hotelDescription = hd;
		starLevel = sl;
		roomNumber=rn;
		wholeRooms = rooms;
		rating =r;
		staffName = sn;
		phoneNumber = pn;
	}
	
	/**
	 * 
	 * @return 获得酒店ID
	 */
	public int getHotelID(){
		return hotelID;
	}
	
	/**
	 * 设置酒店ID
	 * @param hotelID
	 */
	public void setHotelID(int hotelID){
		this.hotelID = hotelID;
	}
	
	/**
	 * 
	 * @return 获得酒店名称
	 */
	public String getHotelName(){
		return hotelName;
	}
	
	/**
	 * 设置酒店名称
	 * @param hotelName
	 */
	public void setHotelName(String hotelName){
		this.hotelName = hotelName;
	}
	
	/**
	 * 
	 * @return 获得酒店地址
	 */
	public String getHotelAddress(){
		return hotelAddress;
	}
	
	/**
	 * 设置酒店地址
	 * @param hotelAddress
	 */
	public void setHotelAddress(String hotelAddress){
		this.hotelAddress = hotelAddress;
	}
	
	/**
	 * 
	 * @return 获得酒店商圈
	 */
	public String getBusinessArea(){
		return businessArea;
	}
	
	/**
	 * 设置酒店商圈
	 * @param businessArea
	 */
	public void setBusinessArea(String businessArea){
		this.businessArea = businessArea;
	}
	
	/**
	 * 
	 * @return 获得酒店简介
	 */
	public String getHotelDescription(){
		return hotelDescription;
	}
	
	/**
	 * 设置酒店简介
	 * @param hotelDescription
	 */
	public void setHotelDescription(String hotelDescription){
		this.hotelDescription = hotelDescription;
	}
	
	/**
	 * 
	 * @return 获得酒店星级
	 */
	public int getStarLevel(){
		return starLevel;
	}
	
	/**
	 * 设置酒店星级
	 * @param starLevel
	 */
	public void setStarLevel(int starLevel){
		this.starLevel = starLevel;
	}
	
	/**
	 * 
	 * @return 获得房间号
	 */
	public int getRoomNumber(){
		return roomNumber;
	}
	
	/**
	 * 设置房间号
	 * @param roomNumber
	 */
	public void setRoomNumber(int roomNumber){
		this.roomNumber = roomNumber;
	}
	
	/**
	 * 
	 * @return 获得所有房间
	 */
	public ArrayList<RoomVO> getWholeRooms(){
		return wholeRooms;
	}
	
	/**
	 * 设置房间
	 * @param wholeRooms
	 */
	public void setWholeRooms(ArrayList<RoomVO> wholeRooms){
		this.wholeRooms = wholeRooms;
	}
	
	/**
	 * 
	 * @return 获得评级
	 */
	public double getRating(){
		return rating;
	}
	
	/**
	 * 设置评级
	 * @param rating
	 */
	public void setRating(int rating){
		this.rating = rating;
	}
	
	/**
	 * 
	 * @return 获得工作人员姓名
	 */
	public String getStaffName(){
		return staffName;
	}
	
	/**
	 * 设置酒店工作人员姓名
	 * @param staffName
	 */
	public void setStaffName(String staffName){
		this.staffName = staffName;
	}
	
	/**
	 * 
	 * @return 获得酒店电话号码
	 */
	public String getPhoneNumber(){
		return phoneNumber;
	}
	
	/**
	 * 设置酒店电话号码
	 * @param phoneNumber
	 */
	public void setPhoneNumber(String phoneNumber){
		this.phoneNumber = phoneNumber;
	}	
}
