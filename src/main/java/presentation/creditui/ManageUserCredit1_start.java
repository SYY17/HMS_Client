package presentation.creditui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ManageUserCredit1_start extends Application {

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			Parent root = FXMLLoader
					.load(getClass().getClassLoader().getResource("FXML/user/saler/ManageUserCredit1.fxml"));
			Scene scene = new Scene(root, 800, 600);
			// scene.getStylesheets().add(getClass().getResource("main.css").toExternalForm());
			ManageUserCredit1_controller.stage = primaryStage;
			primaryStage.setScene(scene);
			primaryStage.setTitle("管理用户信用值");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public static void main(String[] args) {
		launch(args);
	}
}
