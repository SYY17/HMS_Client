package presentation.hotelui.hotel;


import java.io.IOException;

import businesslogicservice.ResultMessage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import presentation.controller.HotelControllerImpl;
import presentation.hotelui.HotelControllerService;
import presentation.loginui.LogFrame;
import presentation.mainui.Hotel_start;
import vo.RoomType;
import vo.RoomVO;

public class Room_controller {
	
	public static Stage stage;
	public static ChoiceBox<RoomType> typeChoice;
	public static TextField remainText;
	public static TextField totalText;
	public static TableView<RoomData> roomView;
	
	@FXML
	private void onLogout(ActionEvent event) throws IOException {
		//JOptionPane.showMessageDialog(null, "注销成功", "提示", JOptionPane.PLAIN_MESSAGE);
		new LogFrame().start(stage);
	}
	
	@FXML
	private void onUpdate(ActionEvent event){
		int hotelID = 20905098;
				
		RoomType type = typeChoice.getValue();
		int remainSum = Integer.parseInt(remainText.getText());
		int totalSum = Integer.parseInt(totalText.getText());
		if(type!=null){
			HotelControllerService hotelController = new HotelControllerImpl();
			RoomVO rvo = new RoomVO(hotelID, type, totalSum, remainSum, 0);
			ResultMessage result = hotelController.modifyRoom(rvo);
		
			if(result == ResultMessage.TRUE){
				//JOptionPane.showMessageDialog(null, "更新成功", "提示", JOptionPane.PLAIN_MESSAGE);
				/*
				 * 提示更新成功
				 */
				new Manage_start().start(stage);
			}else{
				/*
				 * 提示更新失败
				 */
			}
		}else{
			/*
			 *提示需要填写完整才能更新 
			 */
		}

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
	
	@FXML
	private void onAbout(ActionEvent event) throws Exception {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setHeaderText("据说这是大作业");
		alert.showAndWait();
	}
}

