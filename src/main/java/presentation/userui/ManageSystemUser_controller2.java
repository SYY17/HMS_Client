package presentation.userui;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.paint.Paint;
import javafx.stage.Stage;
import presentation.hotelui.ManageHotelCreatingApplication_start;
import presentation.loginui.LoginUI_start;
import presentation.mainui.ManagerUI_start;

public class ManageSystemUser_controller2 {

	public static Stage stage;
	
	@FXML
	private TableView<SystemUserData> applyInfoTable;
	
	@FXML
	private ImageView return_icon;
	
	@FXML
	private Label return_button;
	
	@FXML
	private TextField search_field;
	
	@FXML
	private ImageView search_button;
	
	@FXML
	private ImageView add_button;
	
	@FXML
	private TextField username_field;
	
	@FXML
	private ChoiceBox<String> id_choicebox;
	
	@FXML
	private Label username;
	
	private UserDataHelper userDataHelper;
	
	private final ObservableList<UserData> data = FXCollections.observableArrayList();
	
	@FXML
	private void onManageSystemUser(MouseEvent event) throws Exception {
		new ManageSystemUser_start2().start(stage);
	}
	
	@FXML
	private void onManageHotelCreatingApplication(MouseEvent event) throws Exception {
		new ManageHotelCreatingApplication_start().start(stage);
	}
	
	@FXML
	private void onEnteredReturn(MouseEvent event) throws Exception {
		return_button.setTextFill(Paint.valueOf("#000079"));
		new ManagerUI_start().start(stage);
	}
	
	@FXML
	private void onClickedReturn(MouseEvent event) throws Exception {
		new ManagerUI_start().start(stage);
	}
	
	@FXML
	private void onAddNewUser(MouseEvent event) throws Exception {
		//在observablelist中添加value
	}
	
	@FXML
	private void onDeleteUser(MouseEvent event) throws Exception {
		//在observablelist中删除value
	}
	
	@FXML
	private void onLogout(ActionEvent event) throws Exception {
		new LoginUI_start().start(stage);
	}
	
}
