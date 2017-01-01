package presentation.userui;

import java.text.SimpleDateFormat;
import java.util.Date;

import businesslogic.userbl.UserController;
import businesslogicservice.userblservice.UserBLService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import presentation.controller.IDHelper;
import presentation.controller.TempIDHelper;
import presentation.controller.UserControllerImpl;
import vo.UserVO;

public class SalerInfo_start extends Application {

	private IDHelper idHelper;
	private TempIDHelper tempHelper;
	private int id;
	private int tempId;
	Parent root;

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			root = FXMLLoader
					.load(getClass().getClassLoader().getResource("FXML/user/manager/SalerInformation.fxml"));
			this.initiateHelper();
			this.initiateElements(root);
			this.initialize(root);
			Scene scene = new Scene(root, 800, 600);
			// scene.getStylesheets().add(getClass().getResource("main.css").toExternalForm());
			SalerInfo_controller.stage = primaryStage;
			primaryStage.setScene(scene);
			primaryStage.setTitle("管理系统用户");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 获取当前用户ID
	 */
	private void initiateHelper() {
		idHelper = IDHelper.getInstance();
		tempHelper = TempIDHelper.getInstance();
		id = idHelper.getID();
		tempId = tempHelper.getID();
	}
	
	private void initiateElements(Parent root) {
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
	 */
	private void initiateUserName(Parent root) {
		Label username = (Label) root.lookup("#username");
		UserControllerService userController = new UserControllerImpl();
		String name = userController.searchByUserID(id);
		username.setText(name);
	}
	
	private void initialize(Parent root){
		UserBLService userBlService = new UserController();
		UserVO uvo = userBlService.searchByUserName(userBlService.searchByUserID(tempId));
		String username = uvo.getName();
		
		// 查找name
		TextField name = (TextField) root.lookup("#name");
		name.setText(username);
		name.setEditable(false);
		
	}

}
