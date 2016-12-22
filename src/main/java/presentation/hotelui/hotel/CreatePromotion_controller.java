package presentation.hotelui.hotel;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import businesslogic.promotionbl.PromotionController;
import businesslogicservice.promotionblservice.PromotionBLService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import presentation.alertui.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import presentation.loginui.LoginUI_start;
import presentation.mainui.HotelUI_start;
import vo.DiscountPromotionVO;
import vo.FullCutPromotionVO;
import vo.PromotionType;
import vo.PromotionVO;

public class CreatePromotion_controller {

	public static Stage stage;
	public static int id;
	
	public PromotionBLService promotionBlService = new PromotionController();
	@FXML
	public ListView<String> promotionListView;
	@FXML
	public TextArea description;
	@FXML
	public TextField promotionName;

	@FXML
	DatePicker startTime;
	@FXML
	DatePicker stopTime;
	@FXML
	public TextField every;
	@FXML
	public TextField cut;
	@FXML
	public ChoiceBox<Object> promotionType;
	PromotionType[] pt = { PromotionType.FULL_CUT, PromotionType.DISCOUNT };
	@FXML
	public TextField discount;
	
	private Alert alert;

	@FXML
	private void onLogout(MouseEvent event) throws Exception {
		new LoginUI_start().start(stage);
	}

	@FXML
	private void onSubmit(MouseEvent event) throws Exception {
		Date time;
		Date sp;
		
		LocalDate startIns = startTime.getValue();
		LocalDate stopIns = stopTime.getValue();
		String pattern = "yyyy-MM-dd";
		DateTimeFormatter dateFormatter = DateTimeFormatter.ofPattern(pattern);
		String startday = dateFormatter.format(startIns);
		String stopday = dateFormatter.format(stopIns);
		SimpleDateFormat format = new SimpleDateFormat(pattern);
		java.util.Date date1;
		java.util.Date date2;
		try {
			date1 = format.parse(startday);
			date2 = format.parse(stopday);
			time = new Date(date1.getTime());
			sp = new Date(date2.getTime());
			
			String name = promotionName.getText();
			String content = description.getText();

			String everyText = every.getText();
			String cutText = cut.getText();
			String discountText = discount.getText();
			
			PromotionType pte;
			if (promotionType.getValue().equals("满减")) {
				pte = pt[0];
			} else {
				pte = pt[1];
			}

			promotionBlService.addPromotion(
					new PromotionVO(name, name+":"+content, time, sp, pte, id));//

			if (pte == PromotionType.FULL_CUT) {
				promotionBlService.addFullCutPromotion(new FullCutPromotionVO(name, name+":"+content, time, sp, pte,
						id, Double.parseDouble(everyText), Double.parseDouble(cutText)));
			}

			if (pte == PromotionType.DISCOUNT) {
				promotionBlService.addDiscountPromotion(new DiscountPromotionVO(name, name+":"+content, time, sp, pte,
						id, Double.parseDouble(discountText)/10));
			}
			
			//
			alert = Alert.getInstance();
			alert.showMessageDialog(stage, name+" 增加成功！", "增加成功");
			new Promotion_start().start(stage);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	private void onHomepage(MouseEvent event) throws Exception {
		new HotelUI_start().start(stage);
	}
	
	@FXML
	private void onOrderManage(MouseEvent event) throws Exception {
		new OrderList_start().start(stage);
	}
	
	@FXML
	private void onPromotionManage(MouseEvent event) throws Exception {
		new Promotion_start().start(stage);
	}
	
	@FXML
	private void onHotelManage(MouseEvent event) throws Exception {
		new Manage_start().start(stage);
	}

	 
	public Date strToDate(String strDate) {
		String str = strDate;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd");
		java.util.Date d = null;

		try {
			d = format.parse(str);
		} catch (Exception e) {
			e.printStackTrace();
		}

		Date date = new Date(d.getTime());
		return date;
	}

}
