package presentation.promotionui;

import businesslogic.promotionbl.PromotionController;
import businesslogicservice.promotionblservice.PromotionBLService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import presentation.creditui.ManageUserCredit1_start;
import presentation.hotelui.hotel.PromotionData;
import presentation.loginui.LoginUI_start;
import presentation.mainui.SalerUI_start;
import presentation.orderui.ManageAbnormalOrder1_start;

public class MakePromotionStrategy1_controller {

	public static Stage stage;
	public PromotionBLService promotionBlService = new PromotionController();
	@FXML
	public TableView<PromotionData> promotionTableView;

	@FXML
	private void onLogout(MouseEvent event) throws Exception {
		new LoginUI_start().start(stage);
	}

	@FXML
	private void onHomepage(MouseEvent event) throws Exception {
		new SalerUI_start().start(stage);
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
	
	@FXML
	private void onAdd(MouseEvent event) throws Exception {
		new MakePromotionStrategy2_start().start(stage);
	}

	@FXML
	private void onAbout(ActionEvent event) throws Exception {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setHeaderText("据说这是大作业");
		alert.showAndWait();
	}
}
