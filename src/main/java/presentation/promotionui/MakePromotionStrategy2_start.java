package presentation.promotionui;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import businesslogic.promotionbl.PromotionController;
import businesslogicservice.promotionblservice.PromotionBLService;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;
import presentation.controller.IDHelper;
import presentation.hotelui.hotel.CreatePromotion_controller;
import presentation.hotelui.hotel.PromotionData;
import vo.PromotionVO;

public class MakePromotionStrategy2_start extends Application {

	private final String pattern = "yyyy-MM-dd";
	//
	private IDHelper idHelper;
	private int id;

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			Parent root = FXMLLoader
					.load(getClass().getClassLoader().getResource("FXML/user/saler/MakePromotionStrategy2.fxml"));
			this.initiateHelper();//
			initDatePicker(root);
			initChoiceBox(root);
			initiateTableView(root);
			Scene scene = new Scene(root, 800, 600);
			// scene.getStylesheets().add(getClass().getResource("main.css").toExternalForm());
			MakePromotionStrategy2_controller.stage = primaryStage;
			MakePromotionStrategy2_controller.id = id;
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

		StringConverter converter = new StringConverter<LocalDate>() {
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

		ArrayList<PromotionVO> promotionList = promotionBlService.getAllPromotion(id);//........

		for (int i = 0; i < promotionList.size(); i++) {
			PromotionVO pvo = promotionList.get(i);
			data.add(new PromotionDataHelper().toPromotionData(pvo));
		}

		promotionTableView.setItems(data);
	}

	/**
	 * 获取当前用户ID
	 */
	private void initiateHelper() {
		idHelper = IDHelper.getInstance();
		id = idHelper.getID();
	}
}
