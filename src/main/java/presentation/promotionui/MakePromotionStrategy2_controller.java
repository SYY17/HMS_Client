package presentation.promotionui;

import java.io.IOException;
import java.util.ArrayList;

import businesslogic.promotionbl.PromotionController;
import businesslogicservice.promotionblservice.PromotionBLService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import presentation.creditui.ManageUserCredit1_start;
import presentation.hotelui.hotel.PromotionData;
import presentation.loginui.LogFrame;
import presentation.orderui.ManageAbnormalOrder1_start;
import vo.PromotionVO;

public class MakePromotionStrategy2_controller {

	public static Stage stage;
	private final ObservableList<PromotionData> data = FXCollections.observableArrayList();
	public PromotionBLService promotionBlService = new PromotionController();
	public TableView<PromotionData> promotionTableView;

	@FXML
	private void onLogout(ActionEvent event) throws IOException {
		new LogFrame().start(stage);
	}
	
	@FXML
	private void onReturn(ActionEvent event) throws Exception {
		new MakePromotionStrategy1_start().start(stage);
	}
	
	@FXML
    private void initialize() {
		data.clear();
		ObservableList<TableColumn<PromotionData, ?>> observableList = promotionTableView.getColumns();
		observableList.get(0).setCellValueFactory(new PropertyValueFactory<>("promotionID"));
		observableList.get(1).setCellValueFactory(new PropertyValueFactory<>("promotionDate"));
		observableList.get(2).setCellValueFactory(new PropertyValueFactory<>("promotionContent"));
		
		ArrayList<PromotionVO> promotionList = promotionBlService.getAllPromotion(/* id = */20905098);
		for(int i=0;i<promotionList.size();i++){
			PromotionVO pvo = promotionList.get(i);
			data.add(new PromotionData(pvo.getID(),pvo.getStartTime(),pvo.getContent()));
		}
		
		promotionTableView.setItems(data);
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
