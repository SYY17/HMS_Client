package presentation.userui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import presentation.hotelui.ManageHotelCreatingApplication_start;
import presentation.loginui.LogFrame;
import presentation.mainui.Manager_start;

public class ManageSystemUser_controller {

	public static Stage stage;

	@FXML
	private void onLogout(ActionEvent event) throws IOException {
		new LogFrame().start(stage);
	}
	
	@FXML
	private void onReturn(ActionEvent event) throws Exception {
		new Manager_start().start(stage);
	}
	

	@FXML
	private void onManageSystemUser(ActionEvent event) throws Exception {
		new ManageSystemUser_start().start(stage);
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
