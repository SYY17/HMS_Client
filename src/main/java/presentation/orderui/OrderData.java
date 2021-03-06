package presentation.orderui;

import java.sql.Date;
import java.sql.Timestamp;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import vo.RoomType;
import vo.OrderStatus;

public class OrderData {
	private final SimpleIntegerProperty orderID = new SimpleIntegerProperty();
	private final SimpleStringProperty userName = new SimpleStringProperty();
	private final SimpleStringProperty orderStatus = new SimpleStringProperty();
	private final SimpleStringProperty hotelName = new SimpleStringProperty();
	private final SimpleStringProperty setTime = new SimpleStringProperty();
	private final SimpleStringProperty checkIn = new SimpleStringProperty();
	private final SimpleStringProperty checkOut = new SimpleStringProperty();
	private final SimpleStringProperty roomType = new SimpleStringProperty();
	private final SimpleIntegerProperty roomNumber = new SimpleIntegerProperty();
	private final SimpleIntegerProperty price = new SimpleIntegerProperty();

	public OrderData(int orderID, String userName, OrderStatus orderStatus, String hotelName, Timestamp setTime,
			Date checkIn, Date checkOut, RoomType roomType, int roomNumber, int price) {
		this.orderID.set(orderID);
		this.userName.set(userName);
		this.orderStatus.set(orderStatus.toString());
		this.hotelName.set(hotelName);
		this.setTime.set(setTime.toString());
		this.checkIn.set(checkIn.toString());
		this.checkOut.set(checkOut.toString());
		this.roomType.set(roomType.toString());
		this.roomNumber.set(roomNumber);
		this.price.set(price);
	}

	public int getOrderID() {
		return orderID.get();
	}

	public void setOrderID(int orderID) {
		this.orderID.set(orderID);
	}

	public String getUserName() {
		return userName.get();
	}

	public void setUserName(String userName) {
		this.userName.set(userName);
	}

	public String getOrderStatus() {
		String result = "";
		if (orderStatus.get().equals(OrderStatus.Abnormal.toString())) {
			result = "异常";
		} else if (orderStatus.get().equals(OrderStatus.Canceled.toString())) {
			result = "取消";
		} else if (orderStatus.get().equals(OrderStatus.Finished.toString())) {
			result = "完成";
		} else if (orderStatus.get().equals(OrderStatus.Unfilled.toString())) {
			result = "未完成";
		} else if (orderStatus.get().equals(OrderStatus.Checkout.toString())) {
			result = "完成";
		}
		return result;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus.set(orderStatus.toString());
	}

	public String getHotelName() {
		return hotelName.get();
	}

	public void setHotelID(String hotelName) {
		this.hotelName.set(hotelName);
	}

	public String getSetTime() {
		return setTime.get();
	}

	public void setSetTime(String setTime) {
		this.setTime.set(setTime);
	}

	public String getCheckIn() {
		return checkIn.get();
	}

	public void setCheckIn(Date checkIn) {
		this.checkIn.set(checkIn.toString());
	}

	public String getCheckOut() {
		return checkOut.get();
	}

	public void setCheckOut(Date checkOut) {
		this.checkOut.set(checkOut.toString());
	}

	public String getRoomType() {
		String result = "";
		if (roomType.get().equals(RoomType.KING_SIZE_ROOM.toString())) {
			result = "总统套房";
		} else if (roomType.get().equals(RoomType.SINGLE_ROOM.toString())) {
			result = "单人间";
		} else if (roomType.get().equals(RoomType.STANDARD_ROOM.toString())) {
			result = "标准间";
		} else if (roomType.get().equals(RoomType.SUITE.toString())) {
			result = "套房";
		} else if (roomType.get().equals(RoomType.TRIPLE_ROOM.toString())) {
			result = "三人间";
		}
		return result;
	}

	public void setRoomType(RoomType roomType) {
		this.roomType.set(roomType.toString());
	}

	public int getRoomNumber() {
		return roomNumber.get();
	}

	public void setRoomNumber(int roomNumber) {
		this.roomNumber.set(roomNumber);
	}

	public int getPrice() {
		return price.get();
	}

	public void setPrice(int price) {
		this.price.set(price);
	}
}
