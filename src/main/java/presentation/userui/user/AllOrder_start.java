package presentation.userui.user;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import presentation.controller.IDHelper;
import presentation.controller.OrderControllerImpl;
import presentation.orderui.OrderControllerService;
import presentation.orderui.OrderData;
import presentation.orderui.OrderDataHelper;
import vo.OrderStatus;
import vo.OrderVO;

public class AllOrder_start extends Application {

	private static AllOrder_start instance;
	private Parent root;

	private AllOrder_start() {
		// TODO Auto-generated constructor stub
	}

	// 单件模式
	public static AllOrder_start getInstance() {
		if (instance == null) {
			instance = new AllOrder_start();
		}
		return instance;
	}

	@Override
	public void start(Stage primaryStage) {
		// TODO Auto-generated method stub
		try {
			root = FXMLLoader.load(getClass().getClassLoader().getResource("FXML/user/user/全部订单.fxml"));
			initiateTableView(root);
			initiateListView(root);
			Scene scene = new Scene(root, 800, 600);
			AllOrder_controller.stage = primaryStage;
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
		IDHelper idHelper = IDHelper.getInstance();
		@SuppressWarnings("unchecked")
		// 查找tableview
		TableView<OrderData> allOrderTableView = (TableView<OrderData>) root.lookup("#allOrderTableView");

		// 建立observablelist以更新数据
		final ObservableList<OrderData> data = FXCollections.observableArrayList();
		OrderControllerService orderControllerService = new OrderControllerImpl();

		data.clear();
		ObservableList<TableColumn<OrderData, ?>> observableList = allOrderTableView.getColumns();

		observableList.get(0).setCellValueFactory(new PropertyValueFactory<>("orderID"));
		observableList.get(1).setCellValueFactory(new PropertyValueFactory<>("orderStatus"));
		observableList.get(2).setCellValueFactory(new PropertyValueFactory<>("hotelName"));
		observableList.get(3).setCellValueFactory(new PropertyValueFactory<>("checkIn"));
		observableList.get(4).setCellValueFactory(new PropertyValueFactory<>("checkOut"));
		observableList.get(5).setCellValueFactory(new PropertyValueFactory<>("roomType"));
		observableList.get(6).setCellValueFactory(new PropertyValueFactory<>("roomNumber"));

		ArrayList<OrderVO> orderList = orderControllerService
				.reviewOrder(/* id = */idHelper.getID());
		for (int i = 0; i < orderList.size(); i++) {
			OrderVO ovo = orderList.get(i);
			data.add(new OrderDataHelper().toOrderData(ovo));

		}
		allOrderTableView.setItems(data);
	}

	/**
	 * 
	 * @param root
	 */
	private void initiateListView(Parent root) {
		IDHelper idHelper = IDHelper.getInstance();
		@SuppressWarnings("unchecked")
		// 查找tableview
		ListView<String> hotelList = (ListView<String>) root.lookup("#hotelList");

		// 查找tableview
		Label number = (Label) root.lookup("#number");

		// 建立observablelist以更新数据
		final ObservableList<String> data = FXCollections.observableArrayList();
		data.clear();
		int cnt = 0;
		OrderControllerService orderControllerService = new OrderControllerImpl();
		ArrayList<OrderVO> orderList = orderControllerService
				.reviewOrder(/* id = */idHelper.getID());

		ArrayList<String> hotelname = new ArrayList<String>();
		for (int i = 0; i < orderList.size(); i++) {
			if (orderList.get(i).getOrderStatus() == OrderStatus.Finished
					|| orderList.get(i).getOrderStatus() == OrderStatus.Checkout) {
				cnt++;
				if (!hotelname.contains(orderList.get(i).getHotelName())) {
					hotelname.add(orderList.get(i).getHotelName());
				}
			}
		}

		ObservableList<String> strList = FXCollections.observableArrayList(hotelname);
		hotelList.setItems(strList);
		number.setText(String.valueOf(cnt));
	}

}
