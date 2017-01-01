package presentation.userui.user;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import vo.RoomType;

public class HotelData {
	
	private final SimpleStringProperty roomType = new SimpleStringProperty();
	private final SimpleIntegerProperty totalNum = new SimpleIntegerProperty();
	private final SimpleIntegerProperty vacantNum = new SimpleIntegerProperty();
	private final SimpleStringProperty brief = new SimpleStringProperty();
	private final SimpleIntegerProperty price = new SimpleIntegerProperty();
	
	public HotelData( RoomType roomType, int totalNum, int vacantNum, String brief, int price){
		this.roomType.set(roomType.toString());
		this.totalNum.set(totalNum);
		this.vacantNum.set(vacantNum);
		this.brief.set(brief);
		this.price.set(price);
	}
	
	public int getTotalNum() {
		return totalNum.get();
	}

	public void setTotalNum(int totalNum) {
		this.totalNum.set(totalNum);
	}
	
	public int getVacantNum() {
		return vacantNum.get();
	}

	public void setVacantNum(int vacantNum) {
		this.vacantNum.set(vacantNum);
	}
	
	public int getPrice() {
		return price.get();
	}

	public void setPrice(int price) {
		this.price.set(price);
	}
	
	public String getBrief() {
		return brief.get();
	}

	public void setBrief(String brief) {
		this.brief.set(brief);
	}
	
	public String getRoomType() {
		String result = "";
		if (roomType.get().equals(RoomType.KING_SIZE_ROOM.toString())) {
			result = "KING_SIZE_ROOM";//
		} else if (roomType.get().equals(RoomType.SINGLE_ROOM.toString())) {
			result = "SINGLE_ROOM";//
		} else if (roomType.get().equals(RoomType.STANDARD_ROOM.toString())) {
			result = "STANDARD_ROOM";//
		} else if (roomType.get().equals(RoomType.SUITE.toString())) {
			result = "SUITE";//
		}else if (roomType.get().equals(RoomType.TRIPLE_ROOM.toString())) {
			result = "TRIPLE_ROOM";//
		}
		
		return result;
	}

	public void seRoomType(RoomType roomType) {
		this.roomType.set(roomType.toString());
	}
}
