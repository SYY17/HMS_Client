package presentation.mainui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import presentation.hotelui.ManageHotelCreatingApplication_start;
import presentation.loginui.LoginUI_start;
import presentation.userui.ManageSystemUser_start;

public class ManagerUI_controller {

	public static Stage stage;

	@FXML
	private Label username;

	@FXML
	private TableView<ApplyData> applyInfoTable;
	
	@FXML
	private Label date;

	@FXML
	private void onLogout(MouseEvent event) throws Exception {
		new LoginUI_start().start(stage);
	}

	@FXML
	private void onManageSystemUser(MouseEvent event) throws Exception {
		ManageSystemUser_start.getInstance().start(stage);
	}

	@FXML
	private void onManageHotelCreatingApplication(MouseEvent event) throws Exception {
		new ManageHotelCreatingApplication_start().start(stage);
	}

}
