package presentation.hotelui.hotel;


import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import presentation.loginui.LoginUI_start;
import presentation.mainui.HotelUI_start;

public class OrderList_controller {
	
	public static Stage stage;
	
	
	@FXML
	private void onMain(MouseEvent event) throws IOException {
		new HotelUI_start().start(stage);
	}
	
	@FXML
	private void onLogout(MouseEvent event) throws Exception {
		new LoginUI_start().start(stage);
	}
	
	@FXML
	private void onExecute(MouseEvent event){
		//JOptionPane.showMessageDialog(null, "查看详情成功", "提示", JOptionPane.PLAIN_MESSAGE);
		//TODO
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

