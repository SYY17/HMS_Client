package presentation.promotionui;

import businesslogic.promotionbl.PromotionController;
import businesslogicservice.promotionblservice.PromotionBLService;
import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import presentation.creditui.ManageUserCredit1_start;
import presentation.hotelui.hotel.PromotionData;
import presentation.loginui.LoginUI_start;
import presentation.mainui.Saler_start;
import presentation.orderui.ManageAbnormalOrder1_start;

public class MakePromotionStrategy2_controller {

	public static Stage stage;
	public PromotionBLService promotionBlService = new PromotionController();
	@FXML
	public TableView<PromotionData> promotionTableView;

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
