package presentation.hotelui.hotel;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import presentation.controller.HotelControllerImpl;
import presentation.hotelui.HotelControllerService;
import vo.HotelVO;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;

public class Modify_start extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("FXML/user/hotel/管理酒店基本信息（修改）.fxml"));
			initiate(root);
			Scene scene = new Scene(root, 800, 600);
			// scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			//primaryStage.initStyle(StageStyle.DECORATED);
			Modify_controller.stage = primaryStage;
			primaryStage.setScene(scene);
			primaryStage.setTitle("酒店管理系统");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void initiate(Parent root){
		Label nameLabel = (Label)root.lookup("#nameLabel");
		TextField addressText = (TextField)root.lookup("#addressText");
		TextField businessAreaText = (TextField)root.lookup("#businessAreaText");
		TextField starText = (TextField)root.lookup("#starText");
		TextField phoneText = (TextField)root.lookup("#phoneText");
		TextArea descriptionText = (TextArea)root.lookup("#descriptionText");
		
		nameLabel.setText("homeinn");//not finished
		String name = nameLabel.getText();
		
		
		HotelControllerService hotelController = new HotelControllerImpl();
		HotelVO hvo = hotelController.reviewHotelInfo(name);
		addressText.setText(hvo.getHotelAddress());
		businessAreaText.setText(hvo.getBusinessArea());
		starText.setText(hvo.getStarLevel()+"");
		phoneText.setText(hvo.getPhoneNumber());
		descriptionText.setText(hvo.getHotelDescription());
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}