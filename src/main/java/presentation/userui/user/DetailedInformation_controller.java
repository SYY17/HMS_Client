package presentation.userui.user;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import presentation.loginui.LoginUI_start;
import presentation.mainui.UserUI_start;

public class DetailedInformation_controller {

	public static Stage stage;
	@FXML
	TextField name;
	@FXML
	TextField phone;
	@FXML
	TextField email;
	@FXML
	TextField address;
	@FXML
	DatePicker birth;
	@FXML
	Button modify;
	
	@FXML
	private void onModify(MouseEvent event) throws Exception {
		new DetailedInformation_start().start(stage);
	}
	
	@FXML
	private void onEdit(MouseEvent event) throws Exception {
		new DetailedInformation_start().start(stage);
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

}
