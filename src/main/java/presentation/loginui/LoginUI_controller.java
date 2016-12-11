package presentation.loginui;

import java.io.IOException;

import businesslogicservice.ResultMessage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.controller.IDHelper;
import presentation.controller.LoginControllerImpl;
import presentation.controller.UserControllerImpl;
import presentation.mainui.HotelUI_start;
import presentation.mainui.ManagerUI_start;
import presentation.mainui.SalerUI_start;
import presentation.mainui.UserUI_start;
import presentation.userui.UserControllerService;
import vo.UserVO;

public class LoginUI_controller {

	public static Stage stage;

	@FXML
	private Label message;

	@FXML
	private ChoiceBox<String> choicebox_type;

	@FXML
	private ChoiceBox<String> login_id;

	@FXML
	private Pane panel_login;

	@FXML
	private TextField login_username;

	@FXML
	private PasswordField login_password;

	@FXML
	private Pane panel_register;

	@FXML
	private ChoiceBox<String> register_id;

	@FXML
	private TextField register_username;

	@FXML
	private PasswordField register_password;

	@FXML
	private PasswordField register_confirm;

	private IDHelper idHelper;

	/**
	 * 登录按钮的监听事件
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	private void onLogin(ActionEvent event) throws IOException {
		// System.out.println("Login!");
		LoginControllerService loginController = new LoginControllerImpl();
		String username = login_username.getText();
		String password = login_password.getText();
		int identity = parseID(login_id);

		ResultMessage result = loginController.login(username, password, identity);
		if (result == ResultMessage.TRUE) {
			// 初始化ID
			idHelper = IDHelper.getInstance();
			UserControllerService userController = new UserControllerImpl();
			UserVO uvo = userController.searchByUserName(username);
			idHelper.initialID(uvo.getID());
			jumpToMainFrame(identity);
		} else {
			// 弹出登录失败对话框
			System.out.println("Login Failed!");
		}
	}

	/**
	 * 注册按钮的监听事件
	 * 
	 * @param event
	 * @throws IOException
	 */
	@FXML
	private void onRegister(ActionEvent event) throws IOException {
		// System.out.println("Registered!");
		// TODO Auto-generated method stub
		LoginControllerService loginController = new LoginControllerImpl();
		String username = register_username.getText();
		String password = register_password.getText();
		String confirm = register_confirm.getText();
		if (!password.equals(confirm)) {
			// 提示两次输入不一致
			System.out.println("Not Match!");
			return;
		}
		int identity = parseID(register_id);

		ResultMessage result = loginController.addNewUser(username, password, identity);
		if (result == ResultMessage.TRUE) {
			// 提示注册成功，确认跳转至登录选项
			System.out.println("Registered!");
		} else {
			// 弹出注册失败对话框
		}
	}

	/**
	 * 
	 * @param id
	 * @return 转换成对应数字ID
	 */
	private int parseID(ChoiceBox<String> id) {
		// TODO Auto-generated method stub
		String s = id.getValue();

		if (s.equals("客户")) {
			return 1;
		} else if (s.equals("酒店工作人员")) {
			return 2;
		} else if (s.equals("网站营销人员")) {
			return 3;
		}
		return 4;
	}

	/**
	 * 根据身份判断跳转的界面
	 * 
	 * @param identity
	 */
	private void jumpToMainFrame(int identity) {
		if (identity == 4) {
			new ManagerUI_start().start(stage);
		} else if (identity == 3) {
			new SalerUI_start().start(stage);
		} else if (identity == 2) {
			new HotelUI_start().start(stage);
		} else {
			new UserUI_start().start(stage);
		}
	}

}
