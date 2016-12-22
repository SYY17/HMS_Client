package presentation.mainui;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import businesslogic.hotelbl.HotelController;
import businesslogic.orderbl.OrderController;
import businesslogicservice.hotelBLService.HotelBLService;
import businesslogicservice.orderblservice.OrderBLService;
import javafx.application.Application;
import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import presentation.controller.IDHelper;
import presentation.controller.UserControllerImpl;
import presentation.userui.UserControllerService;
import vo.HotelVO;
import vo.OrderStatus;
import vo.OrderVO;
import vo.RoomVO;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

public class UserUI_start extends Application {

	private IDHelper idHelper;
	private int id;
	private String hotelname;

	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("FXML/user/user/UserUI.fxml"));
			Scene scene = new Scene(root, 800, 600);
			UserUI_controller.stage = primaryStage;
			this.initiateHelper();
			this.initiateElements(root);
			initialize(root);
			initChoiceBox(root);
			primaryStage.setScene(scene);
			primaryStage.setTitle("酒店管理系统");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/*
	 * 初始化ChoiceBox
	 */
	public void initChoiceBox(Parent root) {
		@SuppressWarnings("unchecked")
		// 查找business
		ChoiceBox<String> businessArea = (ChoiceBox<String>) root.lookup("#businessArea");
		HotelBLService hotelBlService = new HotelController();
		ArrayList<HotelVO> listVO = hotelBlService.reviewHotelList();
		ArrayList<String> business = new ArrayList<String>();

		for (int i = 0; i < listVO.size(); i++) {
			String temp = listVO.get(i).getBusinessArea();
			if (!business.contains(temp)) {
				business.add(temp);
			}
		}

		businessArea.setItems(FXCollections.observableArrayList(business));

		businessArea.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener() {
			@Override
			public void changed(ObservableValue observable, Object oldValue, Object newValue) {
				// TODO Auto-generated method stub
				// System.out.println(business.get(Integer.parseInt(String.valueOf(newValue))));
				changeArea(root, business.get(Integer.parseInt(String.valueOf(newValue))));
			}

		});
		//
		@SuppressWarnings("unchecked")
		// 查找star
		ChoiceBox<String> star = (ChoiceBox<String>) root.lookup("#star");
		star.setItems(FXCollections.observableArrayList("从高到低", "从低到高"));

		star.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener() {
			@Override
			public void changed(ObservableValue observable, Object oldValue, Object newValue) {
				// TODO Auto-generated method stub
				changeStar(root, String.valueOf(newValue));
			}

		});

		// 查找rating
		ChoiceBox<String> rating = (ChoiceBox<String>) root.lookup("#rating");
		rating.setItems(FXCollections.observableArrayList("从高到低", "从低到高"));

		rating.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener() {
			@Override
			public void changed(ObservableValue observable, Object oldValue, Object newValue) {
				// TODO Auto-generated method stub
				changeRate(root, String.valueOf(newValue));
			}

		});

		@SuppressWarnings("unchecked")
		// 查找star
		ChoiceBox<String> price = (ChoiceBox<String>) root.lookup("#price");
		price.setItems(FXCollections.observableArrayList("从高到低", "从低到高"));

		price.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener() {
			@Override
			public void changed(ObservableValue observable, Object oldValue, Object newValue) {
				// TODO Auto-generated method stub
				changePrice(root, String.valueOf(newValue));
			}

		});
		
		@SuppressWarnings("unchecked")
		// 查找star
		ChoiceBox<String> type = (ChoiceBox<String>) root.lookup("#type");
		type.setItems(FXCollections.observableArrayList(/*"未预定过",*/ "已预定过","所有"));
		
		type.getSelectionModel().selectedIndexProperty().addListener(new ChangeListener(){
			@Override
			public void changed(ObservableValue observable, Object oldValue, Object newValue) {
				// TODO Auto-generated method stub
				changeType(root, String.valueOf(newValue));
			}
			
		});
		
		@SuppressWarnings("unchecked")
		// 查找star
		ChoiceBox<String> searchBox = (ChoiceBox<String>) root.lookup("#searchBox");
		searchBox.setItems(FXCollections.observableArrayList("酒店名称", "星级","评分区间","有空房"));
		
	}
	
	/**
	 * 
	 * @param root
	 * @param type
	 */
	private void changeType(Parent root, String type){
		ListView<String> hotelList = (ListView<String>) root.lookup("#hotelList");
		
		HotelBLService hotelBlService = new HotelController();
		ArrayList<HotelVO> all = hotelBlService.reviewHotelList();
		
		OrderBLService orderBlService = new OrderController();
		ArrayList<OrderVO> orderList = orderBlService.reviewOrder(id, OrderStatus.Finished);
		
		ArrayList<HotelVO> reserved = new ArrayList<HotelVO>();
		
		for(int i=0;i<orderList.size();i++){
			if(!reserved.contains(hotelBlService.reviewHotelInfo(orderList.get(i).getHotelName()))){
				reserved.add(hotelBlService.reviewHotelInfo(orderList.get(i).getHotelName()));
			}
		}

		if(type.equals("2")){//永远不会取到
			
			ArrayList<HotelVO> un = new ArrayList<HotelVO>();
			for(int i=0;i<all.size();i++){
				for(int j=0;j<reserved.size();j++){
					if(!all.get(i).getHotelName().equals(reserved.get(i).getHotelName())){
						un.add(all.get(i));
					}
				}
			}
			
			 ArrayList<String> content = new ArrayList<String>();
			 for(int i=0;i<un.size();i++){
				 content.add(getExpression(un.get(i)));
			 }
			 
			 ObservableList<String> strList = FXCollections.observableArrayList(content);
			 hotelList.setItems(strList);
			
			 hotelList.getSelectionModel().selectedItemProperty().addListener(
						new ChangeListener<String>(){
							@Override
							public void changed(ObservableValue<? extends String> observable, String oldValue,
									String newValue) {
								// TODO Auto-generated method stub
								//searchTextField.setText(newValue);
								hotelname = getName(newValue);
								UserUI_controller.hotelname = hotelname;
							}
						}
						);
				
		}else if(type.equals("0")){
			ArrayList<String> content = new ArrayList<String>();
			 for(int i=0;i<reserved.size();i++){
				 content.add(getExpression(reserved.get(i)));
			 }

				ObservableList<String> strList = FXCollections.observableArrayList(content);
				hotelList.setItems(strList);
						
				hotelList.getSelectionModel().selectedItemProperty().addListener(
						new ChangeListener<String>(){

							@Override
							public void changed(ObservableValue<? extends String> observable, String oldValue,
									String newValue) {
								// TODO Auto-generated method stub
								//searchTextField.setText(newValue);
								hotelname = getName(newValue);
								UserUI_controller.hotelname = hotelname;
							}
							
						}
						);
		}else if(type.equals("1")){
			ArrayList<String> content = new ArrayList<String>();
			 for(int i=0;i<all.size();i++){
				 content.add(getExpression(all.get(i)));
			 }

				ObservableList<String> strList = FXCollections.observableArrayList(content);
				hotelList.setItems(strList);
						
				hotelList.getSelectionModel().selectedItemProperty().addListener(
						new ChangeListener<String>(){

							@Override
							public void changed(ObservableValue<? extends String> observable, String oldValue,
									String newValue) {
								// TODO Auto-generated method stub
								//searchTextField.setText(newValue);
								hotelname = getName(newValue);
								UserUI_controller.hotelname = hotelname;
							}
							
						}
						);
		}
		
		
	}

	/**
	 * 
	 * @param root
	 * @param whereToSearch
	 */
	private void changeArea(Parent root, String whereToSearch) {
		ListView<String> hotelList = (ListView<String>) root.lookup("#hotelList");

		HotelBLService hotelBlService = new HotelController();

		ArrayList<HotelVO> hvo = hotelBlService.reviewHotelList();

		ArrayList<String> content = new ArrayList<String>();
		for (int i = 0; i < hvo.size(); i++) {
			if (hvo.get(i).getBusinessArea().equals(whereToSearch)) {
				content.add(getExpression(hvo.get(i)));
			}
		}

		ObservableList<String> strList = FXCollections.observableArrayList(content);
		hotelList.setItems(strList);

		hotelList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				// TODO Auto-generated method stub
				// searchTextField.setText(newValue);
				hotelname = getName(newValue);
				UserUI_controller.hotelname = hotelname;
			}

		});
	}

	/**
	 * 
	 * @param root
	 * @param howToRate
	 */
	private void changeRate(Parent root, String howToRate) {
		if (howToRate.equals("0")) {// "从高到低"
			ListView<String> hotelList = (ListView<String>) root.lookup("#hotelList");

			HotelBLService hotelBlService = new HotelController();

			ArrayList<HotelVO> hvo = hotelBlService.reviewHotelList();
			Map<String, Double> maps = new HashMap<String, Double>();
			for (int i = 0; i < hvo.size(); i++) {
				maps.put(getExpression(hvo.get(i)), new Double(hvo.get(i).getRating()));
			}

			ByValueComparator bvc = new ByValueComparator(maps);
			ArrayList<String> content = new ArrayList<String>(maps.keySet());
			Collections.sort(content, bvc);

			ObservableList<String> strList = FXCollections.observableArrayList(content);
			hotelList.setItems(strList);

			hotelList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

				@Override
				public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
					// TODO Auto-generated method stub
					// searchTextField.setText(newValue);
					hotelname = getName(newValue);
					UserUI_controller.hotelname = hotelname;
				}

			});
		} else if (howToRate.equals("1")) {// "从低到高"
			ListView<String> hotelList = (ListView<String>) root.lookup("#hotelList");

			HotelBLService hotelBlService = new HotelController();

			ArrayList<HotelVO> hvo = hotelBlService.reviewHotelList();
			Map<String, Double> maps = new HashMap<String, Double>();
			for (int i = 0; i < hvo.size(); i++) {
				maps.put(getExpression(hvo.get(i)), new Double(hvo.get(i).getRating()));
			}

			SByValueComparator bvc = new SByValueComparator(maps);
			ArrayList<String> content = new ArrayList<String>(maps.keySet());
			Collections.sort(content, bvc);

			ObservableList<String> strList = FXCollections.observableArrayList(content);
			hotelList.setItems(strList);

			hotelList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

				@Override
				public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
					// TODO Auto-generated method stub
					// searchTextField.setText(newValue);
					hotelname = getName(newValue);
					UserUI_controller.hotelname = hotelname;
				}

			});
		}
	}

	/**
	 * 
	 * @param root
	 * @param howToRate
	 */
	private void changeStar(Parent root, String howToRate) {
		if (howToRate.equals("0")) {// "从高到低"
			ListView<String> hotelList = (ListView<String>) root.lookup("#hotelList");

			HotelBLService hotelBlService = new HotelController();

			ArrayList<HotelVO> hvo = hotelBlService.reviewHotelList();
			Map<String, Double> maps = new HashMap<String, Double>();
			for (int i = 0; i < hvo.size(); i++) {
				maps.put(getExpression(hvo.get(i)), new Double(hvo.get(i).getStarLevel()));
			}

			ByValueComparator bvc = new ByValueComparator(maps);
			ArrayList<String> content = new ArrayList<String>(maps.keySet());
			Collections.sort(content, bvc);

			ObservableList<String> strList = FXCollections.observableArrayList(content);
			hotelList.setItems(strList);

			hotelList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

				@Override
				public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
					// TODO Auto-generated method stub
					// searchTextField.setText(newValue);
					hotelname = getName(newValue);
					UserUI_controller.hotelname = hotelname;
				}

			});
		} else if (howToRate.equals("1")) {// "从低到高"
			ListView<String> hotelList = (ListView<String>) root.lookup("#hotelList");

			HotelBLService hotelBlService = new HotelController();

			ArrayList<HotelVO> hvo = hotelBlService.reviewHotelList();
			Map<String, Double> maps = new HashMap<String, Double>();
			for (int i = 0; i < hvo.size(); i++) {
				maps.put(getExpression(hvo.get(i)), new Double(hvo.get(i).getStarLevel()));
			}

			SByValueComparator bvc = new SByValueComparator(maps);
			ArrayList<String> content = new ArrayList<String>(maps.keySet());
			Collections.sort(content, bvc);

			ObservableList<String> strList = FXCollections.observableArrayList(content);
			hotelList.setItems(strList);

			hotelList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

				@Override
				public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
					// TODO Auto-generated method stub
					// searchTextField.setText(newValue);
					hotelname = getName(newValue);
					UserUI_controller.hotelname = hotelname;
				}

			});
		}
	}

	//
	/**
	 * 
	 * @param root
	 * @param priceSql
	 */
	private void changePrice(Parent root, String priceSql) {
		if (priceSql.equals("0")) {// "从高到低"
			ListView<String> hotelList = (ListView<String>) root.lookup("#hotelList");

			HotelBLService hotelBlService = new HotelController();

			ArrayList<HotelVO> hvo = hotelBlService.reviewHotelList();
			Map<String, Double> maps = new HashMap<String, Double>();
			for (int i = 0; i < hvo.size(); i++) {
				ArrayList<RoomVO> room = hotelBlService.SearchRooms(hvo.get(i).getHotelID());
				int small = 0;
				for (int j = 1; j < room.size(); j++) {
					if (room.get(j).getPrice() < room.get(small).getPrice()) {
						small = j;
					}
				}
				double pr = room.get(small).getPrice();
				maps.put(getExpression(hvo.get(i)), new Double(pr));
			}

			ByValueComparator bvc = new ByValueComparator(maps);
			ArrayList<String> content = new ArrayList<String>(maps.keySet());
			Collections.sort(content, bvc);

			ObservableList<String> strList = FXCollections.observableArrayList(content);
			hotelList.setItems(strList);

			hotelList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

				@Override
				public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
					// TODO Auto-generated method stub
					// searchTextField.setText(newValue);
					hotelname = getName(newValue);
					UserUI_controller.hotelname = hotelname;
				}

			});
		} else if (priceSql.equals("1")) {// "从低到高"
			ListView<String> hotelList = (ListView<String>) root.lookup("#hotelList");

			HotelBLService hotelBlService = new HotelController();

			ArrayList<HotelVO> hvo = hotelBlService.reviewHotelList();
			Map<String, Double> maps = new HashMap<String, Double>();
			for (int i = 0; i < hvo.size(); i++) {
				ArrayList<RoomVO> room = hotelBlService.SearchRooms(hvo.get(i).getHotelID());
				int small = 0;
				for (int j = 1; j < room.size(); j++) {
					if (room.get(j).getPrice() < room.get(small).getPrice()) {
						small = j;
					}
				}
				double pr = room.get(small).getPrice();
				maps.put(getExpression(hvo.get(i)), new Double(pr));
			}

			SByValueComparator bvc = new SByValueComparator(maps);
			ArrayList<String> content = new ArrayList<String>(maps.keySet());
			Collections.sort(content, bvc);

			ObservableList<String> strList = FXCollections.observableArrayList(content);
			hotelList.setItems(strList);

			hotelList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

				@Override
				public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
					// TODO Auto-generated method stub
					// searchTextField.setText(newValue);
					hotelname = getName(newValue);
					UserUI_controller.hotelname = hotelname;
				}

			});
		}
	}

	//
	/**
	 * 获取当前用户ID
	 */
	private void initiateHelper() {
		idHelper = IDHelper.getInstance();
		id = idHelper.getID();
	}

	private void initiateElements(Parent root) {
		// TODO Auto-generated method stub
		initiateUserName(root);
		initiateDate(root);
	}

	/**
	 * 初始化当前日期
	 * 
	 * @param root
	 */
	private void initiateDate(Parent root) {
		Label date = (Label) root.lookup("#date");
		Date time = new Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String text = format.format(time);
		date.setText(text);
	}

	/**
	 * 初始化当前用户用户名
	 * 
	 * @param root
	 */
	private void initiateUserName(Parent root) {
		Label username = (Label) root.lookup("#username");
		UserControllerService userController = new UserControllerImpl();
		String name = userController.searchByUserID(id);
		username.setText(name);
	}

	/**
	 * 总体初始化方法
	 * 
	 * @param root
	 */
	private void initialize(Parent root) {
		@SuppressWarnings("unchecked")
		// 查找hotelList
		ListView<String> hotelList = (ListView<String>) root.lookup("#hotelList");

		HotelBLService hotelBlService = new HotelController();

		ArrayList<HotelVO> hvo = hotelBlService.reviewHotelList();

		ArrayList<String> content = new ArrayList<String>();
		for (int i = 0; i < hvo.size(); i++) {
			// content.add(hvo.get(i).getHotelName());
			content.add(getExpression(hvo.get(i)));
		}

		ObservableList<String> strList = FXCollections.observableArrayList(content);
		hotelList.setItems(strList);

		hotelList.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {

			@Override
			public void changed(ObservableValue<? extends String> observable, String oldValue, String newValue) {
				// TODO Auto-generated method stub
				// searchTextField.setText(newValue);
				hotelname = getName(newValue);
				UserUI_controller.hotelname = hotelname;
			}

		});
	}

	public String getName(String str) {
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
	public String getExpression(HotelVO hvo) {
		String str = hvo.getHotelName();
		for (int i = 0; i < 20 - hvo.getHotelName().length(); i++) {
			str += " ";
		}
		str += hvo.getBusinessArea();
		for (int i = 0; i < 40 - str.length(); i++) {
			str += " ";
		}
		for (int i = 0; i < 50 - str.length(); i++) {
			str += " ";
		}
		str += "星级：";
		str += String.valueOf(hvo.getStarLevel());
		for (int i = 0; i < 60 - str.length(); i++) {
			str += " ";
		}
		str += "最低价格：";
		str += String.valueOf(getMinPrice(hvo));
		return str;
	}

	public int getMinPrice(HotelVO hvo) {
		HotelBLService hotelBlService = new HotelController();
		ArrayList<RoomVO> room = hotelBlService.SearchRooms(hvo.getHotelID());
		int small = 0;
		for (int j = 1; j < room.size(); j++) {
			if (room.get(j).getPrice() < room.get(small).getPrice()) {
				small = j;
			}
		}
		int pr = room.get(small).getPrice();
		return pr;
	}
}

class ByValueComparator implements Comparator<String> {
	Map<String, Double> base_map;

	public ByValueComparator(Map<String, Double> base_map) {
		this.base_map = base_map;
	}

	public int compare(String arg0, String arg1) {
		if (!base_map.containsKey(arg0) || !base_map.containsKey(arg1)) {
			return 0;
		}

		if (base_map.get(arg0) < base_map.get(arg1)) {
			return 1;
		} else if (base_map.get(arg0) > base_map.get(arg1)) {
			return -1;
		} else {
			return 0;
		}
	}
}

class SByValueComparator implements Comparator<String> {
	Map<String, Double> base_map;

	public SByValueComparator(Map<String, Double> base_map) {
		this.base_map = base_map;
	}

	public int compare(String arg0, String arg1) {
		if (!base_map.containsKey(arg0) || !base_map.containsKey(arg1)) {
			return 0;
		}

		if (base_map.get(arg0) > base_map.get(arg1)) {
			return 1;
		} else if (base_map.get(arg0) < base_map.get(arg1)) {
			return -1;
		} else {
			return 0;
		}
	}
}
