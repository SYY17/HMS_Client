package presentation.userui.user;

import java.io.IOException;

import businesslogicservice.ResultMessage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import presentation.controller.HotelControllerImpl;
import presentation.hotelui.HotelControllerService;
import presentation.hotelui.hotel.Manage_start;
import presentation.loginui.LogFrame;
import presentation.mainui.User_start;
import vo.HotelVO;

public class OrderAndRating_controller {
	
	public static Stage stage;
	public static Label rateLabel;
	public static TextField rateText;
	public static TextArea hotelInfoText;
	
	@FXML
	private void onLogout(ActionEvent event) throws IOException {
		new LogFrame().start(stage);
	}

	@FXML
	private void onBack(ActionEvent event) throws IOException  {
		new User_start().start(stage);
	}
	
	
	@FXML
	private void onShowOrder(ActionEvent event) throws IOException {
		new AllOrder_start().start(stage);
	}
	
	@FXML
	private void onDetailedInfo(ActionEvent event) {
		new DetailedInfomation_start().start(stage);
	}
	
	@FXML
	private void onSubmit(ActionEvent event) throws IOException {
		int rate = Integer.parseInt(rateText.getText());
		
		String hotelName = "homeinn";/*    传入hotelID    */
		
		if(rate!=0){
			HotelControllerService hotelController = new HotelControllerImpl();
			HotelVO hotel = hotelController.reviewHotelInfo(hotelName);
			
			HotelVO hvo = new HotelVO(hotel.getHotelID(),hotelName,hotel.getHotelAddress(),hotel.getBusinessArea(),
					hotel.getHotelDescription(),hotel.getStarLevel(),hotel.getRoomNumber(),hotel.getRooms(),
					rate,hotel.getStaffName(),hotel.getPhoneNumber());
			ResultMessage result = hotelController.gradeHotel(hvo);
		
			if(result == ResultMessage.TRUE){
				/*
				 * 提示评价成功
				 */
				new Manage_start().start(stage);
			}else{
				/*
				 * 提示评价失败
				 */
			}
			
		}else{
			/*
			 * 提示需要填写才能评价
			 */
		}
	}

}
