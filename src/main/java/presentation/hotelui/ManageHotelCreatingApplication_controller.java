package presentation.hotelui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import presentation.loginui.LoginUI_start;
import presentation.mainui.ManagerUI_start;
import presentation.userui.ManageSystemUser_start;

public class ManageHotelCreatingApplication_controller {

	public static Stage stage;

	@FXML
	private void onLogout(ActionEvent event) throws Exception {
		new LoginUI_start().start(stage);
	}

	@FXML
	private void onReturn(ActionEvent event) throws Exception {
		new ManagerUI_start().start(stage);
	}

	@FXML
	private void onManageSystemUser(ActionEvent event) throws Exception {
		ManageSystemUser_start.getInstance().start(stage);
	}

	@FXML
	private void onManageHotelCreatingApplication(ActionEvent event) throws Exception {
		new ManageHotelCreatingApplication_start().start(stage);
	}

	@FXML
	private void onAbout(ActionEvent event) throws Exception {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setHeaderText("据说这是大作业");
		alert.showAndWait();
	}
}
