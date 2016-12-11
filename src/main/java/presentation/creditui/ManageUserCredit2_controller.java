package presentation.creditui;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import presentation.loginui.LoginUI_start;
import presentation.mainui.Saler_start;
import presentation.orderui.ManageAbnormalOrder1_start;
import presentation.promotionui.MakePromotionStrategy1_start;
import presentation.promotionui.MakePromotionStrategy2_start;

public class ManageUserCredit2_controller {

	public static Stage stage;

	@FXML
	private void onLogout(MouseEvent event) throws Exception {
		new LoginUI_start().start(stage);
	}

	@FXML
	private void onHomePage(MouseEvent event) throws Exception {
		new Saler_start().start(stage);
	}

	@FXML
	private void onMakePromotionStrategy(MouseEvent event) throws Exception {
		new MakePromotionStrategy1_start().start(stage);
	}

	@FXML
	private void onManageCredit(MouseEvent event) throws Exception {
		new ManageUserCredit1_start().start(stage);
	}

	@FXML
	private void onManageAbnormalOrder(MouseEvent event) throws Exception {
		new ManageAbnormalOrder1_start().start(stage);
	}
}
