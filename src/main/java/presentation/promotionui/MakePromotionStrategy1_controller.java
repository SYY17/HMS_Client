package presentation.promotionui;

import java.io.IOException;
import java.util.ArrayList;
import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;

import businesslogic.promotionbl.PromotionController;
import businesslogicservice.promotionblservice.PromotionBLService;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.DateCell;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Separator;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;
import javafx.util.Callback;
import javafx.util.StringConverter;
import presentation.creditui.ManageUserCredit1_start;
import presentation.hotelui.hotel.PromotionData;
import presentation.loginui.LogFrame;
import presentation.mainui.Saler_start;
import presentation.orderui.ManageAbnormalOrder1_start;
import vo.DiscountPromotionVO;
import vo.FullCutPromotionVO;
import vo.PromotionType;
import vo.PromotionVO;

public class MakePromotionStrategy1_controller {

	public static Stage stage;
	private final ObservableList<PromotionData> data = FXCollections.observableArrayList();
	
	public PromotionBLService promotionBlService = new PromotionController();
	
	public TableView<PromotionData> promotionTableView;
	public TextArea description;
	public TextField promotionName;
	
	private final String pattern = "yyyy-MM-dd";
	DatePicker startTime;
	DatePicker stopTime;
	
	public TextField every;
	public TextField cut;
	public ChoiceBox<Object> promotionType;
	public TextField discount;
	
	

	@FXML
	private void onLogout(ActionEvent event) throws IOException {
		new LogFrame().start(stage);
	}
	
	@FXML
	private void onReturn(ActionEvent event) throws IOException {
		new Saler_start().start(stage);
	}
	
	@FXML
    private void initialize() {
		data.clear();
		ObservableList<TableColumn<PromotionData, ?>> observableList = promotionTableView.getColumns();
		
		observableList.get(0).setCellValueFactory(new PropertyValueFactory<>("promotionID"));
		observableList.get(1).setCellValueFactory(new PropertyValueFactory<>("promotionName"));
		observableList.get(2).setCellValueFactory(new PropertyValueFactory<>("promotionDate"));
		observableList.get(3).setCellValueFactory(new PropertyValueFactory<>("promotionStop"));
		observableList.get(4).setCellValueFactory(new PropertyValueFactory<>("promotionContent"));
		
		ArrayList<PromotionVO> promotionList = promotionBlService.getAllPromotion(/* id = */20905098);
		for(int i=0;i<promotionList.size();i++){
			PromotionVO pvo = promotionList.get(i);
			data.add(new PromotionData( pvo.getID(), pvo.getPromotionName(), pvo.getStartTime(), pvo.getStopTime(), pvo.getContent()));//
		}
		
		promotionTableView.setItems(data);
	}
	
	
	/*
	 * 初始化ChoiceBox
	 */
	public PromotionType initChoiceBox(){
		    promotionType.setItems(FXCollections.observableArrayList( "FullCut", "Discount"));  
		    final PromotionType [] pt = { PromotionType.FULL_CUT, PromotionType.DISCOUNT};  
		    
		    if(promotionType.getSelectionModel().equals("FullCut")){
		    	return pt[0];
		    }else{
		    	return pt[1];
		    }
		    /*promotionType.getSelectionModel().selectedIndexProperty().addListener((ov,oldv,newv)->{    
	            return pt[newv.intValue()];  
	        }); */ 
	}
	
	/*
	 * 初始化DatePicker
	 */
	public void initDatePicker(){
		
		StringConverter converter = new StringConverter<LocalDate>() {
			DateTimeFormatter dateFormatter = 
					DateTimeFormatter.ofPattern(pattern);
			
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
	        
	        startTime.setShowWeekNumbers(true);
	        startTime.setConverter(converter);
	        startTime.setPromptText(pattern.toLowerCase());
	        
	        stopTime.setShowWeekNumbers(true);
	        stopTime.setConverter(converter);
	        stopTime.setPromptText(pattern.toLowerCase());
	        
	        startTime.setValue(LocalDate.now());
	        
		final Callback<DatePicker, DateCell> dayCellFactory = 
				new Callback<DatePicker, DateCell>() {
			          @Override
	                  public DateCell call(final DatePicker datePicker) {
	                      return new DateCell() {
	                          @Override
	                          public void updateItem(LocalDate item, boolean empty) {
	                              super.updateItem(item, empty);

	                              if (item.isBefore(
	                                      startTime.getValue().plusDays(1))
	                                  ) {
	                                      setDisable(true);
	                                      setStyle("-fx-background-color: #ffc0cb;");
	                              }   
	                      }
	                  };
	              }
	          };
	          stopTime.setDayCellFactory(dayCellFactory);
	          stopTime.setValue(startTime.getValue().plusDays(1));
	}
	
	/*
	 * 具体该策略的开始时间以及编号的赋予需要补充
	 */
	@FXML
	private void onSubmit(ActionEvent event) throws Exception {
		String name = promotionName.getText();
		String content = description.getText();
		
		String everyText = every.getText();
		String cutText = cut.getText();
		String discountText = discount.getText();
		initDatePicker();
	
		Date time = strToDate(startTime.getPromptText());
		Date sp = strToDate(stopTime.getPromptText());
		
		PromotionType pt = initChoiceBox();
	
		promotionBlService.addPromotion(new PromotionVO( name, content ,time, sp, pt, /* id = */20905098));//

		if(pt ==PromotionType.FULL_CUT){
			promotionBlService.addFullCutPromotion(new FullCutPromotionVO( name, content, time, sp, pt, /* id = */20905098, Double.parseDouble(everyText), Double.parseDouble(cutText)));
		}
		
		if(pt ==PromotionType.DISCOUNT){
			promotionBlService.addDiscountPromotion(new DiscountPromotionVO( name, content, time, sp, pt, /* id = */20905098, Double.parseDouble(discountText)));
		}
	}
	
	@FXML
	private void onOrderManage(ActionEvent event) throws Exception {
		new ManageAbnormalOrder1_start().start(stage);
	}
	
	@FXML
	private void onPromotionManage(ActionEvent event) throws Exception {
		new MakePromotionStrategy1_start().start(stage);
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
	
	public Date strToDate(String strDate){
		String str = strDate;
		SimpleDateFormat format = new SimpleDateFormat("yyyy-mm-dd"); 
		java.util.Date d = null;  
		
		try{
			d = format.parse(str);
		}catch(Exception e){
			e.printStackTrace();
		}
		
		Date date = new Date(d.getTime());
		return date;
	}
}
