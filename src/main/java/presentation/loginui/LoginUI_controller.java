package presentation.loginui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;

public class LoginUI_controller {
	
	public static Stage stage;
	
	@FXML
	private void onLogin(ActionEvent event) throws IOException {
		System.out.println("Login!");
	}
	
	@FXML
	private void onRegister(ActionEvent event) throws IOException {
		System.out.println("Registered!");
	}

}
