package presentation.userui;

import java.text.SimpleDateFormat;
import java.util.Date;

import businesslogic.customerbl.CustomerController;
import businesslogic.userbl.UserController;
import businesslogicservice.customerBLService.CustomerBLService;
import businesslogicservice.userblservice.UserBLService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import presentation.controller.IDHelper;
import presentation.controller.UserControllerImpl;
import vo.CustomerVO;
import vo.UserVO;

public class CustomerInfo_start extends Application {

	private IDHelper idHelper;
	private int id;
	Parent root;

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			root = FXMLLoader
					.load(getClass().getClassLoader().getResource("FXML/user/manager/UserInformation.fxml"));
			this.initiateHelper();
			this.initiateElements(root);
			this.initialize(root);
			Scene scene = new Scene(root, 800, 600);
			// scene.getStylesheets().add(getClass().getResource("main.css").toExternalForm());
			CustomerInfo_controller.stage = primaryStage;
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
		id = idHelper.getID();
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
		UserVO uvo = userBlService.searchByUserName(userBlService.searchByUserID(id));
		String username = uvo.getName();
		CustomerBLService customerBLService = new CustomerController();
		CustomerVO cvo = customerBLService.getCustomerInfo(username);
		
		// 查找name
		TextField name = (TextField) root.lookup("#name");
		name.setText(username);
		name.setEditable(false);
		
		// 查找phone
		TextField phone = (TextField) root.lookup("#phone");
		phone.setText(cvo.getPhoneNumber());
		phone.setEditable(false);
		
		// 查找email
		TextField email = (TextField) root.lookup("#email");
		email.setText(cvo.getEmail());
		email.setEditable(false);
		
		// 查找address
		TextField address = (TextField) root.lookup("#address");
		address.setText(cvo.getAddress());		
		address.setEditable(false);
		
		// 查找birthday
		TextField birth = (TextField) root.lookup("#birth");
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		Date day = cvo.getBirthday();
		java.sql.Date temp = new java.sql.Date(day.getTime());
		String birthday = format.format(temp);
		birth.setText(birthday);		
		birth.setEditable(false);
		
		// 查找enterprise
		TextField enterprise = (TextField) root.lookup("#enterprise");
		enterprise.setText(cvo.getEnterprise());		
		enterprise.setEditable(false);
		
	}

}
