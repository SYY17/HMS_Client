package presentation.hotelui.hotel;

import java.io.IOException;

import businesslogic.promotionbl.PromotionController;
import businesslogicservice.promotionblservice.PromotionBLService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import presentation.loginui.LoginUI_start;
import presentation.mainui.HotelUI_start;

public class Promotion_controller {

	public static Stage stage;
	public PromotionBLService promotionBlService = new PromotionController();
	@FXML
	public ListView<String> promotionListView;

	@FXML
	private void onLogout(MouseEvent event) throws Exception {
		new LoginUI_start().start(stage);
	}

	@FXML
	private void onAdd(MouseEvent event) {
		new CreatePromotion_start().start(stage);
	}

	@FXML
	private void onReviewOrderList(ActionEvent event) throws IOException {
		new OrderList_start().start(stage);
	}

	@FXML
	private void onManage(ActionEvent event) throws IOException {
		new Manage_start().start(stage);
	}

	@FXML
	private void onReviewPromotion(ActionEvent event) throws IOException {
		new Promotion_start().start(stage);
	}
}
