package presentation.userui.user;

import java.sql.Date;
import java.util.ArrayList;

import businesslogic.creditbl.CreditController;
import businesslogicservice.creditBLService.CreditBLService;
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

public class Credit_start extends Application {

	@Override
	public void start(Stage primaryStage) {
		// TODO Auto-generated method stub
		try {
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("FXML/user/user/信用.fxml"));
			initiateTableView(root);
			Scene scene = new Scene(root, 800, 600);
			Credit_controller.stage = primaryStage;
			// scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			// primaryStage.initStyle(StageStyle.DECORATED);
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
		TableView<CreditData> creditTable = (TableView<CreditData>) root.lookup("#creditTable");

		// 建立observablelist以更新数据
		final ObservableList<CreditData> data = FXCollections.observableArrayList();
		CreditBLService creditBlService = new CreditController();
		data.clear();
		ObservableList<TableColumn<CreditData, ?>> observableList = creditTable.getColumns();
		observableList.get(0).setCellValueFactory(new PropertyValueFactory<>("time"));
		observableList.get(1).setCellValueFactory(new PropertyValueFactory<>("history"));

		ArrayList<Date> timeList = creditBlService.getHistoryDate(/* id = */20905098);
		ArrayList<Integer> historyList = creditBlService
				.getHistoryChange(/* id = */20905098);

		for (int i = 0; i < timeList.size(); i++) {
			data.add(new CreditData(timeList.get(i), historyList.get(i)));
		}

		creditTable.setItems(data);
	}

}
