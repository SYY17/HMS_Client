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
import presentation.controller.UserControllerImpl;
import presentation.controller.UserNameHelper;
import presentation.userui.UserControllerService;
import vo.OrderStatus;
import vo.OrderVO;

public class ManageAbnormalOrderAndCredit_start extends Application{
	private static ManageAbnormalOrderAndCredit_start instance;
	private Parent root;
	
	private ManageAbnormalOrderAndCredit_start() {
		// TODO Auto-generated constructor stub
	}
	
	//单件模式
	public static ManageAbnormalOrderAndCredit_start getInstance(){
		if(instance == null){
			instance = new ManageAbnormalOrderAndCredit_start();
		}
		return instance;
	}
	/**
	 * 提供给对外的刷新方法
	 */
	public void refreshTableView(){
		this.initiateTableView(root);
	}
	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			root = FXMLLoader.load(getClass().getClassLoader().getResource("FXML/user/saler/ManageAbnormalOrderAndCredit.fxml"));
			initiateTableView(root);
			
			Scene scene = new Scene(root, 800, 600);
//			scene.getStylesheets().add(getClass().getResource("main.css").toExternalForm());
			ManageAbnormalOrderAndCredit_controller.stage = primaryStage;
			primaryStage.setScene(scene);
			primaryStage.setTitle("管理异常订单");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void initiateTableView(Parent root) {
		@SuppressWarnings("unchecked")
		TableView<OrderDataForManageAbnormalOrderAndCredit> manageAbnormalOrderTableView = (TableView<OrderDataForManageAbnormalOrderAndCredit>) root.lookup("#manageAbnormalOrderTableView");
		System.out.println(manageAbnormalOrderTableView);
		final ObservableList<OrderDataForManageAbnormalOrderAndCredit> data = FXCollections.observableArrayList();
		OrderControllerService orderControllerService = new OrderControllerImpl();
		UserControllerService userControllerService = new UserControllerImpl();
		int userID = userControllerService.searchByUserName(UserNameHelper.getInstance().getUserName()).getID();
		data.clear();
		ObservableList<TableColumn<OrderDataForManageAbnormalOrderAndCredit, ?>> observableList = manageAbnormalOrderTableView.getColumns();
		initiateObservableList(observableList);
		ArrayList<OrderVO> orderList = orderControllerService.reviewOrder(userID,OrderStatus.Abnormal);
		for (int i = 0; i < orderList.size(); i++) {
			OrderVO ovo = orderList.get(i);
			data.add(new OrderDataHelper().toOrderDataForManageAbnormalOrderAndCredit(ovo));
		}
		manageAbnormalOrderTableView.setItems(data);
	}

	private void initiateObservableList(ObservableList<TableColumn<OrderDataForManageAbnormalOrderAndCredit, ?>> observableList) {
		observableList.get(0).setCellValueFactory(new PropertyValueFactory<>("orderID"));
		observableList.get(1).setCellValueFactory(new PropertyValueFactory<>("checkIn"));
		observableList.get(2).setCellValueFactory(new PropertyValueFactory<>("roomType"));
		observableList.get(3).setCellValueFactory(new PropertyValueFactory<>("roomNumber"));
		observableList.get(4).setCellValueFactory(new PropertyValueFactory<>("price"));
		observableList.get(5).setCellValueFactory(new PropertyValueFactory<>("operation"));
	}
	

//	public static void main(String[] args) {
//		launch(args);
//	}
}
