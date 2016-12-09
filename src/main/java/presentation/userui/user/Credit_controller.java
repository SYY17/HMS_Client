package presentation.userui.user;

import java.io.IOException;
import java.util.ArrayList;

import java.sql.Date;

import businesslogic.creditbl.CreditController;
import businesslogicservice.creditBLService.CreditBLService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import presentation.loginui.LogFrame;
import presentation.mainui.User_start;

public class Credit_controller {

	public static Stage stage;
	private final ObservableList<CreditData> data = FXCollections.observableArrayList();
	public CreditBLService creditBlService = new CreditController();
	public TableView<CreditData> creditTable;

	@FXML
	private void onLogout(ActionEvent event) throws IOException {
		new LogFrame().start(stage);
	}

	@FXML
	private void onBack(ActionEvent event) throws IOException {
		new User_start().start(stage);
	}

	@FXML
	private void initialize() {
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

	@FXML
	private void onShowOrder(ActionEvent event) throws IOException {
		new AllOrder_start().start(stage);
	}

	@FXML
	private void onDetailedInfo(ActionEvent event) {
		new DetailedInfomation_start().start(stage);
	}

}
