package presentation.userui.user;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import presentation.controller.HotelControllerImpl;
import presentation.controller.IDHelper;
import presentation.controller.OrderControllerImpl;
import presentation.hotelui.HotelControllerService;
import presentation.orderui.OrderControllerService;
import presentation.orderui.OrderDataHelper;
import vo.HotelVO;
import vo.OrderVO;

public class OrderAndRating_start extends Application {
	
	private static OrderAndRating_start instance;
	private Parent root;
	
	public static String name;
	private static TextArea hotelInfoText;
	private static Label rating;
	
	public void setName(String Name){
		name = Name;
	}
	
	//单件模式
		public static OrderAndRating_start getInstance(){
			if(instance == null){
				instance = new OrderAndRating_start();
			}
			return instance;
		}
		/**
		 * 提供给对外的刷新方法
		 */
		public void refreshTableView(String name){
			this.initiateHotelInfoText(root, name);
		}
		
	@Override
	public void start(Stage primaryStage) {
		// TODO Auto-generated method stub
		try {
			root = FXMLLoader.load(getClass().getClassLoader().getResource("FXML/user/user/OrderAndRating.fxml"));
			
			 initiateTableView(root);
			 initiateHotelInfoText(root, name);
			 
			Scene scene = new Scene(root, 800, 600);
			OrderAndRating_controller.stage = primaryStage;
			primaryStage.setScene(scene);
			primaryStage.setTitle("酒店管理系统");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@SuppressWarnings("unused")
	private void initiateHotelInfoText(Parent root, String name) {
		
		if(name == null){
			hotelInfoText = (TextArea) root.lookup("#hotelInfoText");
			hotelInfoText.setText("请选择订单");
			rating = (Label) root.lookup("#rating");
		}else if(name != null){
			HotelControllerService hotelController = new HotelControllerImpl();
			HotelVO hvo = hotelController.reviewHotelInfo(name);
			
			System.out.println(hvo.getStarLevel());
			
			hotelInfoText.setText("酒店名称：" + hvo.getHotelName() + "\n" + "地址：" + hvo.getHotelAddress() + "\n" + "商圈："
					+ hvo.getBusinessArea() + "\n" + "星级：" + hvo.getStarLevel() + "星\n" + "联系方式：" + hvo.getPhoneNumber()
					+ "\n" + "简介：" + hvo.getHotelDescription());
			rating.setText(String.valueOf(hvo.getRating()));
		}
	}

	@SuppressWarnings("unused")
	private void initiateTableView(Parent root) {
		IDHelper idHelper = IDHelper.getInstance();
		@SuppressWarnings("unchecked")
		TableView<OrderDataForRating> orderAndRatingTableView = (TableView<OrderDataForRating>) root.lookup("#orderAndRatingTableView");
	
		final ObservableList<OrderDataForRating> data = FXCollections.observableArrayList();
		
		OrderControllerService orderControllerService = new OrderControllerImpl();
		
		data.clear();
		ObservableList<TableColumn<OrderDataForRating, ?>> observableList = orderAndRatingTableView.getColumns();
		initiateObservableList(observableList);
		
		ArrayList<OrderVO> orderList = orderControllerService.reviewOrder(idHelper.getID());//
		for (int i = 0; i < orderList.size(); i++) {
			OrderVO ovo = orderList.get(i);
			data.add(new OrderDataHelper().toOrderDataForRating(ovo));
		}
		orderAndRatingTableView.setItems(data);
	}

	private void initiateObservableList(ObservableList<TableColumn<OrderDataForRating, ?>> observableList) {
		observableList.get(0).setCellValueFactory(new PropertyValueFactory<>("hotelName"));
		observableList.get(1).setCellValueFactory(new PropertyValueFactory<>("checkIn"));
		observableList.get(2).setCellValueFactory(new PropertyValueFactory<>("checkOut"));
		observableList.get(3).setCellValueFactory(new PropertyValueFactory<>("roomType"));
		observableList.get(4).setCellValueFactory(new PropertyValueFactory<>("roomNumber"));
		observableList.get(5).setCellValueFactory(new PropertyValueFactory<>("price"));
		observableList.get(6).setCellValueFactory(new PropertyValueFactory<>("operation"));
	}

	public static void main(String[] args) {
		launch(args);
	}
}
