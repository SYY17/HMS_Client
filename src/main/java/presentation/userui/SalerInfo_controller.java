package presentation.userui;

import businesslogic.userbl.UserController;
import businesslogicservice.userblservice.UserBLService;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import presentation.controller.TempIDHelper;
import presentation.hotelui.ManageHotelCreatingApplication_start;
import presentation.loginui.LoginUI_start;
import presentation.userui.user.DetailedInformation_start;
import vo.UserVO;

public class SalerInfo_controller {

	public static Stage stage;
	
	@FXML
	private Label username;
	
	@FXML
	private Label date;
	
	@FXML
	private TextField name;
	
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
		name.setEditable(mode);
	}
	
	/**
	 * 上传信息
	 */
	private void upload(){
		String username = this.getUserName();
		UserBLService userBLService = new UserController();
		
		//获取生日: 获取的String -> java.util.Date -> java.sql.Date
		try {
			String salerName = name.getText();
			//更新用户名
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	/**
	 * 总体更新方法
	 */
	private void update(){
		String username = this.getUserName();
		// 设置组件
		name.setText(username);
	}
	
	/**
	 * 
	 * @return 获取当前用户用户名
	 */
	private String getUserName(){
		TempIDHelper tempHelper = TempIDHelper.getInstance();
		int id = tempHelper.getID();
		UserBLService userBlService = new UserController();
		UserVO uvo = userBlService.searchByUserName(userBlService.searchByUserID(id));
		String username = uvo.getName();
		return username;
	}

}
