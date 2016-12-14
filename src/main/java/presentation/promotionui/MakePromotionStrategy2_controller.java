package presentation.promotionui;

import java.sql.Date;
import java.text.SimpleDateFormat;
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
import presentation.creditui.ManageUserCredit1_start;
import presentation.hotelui.hotel.PromotionData;
import presentation.loginui.LoginUI_start;
import presentation.mainui.SalerUI_start;
import presentation.orderui.ManageAbnormalOrder1_start;
import vo.DiscountPromotionVO;
import vo.FullCutPromotionVO;
import vo.PromotionType;
import vo.PromotionVO;

public class MakePromotionStrategy2_controller {

	public static Stage stage;
	public static int id;
	
	public PromotionBLService promotionBlService = new PromotionController();
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
		new ManageUserCredit1_start().start(stage);
	}

	@FXML
	private void onManageAbnormalOrder(MouseEvent event) throws Exception {
		new ManageAbnormalOrder1_start().start(stage);
	}


	/*
	 * 具体该策略的开始时间以及编号的赋予需要补充
	 */
	@FXML
	private void onSubmit(MouseEvent event) throws Exception {
		String name = promotionName.getText();
		String content = description.getText();

		String everyText = every.getText();
		String cutText = cut.getText();
		String discountText = discount.getText();
		/*
		System.out.println("HHH");
		LocalDate lc = startTime.getValue();
		DateTimeFormatter fmt = DateTimeFormat.forPattern("yyyy-mm-dd");
		String formattedDate = lc.toString(fmt);
		System.out.println(startTime);
		System.out.println("HHH");
*/
		Date time = strToDate(startTime.getPromptText());
		Date sp = strToDate(stopTime.getPromptText());

		PromotionType pte;
		if (promotionType.getSelectionModel().equals("FullCut")) {
			pte = pt[0];
		} else {
			pte = pt[1];
		}

		promotionBlService.addPromotion(
				new PromotionVO(name, content, time, sp, pte, id));//

		if (pte == PromotionType.FULL_CUT) {
			promotionBlService.addFullCutPromotion(new FullCutPromotionVO(name, content, time, sp, pte,
					/* id = */20905098, Double.parseDouble(everyText), Double.parseDouble(cutText)));
		}

		if (pte == PromotionType.DISCOUNT) {
			promotionBlService.addDiscountPromotion(new DiscountPromotionVO(name, content, time, sp, pte,
					/* id = */20905098, Double.parseDouble(discountText)/10));
		}
	}

	@FXML
	private void onOrderManage(ActionEvent event) throws Exception {
		new ManageAbnormalOrder1_start().start(stage);
	}

	@FXML
	private void onPromotionManage(ActionEvent event) throws Exception {
		new MakePromotionStrategy2_start().start(stage);
	}

	@FXML
	private void onCreditManage(ActionEvent event) throws Exception {
		new ManageUserCredit1_start().start(stage);
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
