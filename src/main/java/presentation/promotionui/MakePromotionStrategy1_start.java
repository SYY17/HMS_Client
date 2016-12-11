package presentation.promotionui;

import java.util.ArrayList;

import businesslogic.promotionbl.PromotionController;
import businesslogicservice.promotionblservice.PromotionBLService;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import presentation.hotelui.hotel.PromotionData;
import vo.PromotionVO;

public class MakePromotionStrategy1_start extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			Parent root = FXMLLoader
					.load(getClass().getClassLoader().getResource("FXML/user/saler/MakePromotionStrategy1.fxml"));
			initiateTableView(root);
			Scene scene = new Scene(root, 800, 600);
			// scene.getStylesheets().add(getClass().getResource("main.css").toExternalForm());
			MakePromotionStrategy1_controller.stage = primaryStage;
			primaryStage.setScene(scene);
			primaryStage.setTitle("制定营销策略");
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
		TableView<PromotionData> promotionTableView = (TableView<PromotionData>) root.lookup("#promotionTableView");

		// 建立observablelist以更新数据
		final ObservableList<PromotionData> data = FXCollections.observableArrayList();
		PromotionBLService promotionBlService = new PromotionController();

		data.clear();
		ObservableList<TableColumn<PromotionData, ?>> observableList = promotionTableView.getColumns();

		observableList.get(0).setCellValueFactory(new PropertyValueFactory<>("promotionID"));
		observableList.get(1).setCellValueFactory(new PropertyValueFactory<>("promotionName"));
		observableList.get(2).setCellValueFactory(new PropertyValueFactory<>("promotionDate"));
		observableList.get(3).setCellValueFactory(new PropertyValueFactory<>("promotionStop"));
		observableList.get(4).setCellValueFactory(new PropertyValueFactory<>("promotionContent"));

		ArrayList<PromotionVO> promotionList = promotionBlService.getAllPromotion(20902341);

		for (int i = 0; i < promotionList.size(); i++) {
			PromotionVO pvo = promotionList.get(i);
			data.add(new PromotionDataHelper().toPromotionData(pvo));
		}

		promotionTableView.setItems(data);
	}

}
