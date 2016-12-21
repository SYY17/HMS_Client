package presentation.mainui;

import java.util.ArrayList;

import businesslogic.hotelbl.HotelController;
import businesslogicservice.hotelBLService.HotelBLService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import presentation.loginui.LoginUI_start;
import presentation.userui.user.AllOrder_start;
import presentation.userui.user.Credit_start;
import presentation.userui.user.DetailedInformation_start;
import presentation.userui.user.HotelInformation_start;
import presentation.userui.user.MakeOrder_start;
import vo.HotelVO;
import vo.RoomVO;

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
	private ImageView search;
	
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
		AllOrder_start.getInstance().start(stage);
	}
	
	@FXML
	private void onHomepage(MouseEvent event) throws Exception {
		new UserUI_start().start(stage);
	}
	
	@FXML
	private void onHistory(MouseEvent event) throws Exception {
		Credit_start.getInstance().start(stage);
	}

	@FXML
	private void onInfoManage(MouseEvent event) throws Exception  {
		new DetailedInformation_start().start(stage);
	}
	
	@FXML
	private void onSearch(MouseEvent event) throws Exception  {
		String des = searchTextField.getText();
		
		HotelBLService hotelBlService = new HotelController();

		ArrayList<HotelVO> hvo = hotelBlService.searchHotel(des);
		
		ArrayList<String> content = new ArrayList<String>();
		for (int i = 0; i < hvo.size(); i++) {
			content.add(getExpression(hvo.get(i)));
		}
		
		ObservableList<String> strList = FXCollections.observableArrayList(content);
		hotelList.setItems(strList);
	}

	@FXML
	private void onGo(MouseEvent event)  throws Exception {
		/*
		HotelInformation_start a =new HotelInformation_start();
		a.setName(hotelname);
		a.start(stage);*/
		HotelInformation_start.getInstance().setName(hotelname);
		HotelInformation_start.getInstance().start(stage);
	}
	
	public String getName(String str){
		String name;
		int cnt = str.indexOf(" ");
		name = str.substring(0, cnt);
		return name;
	}
	/**
	 * 
	 * @param hvo
	 * @return listItem
	 */
	public String getExpression(HotelVO hvo){
		String str = hvo.getHotelName();
		for(int i=0;i<20-hvo.getHotelName().length();i++){
			str+=" ";
		}
		str+=hvo.getBusinessArea();
		for(int i=0;i<40-str.length();i++){
			str+=" ";
		}
		for(int i=0;i<50-str.length();i++){
			str+=" ";
		}
		str+="星级：";
		str+=String.valueOf(hvo.getStarLevel());
		for(int i=0;i<60-str.length();i++){
			str+=" ";
		}
		str+="最低价格：";
		str+=String.valueOf(getMinPrice(hvo));
		return str;
	}
	
	
	public int getMinPrice(HotelVO hvo){
		HotelBLService hotelBlService = new HotelController();
		ArrayList<RoomVO> room = hotelBlService.SearchRooms(hvo.getHotelID());
		int small = 0;
			for(int j=1;j<room.size();j++){
				if(room.get(j).getPrice()<room.get(small).getPrice()){
					small = j;
				}
			}
			int pr = room.get(small).getPrice();
			return pr;
	}
	
	@FXML
	private void onOrder(MouseEvent event) throws Exception {
		MakeOrder_start a = new MakeOrder_start();
		a.setName(hotelname);
		a.start(stage);
	}
	
}
