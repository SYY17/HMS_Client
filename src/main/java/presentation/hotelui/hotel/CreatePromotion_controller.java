package presentation.hotelui.hotel;


import java.io.IOException;
import java.util.ArrayList;
import java.sql.Date;


import businesslogic.promotionbl.PromotionController;
import businesslogicservice.promotionblservice.PromotionBLService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import presentation.loginui.LogFrame;
import vo.PromotionVO;

public class CreatePromotion_controller {
	
	public static Stage stage;
	private final ObservableList<PromotionData> data = FXCollections.observableArrayList();
	public PromotionBLService promotionBlService = new PromotionController();
	public ListView<String> promotionListView;
	public TextArea textField;

	@FXML
	private void onLogout(ActionEvent event) throws IOException {
		new LogFrame().start(stage);
	}
	
	@FXML
	private void onSubmit(ActionEvent event){
		String content = textField.getText();
		Date time = Date.valueOf("2016-12-01");//
		promotionBlService.addPromotion(new PromotionVO(content,time,/* id = */20905098));//
		//JOptionPane.showMessageDialog(null, "提交成功", "提示", JOptionPane.PLAIN_MESSAGE);
		new Promotion_start().start(stage);
	}
	
	@FXML
	private void onReturn(ActionEvent event){
		new Promotion_start().start(stage);
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

