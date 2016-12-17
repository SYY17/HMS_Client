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
import vo.OrderStatus;
import vo.OrderVO;

public class ManageAbnormalOrder_start extends Application {
	private static ManageAbnormalOrder_start instance;
	private Parent root;
	
	private ManageAbnormalOrder_start() {
		// TODO Auto-generated constructor stub
	}
	
	//单件模式
	public static ManageAbnormalOrder_start getInstance(){
		if(instance == null){
			instance = new ManageAbnormalOrder_start();
		}
		return instance;
	}
	/**
	 * 提供给对外的刷新方法
	 */
	public void refreshTableView(){
		this.initiateTableView(root);
	}

//	public static void main(String[] args) {
//		launch(args);
//	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			root = FXMLLoader
					.load(getClass().getClassLoader().getResource("FXML/user/saler/ManageAbnormalOrder.fxml"));
			initiateTableView(root);
			Scene scene = new Scene(root, 800, 600);
			// scene.getStylesheets().add(getClass().getResource("main.css").toExternalForm());
			ManageAbnormalOrder_controller.stage = primaryStage;
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
		TableView<OrderDataForManageAbnormalOrder> manageAbnormalOrderTableView = (TableView<OrderDataForManageAbnormalOrder>) root
				.lookup("#manageAbnormalOrderTableView");
		System.out.println(manageAbnormalOrderTableView);

		// 建立observablelist以更新数据
		final ObservableList<OrderDataForManageAbnormalOrder> data = FXCollections.observableArrayList();

		// OrderBLService orderBLService = new OrderController();
		OrderControllerService orderControllerService = new OrderControllerImpl();

		data.clear();
		ObservableList<TableColumn<OrderDataForManageAbnormalOrder, ?>> observableList = manageAbnormalOrderTableView.getColumns();
		initiateObservableList(observableList);

		ArrayList<OrderVO> orderList = orderControllerService.reviewOrder(/* id = */40000000,OrderStatus.Abnormal);
		for (int i = 0; i < orderList.size(); i++) {
			OrderVO ovo = orderList.get(i);
			data.add(new OrderDataHelper().toOrderDataForManageAbnormalOrder(ovo));
		}
		manageAbnormalOrderTableView.setItems(data);
	}

	/**
	 * 初始化数据表
	 * 
	 * @param observableList
	 */
	private void initiateObservableList(ObservableList<TableColumn<OrderDataForManageAbnormalOrder, ?>> observableList) {
		observableList.get(0).setCellValueFactory(new PropertyValueFactory<>("orderID"));
		observableList.get(1).setCellValueFactory(new PropertyValueFactory<>("userName"));
		observableList.get(2).setCellValueFactory(new PropertyValueFactory<>("checkIn"));
		observableList.get(3).setCellValueFactory(new PropertyValueFactory<>("checkOut"));
		observableList.get(4).setCellValueFactory(new PropertyValueFactory<>("roomType"));
		observableList.get(5).setCellValueFactory(new PropertyValueFactory<>("roomNumber"));
		observableList.get(6).setCellValueFactory(new PropertyValueFactory<>("price"));
		observableList.get(7).setCellValueFactory(new PropertyValueFactory<>("operation"));
	}

}
