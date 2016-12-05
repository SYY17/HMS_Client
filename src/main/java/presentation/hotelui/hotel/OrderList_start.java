package presentation.hotelui.hotel;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import presentation.controller.OrderControllerImpl;
import presentation.orderui.OrderControllerService;
import presentation.orderui.OrderData;
import presentation.orderui.OrderDataHelper;
import vo.OrderVO;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class OrderList_start extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("FXML/user/hotel/执行用户订单1.fxml"));
			initiateTableView(root);

			Scene scene = new Scene(root, 800, 600);
			// scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			// primaryStage.initStyle(StageStyle.DECORATED);
			OrderList_controller.stage = primaryStage;
			primaryStage.setScene(scene);
			primaryStage.setTitle("酒店管理系统");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void initiateTableView(Parent root) {
		@SuppressWarnings("unchecked")
		TableView<OrderData> orderListTableView = (TableView<OrderData>) root.lookup("#orderListTableView");
		final ObservableList<OrderData> data = FXCollections.observableArrayList();
		OrderControllerService orderControllerService = new OrderControllerImpl();
		data.clear();
		ObservableList<TableColumn<OrderData, ?>> observableList = orderListTableView.getColumns();
		initiateObservableList(observableList);
		ArrayList<OrderVO> orderList = orderControllerService
				.reviewOrder(/* id = */20905098);
		for (int i = 0; i < orderList.size(); i++) {
			OrderVO ovo = orderList.get(i);
			data.add(new OrderDataHelper().toOrderData(ovo));
		}
		orderListTableView.setItems(data);
	}

	private void initiateObservableList(ObservableList<TableColumn<OrderData, ?>> observableList) {
		observableList.get(0).setCellValueFactory(new PropertyValueFactory<>("orderID"));
		observableList.get(1).setCellValueFactory(new PropertyValueFactory<>("userName"));
		observableList.get(2).setCellValueFactory(new PropertyValueFactory<>("checkIn"));
		observableList.get(3).setCellValueFactory(new PropertyValueFactory<>("roomType"));
		observableList.get(4).setCellValueFactory(new PropertyValueFactory<>("roomNumber"));
		observableList.get(5).setCellValueFactory(new PropertyValueFactory<>("price"));
	}

	public static void main(String[] args) {
		launch(args);
	}
}