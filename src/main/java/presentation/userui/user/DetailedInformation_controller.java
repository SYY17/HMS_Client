package presentation.userui.user;

import java.io.IOException;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import businesslogic.customerbl.CustomerController;
import businesslogic.userbl.UserController;
import businesslogicservice.customerBLService.CustomerBLService;
import businesslogicservice.userblservice.UserBLService;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import javafx.util.StringConverter;
import presentation.controller.IDHelper;
import presentation.loginui.LoginUI_start;
import presentation.mainui.UserUI_start;
import vo.CustomerVO;
import vo.UserVO;

public class DetailedInformation_controller {

	public static Stage stage;
	
	@FXML
	private TextField name;
	
	@FXML
	private TextField phone;
	
	@FXML
	private TextField email;
	
	@FXML
	private TextField address;
	
	@FXML
	private Label date;
	
	@FXML
	private Label username;
	
	@FXML
	private DatePicker birth;
	
	@FXML
	private Button modify;
	
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
		birth.setEditable(mode);
	}
	
	private void update(){
		IDHelper idHelper = IDHelper.getInstance();
		int id = idHelper.getID();
		UserBLService userBlService = new UserController();
		UserVO uvo = userBlService.searchByUserName(userBlService.searchByUserID(id));
		String username = uvo.getName();
		CustomerBLService customerBLService = new CustomerController();
		CustomerVO  cvo = customerBLService.getCustomerInfo(username);
		
		initDatePicker(cvo.getBirthday().toString());
		
		// 设置组件
		name.setText(username);
		phone.setText(cvo.getPhoneNumber());
		email.setText(cvo.getEmail());
		address.setText(cvo.getAddress());		
		
	}
	
	/*
	 * 初始化DatePicker
	 */
	public void initDatePicker(String birthday) {
		// 设置birth
		String pattern = "yyyy-MM-dd";
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
