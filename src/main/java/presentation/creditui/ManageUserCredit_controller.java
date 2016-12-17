package presentation.creditui;

import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import presentation.controller.UserNameHelper;
import presentation.loginui.LoginUI_start;
import presentation.mainui.SalerUI_start;
import presentation.orderui.ManageAbnormalOrder_start;
import presentation.orderui.ManageAbnormalOrderAndCredit_start;
import presentation.promotionui.MakePromotionStrategy1_start;

public class ManageUserCredit_controller {

	public static Stage stage;
	public TextField searchUser;

	@FXML
	private void onLogout(MouseEvent event) throws Exception {
		new LoginUI_start().start(stage);
	}

	@FXML
	private void onHomePage(MouseEvent event) throws Exception {
		SalerUI_start.getInstance().start(stage);
	}

	@FXML
	private void onMakePromotionStrategy(MouseEvent event) throws Exception {
		new MakePromotionStrategy1_start().start(stage);
	}

	@FXML
	private void onManageCredit(MouseEvent event) throws Exception {
		new ManageUserCredit_start().start(stage);
	}

	@FXML
	private void onManageAbnormalOrder(MouseEvent event) throws Exception {
		ManageAbnormalOrder_start.getInstance().start(stage);
	}
	
	@FXML
	private void onSearchUser(KeyEvent event) throws Exception {
		if (event.getCode().equals(KeyCode.ENTER)){
			String userName = searchUser.getText();
			UserNameHelper.getInstance().initialUserName(userName);
			ManageAbnormalOrderAndCredit_start.getInstance().start(stage);
		}
	}
}
