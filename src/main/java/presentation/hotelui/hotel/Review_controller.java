package presentation.hotelui.hotel;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import presentation.loginui.LogFrame;

public class Review_controller {

	public static Stage stage;
	public static Label nameLabel;
	public static Label addressLabel;
	public static Label areaLabel;
	public static Label starLabel;
	public static Label phoneLabel;
	public static TextArea descriptionText;

	@FXML
	private void onLogout(ActionEvent event) throws IOException {
		// JOptionPane.showMessageDialog(null, "注销成功", "提示",
		// JOptionPane.PLAIN_MESSAGE);
		new LogFrame().start(stage);
	}

	@FXML
	private void onReturn(ActionEvent event) {
		// JOptionPane.showMessageDialog(null, "返回成功", "提示",
		// JOptionPane.PLAIN_MESSAGE);
		new Manage_start().start(stage);
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

	@FXML
	private void onAbout(ActionEvent event) throws Exception {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setHeaderText("据说这是大作业");
		alert.showAndWait();
	}
}
