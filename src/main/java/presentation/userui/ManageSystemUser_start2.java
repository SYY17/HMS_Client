package presentation.userui;

import java.util.ArrayList;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import presentation.controller.IDHelper;
import presentation.controller.UserControllerImpl;
import vo.UserVO;

public class ManageSystemUser_start2 extends Application{

	private SystemUserDataHelper systemUserDataHelper;
	private IDHelper idHelper;
	private int id;
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("FXML/user/manager/ManageSystemUser2.fxml"));
			this.initiateHelper();
			this.initiateTableView(root);
			this.initiateElements(root);
			Scene scene = new Scene(root, 800, 600);
//			scene.getStylesheets().add(getClass().getResource("main.css").toExternalForm());
			ManageSystemUser_controller2.stage = primaryStage;
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
		TableView<SystemUserData> applyInfoTable = (TableView<SystemUserData>) root
				.lookup("#applyInfoTable");
		
		//建立observablelist以更新数据
		final ObservableList<SystemUserData> data = FXCollections.observableArrayList();
		
		UserControllerService userController = new UserControllerImpl();
		
		data.clear();
		ObservableList<TableColumn<SystemUserData, ?>> observableList = applyInfoTable.getColumns();
		initiateObservableList(observableList);
		initiateEvent(data);
		
		systemUserDataHelper = new SystemUserDataHelper();
		
		ArrayList<UserVO> list = userController.getAllUsers();
		for (int i = 0; i < list.size(); i++) {
			UserVO uvo = list.get(i);
			data.add(systemUserDataHelper.toSystemUserData(uvo));
		}
		applyInfoTable.setItems(data);
	}
	
	/**
	 * 初始化数据表
	 * @param observableList
	 */
	private void initiateObservableList(ObservableList<TableColumn<SystemUserData, ?>> observableList) {
		observableList.get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
		observableList.get(1).setCellValueFactory(new PropertyValueFactory<>("username"));
		observableList.get(2).setCellValueFactory(new PropertyValueFactory<>("identity"));
		observableList.get(3).setCellValueFactory(new PropertyValueFactory<>("operation"));
	}
	
	/**
	 * 获取当前用户ID
	 */
	private void initiateHelper(){
		idHelper = IDHelper.getInstance();
		id = idHelper.getID();
	}
	
	/**
	 * 初始化界面组件
	 * @param root
	 */
	private void initiateElements(Parent root){
		initiateUserName(root);
		initiateChoiceBox(root);
	}
	
	/**
	 * 初始化当前用户用户名
	 */
	private void initiateUserName(Parent root){
		Label username = (Label) root.lookup("#username");
		UserControllerService userController = new UserControllerImpl();
		String name = userController.searchByUserID(id);
		username.setText(name);
	}
	
	/**
	 * 初始化选择框选项
	 * @param root
	 */
	@SuppressWarnings("unchecked")
	private void initiateChoiceBox(Parent root){
		ChoiceBox<String> id_choicebox = (ChoiceBox<String>) root.lookup("#id_choicebox");
		id_choicebox.setItems(FXCollections.observableArrayList("客户", "酒店工作人员", "网站营销人员", "网站管理人员"));
		id_choicebox.setValue("客户");
	}
	
	private void initiateEvent(ObservableList<SystemUserData> data){
		for(int i=0; i<data.size(); i++){
			SystemUserData user = data.get(i);
			
			user.getOperation().setOnAction(new EventHandler<ActionEvent>() {

				@Override
				public void handle(ActionEvent event) {
					// TODO Auto-generated method stub
					data.remove(user);
				}
			});
		}
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
