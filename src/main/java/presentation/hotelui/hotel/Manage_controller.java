package presentation.hotelui.hotel;


import java.io.IOException;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import presentation.loginui.LoginUI_start;
import presentation.mainui.HotelUI_start;

public class Manage_controller {
	
	public static Stage stage;
	public static Label nameLabel;
	
	@FXML
	private void onMain(MouseEvent event) throws IOException {
		//JOptionPane.showMessageDialog(null, "注销成功", "提示", JOptionPane.PLAIN_MESSAGE);
		new HotelUI_start().start(stage);
	}
	
	@FXML
	private void onLogout(MouseEvent event) throws Exception {
		//JOptionPane.showMessageDialog(null, "注销成功", "提示", JOptionPane.PLAIN_MESSAGE);
		new LoginUI_start().start(stage);
	}
	
	@FXML
	private void onReview(MouseEvent event){
		//JOptionPane.showMessageDialog(null, "浏览成功", "提示", JOptionPane.PLAIN_MESSAGE);
		new Review_start().start(stage);
	}
	
	@FXML
	private void onModify(MouseEvent event){
		//JOptionPane.showMessageDialog(null, "修改成功", "提示", JOptionPane.PLAIN_MESSAGE);
		new Modify_start().start(stage);
	}
	
//	@FXML
//	private void onCreate(ActionEvent event){
//		//JOptionPane.showMessageDialog(null, "创建成功", "提示", JOptionPane.PLAIN_MESSAGE);
//		new Create_start().start(stage);
//	}
	
//	@FXML
//	private void onReturn(ActionEvent event){
//		//JOptionPane.showMessageDialog(null, "返回成功", "提示", JOptionPane.PLAIN_MESSAGE);
//		new Hotel_start().start(stage);
//	}
	
	@FXML
	private void onUpdateRoom(MouseEvent event){
		//JOptionPane.showMessageDialog(null, "返回成功", "提示", JOptionPane.PLAIN_MESSAGE);
		new Room_start().start(stage);
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

