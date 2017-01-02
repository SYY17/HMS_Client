package presentation.mainui;

import java.sql.Timestamp;
import java.text.SimpleDateFormat;
import java.util.ArrayList;

import org.omg.Messaging.SyncScopeHelper;

import java.sql.Date;

import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import presentation.controller.IDHelper;
import vo.OrderStatus;
import presentation.controller.OrderControllerImpl;
import presentation.controller.UserControllerImpl;
import presentation.orderui.OrderControllerService;
import presentation.orderui.OrderDataForSalerUI;
import presentation.orderui.OrderDataHelper;
import presentation.userui.UserControllerService;
import vo.OrderVO;
import vo.UserVO;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;

public class SalerUI_start extends Application {

	private IDHelper idHelper;
	private int id;
	private static SalerUI_start instance;
	private Parent root;
	private OrderControllerService orderControllerService;

	private SalerUI_start() {
		// TODO Auto-generated constructor stub
	}

	// 单件模式
	public static SalerUI_start getInstance() {
		if (instance == null) {
			instance = new SalerUI_start();
		}
		return instance;
	}

	/**
	 * 提供给对外的刷新方法
	 */
	public void refreshTableView() {
		this.initiateTableView(root);
	}

	@Override
	public void start(Stage primaryStage) {
		orderControllerService = new OrderControllerImpl();
		try {
			root = FXMLLoader.load(getClass().getClassLoader().getResource("FXML/user/saler/SalerUI.fxml"));
			initiateTableView(root);
			Scene scene = new Scene(root, 800, 600);
			SalerUI_controller.stage = primaryStage;
			this.initiateHelper();
			this.initiateElements(root);
			primaryStage.setScene(scene);
			primaryStage.setTitle("酒店管理系统");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	// public static void main(String[] args) {
	// launch(args);
	// }

	/**
	 * 初始化界面组件
	 * 
	 * @param root
	 */
	private void initiateElements(Parent root) {
		// TODO Auto-generated method stub
		initiateUserName(root);
		initiateDate(root);
		initiateUserSum(root);
		initiateHotelSum(root);
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
	 * 
	 * @param root
	 */
	private void initiateDate(Parent root) {
		Label date = (Label) root.lookup("#date");
		Date time = new Date(System.currentTimeMillis());
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
		String text = format.format(time);
		date.setText(text);
	}

	/**
	 * 初始化当前用户用户名
	 * 
	 * @param root
	 */
	private void initiateUserName(Parent root) {
		Label username = (Label) root.lookup("#username");
		UserControllerService userController = new UserControllerImpl();
		String name = userController.searchByUserID(id);
		username.setText(name);
	}

	/**
	 * 初始化用户数
	 * 
	 * @param root
	 */
	private void initiateUserSum(Parent root) {
		Label userSum = (Label) root.lookup("#userSum");
		ArrayList<UserVO> list = new UserControllerImpl().getAllUsers();
		int num = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getID() < 20000000) {
				num++;
			}
		}
		userSum.setText(String.valueOf(num));
	}

	/**
	 * 初始化酒店数
	 * 
	 * @param root
	 */
	private void initiateHotelSum(Parent root) {
		Label hotelSum = (Label) root.lookup("#hotelSum");
		ArrayList<UserVO> list = new UserControllerImpl().getAllUsers();
		int num = 0;
		for (int i = 0; i < list.size(); i++) {
			if (list.get(i).getID() >= 20000000 && list.get(i).getID() < 30000000) {
				num++;
			}
		}
		hotelSum.setText(String.valueOf(num));
	}

	/**
	 * 初始化表内数据
	 * 
	 * @param root
	 */
	@SuppressWarnings("deprecation")
	private void initiateTableView(Parent root) {
		@SuppressWarnings("unchecked")
		// 查找tableview
		TableView<OrderDataForSalerUI> newAbnormalOrderTableView = (TableView<OrderDataForSalerUI>) root
				.lookup("#newAbnormalOrderTableView");
		System.out.println(newAbnormalOrderTableView);

		// 建立observablelist以更新数据
		final ObservableList<OrderDataForSalerUI> data = FXCollections.observableArrayList();

		data.clear();
		ObservableList<TableColumn<OrderDataForSalerUI, ?>> observableList = newAbnormalOrderTableView.getColumns();
		initiateObservableList(observableList);

		ArrayList<OrderVO> orderList = orderControllerService
				.reviewOrder(/* id = */40000000, OrderStatus.Unfilled);
		for (int i = 0; i < orderList.size(); i++) {
			OrderVO ovo = orderList.get(i);
			Date orderDate = new Date(ovo.getDeadline().getTime());
			Date currentDate = new Date(System.currentTimeMillis());
			if ((orderDate.getDay() == currentDate.getDay() || orderDate.getDay() == currentDate.getDay() + 1)
					&& orderDate.getMonth() == currentDate.getMonth()) {
				data.add(new OrderDataHelper().toOrderDataForSalerUI(ovo));
			}
		}
		newAbnormalOrderTableView.setItems(data);
	}

	/**
	 * 初始化数据表
	 * 
	 * @param observableList
	 */
	private void initiateObservableList(ObservableList<TableColumn<OrderDataForSalerUI, ?>> observableList) {
		observableList.get(0).setCellValueFactory(new PropertyValueFactory<>("orderID"));
		observableList.get(1).setCellValueFactory(new PropertyValueFactory<>("userName"));
		observableList.get(2).setCellValueFactory(new PropertyValueFactory<>("checkIn"));
		observableList.get(3).setCellValueFactory(new PropertyValueFactory<>("price"));
		observableList.get(4).setCellValueFactory(new PropertyValueFactory<>("operation"));
	}
}
