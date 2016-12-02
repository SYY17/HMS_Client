package presentation.orderui;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import presentation.controller.OrderControllerImpl;
import vo.OrderVO;

public class ManageAbnormalOrder1_start extends Application {
	
	public static void main(String[] args) {
		launch(args);
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			Parent root = FXMLLoader
					.load(getClass().getClassLoader().getResource("FXML/user/saler/ManageAbnormalOrder1.fxml"));
			initiateTableView(root);
			Scene scene = new Scene(root, 800, 600);
			// scene.getStylesheets().add(getClass().getResource("main.css").toExternalForm());
			ManageAbnormalOrder1_controller.stage = primaryStage;
			primaryStage.setScene(scene);
			primaryStage.setTitle("管理异常订单");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 初始化表内数据
	 * 
	 * @param root
	 */
	private void initiateTableView(Parent root) {
		@SuppressWarnings("unchecked")
		// 查找tableview
		TableView<OrderData> manageAbnormalOrderTableView = (TableView<OrderData>) root
				.lookup("#manageAbnormalOrderTableView");

		// 建立observablelist以更新数据
		final ObservableList<OrderData> data = FXCollections.observableArrayList();

		// OrderBLService orderBLService = new OrderController();
		OrderControllerService orderControllerService = new OrderControllerImpl();

		data.clear();
		ObservableList<TableColumn<OrderData, ?>> observableList = manageAbnormalOrderTableView.getColumns();
		initiateObservableList(observableList);

		ArrayList<OrderVO> orderList = orderControllerService
				.reviewOrder(/* id = */20905098);
		for (int i = 0; i < orderList.size(); i++) {
			OrderVO ovo = orderList.get(i);
			data.add(new OrderData(ovo.getOrderID(), ovo.getUserID(), ovo.getCheckIn(), ovo.getCheckOut(),
					ovo.getRoomType(), ovo.getRoomNumber(), ovo.getPrice()));
		}
		orderList = orderControllerService.reviewOrder(/* id = */12098013);
		for (int i = 0; i < orderList.size(); i++) {
			OrderVO ovo = orderList.get(i);

			// 建议建立一个创建OrderData对象的方法
			data.add(new OrderData(ovo.getOrderID(), ovo.getUserID(), ovo.getCheckIn(), ovo.getCheckOut(),
					ovo.getRoomType(), ovo.getRoomNumber(), ovo.getPrice()));
		}
		manageAbnormalOrderTableView.setItems(data);
	}

	/**
	 * 初始化数据表
	 * 
	 * @param observableList
	 */
	private void initiateObservableList(ObservableList<TableColumn<OrderData, ?>> observableList) {
		observableList.get(0).setCellValueFactory(new PropertyValueFactory<>("orderID"));
		observableList.get(1).setCellValueFactory(new PropertyValueFactory<>("userID"));
		observableList.get(2).setCellValueFactory(new PropertyValueFactory<>("checkIn"));
		observableList.get(3).setCellValueFactory(new PropertyValueFactory<>("checkOut"));
		observableList.get(4).setCellValueFactory(new PropertyValueFactory<>("roomType"));
		observableList.get(5).setCellValueFactory(new PropertyValueFactory<>("roomNumber"));
		observableList.get(6).setCellValueFactory(new PropertyValueFactory<>("price"));
	}
	
}
