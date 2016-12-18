package presentation.userui.user;

import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import presentation.loginui.LoginUI_start;
import presentation.mainui.UserUI_start;

public class HotelInformation_controller {

	public static String hotelname;
	public static Stage stage;
	@FXML
	TextArea description;
	@FXML
	TableView</*HotelData暂时先不删*/ ?> hotelTableView;
	
	@FXML
	private void onLogout(MouseEvent event) throws Exception {
		new LoginUI_start().start(stage);
	}

	@FXML
	private void onOrderManage(MouseEvent event) throws Exception {
		AllOrder_start.getInstance().start(stage);
	}
	
	@FXML
	private void onHomepage(MouseEvent event) throws Exception {
		new UserUI_start().start(stage);
	}
	
	@FXML
	private void onHistory(MouseEvent event) throws IOException {
		Credit_start.getInstance().start(stage);
	}

	@FXML
	private void onInfoManage(MouseEvent event) {
		new DetailedInformation_start().start(stage);
	}

	@FXML
	private void onOrder(MouseEvent event) throws Exception {
		MakeOrder_start a = new MakeOrder_start();
		a.setName(hotelname);
		a.start(stage);
	}
}
