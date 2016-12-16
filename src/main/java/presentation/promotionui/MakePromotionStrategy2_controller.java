package presentation.promotionui;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import businesslogic.promotionbl.PromotionController;
import businesslogicservice.promotionblservice.PromotionBLService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import presentation.controller.PromotionControllerImpl;
import presentation.controller.UserControllerImpl;
import presentation.creditui.ManageUserCredit_start;
import presentation.hotelui.hotel.PromotionData;
import presentation.loginui.LoginUI_start;
import presentation.mainui.SalerUI_start;
import presentation.orderui.ManageAbnormalOrder_start;
import presentation.userui.UserControllerService;
import vo.DiscountPromotionVO;
import vo.FullCutPromotionVO;
import vo.PromotionType;
import vo.PromotionVO;

public class MakePromotionStrategy2_controller {

	public static Stage stage;
	public static int id;
	
	//public PromotionBLService promotionBlService = new PromotionController();
	@FXML
	public TableView<PromotionData> promotionTableView;
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
	final PromotionType[] pt = { PromotionType.FULL_CUT, PromotionType.DISCOUNT };
	@FXML
	public TextField discount;

	@FXML
	private void onLogout(MouseEvent event) throws Exception {
		new LoginUI_start().start(stage);
	}

	@FXML
	private void onHomepage(MouseEvent event) throws Exception {
		new SalerUI_start().start(stage);
	}

	@FXML
	private void onMakePromotionStrategy(MouseEvent event) throws Exception {
		new MakePromotionStrategy1_start().start(stage);
	}

	@FXML
	private void onManageCredit(MouseEvent event) throws Exception {
		new ManageUserCredit_start().start(stage);
	}

	@FXML
	private void onManageAbnormalOrder(MouseEvent event) throws Exception {
		new ManageAbnormalOrder_start().start(stage);
	}


	
	/*
	 * 具体该策略的开始时间以及编号的赋予需要补充
	 */
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
			PromotionControllerService promotionController = new PromotionControllerImpl();
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
			if (promotionType.getValue().equals("FullCut")) {
				pte = pt[0];
			} else {
				pte = pt[1];
			}

			promotionController.addPromotion(
					new PromotionVO(name, content, time, sp, pte, id));//
/*
			if (pte == PromotionType.FULL_CUT) {
				promotionBlService.addFullCutPromotion(new FullCutPromotionVO(name, content, time, sp, pte,
						id, Double.parseDouble(everyText), Double.parseDouble(cutText)));
			}

			if (pte == PromotionType.DISCOUNT) {
				promotionBlService.addDiscountPromotion(new DiscountPromotionVO(name, content, time, sp, pte,
						id, Double.parseDouble(discountText)/10));
			}*/
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	@FXML
	private void onOrderManage(ActionEvent event) throws Exception {
		new ManageAbnormalOrder_start().start(stage);
	}

	@FXML
	private void onPromotionManage(ActionEvent event) throws Exception {
		new MakePromotionStrategy2_start().start(stage);
	}

	@FXML
	private void onCreditManage(ActionEvent event) throws Exception {
		new ManageUserCredit_start().start(stage);
	}

	@FXML
	private void onAbout(ActionEvent event) throws Exception {
		Alert alert = new Alert(Alert.AlertType.INFORMATION);
		alert.setHeaderText("据说这是大作业");
		alert.showAndWait();
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
