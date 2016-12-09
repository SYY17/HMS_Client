package presentation.mainui;

import java.io.IOException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.hotelui.ManageHotelCreatingApplication_start;
import presentation.loginui.LogFrame;
import presentation.userui.ManageSystemUser_start;

public class Manager_controller {

	public static Stage stage;

	@FXML
	private Pane layoutPane;

	@FXML
	private void onLogout(ActionEvent event) throws IOException {
		new LogFrame().start(stage);
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
