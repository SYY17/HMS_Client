package presentation.mainui;

import java.io.IOException;
import java.util.ArrayList;

import businesslogic.hotelbl.HotelController;
import businesslogicservice.hotelBLService.HotelBLService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import presentation.loginui.LoginUI_start;
import presentation.userui.user.AllOrder_start;
import presentation.userui.user.Credit_start;
import presentation.userui.user.DetailedInformation_start;
import presentation.userui.user.HotelInformation_start;
import vo.HotelVO;

public class UserUI_controller {

	public static Stage stage;
	public static String hotelname;
	
	@FXML
	private Label ordermanage;
	
	@FXML
	private Label infoManage;
	
	@FXML
	private Label history;
	
	@FXML
	private Label username;
	
	@FXML
	private Label homepage;
	
	@FXML
	private Label date;
	
	@FXML
	private Label search;
	
	@FXML
	private ListView<String> hotelList;
	
	@FXML
	private TextField searchTextField;

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
	private void onSearch(MouseEvent event) {
		String des = searchTextField.getText();
		
		HotelBLService hotelBlService = new HotelController();

		ArrayList<HotelVO> hvo = hotelBlService.searchHotel(des);
		
		ArrayList<String> content = new ArrayList<String>();
		for (int i = 0; i < hvo.size(); i++) {
			content.add(hvo.get(i).getHotelName());
		}
		
		ObservableList<String> strList = FXCollections.observableArrayList(content);
		hotelList.setItems(strList);
	}

	@FXML
	private void onGo(MouseEvent event) {
		HotelInformation_start a =new HotelInformation_start();
		a.setName(hotelname);
		a.start(stage);
	}
	
}
