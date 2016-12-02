package presentation.hotelui.hotel;


import java.io.IOException;
import java.util.ArrayList;

import businesslogic.promotionbl.PromotionController;
import businesslogicservice.promotionblservice.PromotionBLService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.stage.Stage;
import presentation.loginui.LogFrame;
import presentation.mainui.Hotel_start;
import vo.PromotionVO;

public class Promotion_controller {
	
	public static Stage stage;
	private final ObservableList<PromotionData> data = FXCollections.observableArrayList();
	public PromotionBLService promotionBlService = new PromotionController();
	public ListView<String> promotionListView;

	@FXML
	private void onLogout(ActionEvent event) throws IOException {
		new LogFrame().start(stage);
	}
	
	@FXML
	private void onReturn(ActionEvent event){
		new Hotel_start().start(stage);
	}
	
	@FXML
	private void onAdd(ActionEvent event){
		new CreatePromotion_start().start(stage);
	}
	
	@FXML
    private void initialize() {
		data.clear();
		ArrayList<PromotionVO> pvo = promotionBlService.getAllPromotion(/* id = */20905098);//
		ArrayList<String> content = new ArrayList<String>();
		for(int i=0;i<pvo.size();i++){
			content.add(pvo.get(i).getContent());
		}
		ObservableList<String> strList = FXCollections.observableArrayList(content);
		promotionListView.setItems(strList);
	}
	
	@FXML
	private void onReviewOrderList(ActionEvent event) throws IOException {
		new OrderList_start().start(stage);
	}
	
	@FXML
	private void onExecute(ActionEvent event) throws IOException {  
		new Execute_start().start(stage);
	}
	
	@FXML
	private void onManage(ActionEvent event) throws IOException {
		new Manage_start().start(stage);
	}
	
	@FXML
	private void onReviewPromotion(ActionEvent event) throws IOException {
		new Promotion_start().start(stage);
	}
	
	@FXML
	private void onCreatePromotion(ActionEvent event) throws IOException {
		new CreatePromotion_start().start(stage);
	}
}

