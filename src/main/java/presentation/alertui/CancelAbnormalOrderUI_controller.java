package presentation.alertui;

import javafx.event.Event;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import presentation.controller.OrderControllerImpl;
import presentation.orderui.OrderControllerService;
import vo.OrderStatus;

public class CancelAbnormalOrderUI_controller {
	public static Stage stage;
	private OrderControllerService orderControllerService = new OrderControllerImpl();
	public static TextField orderid;
	public static TextField username;
	public static TextField hotelname;
	public static TextField price;

	/**
	 * 
	 * @param event
	 * @throws Exception
	 */
	@FXML
	private void onAll(Event event) throws Exception {
		orderControllerService.changeOrderStatus(Integer.parseInt(orderid.getText()), OrderStatus.Canceled);
	}

	/**
	 * 
	 * @param event
	 * @throws Exception
	 */
	@FXML
	private void onHalf(Event event) throws Exception {
		orderControllerService.changeOrderStatus(Integer.parseInt(orderid.getText()), OrderStatus.HalfCanceled);
	}

	/**
	 * 
	 * @param event
	 * @throws Exception
	 */
	@FXML
	private void onCancel(Event event) throws Exception {
		stage.close();
	}
}
