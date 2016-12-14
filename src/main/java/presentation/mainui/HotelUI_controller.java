package presentation.mainui;

import javafx.event.ActionEvent;
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
	// @FXML
	// private void onReviewOrderList(ActionEvent event) throws IOException {
	// new OrderList_start().start(stage);
	// }
	//
	// @FXML
	// private void onExecute(ActionEvent event) throws IOException { //no use
	// of its existence, further consideration needed
	// new Execute_start().start(stage);
	// }
	//
	// @FXML
	// private void onManage(ActionEvent event) throws IOException {
	// new Manage_start().start(stage);
	// }
	//
	// @FXML
	// private void onReviewPromotion(ActionEvent event) throws IOException {
	// new Promotion_start().start(stage);
	// }
	//
	// @FXML
	// private void onCreatePromotion(ActionEvent event) throws IOException {
	// new CreatePromotion_start().start(stage);
	// }

}
