package presentation.creditui;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import presentation.controller.IDHelper;
import presentation.controller.UserControllerImpl;
import presentation.userui.UserControllerService;
import presentation.userui.UserDataForManageUserCredit;
import presentation.userui.UserDataHelper;
import vo.UserVO;

public class ManageUserCredit_start extends Application {
	private UserDataHelper userDataHelper;

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			Parent root = FXMLLoader
					.load(getClass().getClassLoader().getResource("FXML/user/saler/ManageUserCredit.fxml"));
			initiateTableView(root);
			Scene scene = new Scene(root, 800, 600);
			// scene.getStylesheets().add(getClass().getResource("main.css").toExternalForm());
			ManageUserCredit_controller.stage = primaryStage;
			primaryStage.setScene(scene);
			primaryStage.setTitle("管理用户信用值");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * 初始化表内数据
	 * 
	 * @param root
	 */
	private void initiateTableView(Parent root) {
		@SuppressWarnings("unchecked")

		// 查找tableview
		TableView<UserDataForManageUserCredit> UserListTable = (TableView<UserDataForManageUserCredit>) root.lookup("#UserListTable");
		System.out.println(UserListTable);
		// 建立observablelist以更新数据
		final ObservableList<UserDataForManageUserCredit> data = FXCollections.observableArrayList();

		UserControllerService userController = new UserControllerImpl();

		data.clear();
		ObservableList<TableColumn<UserDataForManageUserCredit, ?>> observableList = UserListTable.getColumns();
		initiateObservableList(observableList);

		userDataHelper = new UserDataHelper();

		ArrayList<UserVO> list = userController.getAllUsers();
		for (int i = 0; i < list.size(); i++) {
			UserVO uvo = list.get(i);
			if (uvo.getID() < 20000000) {
				data.add(userDataHelper.toUserDataForManageUserCredit(uvo));
			}
		}
		UserListTable.setItems(data);
	}

	/**
	 * 初始化数据表
	 * 
	 * @param observableList
	 */
	private void initiateObservableList(ObservableList<TableColumn<UserDataForManageUserCredit, ?>> observableList) {
		observableList.get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
		observableList.get(1).setCellValueFactory(new PropertyValueFactory<>("username"));
		observableList.get(2).setCellValueFactory(new PropertyValueFactory<>("start"));
		observableList.get(3).setCellValueFactory(new PropertyValueFactory<>("credit"));
		observableList.get(4).setCellValueFactory(new PropertyValueFactory<>("operation"));
	}

	public static void main(String[] args) {
		launch(args);
	}
}
