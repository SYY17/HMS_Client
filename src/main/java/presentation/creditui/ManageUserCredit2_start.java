package presentation.creditui;


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
import presentation.orderui.OrderControllerService;
import presentation.orderui.OrderData;
import presentation.orderui.OrderDataHelper;
import vo.OrderStatus;
import vo.OrderVO;

public class ManageUserCredit2_start extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("FXML/user/saler/ManageUserCredit2.fxml"));
			initiateTableView(root);
			Scene scene = new Scene(root, 800, 600);
//			scene.getStylesheets().add(getClass().getResource("main.css").toExternalForm());
			ManageUserCredit2_controller.stage = primaryStage;
			primaryStage.setScene(scene);
			primaryStage.setTitle("管理用户信用值");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	private void initiateTableView(Parent root) {
		@SuppressWarnings("unchecked")
		TableView<OrderData> abnormalOrderTable = (TableView<OrderData>) root.lookup("#abnormalOrderTable");
		System.out.println(abnormalOrderTable);
		final ObservableList<OrderData> data = FXCollections.observableArrayList();
		OrderControllerService orderControllerService = new OrderControllerImpl();
		data.clear();
		ObservableList<TableColumn<OrderData, ?>> observableList = abnormalOrderTable.getColumns();
		initiateObservableList(observableList);
		ArrayList<OrderVO> orderList = orderControllerService.reviewOrder(/* id = */40000000);
		for (int i = 0; i < orderList.size(); i++) {
			OrderVO ovo = orderList.get(i);
			data.add(new OrderDataHelper().toOrderData(ovo));
		}
		abnormalOrderTable.setItems(data);
	}

	private void initiateObservableList(ObservableList<TableColumn<OrderData, ?>> observableList) {
		observableList.get(0).setCellValueFactory(new PropertyValueFactory<>("orderID"));
		observableList.get(1).setCellValueFactory(new PropertyValueFactory<>("userName"));
		observableList.get(2).setCellValueFactory(new PropertyValueFactory<>("checkIn"));
		observableList.get(3).setCellValueFactory(new PropertyValueFactory<>("price"));
	}


	public static void main(String[] args) {
		launch(args);
	}
}
