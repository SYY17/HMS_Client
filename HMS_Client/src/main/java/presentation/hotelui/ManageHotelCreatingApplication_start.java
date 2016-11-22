package presentation.hotelui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class ManageHotelCreatingApplication_start extends Application{

	@Override
	public void start(Stage primaryStage) throws Exception {
		try {
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("FXML/user/manager/ManageHotelCreatingApplication.fxml"));
			Scene scene = new Scene(root, 800, 600);
//			scene.getStylesheets().add(getClass().getResource("main.css").toExternalForm());
			ManageHotelCreatingApplication_controller.stage = primaryStage;
			primaryStage.setScene(scene);
			primaryStage.setTitle("管理合作酒店创建申请");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

//	public static void main(String[] args) {
//		launch(args);
//	}
}
