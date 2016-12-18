package presentation.userui.user;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;

import businesslogic.hotelbl.HotelController;
import businesslogicservice.hotelBLService.HotelBLService;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;
import presentation.controller.HotelControllerImpl;
import presentation.controller.IDHelper;
import presentation.controller.UserControllerImpl;
import presentation.hotelui.HotelControllerService;
import presentation.hotelui.hotel.RoomData;
import presentation.userui.UserControllerService;
import vo.HotelVO;
import vo.RoomType;
import vo.RoomVO;

public class MakeOrder_start extends Application  {

	private final String pattern = "yyyy-MM-dd";
	private IDHelper idHelper;
	private int id;
	public static String hotelname;
	
	public void setName(String s){
		hotelname = s;
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		try {
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("FXML/user/user/makeOrder.fxml"));
			
			initiateChoiceBox(root);
			this.initiateHelper();
			this.initiateElements(root);
			initDatePicker(root);
			initiateTableView(root);
			initiateTextArea(root);
			
			Scene scene = new Scene(root, 800, 600);
			MakeOrder_controller.stage = primaryStage;
			
			primaryStage.setScene(scene);
			primaryStage.setTitle("酒店管理系统");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * 初始化DatePicker
	 */
	public void initDatePicker(Parent root) {
		// 查找checkIn
		DatePicker checkIn = (DatePicker) root.lookup("#checkIn");

		// 查找checkOut
		DatePicker checkOut = (DatePicker) root.lookup("#checkOut");

		StringConverter<LocalDate> converter = new StringConverter<LocalDate>() {
			DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);

			@Override
			public String toString(LocalDate date) {
				if (date != null) {
					return dateFormatter.format(date);
				} else {
					return "";
				}
			}

			@Override
			public LocalDate fromString(String string) {
				if (string != null && !string.isEmpty()) {
					return LocalDate.parse(string, dateFormatter);
				} else {
					return null;
				}
			}
		};

		checkIn.setShowWeekNumbers(true);
		checkIn.setConverter(converter);
		checkIn.setPromptText(pattern.toLowerCase());

		checkOut.setShowWeekNumbers(true);
		checkOut.setConverter(converter);
		checkOut.setPromptText(pattern.toLowerCase());

		checkIn.setValue(LocalDate.now());

		final Callback<DatePicker, DateCell> dayCellFactory = new Callback<DatePicker, DateCell>() {
			@Override
			public DateCell call(final DatePicker datePicker) {
				return new DateCell() {
					@Override
					public void updateItem(LocalDate item, boolean empty) {
						super.updateItem(item, empty);

						if (item.isBefore(checkIn.getValue().plusDays(1))) {
							setDisable(true);
							setStyle("-fx-background-color: #ffc0cb;");
						}
					}
				};
			}
		};
		checkOut.setDayCellFactory(dayCellFactory);
		checkOut.setValue(checkIn.getValue().plusDays(1));
	}
	
	/**
	 * 对于选择框中的内容进行初始化
	 * 
	 * @param root
	 */
	@SuppressWarnings("unchecked")
	private void initiateChoiceBox(Parent root){
		ChoiceBox<String> singlebox = (ChoiceBox<String>) root.lookup("#singlebox");
		ChoiceBox<String> standardbox = (ChoiceBox<String>) root.lookup("#standardbox");
		ChoiceBox<String> triplebox = (ChoiceBox<String>) root.lookup("#triplebox");
		ChoiceBox<String> kingbox = (ChoiceBox<String>) root.lookup("#kingbox");
		ChoiceBox<String> suitebox = (ChoiceBox<String>) root.lookup("#suitebox");
		
		singlebox.setItems(FXCollections.observableArrayList(getNum("single")));
		standardbox.setItems(FXCollections.observableArrayList(getNum("standard")));
		triplebox.setItems(FXCollections.observableArrayList(getNum("triple")));
		kingbox.setItems(FXCollections.observableArrayList(getNum("king")));
		suitebox.setItems(FXCollections.observableArrayList(getNum("suite")));
		
		
	}
	
	public ArrayList<String> getNum(String roomType){
		ArrayList<String> s = new ArrayList<String>();
		RoomType ty = null;
		
		switch(roomType){
		case "single":ty = RoomType.SINGLE_ROOM;break;
		case "standard":ty = RoomType.STANDARD_ROOM;break;
		case "triple":ty = RoomType.TRIPLE_ROOM;break;
		case "king":ty = RoomType.KING_SIZE_ROOM;break;
		case "suite":ty = RoomType.SUITE;break;
		}
		
		int instant =0;
		HotelControllerService hotelController = new HotelControllerImpl();
		ArrayList<RoomVO> roomList = hotelController.searchRooms(hotelController.searchHotel(hotelname).get(0).getHotelID());//morendiyige
		if (roomList != null) {
			for (int i = 0; i < roomList.size(); i++) {
				RoomVO rvo = roomList.get(i);
				if(rvo.getRoomType()==ty && rvo.getRemainSum()!=0){
					instant =rvo.getRemainSum();
				}
			}
		}
		
		for(int i=0;i<=instant;i++){
			s.add(String.valueOf(i));
		}
		return s;
	}
	/**
	 * 初始化表内数据
	 * 
	 * @param root
	 */
	private void initiateTableView(Parent root) {
		@SuppressWarnings("unchecked")
		// 查找tableview
		TableView<RoomData> hotelTableView  = (TableView<RoomData>) root
				.lookup("#hotelTableView");

		// 建立observablelist以更新数据
		final ObservableList<RoomData> data = FXCollections.observableArrayList();

		HotelControllerService hotelController = new HotelControllerImpl();
		data.clear();
		ObservableList<TableColumn<RoomData, ?>> observableList = hotelTableView.getColumns();
		initiateObservableList(observableList);

		ArrayList<RoomVO> roomList = hotelController.searchRooms(hotelController.searchHotel(hotelname).get(0).getHotelID());//morendiyige
		if (roomList != null) {
			for (int i = 0; i < roomList.size(); i++) {
				RoomVO rvo = roomList.get(i);
				data.add(new RoomData(rvo.getHotelID(), rvo.getRoomType(), rvo.getTotalSum(), rvo.getRemainSum(),
						rvo.getPrice()));
			}
		}
		hotelTableView.setItems(data);
	}

	/**
	 * 初始化数据表
	 * 
	 * @param observableList
	 */
	private void initiateObservableList(ObservableList<TableColumn<RoomData, ?>> observableList) {
		observableList.get(0).setCellValueFactory(new PropertyValueFactory<>("roomType"));
		observableList.get(1).setCellValueFactory(new PropertyValueFactory<>("remainSum"));
		observableList.get(2).setCellValueFactory(new PropertyValueFactory<>("price"));
	}

	
	/**
	 * 初始化description
	 * 
	 * @param root
	 */
	private void initiateTextArea(Parent root) {
		// 查找description
		TextArea description  = (TextArea) root.lookup("#description");
		
		// 查找HName
		Label HName  = (Label) root.lookup("#HName");
		
		// 查找HAdress
		Label HAddress  = (Label) root.lookup("#HAddress");
			
		// 查找HBA
		Label HBA  = (Label) root.lookup("#HBA");
		
		// 查找HPhone
		Label HPhone  = (Label) root.lookup("#HPhone");
		
		// 查找HRating
		Label HRating  = (Label) root.lookup("#HRating");
		
		HotelBLService hotelBLService = new HotelController();
		ArrayList<HotelVO> hotelList = hotelBLService.searchHotel(hotelname);
		HotelVO hvo = hotelList.get(0);
		
		String name = hvo.getHotelName();
		String rating = String.valueOf(hvo.getRating());
		String address = hvo.getHotelAddress();
		String businessArea = hvo.getBusinessArea();
		String des = hvo.getHotelDescription();
		String cell = hvo.getPhoneNumber();
		
		HName.setText(name);
		HRating.setText(rating);
		HAddress.setText(address);
		HBA.setText(businessArea);
		HPhone.setText(cell);
		description.setText(des);
		description.setEditable(false);
	}
	
	/**
	 * 初始化界面组件
	 * @param root
	 */
	private void initiateElements(Parent root) {
		// TODO Auto-generated method stub
		initiateUserName(root);
		initiateDate(root);
	}

	/**
	 * 获取当前用户ID
	 */
	private void initiateHelper() {
		idHelper = IDHelper.getInstance();
		id = idHelper.getID();
	}
	
	/**
	 * 初始化当前日期
	 * @param root
	 */
	private void initiateDate(Parent root){
		Label date = (Label) root.lookup("#date");
		Date time = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String text = format.format(time);
		date.setText(text);
	}

	/**
	 * 初始化当前用户用户名
	 * @param root
	 */
	private void initiateUserName(Parent root) {
		Label username = (Label) root.lookup("#username");
		UserControllerService userController = new UserControllerImpl();
		String name = userController.searchByUserID(id);
		username.setText(name);
	}
}
