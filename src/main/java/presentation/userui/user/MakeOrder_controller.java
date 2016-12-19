package presentation.userui.user;

import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
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
		AllOrder_start.getInstance().start(stage);
	}
	
	@FXML
	private void onHomepage(MouseEvent event) throws Exception {
		new UserUI_start().start(stage);
	}
	
	@FXML
	private void onHistory(MouseEvent event) throws IOException {
		Credit_start.getInstance().start(stage);
	}

	@FXML
	private void onInfoManage(MouseEvent event) {
		new DetailedInformation_start().start(stage);
	}
	

	@SuppressWarnings("unused")
	@FXML
	private void onSubmit(MouseEvent event) {
		//new DetailedInformation_start().start(stage);
		this.initiateHelper();
		String date = initiateUserName();
		String username = initiateDate();
		
		try{
			Date ci;
			Date co;
			LocalDate startIns = checkIn.getValue();
			LocalDate stopIns = checkOut.getValue();
			String pattern = "yyyy-MM-dd";
			DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);
			String ciday = dateFormatter.format(startIns);
			String coday = dateFormatter.format(stopIns);
			SimpleDateFormat format = new SimpleDateFormat(pattern);
			java.util.Date date1;
			java.util.Date date2;
			
			date1 = format.parse(ciday);
			date2 = format.parse(coday);
			ci = new Date(date1.getTime());
			co= new Date(date2.getTime());
			
			int singleNum = 0,standardNum = 0,kingNum = 0,suiteNum = 0,tripleNum = 0;
			singleNum = parseNum(singlebox);
			standardNum = parseNum(standardbox);
			kingNum = parseNum(kingbox);
			suiteNum = parseNum(suitebox);
			tripleNum = parseNum(triplebox);
			
			//用户名，酒店名，入住时间，离开时间,所有预定房间类型以及数量都获得了，还有setTime没有得到需要补充
			
			OrderControllerService orderController = new OrderControllerImpl();
			
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
