package presentation.userui;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import businesslogic.customerbl.CustomerController;
import businesslogic.userbl.UserController;
import businesslogicservice.customerBLService.CustomerBLService;
import businesslogicservice.userblservice.UserBLService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import presentation.controller.IDHelper;
import presentation.hotelui.ManageHotelCreatingApplication_start;
import presentation.loginui.LoginUI_start;
import presentation.userui.user.DetailedInformation_start;
import vo.CustomerVO;
import vo.UserVO;

public class CustomerInfo_controller {

	public static Stage stage;
	
	@FXML
	private Label username;
	
	@FXML
	private Label date;
	
	@FXML
	private TextField name;
	
	@FXML
	private TextField phone;
	
	@FXML
	private TextField email;
	
	@FXML
	private TextField address;
	
	@FXML
	private TextField birth;
	
	@FXML
	private TextField enterprise;
	
	@FXML
	private ImageView icon_edit;
	
	@FXML
	private Label label_edit;
	
	@FXML
	private ImageView icon_save;
	
	@FXML
	private Label label_save;
	
	@FXML
	private ImageView icon_cancel;
	
	@FXML
	private Label label_cancel;
	
	@FXML
	private void onModify(MouseEvent event) throws Exception {
		new DetailedInformation_start().start(stage);
	}
	
	@FXML
	private void onEdit(MouseEvent event) throws Exception {
		this.setEditMode(true);
	}
	
	@FXML
	private void onSave(MouseEvent event) throws Exception {
		this.setEditMode(false);
		this.upload();
	}
	
	@FXML
	private void onCancel(MouseEvent event) throws Exception {
		this.setEditMode(false);
		this.update();
	}
	
	@FXML
	private void onEnteredEdit(MouseEvent event) throws Exception {
		label_edit.setTextFill(Paint.valueOf("#003fff"));
	}
	
	@FXML
	private void onExitedEdit(MouseEvent event) throws Exception {
		label_edit.setTextFill(Paint.valueOf("#000000"));
	}
	
	@FXML
	private void onEnteredSave(MouseEvent event) throws Exception {
		label_save.setTextFill(Paint.valueOf("#003fff"));
	}
	
	@FXML
	private void onExitedSave(MouseEvent event) throws Exception {
		label_save.setTextFill(Paint.valueOf("#000000"));
	}
	
	@FXML
	private void onEnteredCancel(MouseEvent event) throws Exception {
		label_cancel.setTextFill(Paint.valueOf("#003fff"));
	}
	
	@FXML
	private void onExitedCancel(MouseEvent event) throws Exception {
		label_cancel.setTextFill(Paint.valueOf("#000000"));
	}
	
	@FXML
	private void onManageSystemUser(MouseEvent event) throws Exception {
		ManageSystemUser_start.getInstance().start(stage);
	}

	@FXML
	private void onManageHotelCreatingApplication(MouseEvent event) throws Exception {
		new ManageHotelCreatingApplication_start().start(stage);
	}
	
	@FXML
	private void onLogout(MouseEvent event) throws Exception {
		new LoginUI_start().start(stage);
	}
	
	/**
	 * 设置为可编辑模式
	 * @param mode
	 */
	private void setEditMode(boolean mode){
		
		//设置按钮
		icon_edit.setDisable(mode);
		icon_edit.setVisible(!mode);
		
		label_edit.setDisable(mode);
		label_edit.setVisible(!mode);
		
		icon_save.setDisable(!mode);
		icon_save.setVisible(mode);
		
		label_save.setDisable(!mode);
		label_save.setVisible(mode);
		
		icon_cancel.setDisable(!mode);
		icon_cancel.setVisible(mode);
		
		label_cancel.setDisable(!mode);
		label_cancel.setVisible(mode);
		
		//设置组件
		phone.setEditable(mode);
		email.setEditable(mode);
		address.setEditable(mode);
		enterprise.setEditable(mode);//
	}
	
	/**
	 * 上传信息
	 */
	private void upload(){
		String username = this.getUserName();
		CustomerBLService customerBLService = new CustomerController();
		UserVO uvo = new UserVO(0, username, null);
		
		//获取生日: 获取的String -> java.util.Date -> java.sql.Date
		String day = birth.getText();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		java.util.Date date;
		try {
			date = format.parse(day);
			Date time = new Date(date.getTime());
			
			//获取其他信息
			String phoneNumber = phone.getText();
			String email = this.email.getText();
			String address = this.address.getText();
			int member = 0;
			String enterprise = this.enterprise.getText();
			
			//??????
			CustomerVO cvo = new CustomerVO(uvo, time, phoneNumber, email, address, member, enterprise);
			
			customerBLService.setCustomerInfo(cvo);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 总体更新方法
	 */
	private void update(){
		String username = this.getUserName();
		CustomerBLService customerBLService = new CustomerController();
		CustomerVO cvo = customerBLService.getCustomerInfo(username);
		
		
		// 设置组件
		name.setText(username);
		phone.setText(cvo.getPhoneNumber());
		email.setText(cvo.getEmail());
		address.setText(cvo.getAddress());		
		enterprise.setText(cvo.getEnterprise());//
		
		Date birthday = cvo.getBirthday();
		long time = birthday.getTime();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String bir = format.format(new java.util.Date(time));
		birth.setText(bir);
	}
	
	/**
	 * 
	 * @return 获取当前用户用户名
	 */
	private String getUserName(){
		IDHelper idHelper = IDHelper.getInstance();
		int id = idHelper.getID();
		UserBLService userBlService = new UserController();
		UserVO uvo = userBlService.searchByUserName(userBlService.searchByUserID(id));
		String username = uvo.getName();
		return username;
	}

}
