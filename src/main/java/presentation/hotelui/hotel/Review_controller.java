package presentation.hotelui.hotel;


import java.io.IOException;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import presentation.loginui.LoginUI_start;
import presentation.mainui.HotelUI_start;

public class Review_controller {
	
	public static Stage stage;
	public static Label nameLabel;
	public static Label addressLabel;
	public static Label areaLabel;
	public static Label starLabel;
	public static Label phoneLabel;
	public static TextArea descriptionText;
	
	@FXML
	private void onMain(MouseEvent event) throws IOException {
		new HotelUI_start().start(stage);
	}
	
	@FXML
	private void onLogout(MouseEvent event) throws Exception {
		new LoginUI_start().start(stage);
	}
	
	@FXML
	private void onReviewOrderList(MouseEvent event) throws IOException {
		new OrderList_start().start(stage);
	}
	
	@FXML
	private void onManage(MouseEvent event) throws IOException {
		new Manage_start().start(stage);
	}
	
	@FXML
	private void onReviewPromotion(MouseEvent event) throws IOException {
		new Promotion_start().start(stage);
	}
}

