package presentation.hotelui.hotel;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import presentation.controller.HotelControllerImpl;
import presentation.hotelui.HotelControllerService;
import vo.RoomVO;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Room_start extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("FXML/user/hotel/维护客房信息.fxml"));
			initiateTableView(root);
			Scene scene = new Scene(root, 800, 600);
			// scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			// primaryStage.initStyle(StageStyle.DECORATED);
			Room_controller.stage = primaryStage;
			primaryStage.setScene(scene);
			primaryStage.setTitle("酒店管理系统");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void initiateTableView(Parent root) {
		@SuppressWarnings("unchecked")
		TableView<RoomData> roomView = (TableView<RoomData>) root.lookup("#roomView");
		final ObservableList<RoomData> data = FXCollections.observableArrayList();
		HotelControllerService hotelController = new HotelControllerImpl();
		data.clear();
		ObservableList<TableColumn<RoomData, ?>> observableList = roomView.getColumns();
		initiateObservableList(observableList);

		int id = 20905098; /* 传入id? */

		ArrayList<RoomVO> roomList = hotelController.searchRooms(id);
		if (roomList != null) {
			for (int i = 0; i < roomList.size(); i++) {
				RoomVO rvo = roomList.get(i);
				data.add(new RoomData(rvo.getHotelID(), rvo.getRoomType(), rvo.getTotalSum(), rvo.getRemainSum(),
						rvo.getPrice()));
			}
		}
		roomView.setItems(data);

	}

	private void initiateObservableList(ObservableList<TableColumn<RoomData, ?>> observableList) {
		observableList.get(0).setCellValueFactory(new PropertyValueFactory<>("roomType"));
		observableList.get(1).setCellValueFactory(new PropertyValueFactory<>("totalSum"));
		observableList.get(2).setCellValueFactory(new PropertyValueFactory<>("remainSum"));
		observableList.get(3).setCellValueFactory(new PropertyValueFactory<>("price"));
	}

	public static void main(String[] args) {
		launch(args);
	}
}