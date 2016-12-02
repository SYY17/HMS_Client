package presentation.userui.user;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.stage.Stage;
import presentation.controller.HotelControllerImpl;
import presentation.hotelui.HotelControllerService;
import vo.HotelVO;

public class OrderAndRating_start extends Application{

	@Override
	public void start(Stage primaryStage){
		// TODO Auto-generated method stub
		try {
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("FXML/user/user/订单＋酒店评分.fxml"));
			
			initiateHotelInfoText(root);
			
			Scene scene = new Scene(root, 800, 600);
			OrderAndRating_controller.stage=primaryStage;
			// scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			//primaryStage.initStyle(StageStyle.DECORATED);
			primaryStage.setScene(scene);
			primaryStage.setTitle("酒店管理系统");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	private void initiateHotelInfoText(Parent root){
		TextArea hotelInfoText = (TextArea)root.lookup("#hotelInfoText");
		
		String name = "homeinn";//not finished
		
		
		HotelControllerService hotelController = new HotelControllerImpl();
		HotelVO hvo = hotelController.reviewHotelInfo(name);
		hotelInfoText.setText("酒店名称："+hvo.getHotelName()+"\n"
				+"地址："+hvo.getHotelAddress()+"\n"
				+"商圈："+hvo.getBusinessArea()+"\n"
				+"星级："+hvo.getStarLevel()+"星\n"
				+"联系方式："+hvo.getPhoneNumber()+"\n"
				+"简介："+hvo.getHotelDescription());

	}
	
	public static void main(String[] args) {
		launch(args);
	}
}
