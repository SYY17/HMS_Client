package presentation.userui.user;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import businesslogic.creditbl.CreditController;
import businesslogicservice.creditBLService.CreditBLService;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import presentation.controller.IDHelper;
import presentation.controller.UserControllerImpl;
import presentation.userui.UserControllerService;
import vo.UserCreditHistoryVO;

public class Credit_start extends Application {

	private IDHelper idHelper;
	private int id;
	
	private static Credit_start instance;
	private Parent root;
	
	private Credit_start(){
		
	}
	
	//单件模式
		public static  Credit_start getInstance(){
			if(instance == null){
				instance = new Credit_start();
			}
			return instance;
		}
	
	@Override
	public void start(Stage primaryStage) {
		// TODO Auto-generated method stub
		try {
			root = FXMLLoader.load(getClass().getClassLoader().getResource("FXML/user/user/信用.fxml"));
			
			this.initiateHelper();
			this.initiateElements(root);
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

		System.out.println(id);
		ArrayList<UserCreditHistoryVO> timeList = creditBlService.getHistory(id);

		for (int i = 0; i < timeList.size(); i++) {
			data.add(new CreditData(timeList.get(i).getTime(), timeList.get(i).getChange()));
		}

		creditTable.setItems(data);
	}

	/**
	 * 初始化界面组件
	 * @param root
	 */
	private void initiateElements(Parent root) {
		// TODO Auto-generated method stub
		initiateUserName(root);
		initiateDate(root);
	}

	/**
	 * 获取当前用户ID
	 */
	private void initiateHelper() {
		idHelper = IDHelper.getInstance();
		id = idHelper.getID();
	}
	
	/**
	 * 初始化当前日期
	 * @param root
	 */
	private void initiateDate(Parent root){
		Label date = (Label) root.lookup("#date");
		java.util.Date time = new java.util.Date();
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String text = format.format(time);
		date.setText(text);
	}

	/**
	 * 初始化当前用户用户名
	 * @param root
	 */
	private void initiateUserName(Parent root) {
		Label username = (Label) root.lookup("#username");
		UserControllerService userController = new UserControllerImpl();
		String name = userController.searchByUserID(id);
		username.setText(name);
	}
}
