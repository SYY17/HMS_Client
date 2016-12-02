package presentation.userui;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import presentation.controller.UserControllerImpl;
import vo.UserVO;

public class ManageSystemUser_start extends Application{

	private UserDataHelper userDataHelper;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("FXML/user/manager/ManageSystemUser.fxml"));
			initiateTableView(root);
			Scene scene = new Scene(root, 800, 600);
//			scene.getStylesheets().add(getClass().getResource("main.css").toExternalForm());
			ManageSystemUser_controller.stage = primaryStage;
			primaryStage.setScene(scene);
			primaryStage.setTitle("管理系统用户");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 初始化表内数据
	 * @param root
	 */
	private void initiateTableView(Parent root){
		@SuppressWarnings("unchecked")
		
		//查找tableview
		TableView<UserData> userTable = (TableView<UserData>) root
				.lookup("#userTable");
		
		//建立observablelist以更新数据
		final ObservableList<UserData> data = FXCollections.observableArrayList();
		
		UserControllerService userController = new UserControllerImpl();
		
		data.clear();
		ObservableList<TableColumn<UserData, ?>> observableList = userTable.getColumns();
		initiateObservableList(observableList);
		
		userDataHelper = new UserDataHelper();
		
		ArrayList<UserVO> list = userController.getAllUsers();
		for (int i = 0; i < list.size(); i++) {
			UserVO uvo = list.get(i);
			data.add(userDataHelper.toUserData(uvo));
		}
		userTable.setItems(data);
	}
	
	/**
	 * 初始化数据表
	 * @param observableList
	 */
	private void initiateObservableList(ObservableList<TableColumn<UserData, ?>> observableList) {
		observableList.get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
		observableList.get(1).setCellValueFactory(new PropertyValueFactory<>("username"));
		observableList.get(2).setCellValueFactory(new PropertyValueFactory<>("identity"));
		observableList.get(3).setCellValueFactory(new PropertyValueFactory<>("start"));
		observableList.get(4).setCellValueFactory(new PropertyValueFactory<>("operation"));
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
