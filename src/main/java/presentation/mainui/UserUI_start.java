package presentation.mainui;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import businesslogic.hotelbl.HotelController;
import businesslogic.promotionbl.PromotionController;
import businesslogicservice.hotelBLService.HotelBLService;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import presentation.controller.IDHelper;
import presentation.controller.UserControllerImpl;
import presentation.userui.UserControllerService;
import vo.HotelVO;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;


public class UserUI_start extends Application {
	
	private IDHelper idHelper;
	private int id;
	private String hotelname;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("FXML/user/user/UserUI.fxml"));
			Scene scene = new Scene(root, 800, 600);
			UserUI_controller.stage = primaryStage;
			this.initiateHelper();
			this.initiateElements(root);
			initialize(root);
			initChoiceBox(root);
			primaryStage.setScene(scene);
			primaryStage.setTitle("酒店管理系统");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	
	/*
	 * 初始化ChoiceBox
	 */
	public void initChoiceBox(Parent root) {
		@SuppressWarnings("unchecked")
		// 查找business
		ChoiceBox<String> businessArea = (ChoiceBox<String>) root.lookup("#businessArea");
		HotelBLService hotelBlService = new HotelController();
		ArrayList<HotelVO> listVO = hotelBlService.reviewHotelList();
		ArrayList<String> business = new ArrayList<String>();
		
		for(int i=0;i<listVO.size();i++){
			String temp  =listVO.get(i).getBusinessArea();
			if(!business.contains(temp)){
				business.add(temp);
			}
		}

		businessArea.setItems(FXCollections.observableArrayList(business));
		String whereToSearch = businessArea.getValue();
		//changeArea(root, whereToSearch);
		
		// 查找rating
		ChoiceBox<String> rating = (ChoiceBox<String>) root.lookup("#rating");
		rating.setItems(FXCollections.observableArrayList("从高到低", "从低到高"));
		String howToRate = rating.getValue();
		//changeRate(root, howToRate);
	}
	
	/**
	 * 
	 * @param root
	 * @param whereToSearch
	 */
	private void changeArea(Parent root, String whereToSearch){
		ListView<String> hotelList = (ListView<String>) root.lookup("#hotelList");
		HotelBLService hotelBlService = new HotelController();

		ArrayList<HotelVO> hvo = hotelBlService.reviewHotelList();
		
		ArrayList<String> content = new ArrayList<String>();
		for (int i = 0; i < hvo.size(); i++) {
			if(hvo.get(i).getBusinessArea() == whereToSearch){
				content.add(hvo.get(i).getHotelName());
			}
		}
		
		ObservableList<String> strList = FXCollections.observableArrayList(content);
		hotelList.setItems(strList);
				
		hotelList.getSelectionModel().selectedItemProperty().addListener(
				new ChangeListener<String>(){

					@Override
					public void changed(ObservableValue<? extends String> observable, String oldValue,
							String newValue) {
						// TODO Auto-generated method stub
						//searchTextField.setText(newValue);
						hotelname = newValue;
						UserUI_controller.hotelname = hotelname;
					}
					
				}
				);
	}
	/**
	 * 
	 * @param root
	 * @param howToRate
	 */
	private void changeRate(Parent root, String howToRate){
		
	}
	/**
	 * 获取当前用户ID
	 */
	private void initiateHelper() {
		idHelper = IDHelper.getInstance();
		id = idHelper.getID();
	}

	private void initiateElements(Parent root) {
		// TODO Auto-generated method stub
		initiateUserName(root);
		initiateDate(root);
	}
	
	/**
	 * 初始化当前日期
	 * @param root
	 */
	private void initiateDate(Parent root){
		Label date = (Label) root.lookup("#date");
		Date time = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String text = format.format(time);
		date.setText(text);
	}

	/**
	 * 初始化当前用户用户名
	 * @param root
	 */
	private void initiateUserName(Parent root) {
		Label username = (Label) root.lookup("#username");
		UserControllerService userController = new UserControllerImpl();
		String name = userController.searchByUserID(id);
		username.setText(name);
	}
	
	/**
	 * 总体初始化方法
	 * @param root
	 */
	private void initialize(Parent root){
		@SuppressWarnings("unchecked")
		// 查找hotelList
		ListView<String> hotelList = (ListView<String>) root.lookup("#hotelList");
		
		/*
		@SuppressWarnings("unchecked")
		TextField searchTextField = (TextField) root.lookup("#searchTextField");
		*/
		
		// 建立observablelist以更新数据
		//final ObservableList<HotelData> data = FXCollections.observableArrayList();
		HotelBLService hotelBlService = new HotelController();

		//data.clear();
		ArrayList<HotelVO> hvo = hotelBlService.reviewHotelList();
		
		ArrayList<String> content = new ArrayList<String>();
		for (int i = 0; i < hvo.size(); i++) {
			content.add(hvo.get(i).getHotelName());
		}
		
		ObservableList<String> strList = FXCollections.observableArrayList(content);
		hotelList.setItems(strList);
				
		hotelList.getSelectionModel().selectedItemProperty().addListener(
				new ChangeListener<String>(){

					@Override
					public void changed(ObservableValue<? extends String> observable, String oldValue,
							String newValue) {
						// TODO Auto-generated method stub
						//searchTextField.setText(newValue);
						hotelname = newValue;
						UserUI_controller.hotelname = hotelname;
					}
					
				}
				);
	}
}
