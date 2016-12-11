package presentation.userui.user;

import java.util.ArrayList;

import businesslogic.hotelbl.HotelController;
import businesslogicservice.hotelBLService.HotelBLService;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import vo.HotelVO;

public class HotelInformation_start extends Application {

	@Override
	public void start(Stage primaryStage) {
		// TODO Auto-generated method stub
		try {
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("FXML/user/user/酒店信息.fxml"));
			initiateTableView(root);
			initiateTextArea(root);
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
		TableView<HotelData> hotelTableView  = (TableView<HotelData>) root
				.lookup("#hotelTableView");

		// 建立observablelist以更新数据
		final ObservableList<HotelData> data = FXCollections.observableArrayList();

		HotelBLService hotelBLService = new HotelController();
		//OrderControllerService orderControllerService = new OrderControllerImpl();

		data.clear();
		ObservableList<TableColumn<HotelData, ?>> observableList = hotelTableView.getColumns();
		initiateObservableList(observableList);

		ArrayList<HotelVO> hotelList = hotelBLService.searchHotel("name");
		
		HotelVO hvo = hotelList.get(0);
		data.add(new HotelDataHelper().toHotelData(hvo));
		
		hotelTableView.setItems(data);
	}

	/**
	 * 初始化数据表
	 * 
	 * @param observableList
	 */
	private void initiateObservableList(ObservableList<TableColumn<HotelData, ?>> observableList) {
		observableList.get(0).setCellValueFactory(new PropertyValueFactory<>("roomType"));
		observableList.get(1).setCellValueFactory(new PropertyValueFactory<>("totalNum"));
		observableList.get(2).setCellValueFactory(new PropertyValueFactory<>("vacantNum"));
		observableList.get(3).setCellValueFactory(new PropertyValueFactory<>("brief"));
		observableList.get(4).setCellValueFactory(new PropertyValueFactory<>("price"));
	}


	/**
	 * 初始化description
	 * 
	 * @param root
	 */
	private void initiateTextArea(Parent root) {
		@SuppressWarnings("unchecked")
		// 查找description
		TextArea description  = (TextArea) root
				.lookup("#description");
		
		HotelBLService hotelBLService = new HotelController();
		ArrayList<HotelVO> hotelList = hotelBLService.searchHotel("name");
		
		HotelVO hvo = hotelList.get(0);
		description.setText(hvo.getHotelName()+"\n"+hvo.getRating()+"\n"+hvo.getHotelAddress()+"\n"+hvo.getBusinessArea()+"\n"+hvo.getHotelDescription()
		+"\n"+hvo.getPhoneNumber());
	}
}
