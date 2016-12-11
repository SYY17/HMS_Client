package presentation.mainui;

import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableView;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import presentation.creditui.ManageUserCredit1_start;
import presentation.loginui.LoginUI_start;
import presentation.orderui.ManageAbnormalOrder1_start;
import presentation.promotionui.MakePromotionStrategy1_start;

public class SalerUI_controller {

	public static Stage stage;
	
	@FXML
	private Label manageabnormalorder;
	
	@FXML
	private Label makepromotionstrategy;
	
	@FXML
	private Label managecredit;
	
	@FXML
	private Label homepage;
	
	@FXML
	private TableView<AbnormalOrderData> newAbnormalOrderTableView;
	
	@FXML
	private Label username;
	
	@FXML
	private Label date;

	/**
	 * 注销
	 * @param event
	 * @throws Exception
	 */
	@FXML
	private void onLogout(MouseEvent event) throws Exception {
		new LoginUI_start().start(stage);
	}

	/**
	 * 返回首页
	 * @param event
	 * @throws Exception
	 */
	@FXML
	private void onHomePage(MouseEvent event) throws Exception {
		new SalerUI_start().start(stage);
	}

	/**
	 * 跳转至制定营销策略界面
	 * @param event
	 * @throws Exception
	 */
	@FXML
	private void onMakePromotionStrategy(MouseEvent event) throws Exception {
		new MakePromotionStrategy1_start().start(stage);
	}

	/**
	 * 跳转至管理信用值界面
	 * @param event
	 * @throws Exception
	 */
	@FXML
	private void onManageCredit(MouseEvent event) throws Exception {
		new ManageUserCredit1_start().start(stage);
	}

	/**
	 * 跳转至管理异常订单界面
	 * @param event
	 * @throws Exception
	 */
	@FXML
	private void onManageAbnormalOrder(MouseEvent event) throws Exception {
		new ManageAbnormalOrder1_start().start(stage);
	}
}
