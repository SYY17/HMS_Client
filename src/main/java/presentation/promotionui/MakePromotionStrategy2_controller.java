package presentation.promotionui;

import java.io.IOException;

import businesslogic.promotionbl.PromotionController;
import businesslogicservice.promotionblservice.PromotionBLService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableView;
import javafx.stage.Stage;
import presentation.creditui.ManageUserCredit1_start;
import presentation.hotelui.hotel.PromotionData;
import presentation.loginui.LogFrame;
import presentation.orderui.ManageAbnormalOrder1_start;

public class MakePromotionStrategy2_controller {

	public static Stage stage;
	public PromotionBLService promotionBlService = new PromotionController();
	@FXML
	public TableView<PromotionData> promotionTableView;

	@FXML
	private void onLogout(ActionEvent event) throws IOException {
		new LogFrame().start(stage);
	}
	
	@FXML
	private void onOrderManage(ActionEvent event) throws Exception {
		new ManageAbnormalOrder1_start().start(stage);
	}
	
	@FXML
	private void onPromotionManage(ActionEvent event) throws Exception {
		new MakePromotionStrategy1_start().start(stage);
	}
	
	@FXML
	private void onCreditManage(ActionEvent event) throws Exception {
		new ManageUserCredit1_start().start(stage);
	}
	
	@FXML
	private void onAbout(ActionEvent event) throws Exception {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setHeaderText("据说这是大作业");
		alert.showAndWait();
	}
}
