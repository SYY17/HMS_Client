package presentation.userui.user;

import java.io.IOException;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import presentation.loginui.LoginUI_start;
import presentation.mainui.User_start;

public class DetailedInformation_controller {

	public static Stage stage;

	@FXML
	private void onLogout(MouseEvent event) throws Exception {
		new LoginUI_start().start(stage);
	}

	@FXML
	private void onOrderManage(MouseEvent event) throws Exception {
		new AllOrder_start().start(stage);
	}
	
	@FXML
	private void onHomepage(MouseEvent event) throws Exception {
		new User_start().start(stage);
	}
	
	@FXML
	private void onHistory(MouseEvent event) throws IOException {
		new Credit_start().start(stage);
	}

	@FXML
	private void onInfoManage(MouseEvent event) {
		new DetailedInformation_start().start(stage);
	}

	@FXML
	private void onEdit(ActionEvent event) {
		new User_start().start(stage);
		// JOptionPane.showMessageDialog(null, "�����˳�", "����",
		// JOptionPane.PLAIN_MESSAGE);
	}

	@FXML
	private void onSubmit(ActionEvent event) {
		new User_start().start(stage);
		// JOptionPane.showMessageDialog(null, "�����˳�", "����",
		// JOptionPane.PLAIN_MESSAGE);
	}
}
