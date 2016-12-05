package presentation.loginui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

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
	
	@FXML
	private void onLogin(ActionEvent event) throws IOException {
		System.out.println("Login!");
	}
	
	@FXML
	private void onRegister(ActionEvent event) throws IOException {
		System.out.println("Registered!");
	}
	
	@FXML
	private void onSelectedType(MouseEvent event) throws IOException {
		//在start中初始化
		//type变化刷新message和pane
	}

}
