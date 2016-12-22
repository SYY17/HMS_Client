package presentation.hotelui.hotel;


import java.io.IOException;

import businesslogicservice.ResultMessage;
import javafx.fxml.FXML;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import presentation.controller.HotelControllerImpl;
import presentation.controller.IDHelper;
import presentation.hotelui.HotelControllerService;
import presentation.loginui.LoginUI_start;
import presentation.mainui.HotelUI_start;
import vo.RoomType;
import vo.RoomVO;

public class Room_controller {
	
	public static Stage stage;
	public ChoiceBox<String> typeChoice;
	public TextField remainText;
	public TextField totalText;
	public TextField priceText;
	public TableView<RoomData> roomView;
	
	@FXML
	private void onMain(MouseEvent event) throws IOException {
		new HotelUI_start().start(stage);
	}
	
	@FXML
	private void onLogout(MouseEvent event) throws Exception {
		new LoginUI_start().start(stage);
	}
	
	@FXML
	private void onUpdate(MouseEvent event){
		int hotelID = IDHelper.getInstance().getID();
			
		RoomType type = null;
		if (typeChoice.getValue().equals("单人间")) {
			type = RoomType.SINGLE_ROOM;
		} else if (typeChoice.getValue().equals("标准间")){
			type = RoomType.STANDARD_ROOM;
		} else if (typeChoice.getValue().equals("套间")){
			type = RoomType.SUITE;
		}else if (typeChoice.getValue().equals("三人间")){
			type = RoomType.TRIPLE_ROOM;
		}else if (typeChoice.getValue().equals("总统套房")){
			type = RoomType.KING_SIZE_ROOM;
		}
		
		
		//RoomType type = typeChoice.getValue();
		System.out.println(type);
		
		int remainSum = Integer.parseInt(remainText.getText());
		int totalSum = Integer.parseInt(totalText.getText());
		int price = Integer.parseInt(priceText.getText());
		if(type!=null){
			HotelControllerService hotelController = new HotelControllerImpl();
			RoomVO rvo = new RoomVO(hotelID, type, totalSum, remainSum, price);
			ResultMessage result = hotelController.modifyRoom(rvo);
		
			if(result == ResultMessage.TRUE){
				//JOptionPane.showMessageDialog(null, "更新成功", "提示", JOptionPane.PLAIN_MESSAGE);
				/*
				 * 提示更新成功
				 */
				new Room_start().start(stage);
			}else{
				/*
				 * 提示更新失败
				 */
			}
		}else{
			/*
			 *提示需要填写完整才能更新 
			 */
		}

	}
	
	
	
	@FXML
	private void onReviewOrderList(MouseEvent event) throws IOException {
		new OrderList_start().start(stage);
	}
	
	@FXML
	private void onManage(MouseEvent event) throws IOException {
		new Manage_start().start(stage);
	}
	
	@FXML
	private void onReviewPromotion(MouseEvent event) throws IOException {
		new Promotion_start().start(stage);
	}
}

