package presentation.hotelui.hotel;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.stage.Stage;
import presentation.controller.HotelControllerImpl;
import presentation.controller.IDHelper;
import presentation.hotelui.HotelControllerService;
import vo.HotelVO;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;

public class Review_start extends Application {
	
	private IDHelper idHelper;
	private int id;
	
	@Override
	public void start(Stage primaryStage) {
		try {
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("FXML/user/hotel/管理酒店基本信息（浏览）.fxml"));
			this.initiateHelper();
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

		//initiate hotel name:
		HotelControllerService hotelController = new HotelControllerImpl();
		String name = hotelController.searchHotelByID(id).getHotelName();
		nameLabel.setText(name);

		HotelVO hvo = hotelController.reviewHotelInfo(name);
		addressLabel.setText("地址：" + hvo.getHotelAddress());
		areaLabel.setText("商圈：" + hvo.getBusinessArea());
		starLabel.setText("星级：" + hvo.getStarLevel() + "星");
		phoneLabel.setText("联系方式：" + hvo.getPhoneNumber());
		descriptionText.setText(hvo.getHotelDescription());
	}

	/**
	 * 获取当前用户ID
	 */
	private void initiateHelper() {
		idHelper = IDHelper.getInstance();
		id = idHelper.getID();
	}
	
	public static void main(String[] args) {
		launch(args);
	}
}