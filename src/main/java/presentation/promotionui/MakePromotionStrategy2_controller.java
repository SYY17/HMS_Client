package presentation.promotionui;

import java.sql.Date;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;

import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import presentation.alertui.Alert;
import presentation.controller.PromotionControllerImpl;
import presentation.creditui.ManageUserCredit_start;
import presentation.hotelui.hotel.PromotionData;
import presentation.hotelui.hotel.Promotion_start;
import presentation.loginui.LoginUI_start;
import presentation.mainui.SalerUI_start;
import presentation.orderui.ManageAbnormalOrder_start;
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

	private Alert alert;
	
	@FXML
	private void onLogout(MouseEvent event) throws Exception {
		new LoginUI_start().start(stage);
	}

	@FXML
	private void onHomepage(MouseEvent event) throws Exception {
		SalerUI_start.getInstance().start(stage);
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
		ManageAbnormalOrder_start.getInstance().start(stage);
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
			if (promotionType.getValue().equals("满减")) {
				pte = pt[0];
			} else {
				pte = pt[1];
			}

			ArrayList<PromotionVO> promotionList =  promotionController.getAllPromotion(id);
			ArrayList<String> existed = new ArrayList<String>();
			
			for(int i=0; i<promotionList.size();i++){
				existed.add(promotionList.get(i).getPromotionName());
			}
			
			if(existed.contains(name)){
				alert = Alert.getInstance();
				alert.showConfirmDialog(stage, name+" 已经存在！", "增加失败");
			}else{
				promotionController.addPromotion(
						new PromotionVO(name, name+":"+content, time, sp, pte, id));//

				if (pte == PromotionType.FULL_CUT) {
					promotionController.addFullCutPromotion(new FullCutPromotionVO(name, name+":"+content, time, sp, pte,
							id, Double.parseDouble(everyText), Double.parseDouble(cutText)));
				}

				if (pte == PromotionType.DISCOUNT) {
					promotionController.addDiscountPromotion(new DiscountPromotionVO(name, name+":"+content, time, sp, pte,
							id, Double.parseDouble(discountText)/10));
				}
				
				//
				alert = Alert.getInstance();
				alert.showMessageDialog(stage, name+" 增加成功！", "增加成功");
				new Promotion_start().start(stage);
			}
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
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
