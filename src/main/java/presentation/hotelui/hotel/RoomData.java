package presentation.hotelui.hotel;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import vo.RoomType;

public class RoomData {
	private final SimpleIntegerProperty hotelID = new SimpleIntegerProperty();
	private final SimpleStringProperty roomType = new SimpleStringProperty();
	private final SimpleIntegerProperty totalSum = new SimpleIntegerProperty();
	private final SimpleIntegerProperty remainSum = new SimpleIntegerProperty();
	private final SimpleIntegerProperty price = new SimpleIntegerProperty();

	public RoomData(int hotelID, RoomType roomType, int totalSum, int remainSum, int price) {
		this.hotelID.set(hotelID);
		this.roomType.set(roomType.toString());
		this.totalSum.set(totalSum);
		this.remainSum.set(remainSum);
		this.price.set(price);
	}

	public int getHotelID() {
		return hotelID.get();
	}

	public void setHotelID(int hotelID) {
		this.hotelID.set(hotelID);
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

	public int getTotalSum() {
		return totalSum.get();
	}

	public void setTotalSum(int totalSum) {
		this.totalSum.set(totalSum);
	}

	public int getRemainSum() {
		return remainSum.get();
	}

	public void setRemainSum(int remainSum) {
		this.remainSum.set(remainSum);
	}

	public int getPrice() {
		return price.get();
	}

	public void setPrice(int price) {
		this.price.set(price);
	}
}
