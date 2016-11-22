package presentation.hotelui.hotel;


import java.io.IOException;

import javax.swing.JOptionPane;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import presentation.loginui.LogFrame;
import presentation.mainui.Hotel_start;

public class Room_controller {
	
	public static Stage stage;

	@FXML
	private void onLogout(ActionEvent event) throws IOException {
		//JOptionPane.showMessageDialog(null, "注销成功", "提示", JOptionPane.PLAIN_MESSAGE);
		new LogFrame().start(stage);
	}
	
	@FXML
	private void onUpdateIn(ActionEvent event){
		JOptionPane.showMessageDialog(null, "更新成功", "提示", JOptionPane.PLAIN_MESSAGE);
	}
	
	@FXML
	private void onUpdateOut(ActionEvent event){
		JOptionPane.showMessageDialog(null, "更新成功", "提示", JOptionPane.PLAIN_MESSAGE);
	}
	
	@FXML
	private void onReturn(ActionEvent event){
		//JOptionPane.showMessageDialog(null, "返回成功", "提示", JOptionPane.PLAIN_MESSAGE);
		new Hotel_start().start(stage);
	}
	
	
	@FXML
	private void onReviewOrderList(ActionEvent event) throws IOException {
		new OrderList_start().start(stage);
	}
	
	@FXML
	private void onExecute(ActionEvent event) throws IOException {  //no use of its existence, further consideration needed
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

