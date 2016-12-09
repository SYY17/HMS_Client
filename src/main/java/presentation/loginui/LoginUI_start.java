package presentation.loginui;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class LoginUI_start extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("FXML/login/LogFrame.fxml"));
			Scene scene = new Scene(root, 800, 600);
			initiateElements(root);
			LoginUI_controller.stage = primaryStage;
			primaryStage.setScene(scene);
			primaryStage.setTitle("酒店管理系统");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * 提供给start方法的总体初始化方法
	 * 
	 * @param root
	 */
	private void initiateElements(Parent root) {
		initiateChoiceBox(root);
		initiatePane(root);
		initiateActionEvent(root);
	}

	/**
	 * 对于选择框中的内容进行初始化
	 * 
	 * @param root
	 */
	@SuppressWarnings("unchecked")
	private void initiateChoiceBox(Parent root) {
		ChoiceBox<String> choicebox_type = (ChoiceBox<String>) root.lookup("#choicebox_type");
		ChoiceBox<String> login_id = (ChoiceBox<String>) root.lookup("#login_id");
		ChoiceBox<String> register_id = (ChoiceBox<String>) root.lookup("#register_id");

		choicebox_type.setItems(FXCollections.observableArrayList("登录", "注册"));
		choicebox_type.setValue("登录");
		login_id.setItems(FXCollections.observableArrayList("客户", "酒店工作人员", "网站营销人员", "网站管理人员"));
		login_id.setValue("客户");
		register_id.setItems(FXCollections.observableArrayList("客户", "酒店工作人员", "网站营销人员", "网站管理人员"));
		register_id.setValue("客户");
	}

	/**
	 * 对于登录/注册面板进行初始化
	 * 
	 * @param root
	 */
	private void initiatePane(Parent root) {
		Pane loginPane = (Pane) root.lookup("#panel_login");
		Pane registerPane = (Pane) root.lookup("#panel_register");

		loginPane.setDisable(false);
		loginPane.setVisible(true);

		registerPane.setDisable(true);
		registerPane.setVisible(false);
	}

	/**
	 * 初始化监听事件
	 * 
	 * @param root
	 */
	@SuppressWarnings("unchecked")
	private void initiateActionEvent(Parent root) {
		ChoiceBox<String> choicebox_type = (ChoiceBox<String>) root.lookup("#choicebox_type");
		ChoiceBox<String> login_id = (ChoiceBox<String>) root.lookup("#login_id");
		ChoiceBox<String> register_id = (ChoiceBox<String>) root.lookup("#register_id");

		// 操作选择框监听事件：登录/注册面板切换
		choicebox_type.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				refreshPane(root);
			}

		});

		// 登录面板身份选择框监听事件：刷新欢迎信息
		login_id.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent arg0) {
				// TODO Auto-generated method stub
				refreshMessage(root, login_id);
			}
		});

		// 注册面板身份选择框监听事件：刷新欢迎信息
		register_id.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				refreshMessage(root, register_id);
			}
		});
	}

	/**
	 * 初始化登录面板
	 */
	private void initiateLoginFields(Parent root) {
		TextField login_username = (TextField) root.lookup("#login_username");
		PasswordField login_password = (PasswordField) root.lookup("#login_password");

		login_username.clear();
		login_password.clear();
	}

	/**
	 * 初始化注册面板
	 */
	private void initiateRegisterFields(Parent root) {
		TextField register_username = (TextField) root.lookup("#register_username");
		PasswordField register_password = (PasswordField) root.lookup("#register_password");
		PasswordField register_confirm = (PasswordField) root.lookup("#register_confirm");

		register_username.clear();
		register_password.clear();
		register_confirm.clear();
	}

	/**
	 * 面板刷新
	 */
	@SuppressWarnings("unchecked")
	private void refreshPane(Parent root) {
		ChoiceBox<String> choicebox_type = (ChoiceBox<String>) root.lookup("#choicebox_type");
		ChoiceBox<String> login_id = (ChoiceBox<String>) root.lookup("#login_id");
		ChoiceBox<String> register_id = (ChoiceBox<String>) root.lookup("#register_id");
		Pane panel_login = (Pane) root.lookup("#panel_login");
		Pane panel_register = (Pane) root.lookup("#panel_register");

		String value = choicebox_type.getValue();

		if (value.equals("登录")) {
			initiateRegisterFields(root);
			refreshMessage(root, login_id);

			panel_login.setVisible(true);
			panel_login.setDisable(false);

			panel_register.setVisible(false);
			panel_register.setDisable(true);
		} else {
			initiateLoginFields(root);
			refreshMessage(root, register_id);

			panel_register.setVisible(true);
			panel_register.setDisable(false);

			panel_login.setVisible(false);
			panel_login.setDisable(true);
		}
	}

	/**
	 * 根据身份刷新欢迎信息
	 * 
	 * @param root
	 * @param box
	 */
	private void refreshMessage(Parent root, ChoiceBox<String> box) {
		Label message = (Label) root.lookup("#message");

		String value = box.getValue();

		if (value.equals("客户")) {
			message.setText("找到最适合您的酒店");
		} else if (value.equals("酒店工作人员")) {
			message.setText("协助您管理您的酒店");
		} else if (value.equals("网站营销人员")) {
			message.setText("帮助您处理您的业务");
		} else {
			message.setText("让网站管理更加简单");
		}
	}
}
