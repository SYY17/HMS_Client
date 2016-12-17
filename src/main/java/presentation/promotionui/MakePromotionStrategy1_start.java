package presentation.promotionui;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import businesslogic.promotionbl.PromotionController;
import businesslogicservice.promotionblservice.PromotionBLService;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import presentation.controller.IDHelper;
import presentation.controller.UserControllerImpl;
import presentation.hotelui.hotel.PromotionData;
import presentation.userui.UserControllerService;
import vo.PromotionVO;
import vo.UserVO;

public class MakePromotionStrategy1_start extends Application {
	
	private IDHelper idHelper;
	private int id;

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			Parent root = FXMLLoader
					.load(getClass().getClassLoader().getResource("FXML/user/saler/MakePromotionStrategy1.fxml"));
			
			this.initiateHelper();
			initiateTableView(root);
			this.initiateElements(root);
			Scene scene = new Scene(root, 800, 600);
			// scene.getStylesheets().add(getClass().getResource("main.css").toExternalForm());
			MakePromotionStrategy1_controller.stage = primaryStage;
			primaryStage.setScene(scene);
			primaryStage.setTitle("制定营销策略");
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
		@SuppressWarnings("unchecked")
		// 查找tableview
		TableView<PromotionData> promotionTableView = (TableView<PromotionData>) root.lookup("#promotionTableView");

		// 建立observablelist以更新数据
		final ObservableList<PromotionData> data = FXCollections.observableArrayList();
		PromotionBLService promotionBlService = new PromotionController();

		data.clear();
		ObservableList<TableColumn<PromotionData, ?>> observableList = promotionTableView.getColumns();

		observableList.get(0).setCellValueFactory(new PropertyValueFactory<>("promotionID"));
		observableList.get(1).setCellValueFactory(new PropertyValueFactory<>("promotionName"));
		observableList.get(2).setCellValueFactory(new PropertyValueFactory<>("promotionDate"));
		observableList.get(3).setCellValueFactory(new PropertyValueFactory<>("promotionStop"));
		observableList.get(4).setCellValueFactory(new PropertyValueFactory<>("promotionContent"));

		ArrayList<PromotionVO> promotionList = promotionBlService.getAllPromotion(id);//

		for (int i = 0; i < promotionList.size(); i++) {
			PromotionVO pvo = promotionList.get(i);
			data.add(new PromotionDataHelper().toPromotionData(pvo));
		}

		promotionTableView.setItems(data);
	}

	/**
	 * 初始化界面组件
	 * @param root
	 */
	private void initiateElements(Parent root) {
		// TODO Auto-generated method stub
		initiateUserName(root);
		initiateDate(root);
		initiateUserSum(root);
		initiateHotelSum(root);
	}

	/**
	 * 获取当前用户ID
	 */
	private void initiateHelper() {
		idHelper = IDHelper.getInstance();
		id = idHelper.getID();
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
	 * 初始化用户数
	 * 
	 * @param root
	 */
	private void initiateUserSum(Parent root) {
		Label userSum = (Label) root.lookup("#userSum");
		ArrayList<UserVO> list = new UserControllerImpl().getAllUsers();
		int num = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getID() < 20000000) {
				num++;
			}
		}
		userSum.setText(String.valueOf(num));
	}

	/**
	 * 初始化酒店数
	 * 
	 * @param root
	 */
	private void initiateHotelSum(Parent root) {
		Label hotelSum = (Label) root.lookup("#hotelSum");
		ArrayList<UserVO> list = new UserControllerImpl().getAllUsers();
		int num = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getID() >= 20000000 && list.get(i).getID() < 30000000) {
				num++;
			}
		}
		hotelSum.setText(String.valueOf(num));
	}
}
