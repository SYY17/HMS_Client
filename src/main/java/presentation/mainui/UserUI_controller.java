package presentation.mainui;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import presentation.loginui.LoginUI_start;
import presentation.userui.user.AllOrder_start;
import presentation.userui.user.Credit_start;
import presentation.userui.user.DetailedInformation_start;

public class UserUI_controller {

	public static Stage stage;
	
	@FXML
	private Label ordermanage;
	
	@FXML
	private Label infoManage;
	
	@FXML
	private Label history;
	
	@FXML
	private Label username;
	
	@FXML
	private Label homepage;
	
	@FXML
	private Label date;

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