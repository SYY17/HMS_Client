package presentation.userui;

import java.io.IOException;
import java.util.ArrayList;

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
import presentation.loginui.LoginUI_start;
import presentation.mainui.ManagerUI_start;
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

	private UserDataHelper userDataHelper;
	private final ObservableList<UserData> data = FXCollections.observableArrayList();

	@FXML
	private void onClickedRefreshButton(MouseEvent event) throws IOException {
		UserControllerService userController = new UserControllerImpl();

		data.clear();
		ObservableList<TableColumn<UserData, ?>> observableList = userTable.getColumns();
		initiateObservableList(observableList);

		ArrayList<UserVO> list = userController.getAllUsers();

		userDataHelper = new UserDataHelper();

		for (int i = 0; i < list.size(); i++) {
			data.add(userDataHelper.toUserData(list.get(i)));
		}

		userTable.setItems(data);
	}

	@FXML
	private void onLogout(ActionEvent event) throws Exception {
		new LoginUI_start().start(stage);
	}

	@FXML
	private void onReturn(ActionEvent event) throws Exception {
		new ManagerUI_start().start(stage);
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

	/**
	 * 初始化数据表
	 * 
	 * @param observableList
	 */
	private void initiateObservableList(ObservableList<TableColumn<UserData, ?>> observableList) {
		observableList.get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
		observableList.get(1).setCellValueFactory(new PropertyValueFactory<>("username"));
		observableList.get(2).setCellValueFactory(new PropertyValueFactory<>("identity"));
		observableList.get(3).setCellValueFactory(new PropertyValueFactory<>("start"));
		observableList.get(4).setCellValueFactory(new PropertyValueFactory<>("operation"));
	}
}
