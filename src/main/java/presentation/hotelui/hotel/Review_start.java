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

public class Review_start extends Application {
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("FXML/user/hotel/管理酒店基本信息（浏览）.fxml"));
			initiate(root);
			Scene scene = new Scene(root, 800, 600);
			// scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			// primaryStage.initStyle(StageStyle.DECORATED);
			Review_controller.stage = primaryStage;
			primaryStage.setScene(scene);
			primaryStage.setTitle("酒店管理系统");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	private void initiate(Parent root) {
		Label nameLabel = (Label) root.lookup("#nameLabel");
		Label addressLabel = (Label) root.lookup("#addressLabel");
		Label areaLabel = (Label) root.lookup("#areaLabel");
		Label starLabel = (Label) root.lookup("#starLabel");
		Label phoneLabel = (Label) root.lookup("#phoneLabel");
		TextArea descriptionText = (TextArea) root.lookup("#descriptionText");

		nameLabel.setText("homeinn");// not finished
		String name = nameLabel.getText();

		HotelControllerService hotelController = new HotelControllerImpl();
		HotelVO hvo = hotelController.reviewHotelInfo(name);
		addressLabel.setText("地址：" + hvo.getHotelAddress());
		areaLabel.setText("商圈：" + hvo.getBusinessArea());
		starLabel.setText("星级：" + hvo.getStarLevel() + "星");
		phoneLabel.setText("联系方式：" + hvo.getPhoneNumber());
		descriptionText.setText(hvo.getHotelDescription());
	}

	public static void main(String[] args) {
		launch(args);
	}
}