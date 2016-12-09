package presentation.mainui;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import presentation.loginui.LogFrame;

public class Hotel_controller {

	public static Stage stage;

	@FXML
	private void onLogout(ActionEvent event) throws IOException {
		new LogFrame().start(stage);
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
