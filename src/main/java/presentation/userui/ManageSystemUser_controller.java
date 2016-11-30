package presentation.userui;

import java.io.IOException;
import java.util.ArrayList;

import businesslogic.userbl.UserLineItem;
import businesslogic.userbl.UserList;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import presentation.controller.UserControllerImpl;
import presentation.hotelui.ManageHotelCreatingApplication_start;
import presentation.loginui.LogFrame;
import presentation.mainui.Manager_start;
import vo.UserVO;

public class ManageSystemUser_controller {

	public static Stage stage;
	public ImageView refreshButton;
	public Label refreshLabel;
	public TableView<UserData> userTable;
	public TableColumn<UserData, String> idColumn;
	public TableColumn<UserData, String> usernameColumn;
	public TableColumn<UserData, String> identityColumn;
	public TableColumn<UserData, String> startColumn;
	public TableColumn<UserData, Button> operationColumn;
	
	private UserList userList;
	private final ObservableList<UserData> data = FXCollections.observableArrayList();

	@FXML
	private void onClickedRefreshButton(MouseEvent event) throws IOException {
		UserControllerService userController = new UserControllerImpl();
		ArrayList<UserVO> list = userController.getAllUsers();
		UserLineItem userLineItem;
		userList = new UserList();
		
		//转换VO list并存储于user list中
		for(int i=0; i<list.size(); i++){
			userLineItem = new UserLineItem(list.get(i));
			userList.add(userLineItem);
		}
		
		refreshList();
	}
	
	@FXML
	private void onLogout(ActionEvent event) throws IOException {
		new LogFrame().start(stage);
	}
	
	@FXML
	private void onReturn(ActionEvent event) throws Exception {
		new Manager_start().start(stage);
	}
	

	@FXML
	private void onManageSystemUser(ActionEvent event) throws Exception {
		new ManageSystemUser_start().start(stage);
	}
	
	@FXML
	private void onManageHotelCreatingApplication(ActionEvent event) throws Exception {
		new ManageHotelCreatingApplication_start().start(stage);
	}
	
	@FXML
	private void onAbout(ActionEvent event) throws Exception {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setHeaderText("据说这是大作业");
		alert.showAndWait();
	}
	
	private void refreshList(){		
		idColumn.setCellValueFactory(new PropertyValueFactory<>("id"));
		usernameColumn.setCellValueFactory(new PropertyValueFactory<>("username"));
		identityColumn.setCellValueFactory(new PropertyValueFactory<>("identity"));
		startColumn.setCellValueFactory(new PropertyValueFactory<>("start"));
		operationColumn.setCellValueFactory(new PropertyValueFactory<>("operation"));
		
		data.clear();
		ArrayList<UserData> dataList = convert(userList);
		data.addAll(dataList);
		
		userTable.setItems(data);
	}
	
	private ArrayList<UserData> convert(UserList list){
		ArrayList<UserData> result = new ArrayList<UserData>();
		UserData temp;
		for(int i=0; i<list.size(); i++){
			temp = convert(list.get(i));
			if(temp != null){
				result.add(temp);
			}
		}
		return result;
	}
	
	private UserData convert(UserLineItem userLineItem){
		int id = userLineItem.getID();
		String username = userLineItem.getName();
		String identity = judgeIdentity(id);
		String start = judgeStart(id);
		String operation = "管理";
		if(identity != null){
			return new UserData(String.valueOf(id), username, identity, start, operation);
		}
		
		return null;
	}
	
	private String judgeIdentity(int id){
		char c = String.valueOf(id).charAt(0);
		
		if(c == '1'){
			return "客户";
		}else if(c == '2'){
			return "酒店工作人员";
		}else if(c == '3'){
			return "网站营销人员";
		}else{
			return null;
		}
	}
	
	private String judgeStart(int id){
		String temp = String.valueOf(id);
		String result = temp.substring(1, 3)+"-"+temp.substring(3, 5);
		return result;
	}
}
