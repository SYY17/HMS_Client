package presentation.userui.user;

import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import presentation.controller.IDHelper;
import presentation.controller.OrderControllerImpl;
import presentation.loginui.LoginUI_start;
import presentation.mainui.UserUI_start;
import presentation.orderui.OrderControllerService;
import presentation.orderui.OrderData;
import presentation.orderui.OrderDataHelper;
import vo.CreditMovement;
import vo.OrderStatus;
import vo.OrderVO;

public class AllOrder_controller {

	public static Stage stage;
	private IDHelper idHelper;
	private final ObservableList<OrderData> data = FXCollections.observableArrayList();
	public OrderControllerService orderControllerService = new OrderControllerImpl();
	public Button cancelOrder;
	public TableView<OrderData> allOrderTableView;
	public TableView<OrderData> unfilledOrderTableView;
	public TableView<OrderData> canceledOrderTableView;
	public TableView<OrderData> abnormalOrderTableView;
	public TableView<OrderData> finishedOrderTableView;

	@FXML
	private void onRate(MouseEvent event) throws Exception {
		OrderAndRating_start.getInstance().start(stage);
	}

	@FXML
	private void onLogout(MouseEvent event) throws Exception {
		new LoginUI_start().start(stage);
	}

	@FXML
	private void onOrderManage(MouseEvent event) throws Exception {
		AllOrder_start.getInstance().start(stage);
	}

	@FXML
	private void onHomepage(MouseEvent event) throws Exception {
		new UserUI_start().start(stage);
	}

	@FXML
	private void onHistory(MouseEvent event) throws IOException {
		Credit_start.getInstance().start(stage);
	}

	@FXML
	private void onInfoManage(MouseEvent event) {
		new DetailedInformation_start().start(stage);
	}

	@FXML
	private void onAllOrder(Event event) {
		initialTableView(allOrderTableView, null);
		cancelOrder.setVisible(false);
	}

	@FXML
	private void onUnfilledOrder(Event event) {
		initialTableView(unfilledOrderTableView, OrderStatus.Unfilled);
		cancelOrder.setVisible(true);
	}

	@FXML
	private void onCanceledOrder(Event event) {
		initialTableView(canceledOrderTableView, OrderStatus.Canceled);
		cancelOrder.setVisible(false);
	}

	@FXML
	private void onAbnormalOrder(Event event) {
		initialTableView(abnormalOrderTableView, OrderStatus.Abnormal);
		cancelOrder.setVisible(false);
	}

	@FXML
	private void onFinishedOrder(Event event) {
		initialTableView(finishedOrderTableView, OrderStatus.Finished);
		cancelOrder.setVisible(false);
	}

	@FXML
	private void onCancelOrder(ActionEvent event) throws Exception {
		int orderID = unfilledOrderTableView.getSelectionModel().getSelectedItems().get(0).getOrderID();
		orderControllerService.changeOrderStatus(orderID, OrderStatus.Canceled,CreditMovement.CancelOrder);
		initialTableView(unfilledOrderTableView, OrderStatus.Unfilled);
	}

	private void initialTableView(TableView<OrderData> tableView, OrderStatus orderStatus) {
		ObservableList<TableColumn<OrderData, ?>> observableList = tableView.getColumns();
		observableList.get(0).setCellValueFactory(new PropertyValueFactory<>("orderID"));
		observableList.get(1).setCellValueFactory(new PropertyValueFactory<>("orderStatus"));
		observableList.get(2).setCellValueFactory(new PropertyValueFactory<>("hotelName"));
		observableList.get(3).setCellValueFactory(new PropertyValueFactory<>("checkIn"));
		observableList.get(4).setCellValueFactory(new PropertyValueFactory<>("checkOut"));
		observableList.get(5).setCellValueFactory(new PropertyValueFactory<>("roomType"));
		observableList.get(6).setCellValueFactory(new PropertyValueFactory<>("roomNumber"));

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
		} else if (orderStatus.toString().equals(OrderStatus.Finished.toString())) {
			return ovo.getOrderStatus().toString().equals(OrderStatus.Finished.toString())
					|| ovo.getOrderStatus().toString().equals(OrderStatus.Checkout.toString());
		} else {
			return ovo.getOrderStatus().toString().equals(orderStatus.toString());
		}

	}
}
