package presentation.orderui;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.KeyCode;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import presentation.controller.UserControllerImpl;
import presentation.controller.UserNameHelper;
import presentation.creditui.ManageUserCredit_start;
import presentation.loginui.LoginUI_start;
import presentation.mainui.SalerUI_start;
import presentation.promotionui.MakePromotionStrategy1_start;
import presentation.userui.UserControllerService;

public class ManageAbnormalOrder_controller {

	public static Stage stage;
	
	public TableView<OrderData> manageAbnormalOrderTableView;
	public TextField searchUser;

	@FXML
	private void onLogout(MouseEvent event) throws Exception {
		new LoginUI_start().start(stage);
	}

	@FXML
	private void onHomePage(MouseEvent event) throws Exception {
		new SalerUI_start().start(stage);
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
		new ManageAbnormalOrder_start().start(stage);
	}
	
	@FXML
	private void onSearchUser(KeyEvent event) throws Exception {
		if (event.getCode().equals(KeyCode.ENTER)){
			String userName = searchUser.getText();
			UserNameHelper.getInstance().initialUserName(userName);
			new ManageAbnormalOrderAndCredit_start().start(stage);
		}
	}
}