package presentation.hotelui.hotel;


import java.io.IOException;

import businesslogicservice.ResultMessage;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import presentation.controller.HotelControllerImpl;
import presentation.hotelui.HotelControllerService;
import presentation.loginui.LoginUI_start;
import presentation.mainui.HotelUI_start;
import vo.HotelVO;

public class Modify_controller {
	
	public static Stage stage;
	@FXML
	public Label nameLabel;
	public TextField addressText;
	public TextField businessAreaText;
	public TextField starText;
	public TextField phoneText;
	public TextArea descriptionText;
	
	@FXML
	private void onMain(MouseEvent event) throws IOException {
		new HotelUI_start().start(stage);
	}
	
	@FXML
	private void onLogout(MouseEvent event) throws Exception {
		new LoginUI_start().start(stage);
	}

	

	@FXML
	private void onConfirm(MouseEvent event){
		
		String hotelName = nameLabel.getText();
		System.out.println(hotelName);
		String address = addressText.getText();
		String businessArea = businessAreaText.getText();
		int starLevel = Integer.parseInt(starText.getText());
		String phone = phoneText.getText();
		String description = descriptionText.getText();
		if(hotelName!=null && address!=null && businessArea!=null && starLevel!=0 && phone!=null){
			HotelControllerService hotelController = new HotelControllerImpl();
			int id = hotelController.reviewHotelInfo(hotelName).getHotelID();
			String staffname = hotelController.reviewHotelInfo(hotelName).getStaffName();
			double rate = hotelController.reviewHotelInfo(hotelName).getRating();
			HotelVO hvo = new HotelVO(id,hotelName,address,businessArea,description,starLevel,rate,staffname,phone);
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
		
		new Manage_start().start(stage);
	}
	
	@FXML
	private void onCancel(MouseEvent event){
		new Manage_start().start(stage);
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

