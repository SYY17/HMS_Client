package presentation.mainui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import presentation.controller.IDHelper;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class Manager_start extends Application {
	
	private IDHelper idHelper;
	private int id;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("FXML/user/manager/ManagerUI.fxml"));
			Scene scene = new Scene(root, 800, 600);
			Manager_controller.stage = primaryStage;
			this.initiateHelper();
			
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
	 * 获取当前用户ID
	 */
	private void initiateHelper(){
		idHelper = IDHelper.getInstance();
		id = idHelper.getID();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
