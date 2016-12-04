package presentation.userui.user;

import java.util.ArrayList;

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
import presentation.controller.HotelControllerImpl;
import presentation.controller.OrderControllerImpl;
import presentation.hotelui.HotelControllerService;
import presentation.orderui.OrderControllerService;
import presentation.orderui.OrderData;
import vo.HotelVO;
import vo.OrderVO;

public class OrderAndRating_start extends Application {

	@Override
	public void start(Stage primaryStage) {
		// TODO Auto-generated method stub
		try {
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("FXML/user/user/OrderAndRating.fxml"));

//			initiateHotelInfoText(root);
//			initiateTableView(root);

			Scene scene = new Scene(root, 800, 600);
			OrderAndRating_controller.stage = primaryStage;
			// scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			// primaryStage.initStyle(StageStyle.DECORATED);
			primaryStage.setScene(scene);
			primaryStage.setTitle("酒店管理系统");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void initiateHotelInfoText(Parent root) {
		TextArea hotelInfoText = (TextArea) root.lookup("#hotelInfoText");

		String name = "homeinn";// not finished

		HotelControllerService hotelController = new HotelControllerImpl();
		HotelVO hvo = hotelController.reviewHotelInfo(name);
		hotelInfoText.setText("酒店名称：" + hvo.getHotelName() + "\n" + "地址：" + hvo.getHotelAddress() + "\n" + "商圈："
				+ hvo.getBusinessArea() + "\n" + "星级：" + hvo.getStarLevel() + "星\n" + "联系方式：" + hvo.getPhoneNumber()
				+ "\n" + "简介：" + hvo.getHotelDescription());

	}

	private void initiateTableView(Parent root) {
		@SuppressWarnings("unchecked")
		TableView<OrderData> orderAndRatingTableView = (TableView<OrderData>) root.lookup("#orderAndRatingTableView");
		final ObservableList<OrderData> data = FXCollections.observableArrayList();
		OrderControllerService orderControllerService = new OrderControllerImpl();
		data.clear();
		ObservableList<TableColumn<OrderData, ?>> observableList = orderAndRatingTableView.getColumns();
		initiateObservableList(observableList);
		ArrayList<OrderVO> orderList = orderControllerService
				.reviewOrder(/* id = */20905098);
		for (int i = 0; i < orderList.size(); i++) {
			OrderVO ovo = orderList.get(i);
			data.add(new OrderData(ovo.getHotelName(), ovo.getCheckIn(), ovo.getCheckOut(), ovo.getRoomType(),
					ovo.getRoomNumber(), ovo.getPrice()));
		}
		orderAndRatingTableView.setItems(data);
	}

	private void initiateObservableList(ObservableList<TableColumn<OrderData, ?>> observableList) {
		observableList.get(0).setCellValueFactory(new PropertyValueFactory<>("hotelName"));
		observableList.get(1).setCellValueFactory(new PropertyValueFactory<>("checkIn"));
		observableList.get(2).setCellValueFactory(new PropertyValueFactory<>("checkOut"));
		observableList.get(3).setCellValueFactory(new PropertyValueFactory<>("roomType"));
		observableList.get(4).setCellValueFactory(new PropertyValueFactory<>("roomNumber"));
		observableList.get(5).setCellValueFactory(new PropertyValueFactory<>("price"));
	}

	public static void main(String[] args) {
		launch(args);
	}
}
