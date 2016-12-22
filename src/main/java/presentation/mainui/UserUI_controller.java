package presentation.mainui;

import java.util.ArrayList;

import businesslogic.hotelbl.HotelController;
import businesslogicservice.hotelBLService.HotelBLService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import presentation.alertui.Alert;
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
	public static String type;//
	
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
	private ChoiceBox<String> searchBox;

	public static void setType(String s){
		type = s;
	}
	
	private Alert alert;
	
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
		
		type = searchBox.getValue();
		
		HotelBLService hotelBlService = new HotelController();
		ArrayList<HotelVO> all = hotelBlService.reviewHotelList();
		System.out.println(type);
		if(type.equals("酒店名称")){
			ArrayList<HotelVO> containsName = new ArrayList<HotelVO>();
			
			for(int i=0;i<all.size();i++){
				if(all.get(i).getHotelName().contains(des)){
					containsName.add(all.get(i));
				}
			}
			
			if(containsName.size() ==0){
				alert = Alert.getInstance();
				alert.showMessageDialog(stage, "未找到 "+des+" 的相关信息", "未找到酒店");
			}
			
			ArrayList<String> content = new ArrayList<String>();
			for (int i = 0; i < containsName.size(); i++) {
				content.add(getExpression(containsName.get(i)));
			}
			
			ObservableList<String> strList = FXCollections.observableArrayList(content);
			hotelList.setItems(strList);
		}else if(type.equals("星级")){
			boolean ok = true;
			for(int i=0;i<des.length();i++){
				if((des.charAt(i)<'0'||des.charAt(i)>'9')&&des.charAt(i)!='.'){
					alert = Alert.getInstance();
					alert.showMessageDialog(stage, "未找到相关酒店", "请正确输入");
					ok = false;
				}
			}
			
			if(ok){
				double star = Double.parseDouble(des);
				
				ArrayList<HotelVO> containsStar = new ArrayList<HotelVO>();
				if(star==(int)star){
					for(int i=0;i<all.size();i++){
						if(all.get(i).getStarLevel() == star){
							containsStar.add(all.get(i));
						}
					}
				}else{
					int low = (int)star;
					int high = low+1;
					for(int i=0;i<all.size();i++){
						if(all.get(i).getStarLevel() == low||all.get(i).getStarLevel() == high){
							containsStar.add(all.get(i));
						}
					}
				}
				
				ArrayList<String> content = new ArrayList<String>();
				for (int i = 0; i < containsStar.size(); i++) {
					content.add(getExpression(containsStar.get(i)));
				}
				
				ObservableList<String> strList = FXCollections.observableArrayList(content);
				hotelList.setItems(strList);
			}
			
		}else if(type.equals("评分区间")){
			boolean ok = true;
			for(int i=0;i<des.length();i++){
				if((des.charAt(i)<'0'||des.charAt(i)>'9')&&des.charAt(i)!='.'){
					alert = Alert.getInstance();
					alert.showMessageDialog(stage, "未找到相关酒店", "请正确输入");
					ok = false;
				}
			}
			
			if(ok){
				double rate = Double.parseDouble(des);
				int low = (int)rate;
				int high = low+1;
				
				ArrayList<HotelVO> containsRate = new ArrayList<HotelVO>();
				
				for(int i=0;i<all.size();i++){
					if(all.get(i).getRating()>=low&&all.get(i).getRating()<=high){//可以修改
						containsRate.add(all.get(i));
					}
				}
				
				ArrayList<String> content = new ArrayList<String>();
				for (int i = 0; i < containsRate.size(); i++) {
					content.add(getExpression(containsRate.get(i)));
				}
				
				ObservableList<String> strList = FXCollections.observableArrayList(content);
				hotelList.setItems(strList);
			}
		}else if(type.equals("有空房")){
			ArrayList<HotelVO> availableHotel = new ArrayList<HotelVO>();
			
			for(int i=0;i<all.size();i++){
				boolean flag = false;
				ArrayList<RoomVO> roomList = hotelBlService.SearchRooms(all.get(i).getHotelID());
				for(int j=0;j<roomList.size();j++){
					if(roomList.get(j).getRemainSum()>0){
						flag = true;
					}
				}
				if(flag){
					availableHotel.add(all.get(i));
				}
			}
			
			ArrayList<String> content = new ArrayList<String>();
			for (int i = 0; i < availableHotel.size(); i++) {
				content.add(getExpression(availableHotel.get(i)));
			}
			
			ObservableList<String> strList = FXCollections.observableArrayList(content);
			hotelList.setItems(strList);
		}
	}

	@FXML
	private void onGo(MouseEvent event)  throws Exception {
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
