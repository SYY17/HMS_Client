package presentation.promotionui;

import java.io.IOException;
import java.util.ArrayList;
import java.sql.Date;

import businesslogic.promotionbl.PromotionController;
import businesslogicservice.promotionblservice.PromotionBLService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import presentation.creditui.ManageUserCredit1_start;
import presentation.hotelui.hotel.PromotionData;
import presentation.loginui.LogFrame;
import presentation.mainui.Saler_start;
import presentation.orderui.ManageAbnormalOrder1_start;
import vo.PromotionVO;

public class MakePromotionStrategy1_controller {

	public static Stage stage;
	private final ObservableList<PromotionData> data = FXCollections.observableArrayList();
	public PromotionBLService promotionBlService = new PromotionController();
	public TableView<PromotionData> promotionTableView;
	public TextArea textField;

	@FXML
	private void onLogout(ActionEvent event) throws IOException {
		new LogFrame().start(stage);
	}
	
	@FXML
	private void onReturn(ActionEvent event) throws IOException {
		new Saler_start().start(stage);
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
	
	/*
	 * 具体该策略的开始时间以及编号的赋予需要补充
	 */
	@FXML
	private void onSubmit(ActionEvent event) throws Exception {
		String content = textField.getText();
		Date time = Date.valueOf("2016-12-01");//
		promotionBlService.addPromotion(new PromotionVO(content,time,/* id = */20905098));//
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
