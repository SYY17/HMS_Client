package presentation.userui.user;

import java.io.IOException;
import java.util.ArrayList;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import presentation.controller.OrderControllerImpl;
import presentation.loginui.LogFrame;
import presentation.mainui.User_start;
import presentation.orderui.OrderControllerService;
import presentation.orderui.OrderData;
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
	private void onLogout(ActionEvent event) throws IOException {
		new LogFrame().start(stage);
	}

	@FXML
	private void onBack(ActionEvent event) throws IOException {
		new User_start().start(stage);
	}

	@FXML
	private void onShowOrder(ActionEvent event) throws IOException {
		new AllOrder_start().start(stage);
	}

	@FXML
	private void onDetailedInfo(ActionEvent event) {
		new DetailedInfomation_start().start(stage);
	}

	private void initialTableView(ObservableList<TableColumn<OrderData, ?>> observableList) {
		observableList.get(0).setCellValueFactory(new PropertyValueFactory<>("orderID"));
		observableList.get(1).setCellValueFactory(new PropertyValueFactory<>("orderStatus"));
		observableList.get(2).setCellValueFactory(new PropertyValueFactory<>("hotelID"));
		observableList.get(3).setCellValueFactory(new PropertyValueFactory<>("checkIn"));
		observableList.get(4).setCellValueFactory(new PropertyValueFactory<>("checkOut"));
		observableList.get(5).setCellValueFactory(new PropertyValueFactory<>("roomType"));
		observableList.get(6).setCellValueFactory(new PropertyValueFactory<>("roomNumber"));
	}

	@FXML
	private void onAllOrder(Event event) {
		data.clear();
		ObservableList<TableColumn<OrderData, ?>> observableList = allOrderTableView.getColumns();
		initialTableView(observableList);
		ArrayList<OrderVO> orderList = orderControllerService.reviewOrder(/* id = */20905098);
		orderList.addAll(orderControllerService.reviewOrder(/* id = */12098013));
		for (int i = 0; i < orderList.size(); i++) {
			OrderVO ovo = orderList.get(i);
			data.add(new OrderData(ovo.getOrderID(), ovo.getOrderStatus(), ovo.getHotelID(), ovo.getCheckIn(),
					ovo.getCheckOut(), ovo.getRoomType(), ovo.getRoomNumber()));
		}
		
		allOrderTableView.setItems(data);
	}

	@FXML
	private void onUnfilledOrder(Event event) {
		data.clear();
		ObservableList<TableColumn<OrderData, ?>> observableList = unfilledOrderTableView.getColumns();
		initialTableView(observableList);

		ArrayList<OrderVO> orderList = orderControllerService.reviewOrder(/* id = */20905098);
		orderList.addAll(orderControllerService.reviewOrder(/* id = */12098013));
		for (int i = 0; i < orderList.size(); i++) {
			OrderVO ovo = orderList.get(i);
			if (ovo.getOrderStatus().toString().equals(OrderStatus.Unfilled.toString())) {
				data.add(new OrderData(ovo.getOrderID(), ovo.getOrderStatus(), ovo.getHotelID(), ovo.getCheckIn(),
						ovo.getCheckOut(), ovo.getRoomType(), ovo.getRoomNumber()));
			}
		}
		unfilledOrderTableView.setItems(data);
	}

	@FXML
	private void onCanceledOrder(Event event) {
		data.clear();
		ObservableList<TableColumn<OrderData, ?>> observableList = canceledOrderTableView.getColumns();
		initialTableView(observableList);

		ArrayList<OrderVO> orderList = orderControllerService.reviewOrder(/* id = */20905098);
		orderList.addAll(orderControllerService.reviewOrder(/* id = */12098013));
		for (int i = 0; i < orderList.size(); i++) {
			OrderVO ovo = orderList.get(i);
			if (ovo.getOrderStatus().toString().equals(OrderStatus.Canceled.toString())) {
				data.add(new OrderData(ovo.getOrderID(), ovo.getOrderStatus(), ovo.getHotelID(), ovo.getCheckIn(),
						ovo.getCheckOut(), ovo.getRoomType(), ovo.getRoomNumber()));
			}
		}
		canceledOrderTableView.setItems(data);
	}

	@FXML
	private void onAbnormalOrder(Event event) {
		data.clear();
		ObservableList<TableColumn<OrderData, ?>> observableList = abnormalOrderTableView.getColumns();
		initialTableView(observableList);

		ArrayList<OrderVO> orderList = orderControllerService.reviewOrder(/* id = */20905098);
		orderList.addAll(orderControllerService.reviewOrder(/* id = */12098013));
		for (int i = 0; i < orderList.size(); i++) {
			OrderVO ovo = orderList.get(i);
			if (ovo.getOrderStatus().toString().equals(OrderStatus.Abnormal.toString())) {
				data.add(new OrderData(ovo.getOrderID(), ovo.getOrderStatus(), ovo.getHotelID(), ovo.getCheckIn(),
						ovo.getCheckOut(), ovo.getRoomType(), ovo.getRoomNumber()));
			}
		}
		abnormalOrderTableView.setItems(data);
	}

	@FXML
	private void onFinishedOrder(Event event) {
		data.clear();
		ObservableList<TableColumn<OrderData, ?>> observableList = finishedOrderTableView.getColumns();
		initialTableView(observableList);

		ArrayList<OrderVO> orderList = orderControllerService.reviewOrder(/* id = */20905098);
		orderList.addAll(orderControllerService.reviewOrder(/* id = */12098013));
		for (int i = 0; i < orderList.size(); i++) {
			OrderVO ovo = orderList.get(i);
			if (ovo.getOrderStatus().toString().equals(OrderStatus.Finished.toString())) {
				data.add(new OrderData(ovo.getOrderID(), ovo.getOrderStatus(), ovo.getHotelID(), ovo.getCheckIn(),
						ovo.getCheckOut(), ovo.getRoomType(), ovo.getRoomNumber()));
			}
		}
		finishedOrderTableView.setItems(data);
	}

}
