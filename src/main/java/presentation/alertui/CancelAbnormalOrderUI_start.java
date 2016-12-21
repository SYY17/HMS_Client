package presentation.alertui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class CancelAbnormalOrderUI_start extends Application {

	public void initiateView(int orderid, String username, String hotelname, int price) {
//		CancelAbnormalOrderUI_controller.orderid.setText(orderid + "");
//		CancelAbnormalOrderUI_controller.username.setText(username);
//		CancelAbnormalOrderUI_controller.hotelname.setText(hotelname);
//		CancelAbnormalOrderUI_controller.price.setText(price + "");
	}

	@Override
	public void start(Stage primaryStage) {
		try {
			primaryStage = new Stage();
			Parent root = FXMLLoader
					.load(getClass().getClassLoader().getResource("FXML/elements/cancelAbnormalOrderUI.fxml"));
			Scene scene = new Scene(root, 800, 600);
			// scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			// primaryStage.initStyle(StageStyle.DECORATED);
			CancelAbnormalOrderUI_controller.stage = primaryStage;
			primaryStage.setScene(scene);
			primaryStage.setTitle("酒店管理系统");
			primaryStage.show();
//			Alert.getInstance().showConfirmDialog(primaryStage, STYLESHEET_MODENA, STYLESHEET_CASPIAN);
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
