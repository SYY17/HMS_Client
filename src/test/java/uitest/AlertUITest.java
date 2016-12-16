package uitest;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import presentation.alertui.Alert;

public class AlertUITest extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Pane root = new Pane();
		root.setPrefSize(500, 300);
		Scene scene = new Scene(root, 500, 300);
		primaryStage.setScene(scene);
		primaryStage.show();
		Alert alert = Alert.getInstance();
		alert.showMessageDialog(primaryStage, "您有一条新信息！", "最新消息");
	}
	
	public static void main(String[] args) {
		launch(args);
	}
	
}
