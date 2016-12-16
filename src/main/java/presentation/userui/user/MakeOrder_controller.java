package presentation.userui.user;

import java.io.IOException;
import java.text.SimpleDateFormat;
import java.util.Date;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import presentation.controller.IDHelper;
import presentation.controller.OrderControllerImpl;
import presentation.controller.UserControllerImpl;
import presentation.loginui.LoginUI_start;
import presentation.mainui.UserUI_start;
import presentation.orderui.OrderControllerService;
import presentation.userui.UserControllerService;

public class MakeOrder_controller {
	
	private IDHelper idHelper;
	private int id;
	public static String hotelname;
	
	public static Stage stage;
	@FXML
	ChoiceBox<String> singlebox;
	@FXML
	ChoiceBox<String> standardbox;
	@FXML
	ChoiceBox<String> triplebox;
	@FXML
	ChoiceBox<String> kingbox;
	@FXML
	ChoiceBox<String> suitebox;
	@FXML
	DatePicker checkIn;
	@FXML
	DatePicker checkOut;
	
	@FXML
	private void onLogout(MouseEvent event) throws Exception {
		new LoginUI_start().start(stage);
	}

	@FXML
	private void onOrderManage(MouseEvent event) throws Exception {
		new AllOrder_start().start(stage);
	}
	
	@FXML
	private void onHomepage(MouseEvent event) throws Exception {
		new UserUI_start().start(stage);
	}
	
	@FXML
	private void onHistory(MouseEvent event) throws IOException {
		new Credit_start().start(stage);
	}

	@FXML
	private void onInfoManage(MouseEvent event) {
		new DetailedInformation_start().start(stage);
	}
	

	@FXML
	private void onSubmit(MouseEvent event) {
		//new DetailedInformation_start().start(stage);
		this.initiateHelper();
		String date = initiateUserName();
		String username = initiateDate();
		
		OrderControllerService orderControllerService = new OrderControllerImpl();
		
	}
	
	/**
	 * 
	 * @param id
	 * @return 转换成对应数字ID
	 */
	private int parseNum(ChoiceBox<String> id) {
		// TODO Auto-generated method stub
		String s = id.getValue();
		return Integer.parseInt(s);
	}

	/**
	 * 获取当前用户ID
	 */
	private void initiateHelper() {
		idHelper = IDHelper.getInstance();
		id = idHelper.getID();
	}
	
	/**
	 * 获得当前日期
	 * @param root
	 */
	private String initiateDate(){
		Date time = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String text = format.format(time);
		return text;
	}

	/**
	 * 获得当前用户用户名
	 * @param root
	 */
	private String initiateUserName() {
		UserControllerService userController = new UserControllerImpl();
		String name = userController.searchByUserID(id);
		return name;
	}
}
