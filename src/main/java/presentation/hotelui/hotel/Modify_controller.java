package presentation.hotelui.hotel;


import java.io.IOException;

import businesslogicservice.ResultMessage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import presentation.controller.HotelControllerImpl;
import presentation.hotelui.HotelControllerService;
import presentation.loginui.LogFrame;
import vo.HotelVO;

public class Modify_controller {
	
	public static Stage stage;
	public static Label nameLabel;
	public static TextField addressText;
	public static TextField businessAreaText;
	public static TextField starText;
	public static TextField phoneText;
	public static TextArea descriptionText;
	
	@FXML
	private void onLogout(ActionEvent event) throws IOException {
		//JOptionPane.showMessageDialog(null, "注销成功", "提示", JOptionPane.PLAIN_MESSAGE);
		new LogFrame().start(stage);
	}

	
	//showing the information before current edition???
	@FXML
	private void onConfirm(ActionEvent event){
		
		String hotelName = nameLabel.getText();
		String address = addressText.getText();
		String businessArea = businessAreaText.getText();
		int starLevel = Integer.parseInt(starText.getText());
		String phone = phoneText.getText();
		String description = descriptionText.getText();
		if(hotelName!=null && address!=null && businessArea!=null && starLevel!=0 && phone!=null){
			HotelControllerService hotelController = new HotelControllerImpl();
			int id = hotelController.reviewHotelInfo(hotelName).getHotelID();
			HotelVO hvo = new HotelVO(id,hotelName,address,businessArea,description,starLevel,0,null,0,null,phone);
			ResultMessage result = hotelController.modifyHotel(hvo);
		
			if(result == ResultMessage.TRUE){
				/*
				 * 提示修改成功
				 */
				new Manage_start().start(stage);
			}else{
				/*
				 * 提示修改失败
				 */
			}
			
		}else{
			/*
			 * 提示需要填写完整才能修改
			 */
		}
		
		
		//JOptionPane.showMessageDialog(null, "修改成功", "提示", JOptionPane.PLAIN_MESSAGE);
		new Manage_start().start(stage);
	}
	
	@FXML
	private void onCancel(ActionEvent event){
		//JOptionPane.showMessageDialog(null, "取消成功", "提示", JOptionPane.PLAIN_MESSAGE);
		new Manage_start().start(stage);
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

