package presentation.mainui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import presentation.hotelui.hotel.Manage_start;
import presentation.hotelui.hotel.OrderList_start;
import presentation.hotelui.hotel.Promotion_start;
import presentation.loginui.LoginUI_start;

public class HotelUI_controller {

	public static Stage stage;
	
	@FXML
	private Label username;
	
	@FXML
	private Label homepage;
	
	@FXML
	private Label date;
	
	@FXML
	private TableView<OrderData> orderInfoTable;

	@FXML
	private void onLogout(MouseEvent event) throws Exception {
		new LoginUI_start().start(stage);
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
	//
	// @FXML
	// private void onEditOrder(ActionEvent event) throws IOException {
	// new Update_start().start(stage);
	// }
	//
	//
	 @FXML
	 private void onOrderList(MouseEvent event) throws Exception {
	 new OrderList_start().start(stage);
	}
	
	 @FXML
	 private void onMain(MouseEvent event) throws Exception {
	 new HotelUI_start().start(stage);
	 }
	//
	 @FXML
	 private void onManage(MouseEvent event) throws Exception {
	new Manage_start().start(stage);
	}
	//
	 @FXML
	 private void onReviewPromotion(MouseEvent event) throws Exception {
	 new Promotion_start().start(stage);
	 }
	//
	// @FXML
	// private void onCreatePromotion(ActionEvent event) throws IOException {
	// new CreatePromotion_start().start(stage);
	// }

}
