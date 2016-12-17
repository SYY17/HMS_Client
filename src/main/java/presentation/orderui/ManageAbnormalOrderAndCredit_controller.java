package presentation.orderui;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import presentation.creditui.ManageUserCredit_start;
import presentation.loginui.LoginUI_start;
import presentation.mainui.SalerUI_start;
import presentation.promotionui.MakePromotionStrategy1_start;

public class ManageAbnormalOrderAndCredit_controller {

	public static Stage stage;

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
}
