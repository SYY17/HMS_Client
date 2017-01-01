package presentation.userui;

import java.text.SimpleDateFormat;
import java.util.Date;

import businesslogic.hotelbl.HotelController;
import businesslogicservice.hotelBLService.HotelBLService;
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
import vo.HotelVO;

public class HotelInfo_start extends Application {

	private IDHelper idHelper;
	private TempIDHelper tempHelper;
	private int id;
	private int tempId;
	Parent root;

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			root = FXMLLoader
					.load(getClass().getClassLoader().getResource("FXML/user/manager/HotelInformation.fxml"));
			this.initiateHelper();
			this.initiateElements(root);
			this.initialize(root);
			Scene scene = new Scene(root, 800, 600);
			// scene.getStylesheets().add(getClass().getResource("main.css").toExternalForm());
			HotelInfo_controller.stage = primaryStage;
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
		HotelBLService hotelBLService = new HotelController();
		HotelVO hvo = hotelBLService.searchHotelByID(tempId);
		
		// 查找hotelname
		TextField hotelname = (TextField) root.lookup("#hotelname");
		hotelname.setText(hvo.getHotelName());
		hotelname.setEditable(false);
		
		// 查找phone
		TextField phone = (TextField) root.lookup("#phone");
		phone.setText(hvo.getPhoneNumber());
		phone.setEditable(false);
		
		// 查找star
		TextField star = (TextField) root.lookup("#star");
		star.setText(hvo.getStarLevel()+"");
		star.setEditable(false);
		
		// 查找address
		TextField address = (TextField) root.lookup("#address");
		address.setText(hvo.getHotelAddress());		
		address.setEditable(false);
		
		// 查找area
		TextField area = (TextField) root.lookup("#area");
		area.setText(hvo.getBusinessArea());		
		area.setEditable(false);
		
		// 查找workername
		TextField workername = (TextField) root.lookup("#workername");
		workername.setText(hvo.getStaffName());	
		workername.setEditable(false);
		
	}

}
