package presentation.hotelui.hotel;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import presentation.loginui.LoginUI_start;
import presentation.mainui.Hotel_start;

public class OrderList_controller {

	public static Stage stage;

	@FXML
	private void onLogout(ActionEvent event) throws Exception {
		// JOptionPane.showMessageDialog(null, "注销成功", "提示",
		// JOptionPane.PLAIN_MESSAGE);
		new LoginUI_start().start(stage);
	}

	@FXML
	private void onDetail(ActionEvent event) {
		// JOptionPane.showMessageDialog(null, "查看详情成功", "提示",
		// JOptionPane.PLAIN_MESSAGE);
		new Execute_start().start(stage);
	}

	@FXML
	private void onReturn(ActionEvent event) {
		// JOptionPane.showMessageDialog(null, "返回成功", "提示",
		// JOptionPane.PLAIN_MESSAGE);
		new Hotel_start().start(stage);
	}

	@FXML
	private void onReviewOrderList(ActionEvent event) throws IOException {
		new OrderList_start().start(stage);
	}

	@FXML
	private void onExecute(ActionEvent event) throws IOException { // no use of
																	// its
																	// existence,
																	// further
																	// consideration
																	// needed
		new Execute_start().start(stage);
	}

	@FXML
	private void onManage(ActionEvent event) throws IOException {
		new Manage_start().start(stage);
	}

	@FXML
	private void onReviewPromotion(ActionEvent event) throws IOException {
		new Promotion_start().start(stage);
	}

	@FXML
	private void onCreatePromotion(ActionEvent event) throws IOException {
		new CreatePromotion_start().start(stage);
	}
}
