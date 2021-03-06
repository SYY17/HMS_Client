package presentation.userui.user;

import java.sql.Date;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import vo.RoomType;

public class OrderDataForRating {
	
	private final SimpleStringProperty hotelName = new SimpleStringProperty();
	private final SimpleStringProperty checkIn = new SimpleStringProperty();
	private final SimpleStringProperty checkOut = new SimpleStringProperty();
	private final SimpleStringProperty roomType = new SimpleStringProperty();
	private final SimpleIntegerProperty roomNumber = new SimpleIntegerProperty();
	private final SimpleIntegerProperty price = new SimpleIntegerProperty();
	private final SimpleStringProperty operation = new SimpleStringProperty();
	
	public OrderDataForRating(String hotelName, Date checkIn, Date checkOut, RoomType roomType, int roomNumber, int price){
		this.hotelName.set(hotelName);
		this.checkIn.set(checkIn.toString());
		this.checkOut.set(checkOut.toString());
		this.roomType.set(roomType.toString());
		this.roomNumber.set(roomNumber);
		this.price.set(price);
	}
	
	public String getHotelName() {
		return hotelName.get();
	}

	public void setHotelID(String hotelName) {
		this.hotelName.set(hotelName);
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
	
	public Button getOperation() {
		Button button = new Button();
		button.setPrefSize(20, 20);
		button.setMaxSize(20, 20);
		button.setMinSize(20, 20);
		button.setCursor(Cursor.HAND);
		
		button.setBackground(new Background(new BackgroundImage(
				new Image(getClass().getResource("orderhandle.png").toString()), null, null, null, null)));
		button.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				String name = getHotelName();
				OrderAndRating_start.getInstance().setName(name);
				OrderAndRating_start.getInstance().refreshTableView(name);

			}
		});

		return button;
	}

	public void setOperation(String operation) {
		this.operation.set(operation);
	}

}
