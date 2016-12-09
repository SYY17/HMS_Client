package presentation.hotelui.hotel;

import java.util.ArrayList;

import businesslogic.promotionbl.PromotionController;
import businesslogicservice.promotionblservice.PromotionBLService;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import vo.PromotionVO;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ListView;

public class Promotion_start extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("FXML/user/hotel/制定营销策略2.fxml"));
			initiateTableView(root);
			Scene scene = new Scene(root, 800, 600);
			// scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			// primaryStage.initStyle(StageStyle.DECORATED);
			Promotion_controller.stage = primaryStage;
			primaryStage.setScene(scene);
			primaryStage.setTitle("酒店管理系统");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}

	/**
	 * 初始化表内数据
	 * 
	 * @param root
	 */
	private void initiateTableView(Parent root) {
		@SuppressWarnings("unchecked")
		// 查找tableview
		ListView<String> promotionListView = (ListView<String>) root.lookup("#promotionListView");

		// 建立observablelist以更新数据
		final ObservableList<PromotionData> data = FXCollections.observableArrayList();
		PromotionBLService promotionBlService = new PromotionController();

		data.clear();
		ArrayList<PromotionVO> pvo = promotionBlService
				.getAllPromotion(/* id = */20902341);//
		ArrayList<String> content = new ArrayList<String>();
		for (int i = 0; i < pvo.size(); i++) {
			content.add(pvo.get(i).getPromotionName());
		}
		ObservableList<String> strList = FXCollections.observableArrayList(content);
		promotionListView.setItems(strList);
	}

}