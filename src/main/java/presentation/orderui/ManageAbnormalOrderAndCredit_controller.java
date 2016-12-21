package presentation.orderui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import presentation.controller.CreditControllerImpl;
import presentation.controller.UserControllerImpl;
import presentation.creditui.CreditControllerService;
import presentation.creditui.ManageUserCredit_start;
import presentation.loginui.LoginUI_start;
import presentation.mainui.SalerUI_start;
import presentation.promotionui.MakePromotionStrategy1_start;
import presentation.userui.UserControllerService;
import vo.CreditMovement;

public class ManageAbnormalOrderAndCredit_controller {

	public static Stage stage;
	public Label username;
	public Label credit;
	public Label addcredit;
	public TextField money;
	private CreditControllerService creditControllerService = new CreditControllerImpl();
	private UserControllerService userControllerService = new UserControllerImpl();

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
	private void onEnteredCredit(MouseEvent event) throws Exception {
		addcredit.setTextFill(Paint.valueOf("#003fff"));
	}

	@FXML
	private void onExitedCredit(MouseEvent event) throws Exception {
		addcredit.setTextFill(Paint.valueOf("#000000"));
	}

	@FXML
	private void onAddCredit(MouseEvent event) throws Exception {
		int userID = userControllerService.searchByUserName(username.getText()).getID();
		int credit = Integer.parseInt(money.getText()) * 100;
		creditControllerService.modifyCredit(userID, credit, CreditMovement.AddMoney);
		this.credit.setText(credit + "");
		this.money.clear();
	}
}
