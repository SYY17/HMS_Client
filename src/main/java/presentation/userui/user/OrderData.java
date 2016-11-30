package presentation.userui.user;

import java.sql.Date;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import vo.RoomType;
import vo.OrderStatus;

public class OrderData {
	private final SimpleIntegerProperty orderID = new SimpleIntegerProperty();
	private final SimpleStringProperty orderStatus = new SimpleStringProperty();
	private final SimpleIntegerProperty hotelID = new SimpleIntegerProperty();
	private final SimpleStringProperty checkIn = new SimpleStringProperty();
	private final SimpleStringProperty checkOut = new SimpleStringProperty();
	private final SimpleStringProperty roomType = new SimpleStringProperty();
	private final SimpleIntegerProperty roomNumber = new SimpleIntegerProperty();

	public OrderData(int orderID, OrderStatus orderStatus, int hotelID, Date checkIn, Date checkOut,
			RoomType roomType, int roomNumber) {
		this.orderID.set(orderID);
		this.orderStatus.set(orderStatus.toString());
		this.hotelID.set(hotelID);
		this.checkIn.set(checkIn.toString());
		this.checkOut.set(checkOut.toString());
		this.roomType.set(roomType.toString());
		this.roomNumber.set(roomNumber);
	}

	public int getOrderID() {
		return orderID.get();
	}

	public void setOrderID(int orderID) {
		this.orderID.set(orderID);
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
		}
		return result;
	}

	public void setOrderStatus(OrderStatus orderStatus) {
		this.orderStatus.set(orderStatus.toString());
	}

	public int getHotelID() {
		return hotelID.get();
	}

	public void setHotelID(int hotelID) {
		this.hotelID.set(hotelID);
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
}
