package presentation.creditui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import presentation.loginui.LoginUI_start;
import presentation.orderui.ManageAbnormalOrder1_start;
import presentation.promotionui.MakePromotionStrategy1_start;

public class ManageUserCredit2_controller {

	public static Stage stage;

	@FXML
	private void onLogout(ActionEvent event) throws Exception {
		new LoginUI_start().start(stage);
	}

	@FXML
	private void onReturn(ActionEvent event) throws Exception {
		new ManageUserCredit1_start().start(stage);
	}

	@FXML
	private void onOrderManage(ActionEvent event) throws Exception {
		new ManageAbnormalOrder1_start().start(stage);
	}

	@FXML
	private void onPromotionManage(ActionEvent event) throws Exception {
		new MakePromotionStrategy1_start().start(stage);
	}

	@FXML
	private void onCreditManage(ActionEvent event) throws Exception {
		new ManageUserCredit1_start().start(stage);
	}

	@FXML
	private void onAbout(ActionEvent event) throws Exception {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setHeaderText("据说这是大作业");
		alert.showAndWait();
	}
}
