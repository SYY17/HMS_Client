package presentation.hotelui.hotel;

import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import presentation.controller.IDHelper;
import presentation.controller.OrderControllerImpl;
import presentation.loginui.LoginUI_start;
import presentation.mainui.HotelUI_start;
import presentation.orderui.OrderControllerService;
import presentation.orderui.OrderData;
import presentation.orderui.OrderDataHelper;
import vo.CreditMovement;
import vo.OrderStatus;
import vo.OrderVO;

public class OrderList_controller {

	public static Stage stage;
	private IDHelper idHelper;
	private final ObservableList<OrderData> data = FXCollections.observableArrayList();
	public OrderControllerService orderControllerService = new OrderControllerImpl();
	public TableView<OrderData> orderListTableView;
	public TableView<OrderData> abnormalOrderListTableView;
	public TableView<OrderData> uncheckoutOrderListTableView;
	public Button execute;
	public Label mark;
	public TextField room;

	@FXML
	private void onMain(MouseEvent event) throws IOException {
		new HotelUI_start().start(stage);
	}

	@FXML
	private void onLogout(MouseEvent event) throws Exception {
		new LoginUI_start().start(stage);
	}

	@FXML
	private void onExecute(ActionEvent event) {
		int orderID = 0;
		if (execute.getText().equals("确认入住")) {
			orderID = orderListTableView.getSelectionModel().getSelectedItem().getOrderID();
			orderControllerService.changeOrderStatus(orderID, OrderStatus.Finished, CreditMovement.ExecuteOrder);
			orderControllerService.assignRoom(orderID, room.getText());
			initialTableView(orderListTableView, OrderStatus.Unfilled);
		} else if (execute.getText().equals("延迟入住")) {
			orderID = abnormalOrderListTableView.getSelectionModel().getSelectedItem().getOrderID();
			orderControllerService.changeOrderStatus(orderID, OrderStatus.Finished, CreditMovement.ExecuteOrder);
			initialTableView(abnormalOrderListTableView, OrderStatus.Abnormal);
		} else if (execute.getText().equals("确认退房")) {
			orderID = uncheckoutOrderListTableView.getSelectionModel().getSelectedItem().getOrderID();
			orderControllerService.changeOrderStatus(orderID, OrderStatus.Checkout, CreditMovement.ExecuteOrder);
			initialTableView(uncheckoutOrderListTableView, OrderStatus.Finished);
		}
	}

	@FXML
	private void onOrderList(Event event) {
//		mark.setVisible(true);
//		room.setVisible(true);
		execute.setText("确认入住");
		initialTableView(orderListTableView, OrderStatus.Unfilled);
	}

	@FXML
	private void onAbnormalOrderList(Event event) {
//		mark.setVisible(true);
//		room.setVisible(true);
		execute.setText("延迟入住");
		initialTableView(abnormalOrderListTableView, OrderStatus.Abnormal);
	}

	@FXML
	private void onUncheckoutOrderList(Event event) {
//		mark.setVisible(false);
//		room.setVisible(false);
		execute.setText("确认退房");
		initialTableView(uncheckoutOrderListTableView, OrderStatus.Finished);
	}

	@FXML
	private void onReviewOrderList(MouseEvent event) throws IOException {
		new OrderList_start().start(stage);
	}

	@FXML
	private void onManage(MouseEvent event) throws IOException {
		new Manage_start().start(stage);
	}

	@FXML
	private void onReviewPromotion(MouseEvent event) throws IOException {
		new Promotion_start().start(stage);
	}

	private void initialTableView(TableView<OrderData> tableView, OrderStatus orderStatus) {
		ObservableList<TableColumn<OrderData, ?>> observableList = tableView.getColumns();
		observableList.get(0).setCellValueFactory(new PropertyValueFactory<>("orderID"));
		observableList.get(1).setCellValueFactory(new PropertyValueFactory<>("userName"));
		observableList.get(2).setCellValueFactory(new PropertyValueFactory<>("checkIn"));
		observableList.get(3).setCellValueFactory(new PropertyValueFactory<>("roomType"));
		observableList.get(4).setCellValueFactory(new PropertyValueFactory<>("roomNumber"));
		observableList.get(5).setCellValueFactory(new PropertyValueFactory<>("price"));

		idHelper = IDHelper.getInstance();
		data.clear();
		ArrayList<OrderVO> orderList = orderControllerService
				.reviewOrder(/* id = */idHelper.getID());
		for (int i = 0; i < orderList.size(); i++) {
			OrderVO ovo = orderList.get(i);
			if (isValid(orderStatus, ovo)) {
				data.add(new OrderDataHelper().toOrderData(ovo));
			}
		}

		tableView.setItems(data);
	}

	private boolean isValid(OrderStatus orderStatus, OrderVO ovo) {
		if (orderStatus == null) {
			return true;
		} else {
			return ovo.getOrderStatus().toString().equals(orderStatus.toString());
		}

	}
}
