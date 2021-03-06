package presentation.hotelui.hotel;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import presentation.controller.HotelControllerImpl;
import presentation.controller.IDHelper;
import presentation.hotelui.HotelControllerService;
import vo.RoomVO;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class Room_start extends Application {
	
	private IDHelper idHelper;
	private int id;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("FXML/user/hotel/维护客房信息.fxml"));
			this.initiateHelper();
			initiateTableView(root);
			initChoiceBox(root);
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

	/**
	 * 初始化ChoiceBox
	 */
	public void initChoiceBox(Parent root) {
		@SuppressWarnings("unchecked")
		// 查找promotionType
		ChoiceBox<Object> roomType = (ChoiceBox<Object>) root.lookup("#typeChoice");

		//roomType.setItems(FXCollections.observableArrayList("SINGLE_ROOM","STANDARD_ROOM","TRIPLE_ROOM","KING_SIZE_ROOM","SUITE"));
		roomType.setItems(FXCollections.observableArrayList("单人间","标准间","三人间","总统套房","套间"));
		
	}
	
	/**
	 * 初始化修改栏中原始数据
	 */
	public void initiateTexts(Parent root){
		
	}
	
	/**
	 * 初始化order列表
	 * @param root
	 */
	private void initiateTableView(Parent root) {
		@SuppressWarnings("unchecked")
		TableView<RoomData> roomView = (TableView<RoomData>) root.lookup("#roomView");
		final ObservableList<RoomData> data = FXCollections.observableArrayList();
		HotelControllerService hotelController = new HotelControllerImpl();
		data.clear();
		ObservableList<TableColumn<RoomData, ?>> observableList = roomView.getColumns();
		initiateObservableList(observableList);

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
	
	/**
	 * 获取当前hotel ID
	 */
	private void initiateHelper() {
		idHelper = IDHelper.getInstance();
		id = idHelper.getID();
	}

	public static void main(String[] args) {
		launch(args);
	}
}