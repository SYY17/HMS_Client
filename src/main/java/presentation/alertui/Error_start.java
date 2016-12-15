package presentation.alertui;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Error_start extends Application{

	private String message;
	
	public void setMessage(String information){
		message = information;
	}
	
	@Override
	public void start(Stage primaryStage) throws Exception {
		// TODO Auto-generated method stub
		Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("FXML/elements/errorUI.fxml"));
		Scene scene = new Scene(root, 380, 238);
		initiateMessage(root);
		// scene.getStylesheets().add(getClass().getResource("main.css").toExternalForm());
		Error_controller.stage = primaryStage;
		primaryStage.setScene(scene);
		primaryStage.setTitle("错误提示");
		primaryStage.show();
	}
	
	private void initiateMessage(Parent root){
		TextField message_field = (TextField)root.lookup("#message");
		message_field.setText(message);
		message_field.setEditable(false);
	}

}
