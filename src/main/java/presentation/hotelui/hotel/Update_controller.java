package presentation.hotelui.hotel;


import java.io.IOException;

import javax.swing.JOptionPane;
import javafx.fxml.FXML;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import presentation.loginui.LoginUI_start;
import presentation.mainui.HotelUI_start;

public class Update_controller {
	
	public static Stage stage;

	@FXML
	private void onMain(MouseEvent event) throws IOException {
		//JOptionPane.showMessageDialog(null, "注销成功", "提示", JOptionPane.PLAIN_MESSAGE);
		new HotelUI_start().start(stage);
	}
	
	@FXML
	private void onLogout(MouseEvent event) throws Exception {
		// JOptionPane.showMessageDialog(null, "注销成功", "提示",
		// JOptionPane.PLAIN_MESSAGE);
		new LoginUI_start().start(stage);
	}
	
	@FXML
	private void onUpdate(MouseEvent event){
		JOptionPane.showMessageDialog(null, "更新成功", "提示", JOptionPane.PLAIN_MESSAGE);
	}

//	@FXML
//	private void onReturn(ActionEvent event){
//		//JOptionPane.showMessageDialog(null, "返回成功", "提示", JOptionPane.PLAIN_MESSAGE);
//		new Hotel_start().start(stage);
//	}
	
	
	
	@FXML
	private void onReviewOrderList(MouseEvent event) throws IOException {
		new OrderList_start().start(stage);
	}
	
//	@FXML
//	private void onExecute(ActionEvent event) throws IOException {  //no use of its existence, further consideration needed
//		new Execute_start().start(stage);
//	}
	
	@FXML
	private void onManage(MouseEvent event) throws IOException {
		new Manage_start().start(stage);
	}
	
	@FXML
	private void onReviewPromotion(MouseEvent event) throws IOException {
		new Promotion_start().start(stage);
	}
	
//	@FXML
//	private void onCreatePromotion(ActionEvent event) throws IOException {
//		new CreatePromotion_start().start(stage);
//	}
}

