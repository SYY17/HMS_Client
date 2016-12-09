package presentation.mainui;

import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import presentation.controller.IDHelper;
import presentation.controller.UserControllerImpl;
import presentation.userui.UserControllerService;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;

public class ManagerUI_start extends Application {
	
	private IDHelper idHelper;
	private int id;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("FXML/user/manager/ManagerUI2.fxml"));
			Scene scene = new Scene(root, 800, 600);
			ManagerUI_controller.stage = primaryStage;
			this.initiateHelper();
			this.initiateElements(root);
			
			//print，待删除
			System.out.println(id);
			primaryStage.setScene(scene);
			primaryStage.setTitle("酒店管理系统");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 初始化各组件的总方法
	 * @param root
	 */
	private void initiateElements(Parent root) {
		// TODO Auto-generated method stub
		initiateDate(root);
		initiateUserName(root);
	}

	/**
	 * 获取当前用户ID
	 */
	private void initiateHelper(){
		idHelper = IDHelper.getInstance();
		id = idHelper.getID();
	}
	
	/**
	 * 初始化当前用户用户名
	 * @param root
	 */
	private void initiateUserName(Parent root){
		Label username = (Label) root.lookup("#username");
		UserControllerService userController = new UserControllerImpl();
		String name = userController.searchByUserID(id);
		username.setText(name);
	}
	
	/**
	 * 初始化当前日期
	 * @param root
	 */
	private void initiateDate(Parent root){
		Label date = (Label) root.lookup("#date");
		Date today = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String text = format.format(today);
		date.setText(text);
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
