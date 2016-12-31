package presentation.userui;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
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

public class ManageSystemUser_start extends Application {

	private static ManageSystemUser_start instance;
	
	private SystemUserDataHelper systemUserDataHelper;
	private IDHelper idHelper;
	private int id;
	Parent root;
	
	private ManageSystemUser_start() {
		// TODO Auto-generated constructor stub
	}
	
	//单件模式
	public static ManageSystemUser_start getInstance(){
		if(instance == null){
			instance = new ManageSystemUser_start();
		}
		return instance;
	}

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			root = FXMLLoader
					.load(getClass().getClassLoader().getResource("FXML/user/manager/ManageSystemUser.fxml"));
			this.initiateHelper();
			this.initiateTableView(root);
			this.initiateElements(root);
			Scene scene = new Scene(root, 800, 600);
			// scene.getStylesheets().add(getClass().getResource("main.css").toExternalForm());
			ManageSystemUser_controller.stage = primaryStage;
			primaryStage.setScene(scene);
			primaryStage.setTitle("管理系统用户");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	/**
	 * 提供给对外的刷新方法
	 */
	public void refreshTableView(){
		this.initiateTableView(root);
	}

	/**
	 * 初始化表内数据
	 * 
	 * @param root
	 */
	private void initiateTableView(Parent root) {
		@SuppressWarnings("unchecked")

		// 查找tableview
		TableView<SystemUserData> applyInfoTable = (TableView<SystemUserData>) root.lookup("#applyInfoTable");

		// 建立observablelist以更新数据
		final ObservableList<SystemUserData> data = FXCollections.observableArrayList();

		UserControllerService userController = new UserControllerImpl();

		data.clear();
		ObservableList<TableColumn<SystemUserData, ?>> observableList = applyInfoTable.getColumns();
		initiateObservableList(observableList);

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
	 * 
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
	private void initiateHelper() {
		idHelper = IDHelper.getInstance();
		id = idHelper.getID();
	}

	/**
	 * 初始化界面组件
	 * 
	 * @param root
	 */
	private void initiateElements(Parent root) {
		initiateUserName(root);
		initiateDate(root);
		initiateChoiceBox(root);
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
	 */
	private void initiateUserName(Parent root) {
		Label username = (Label) root.lookup("#username");
		UserControllerService userController = new UserControllerImpl();
		String name = userController.searchByUserID(id);
		username.setText(name);
	}

	/**
	 * 初始化选择框选项
	 * 
	 * @param root
	 */
	@SuppressWarnings("unchecked")
	private void initiateChoiceBox(Parent root) {
		ChoiceBox<String> id_choicebox = (ChoiceBox<String>) root.lookup("#id_choicebox");
		id_choicebox.setItems(FXCollections.observableArrayList("网站营销人员", "网站管理人员"));
		id_choicebox.setValue("客户");
	}

}
