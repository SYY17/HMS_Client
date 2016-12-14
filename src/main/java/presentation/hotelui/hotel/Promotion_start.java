package presentation.hotelui.hotel;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import businesslogic.promotionbl.PromotionController;
import businesslogicservice.promotionblservice.PromotionBLService;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import presentation.controller.IDHelper;
import presentation.controller.UserControllerImpl;
import presentation.userui.UserControllerService;
import vo.PromotionVO;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class Promotion_start extends Application {
	
	private IDHelper idHelper;
	private int id;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("FXML/user/hotel/制定营销策略2.fxml"));
			
			this.initiateHelper();
			this.initiateElements(root);
			initiateTableView(root);
			Scene scene = new Scene(root, 800, 600);
			// scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			// primaryStage.initStyle(StageStyle.DECORATED);
			Promotion_controller.stage = primaryStage;
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
		@SuppressWarnings("unchecked")
		// 查找tableview
		ListView<String> promotionListView = (ListView<String>) root.lookup("#promotionListView");

		// 建立observablelist以更新数据
		final ObservableList<PromotionData> data = FXCollections.observableArrayList();
		PromotionBLService promotionBlService = new PromotionController();

		data.clear();
		ArrayList<PromotionVO> pvo = promotionBlService
				.getAllPromotion(id);//
		ArrayList<String> content = new ArrayList<String>();
		for (int i = 0; i < pvo.size(); i++) {
			content.add(pvo.get(i).getPromotionName());
		}
		ObservableList<String> strList = FXCollections.observableArrayList(content);
		promotionListView.setItems(strList);
	}

	/**
	 * 初始化界面组件
	 * @param root
	 */
	private void initiateElements(Parent root) {
		// TODO Auto-generated method stub
		initiateUserName(root);
		initiateDate(root);
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
}