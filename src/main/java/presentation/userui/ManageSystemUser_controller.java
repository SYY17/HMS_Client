package presentation.userui;

import java.util.ArrayList;

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
import presentation.controller.LoginControllerImpl;
import presentation.controller.UserControllerImpl;
import presentation.hotelui.ManageHotelCreatingApplication_start;
import presentation.loginui.LoginControllerService;
import presentation.loginui.LoginUI_start;
import presentation.mainui.ManagerUI_start;
import vo.UserVO;

public class ManageSystemUser_controller {

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
	
	@FXML
	private Label date;

	private ObservableList<SystemUserData> data;

	@FXML
	private void onManageSystemUser(MouseEvent event) throws Exception {
		new ManageSystemUser_start().start(stage);
	}

	@FXML
	private void onManageHotelCreatingApplication(MouseEvent event) throws Exception {
		new ManageHotelCreatingApplication_start().start(stage);
	}

	@FXML
	private void onEnteredReturn(MouseEvent event) throws Exception {
		return_button.setTextFill(Paint.valueOf("#ffffff"));
	}

	@FXML
	private void onExitedReturn(MouseEvent event) throws Exception {
		return_button.setTextFill(Paint.valueOf("#000000"));
	}

	@FXML
	private void onClickedReturn(MouseEvent event) throws Exception {
		new ManagerUI_start().start(stage);
	}

	@FXML
	private void onSearch(MouseEvent event) throws Exception {
		String text = search_field.getText();
		
		// 建立observablelist以更新数据
		UserControllerService userController = new UserControllerImpl();

		data = applyInfoTable.getItems();
		data.clear();

		SystemUserDataHelper systemUserDataHelper = new SystemUserDataHelper();

		ArrayList<UserVO> list = userController.getAllUsers();
		for (int i = 0; i < list.size(); i++) {
			UserVO uvo = list.get(i);
			if(uvo.getName().contains(text))
			data.add(systemUserDataHelper.toSystemUserData(uvo));
		}
		applyInfoTable.setItems(data);
	}
	
	@FXML
	private void onAddNewUser(MouseEvent event) throws Exception {
		// 在observablelist中添加value
		String text = username_field.getText();

		if (text.equals("")) {
			// 提示未输入用户名
		} else if (text.length() > 12) {
			// 提示字数过多
		} else {
			LoginControllerService loginController = new LoginControllerImpl();
			loginController.addNewUser(text, "000000", this.parseID(id_choicebox));
		}

		this.refreshTableView();
	}

	@FXML
	private void onLogout(ActionEvent event) throws Exception {
		new LoginUI_start().start(stage);
	}

	/**
	 * 刷新表内数据
	 * 
	 * @param root
	 */
	private void refreshTableView() {

		// 建立observablelist以更新数据
		UserControllerService userController = new UserControllerImpl();

		data = applyInfoTable.getItems();
		data.clear();

		SystemUserDataHelper systemUserDataHelper = new SystemUserDataHelper();

		ArrayList<UserVO> list = userController.getAllUsers();
		for (int i = 0; i < list.size(); i++) {
			UserVO uvo = list.get(i);
			data.add(systemUserDataHelper.toSystemUserData(uvo));
		}
		applyInfoTable.setItems(data);
	}

	/**
	 * 
	 * @param id
	 * @return 转换成对应数字ID
	 */
	private int parseID(ChoiceBox<String> id) {
		// TODO Auto-generated method stub
		String s = id.getValue();

		if (s.equals("客户")) {
			return 1;
		} else if (s.equals("酒店工作人员")) {
			return 2;
		} else if (s.equals("网站营销人员")) {
			return 3;
		}
		return 4;
	}

}
