package presentation.userui.user;

import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import presentation.controller.OrderControllerImpl;
import presentation.loginui.LoginUI_start;
import presentation.mainui.UserUI_start;
import presentation.orderui.OrderControllerService;
import presentation.orderui.OrderData;
import presentation.orderui.OrderDataHelper;
import vo.OrderStatus;
import vo.OrderVO;

public class AllOrder_controller {

	public static Stage stage;
	private final ObservableList<OrderData> data = FXCollections.observableArrayList();
	public OrderControllerService orderControllerService = new OrderControllerImpl();
	public TableView<OrderData> allOrderTableView;
	public TableView<OrderData> unfilledOrderTableView;
	public TableView<OrderData> canceledOrderTableView;
	public TableView<OrderData> abnormalOrderTableView;
	public TableView<OrderData> finishedOrderTableView;

	@FXML
	private void onLogout(MouseEvent event) throws Exception {
		new LoginUI_start().start(stage);
	}
	
	@FXML
	private void onOrderManage(MouseEvent event) throws Exception {
		new AllOrder_start().start(stage);
	}
	
	@FXML
	private void onHomepage(MouseEvent event) throws Exception {
		new UserUI_start().start(stage);
	}
	
	@FXML
	private void onHistory(MouseEvent event) throws IOException {
		new Credit_start().start(stage);
	}

	@FXML
	private void onInfoManage(MouseEvent event) {
		new DetailedInformation_start().start(stage);
	}

	@FXML
	private void onAllOrder(Event event) {
		initialTableView(allOrderTableView, null);
	}

	@FXML
	private void onUnfilledOrder(Event event) {
		initialTableView(unfilledOrderTableView, OrderStatus.Unfilled);
	}

	@FXML
	private void onCanceledOrder(Event event) {
		initialTableView(canceledOrderTableView, OrderStatus.Canceled);
	}

	@FXML
	private void onAbnormalOrder(Event event) {
		initialTableView(abnormalOrderTableView, OrderStatus.Abnormal);
	}

	@FXML
	private void onFinishedOrder(Event event) {
		initialTableView(finishedOrderTableView, OrderStatus.Finished);
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

		data.clear();
		ArrayList<OrderVO> orderList = orderControllerService
				.reviewOrder(/* id = */40000000);
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
