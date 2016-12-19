package presentation.hotelui.hotel;

import java.text.SimpleDateFormat;
import java.util.Date;

import businesslogic.promotionbl.PromotionController;
import businesslogicservice.promotionblservice.PromotionBLService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import presentation.controller.IDHelper;
import presentation.controller.UserControllerImpl;
import presentation.userui.UserControllerService;
import vo.PromotionVO;

public class PromotionContent_start extends Application {

	public static PromotionVO pvo;
	private IDHelper idHelper;
	private int id;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		try{
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("FXML/user/hotel/PromotionContent.fxml"));
		
		this.initiateHelper();
		this.initiateElements(root);
		initiatePromotion(root);
		
		Scene scene = new Scene(root, 800, 600);
		// scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
		// primaryStage.initStyle(StageStyle.DECORATED);
		PromotionContent_controller.stage = primaryStage;
		primaryStage.setScene(scene);
		primaryStage.setTitle("酒店管理系统");
		primaryStage.show();
	} catch (Exception e) {
		e.printStackTrace();
	}
	}
	
	/**
	 * 初始化界面组件
	 * @param root
	 */
	private void initiatePromotion(Parent root){
		PromotionBLService promotionBlService = new PromotionController();
		promotionBlService.searchPromotion(pvo);
		
		@SuppressWarnings("unchecked")
		// 查找promotionName
		Label promotionName = (Label) root.lookup("#promotionName");
		promotionName.setText(pvo.getPromotionName());
		
		// 查找startTime
		TextField startTime = (TextField) root.lookup("#startTime");
		startTime.setText(String.valueOf(pvo.getStartTime()));
		startTime.setEditable(false);
		
		// 查找stopTime
		TextField stopTime = (TextField) root.lookup("#stopTime");
		stopTime.setText(String.valueOf(pvo.getStopTime()));
		stopTime.setEditable(false);
		
		// 查找content
		TextArea content = (TextArea) root.lookup("#content");
		content.setText(pvo.getContent());
		content.setEditable(false);
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


	public static void main(String[] args) {
		launch(args);
	}
}
