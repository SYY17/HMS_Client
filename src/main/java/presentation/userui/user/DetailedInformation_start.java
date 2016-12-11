package presentation.userui.user;

import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import businesslogic.userbl.UserController;
import businesslogicservice.userblservice.UserBLService;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;
import presentation.hotelui.hotel.PromotionData;
import vo.UserVO;

public class DetailedInformation_start extends Application {

	private final String pattern = "yyyy-MM-dd";
	
	@Override
	public void start(Stage primaryStage) {
		// TODO Auto-generated method stub
		try {
			Parent root = FXMLLoader.load(getClass().getClassLoader().getResource("FXML/user/user/DetailedInformation.fxml"));
			initialize(root);
			initDatePicker(root);
			Scene scene = new Scene(root, 800, 600);
			DetailedInformation_controller.stage = primaryStage;
			// scene.getStylesheets().add(getClass().getResource("application.css").toExternalForm());
			// primaryStage.initStyle(StageStyle.DECORATED);
			primaryStage.setScene(scene);
			primaryStage.setTitle("酒店管理系统");
			primaryStage.show();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	public void initialize(Parent root){
		UserBLService userBlService = new UserController();
		UserVO uvo = userBlService.searchByUserName(userBlService.searchByUserID(/*id=*/400000000));
		
		@SuppressWarnings("unchecked")
		// 查找name
		TextField name = (TextField) root.lookup("#name");
		name.setText(uvo.getName());
		name.setEditable(false);
		
		// 查找phone
		TextField phone = (TextField) root.lookup("#phone");
		phone.setText("phoneCannotGet");
		phone.setEditable(false);
		
		// 查找email
		TextField email = (TextField) root.lookup("#email");
		email.setText("emailCannotGet");
		email.setEditable(false);
		
		// 查找address
		TextField address = (TextField) root.lookup("#address");
		address.setText("addressCannotGet");		
		address.setEditable(false);
		
	}
	
	/*
	 * 初始化DatePicker
	 */
	public void initDatePicker(Parent root) {
		// 查找birth
		DatePicker birth = (DatePicker) root.lookup("#birth");

		StringConverter converter = new StringConverter<LocalDate>() {
			DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);

			@Override
			public String toString(LocalDate date) {
				if (date != null) {
					return dateFormatter.format(date);
				} else {
					return "";
				}
			}

			@Override
			public LocalDate fromString(String string) {
				if (string != null && !string.isEmpty()) {
					return LocalDate.parse(string, dateFormatter);
				} else {
					return null;
				}
			}
		};

		birth.setShowWeekNumbers(true);
		birth.setConverter(converter);
		birth.setPromptText(pattern.toLowerCase());

		birth.setValue(LocalDate.now());//..............
		birth.setEditable(false);
	}

}
