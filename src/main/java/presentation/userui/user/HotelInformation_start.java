package presentation.userui.user;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import businesslogic.hotelbl.HotelController;
import businesslogicservice.hotelBLService.HotelBLService;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import presentation.controller.HotelControllerImpl;
import presentation.controller.IDHelper;
import presentation.controller.UserControllerImpl;
import presentation.hotelui.HotelControllerService;
import presentation.hotelui.hotel.RoomData;
import presentation.userui.UserControllerService;
import vo.HotelVO;
import vo.RoomVO;

public class HotelInformation_start extends Application {

	private IDHelper idHelper;
	private int id;
	
	@Override
	public void start(Stage primaryStage) {
		// TODO Auto-generated method stub
		try {
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("FXML/user/user/酒店信息.fxml"));
			initiateTableView(root);
			initiateTextArea(root);
			this.initiateHelper();
			this.initiateElements(root);
			
			Scene scene = new Scene(root, 800, 600);
			HotelInformation_controller.stage = primaryStage;
			// scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			// primaryStage.initStyle(StageStyle.DECORATED);
			primaryStage.setScene(scene);
			primaryStage.setTitle("酒店管理系统");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * 初始化表内数据
	 * 
	 * @param root
	 */
	private void initiateTableView(Parent root) {
		@SuppressWarnings("unchecked")
		// 查找tableview
		TableView<RoomData> hotelTableView  = (TableView<RoomData>) root
				.lookup("#hotelTableView");

		// 建立observablelist以更新数据
		final ObservableList<RoomData> data = FXCollections.observableArrayList();

		HotelControllerService hotelController = new HotelControllerImpl();
		data.clear();
		ObservableList<TableColumn<RoomData, ?>> observableList = hotelTableView.getColumns();
		initiateObservableList(observableList);

		ArrayList<RoomVO> roomList = hotelController.searchRooms(id);
		if (roomList != null) {
			for (int i = 0; i < roomList.size(); i++) {
				RoomVO rvo = roomList.get(i);
				data.add(new RoomData(rvo.getHotelID(), rvo.getRoomType(), rvo.getTotalSum(), rvo.getRemainSum(),
						rvo.getPrice()));
			}
		}
		hotelTableView.setItems(data);
	}

	/**
	 * 初始化数据表
	 * 
	 * @param observableList
	 */
	private void initiateObservableList(ObservableList<TableColumn<RoomData, ?>> observableList) {
		observableList.get(0).setCellValueFactory(new PropertyValueFactory<>("roomType"));
		observableList.get(1).setCellValueFactory(new PropertyValueFactory<>("totalNum"));
		observableList.get(2).setCellValueFactory(new PropertyValueFactory<>("vacantNum"));
		observableList.get(3).setCellValueFactory(new PropertyValueFactory<>("price"));
	}


	/**
	 * 初始化description
	 * 
	 * @param root
	 */
	private void initiateTextArea(Parent root) {
		// 查找description
		TextArea description  = (TextArea) root
				.lookup("#description");
		
		HotelBLService hotelBLService = new HotelController();
		ArrayList<HotelVO> hotelList = hotelBLService.searchHotel("name");
		
		HotelVO hvo = hotelList.get(0);
		description.setText(hvo.getHotelName()+"\n"+hvo.getRating()+"\n"+hvo.getHotelAddress()+"\n"+hvo.getBusinessArea()+"\n"+hvo.getHotelDescription()
		+"\n"+hvo.getPhoneNumber());
	}
	
	/**
	 * 初始化界面组件
	 * @param root
	 */
	private void initiateElements(Parent root) {
		// TODO Auto-generated method stub
		initiateUserName(root);
		initiateDate(root);
	}

	/**
	 * 获取当前用户ID
	 */
	private void initiateHelper() {
		idHelper = IDHelper.getInstance();
		id = idHelper.getID();
	}
	
	/**
	 * 初始化当前日期
	 * @param root
	 */
	private void initiateDate(Parent root){
		Label date = (Label) root.lookup("#date");
		Date time = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String text = format.format(time);
		date.setText(text);
	}

	/**
	 * 初始化当前用户用户名
	 * @param root
	 */
	private void initiateUserName(Parent root) {
		Label username = (Label) root.lookup("#username");
		UserControllerService userController = new UserControllerImpl();
		String name = userController.searchByUserID(id);
		username.setText(name);
	}
}
