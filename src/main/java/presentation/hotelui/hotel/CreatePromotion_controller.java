package presentation.hotelui.hotel;

import java.io.IOException;
import java.sql.Date;
import java.text.SimpleDateFormat;

import businesslogic.promotionbl.PromotionController;
import businesslogicservice.promotionblservice.PromotionBLService;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.ListView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import presentation.loginui.LoginUI_start;
import vo.DiscountPromotionVO;
import vo.FullCutPromotionVO;
import vo.PromotionType;
import vo.PromotionVO;

public class CreatePromotion_controller {

	public static Stage stage;
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

	@FXML
	private void onLogout(MouseEvent event) throws Exception {
		new LoginUI_start().start(stage);
	}

	@FXML
	private void onSubmit(MouseEvent event) throws Exception {
		String name = promotionName.getText();
		String content = description.getText();

		String everyText = every.getText();
		String cutText = cut.getText();
		String discountText = discount.getText();

		Date time = strToDate(startTime.getPromptText());
		Date sp = strToDate(stopTime.getPromptText());

		PromotionType pte;
		if (promotionType.getSelectionModel().equals("FullCut")) {
			pte = pt[0];
		} else {
			pte = pt[1];
		}

		promotionBlService.addPromotion(
				new PromotionVO(name, content, time, sp, pte, /* id = */20902341));//

		if (pte == PromotionType.FULL_CUT) {
			promotionBlService.addFullCutPromotion(new FullCutPromotionVO(name, content, time, sp, pte,
					/* id = */20905098, Double.parseDouble(everyText), Double.parseDouble(cutText)));
		}

		if (pte == PromotionType.DISCOUNT) {
			promotionBlService.addDiscountPromotion(new DiscountPromotionVO(name, content, time, sp, pte,
					/* id = */20905098, Double.parseDouble(discountText)));
		}
	}

	@FXML
	private void onReviewOrderList(ActionEvent event) throws IOException {
		new OrderList_start().start(stage);
	}

	@FXML
	private void onManage(ActionEvent event) throws IOException {
		new Manage_start().start(stage);
	}

	@FXML
	private void onReviewPromotion(ActionEvent event) throws IOException {
		new Promotion_start().start(stage);
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
