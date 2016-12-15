package presentation.userui.user;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import businesslogic.customerbl.CustomerController;
import businesslogic.userbl.UserController;
import businesslogicservice.customerBLService.CustomerBLService;
import businesslogicservice.userblservice.UserBLService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import presentation.controller.IDHelper;
import presentation.controller.UserControllerImpl;
import presentation.userui.UserControllerService;
import vo.CustomerVO;
import vo.UserVO;

public class DetailedInformation_start extends Application {

	private final String pattern = "yyyy-MM-dd";
	private IDHelper idHelper;
	private int id;

	public static void main(String[] args) {
		launch(args);
	}
	
	@Override
	public void start(Stage primaryStage) {
		// TODO Auto-generated method stub
		try {
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("FXML/user/user/DetailedInformation.fxml"));
			initiateHelper();
			initialize(root);
			Scene scene = new Scene(root, 800, 600);
			DetailedInformation_controller.stage = primaryStage;
			this.initiateHelper();
			this.initiateElements(root);
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

	private void initialize(Parent root){
		UserBLService userBlService = new UserController();
		UserVO uvo = userBlService.searchByUserName(userBlService.searchByUserID(id));
		String username = uvo.getName();
		CustomerBLService customerBLService = new CustomerController();
		CustomerVO  cvo = customerBLService.getCustomerInfo(username);
		
		initDatePicker(root, cvo.getBirthday().toString());
		
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
		
	}
	
	/*
	 * 初始化DatePicker
	 */
	private void initDatePicker(Parent root, String birthday) {
		// 查找birth
		DatePicker birth = (DatePicker) root.lookup("#birth");

		StringConverter<LocalDate> converter = new StringConverter<LocalDate>() {
			DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);

			@Override
			public String toString(LocalDate date) {
				if (date != null) {
					return dateFormatter.format(date);
				} else {
					return "";
				}
			}

			@Override
			public LocalDate fromString(String string) {
				if (string != null && !string.isEmpty()) {
					return LocalDate.parse(string, dateFormatter);
				} else {
					return null;
				}
			}
		};

		birth.setShowWeekNumbers(true);
		birth.setConverter(converter);
		birth.setPromptText(pattern.toLowerCase());

		birth.setValue(converter.fromString(birthday));
		birth.setEditable(false);
	}
	
}
