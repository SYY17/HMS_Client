package presentation.userui.user;

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
import presentation.controller.IDHelper;
import presentation.controller.OrderControllerImpl;
import presentation.orderui.OrderControllerService;
import presentation.orderui.OrderData;
import presentation.orderui.OrderDataHelper;
import vo.OrderVO;

public class HotelHistoryOrder_start extends Application {

	public static String hotelname;
	
	public void setName(String s){
		hotelname = s;
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		try {
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("FXML/user/user/酒店历史订单.fxml"));
	
			
			Scene scene = new Scene(root, 800, 600);
			HotelHistoryOrder_controller.hotelname = hotelname;//
			HotelHistoryOrder_controller.stage = primaryStage;
			initiateTableView(root);
			// scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			// primaryStage.initStyle(StageStyle.DECORATED);
			primaryStage.setScene(scene);
			primaryStage.setTitle("酒店管理系统");
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
		//System.out.println(hotelname);
		
		ArrayList<OrderVO> thisList = new ArrayList<OrderVO>();
		
		for(int i=0;i<orderList.size();i++){
			if(orderList.get(i).getHotelName().equals(hotelname)){
				thisList.add(orderList.get(i));
			}
		}
		for (int i = 0; i < thisList.size(); i++) {
			OrderVO ovo = thisList.get(i);
			data.add(new OrderDataHelper().toOrderData(ovo));
			
		}
			allOrderTableView.setItems(data);
	}

}
