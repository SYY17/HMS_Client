package presentation.hotelui.hotel;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import businesslogic.promotionbl.PromotionController;
import businesslogicservice.promotionblservice.PromotionBLService;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;
import presentation.controller.IDHelper;
import vo.PromotionVO;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;

public class CreatePromotion_start extends Application {

	private final String pattern = "yyyy-MM-dd";
	
	private IDHelper idHelper;
	private int id;

	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("FXML/user/hotel/制定营销策略1.fxml"));
			this.initiateHelper();//
			initDatePicker(root);
			initChoiceBox(root);
			initiateTableView(root);
			Scene scene = new Scene(root, 800, 600);
			// scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			// primaryStage.initStyle(StageStyle.DECORATED);
			CreatePromotion_controller.stage = primaryStage;
			CreatePromotion_controller.id = id;
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

	/*
	 * 初始化ChoiceBox
	 */
	public void initChoiceBox(Parent root) {
		@SuppressWarnings("unchecked")
		// 查找promotionType
		ChoiceBox<Object> promotionType = (ChoiceBox<Object>) root.lookup("#promotionType");

		promotionType.setItems(FXCollections.observableArrayList("FullCut", "Discount"));
	}

	/*
	 * 初始化DatePicker
	 */
	public void initDatePicker(Parent root) {
		// 查找startTime
		DatePicker startTime = (DatePicker) root.lookup("#startTime");

		// 查找stopTime
		DatePicker stopTime = (DatePicker) root.lookup("#stopTime");

		StringConverter<LocalDate> converter = new StringConverter<LocalDate>() {
			DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);

			@Override
			public String toString(LocalDate date) {
				if (date != null) {
					return dateFormatter.format(date);
				} else {
					return "";
				}
			}

			@Override
			public LocalDate fromString(String string) {
				if (string != null && !string.isEmpty()) {
					return LocalDate.parse(string, dateFormatter);
				} else {
					return null;
				}
			}
		};

		startTime.setShowWeekNumbers(true);
		startTime.setConverter(converter);
		startTime.setPromptText(pattern.toLowerCase());

		stopTime.setShowWeekNumbers(true);
		stopTime.setConverter(converter);
		stopTime.setPromptText(pattern.toLowerCase());

		startTime.setValue(LocalDate.now());

		final Callback<DatePicker, DateCell> dayCellFactory = new Callback<DatePicker, DateCell>() {
			@Override
			public DateCell call(final DatePicker datePicker) {
				return new DateCell() {
					@Override
					public void updateItem(LocalDate item, boolean empty) {
						super.updateItem(item, empty);

						if (item.isBefore(startTime.getValue().plusDays(1))) {
							setDisable(true);
							setStyle("-fx-background-color: #ffc0cb;");
						}
					}
				};
			}
		};
		stopTime.setDayCellFactory(dayCellFactory);
		stopTime.setValue(startTime.getValue().plusDays(1));
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
				.getAllPromotion(id);//
		ArrayList<String> content = new ArrayList<String>();
		for (int i = 0; i < pvo.size(); i++) {
			content.add(pvo.get(i).getPromotionName());
		}
		ObservableList<String> strList = FXCollections.observableArrayList(content);
		promotionListView.setItems(strList);
	}
	
	/**
	 * 获取当前用户ID
	 */
	private void initiateHelper() {
		idHelper = IDHelper.getInstance();
		id = idHelper.getID();
	}
	
}