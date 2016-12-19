package presentation.hotelui.hotel;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import presentation.loginui.LoginUI_start;
import presentation.mainui.HotelUI_start;

public class PromotionContent_controller {
	
	public static Stage stage;
	
	@FXML
	private void onLogout(MouseEvent event) throws Exception {
		new LoginUI_start().start(stage);
	}

	@FXML
	private void onBack(MouseEvent event) {
		new Promotion_start().start(stage);
	}
	
	@FXML
	private void onHomepage(MouseEvent event) throws Exception {
		new HotelUI_start().start(stage);
	}
	
	@FXML
	private void onOrderManage(MouseEvent event) throws Exception {
		new OrderList_start().start(stage);
	}
	
	@FXML
	private void onPromotionManage(MouseEvent event) throws Exception {
		new Promotion_start().start(stage);
	}
	
	@FXML
	private void onHotelManage(MouseEvent event) throws Exception {
		new Manage_start().start(stage);
	}
}
