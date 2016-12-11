package presentation.userui.user;

import java.io.IOException;

import businesslogicservice.ResultMessage;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import presentation.controller.HotelControllerImpl;
import presentation.hotelui.HotelControllerService;
import presentation.hotelui.hotel.Manage_start;
import presentation.loginui.LoginUI_start;
import presentation.mainui.UserUI_start;
import vo.HotelVO;

public class OrderAndRating_controller {

	public static Stage stage;
	public static Label rateLabel;
	public static TextField rateText;
	public static TextArea hotelInfoText;

	@FXML
	private void onLogout(MouseEvent event) throws Exception {
		new LoginUI_start().start(stage);
	}

	@FXML
	private void onOrderManage(MouseEvent event) throws Exception {
		new AllOrder_start().start(stage);
	}
	
	@FXML
	private void onHomepage(MouseEvent event) throws Exception {
		new UserUI_start().start(stage);
	}
	
	@FXML
	private void onHistory(MouseEvent event) throws IOException {
		new Credit_start().start(stage);
	}

	@FXML
	private void onInfoManage(MouseEvent event) {
		new DetailedInformation_start().start(stage);
	}

	@FXML
	private void onSubmit(ActionEvent event) throws IOException {
		int rate = Integer.parseInt(rateText.getText());

		String hotelName = "homeinn";/* 浼犲叆hotelID */

		if (rate != 0) {
			HotelControllerService hotelController = new HotelControllerImpl();
			HotelVO hotel = hotelController.reviewHotelInfo(hotelName);

			HotelVO hvo = new HotelVO(hotel.getHotelID(), hotelName, hotel.getHotelAddress(), hotel.getBusinessArea(),
					hotel.getHotelDescription(), hotel.getStarLevel(), rate, hotel.getStaffName(),
					hotel.getPhoneNumber());
			ResultMessage result = hotelController.gradeHotel(hvo);

			if (result == ResultMessage.TRUE) {
				/*
				 * 鎻愮ず璇勪环鎴愬姛
				 */
				new Manage_start().start(stage);
			} else {
				/*
				 * 鎻愮ず璇勪环澶辫触
				 */
			}

		} else {
			/*
			 * 鎻愮ず闇�瑕佸～鍐欐墠鑳借瘎浠�
			 */
		}
	}

}
