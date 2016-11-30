package presentation.userui.user;

import java.util.ArrayList;

import businesslogic.orderbl.OrderController;
import businesslogicservice.orderblservice.OrderBLService;
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
import presentation.orderui.OrderData;
import vo.OrderVO;

public class OrderAndRating_start extends Application {

	@Override
	public void start(Stage primaryStage) {
		// TODO Auto-generated method stub
		try {
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("FXML/user/user/订单＋酒店评分.fxml"));
			initiateTableView(root);

			Scene scene = new Scene(root, 800, 600);
			OrderAndRating_controller.stage = primaryStage;
			// scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			// primaryStage.initStyle(StageStyle.DECORATED);
			primaryStage.setScene(scene);
			primaryStage.setTitle("酒店管理系统");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void initiateTableView(Parent root) {
		TableView<OrderData> orderAndRatingTableView = (TableView<OrderData>) root.lookup("#orderAndRatingTableView");
		final ObservableList<OrderData> data = FXCollections.observableArrayList();
		OrderBLService orderBLService = new OrderController();
		data.clear();
		ObservableList<TableColumn<OrderData, ?>> observableList = orderAndRatingTableView.getColumns();
		initiateObservableList(observableList);
		ArrayList<OrderVO> orderList = orderBLService.reviewOrder(/* id = */20905098);
		for (int i = 0; i < orderList.size(); i++) {
			OrderVO ovo = orderList.get(i);
			data.add(new OrderData(ovo.getHotelID(), ovo.getCheckIn(), ovo.getCheckOut(), ovo.getRoomType(),
					ovo.getRoomNumber(), ovo.getPrice()));
		}
		orderAndRatingTableView.setItems(data);
	}

	private void initiateObservableList(ObservableList<TableColumn<OrderData, ?>> observableList) {
		observableList.get(0).setCellValueFactory(new PropertyValueFactory<>("hotelID"));
		observableList.get(1).setCellValueFactory(new PropertyValueFactory<>("checkIn"));
		observableList.get(2).setCellValueFactory(new PropertyValueFactory<>("checkOut"));
		observableList.get(3).setCellValueFactory(new PropertyValueFactory<>("roomType"));
		observableList.get(4).setCellValueFactory(new PropertyValueFactory<>("roomNumber"));
		observableList.get(5).setCellValueFactory(new PropertyValueFactory<>("price"));
	}

	public static void main(String[] args) {
		launch(args);
	}

}
