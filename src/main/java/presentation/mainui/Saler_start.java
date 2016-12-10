package presentation.mainui;

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

public class Saler_start extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("FXML/user/saler/SalerUI.fxml"));
			initiateTableView(root);
			Scene scene = new Scene(root, 800, 600);
			Saler_controller.stage = primaryStage;
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
		TableView<OrderData> newAbnormalOrderTableView = (TableView<OrderData>) root
				.lookup("#newAbnormalOrderTableView");
		System.out.println(newAbnormalOrderTableView);

		// 建立observablelist以更新数据
		final ObservableList<OrderData> data = FXCollections.observableArrayList();

		// OrderBLService orderBLService = new OrderController();
		OrderControllerService orderControllerService = new OrderControllerImpl();

		data.clear();
		ObservableList<TableColumn<OrderData, ?>> observableList = newAbnormalOrderTableView.getColumns();
		initiateObservableList(observableList);

		ArrayList<OrderVO> orderList = orderControllerService.reviewOrder(/* id = */40000000);
		for (int i = 0; i < orderList.size(); i++) {
			OrderVO ovo = orderList.get(i);
			data.add(new OrderDataHelper().toOrderData(ovo));
		}
		newAbnormalOrderTableView.setItems(data);
	}

	/**
	 * 初始化数据表
	 * 
	 * @param observableList
	 */
	private void initiateObservableList(ObservableList<TableColumn<OrderData, ?>> observableList) {
		observableList.get(0).setCellValueFactory(new PropertyValueFactory<>("orderID"));
		observableList.get(1).setCellValueFactory(new PropertyValueFactory<>("userName"));
		observableList.get(2).setCellValueFactory(new PropertyValueFactory<>("checkIn"));
		observableList.get(3).setCellValueFactory(new PropertyValueFactory<>("price"));
	}
}
