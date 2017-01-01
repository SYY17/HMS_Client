package presentation.userui;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import presentation.alertui.Alert;
import presentation.alertui.Alert.Response;
import presentation.controller.TempIDHelper;
import presentation.controller.UserControllerImpl;

public class SystemUserData {
	private final SimpleStringProperty id = new SimpleStringProperty();
	private final SimpleStringProperty username = new SimpleStringProperty();
	private final SimpleStringProperty identity = new SimpleStringProperty();
	private final SimpleStringProperty view = new SimpleStringProperty();
	private final SimpleStringProperty delete = new SimpleStringProperty();
	
	public SystemUserData(String id, String username, String identity, String view, String delete) {
	// TODO Auto-generated constructor stub
	this.id.set(id);
	this.username.set(username);
	this.identity.set(identity);
	this.view.set(view);
	this.delete.set(delete);
}
	
	/**
	 * 
	 * @return 用户ID
	 */
	public String getId() {
		return id.getValue();
	}
	
	/**
	 * 
	 * @return 用户名
	 */
	public String getUsername() {
		return username.getValue();
	}
	
	/**
	 * 
	 * @return 身份
	 */
	public String getIdentity() {
		return identity.getValue();
	}
	
	/**
	 * 
	 * @return 管理操作
	 */
	public Button getView() {
		Button button = new Button();
		button.setPrefSize(20, 20);
		button.setMaxSize(20, 20);
		button.setMinSize(20, 20);
		button.setCursor(Cursor.HAND);
		button.setBackground(new Background(new BackgroundImage(
				new Image(getClass().getResource("viewinfo.png").toString()), null, null, null, null)));
		button.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				Alert alert = Alert.getInstance();
				Response response = alert.showConfirmDialog(ManageSystemUser_controller.stage, "您是否要管理该用户信息", "管理确认");
				
				if(response == Response.CANCEL){
					return;
				}
				
				try {
					TempIDHelper tempHelper = TempIDHelper.getInstance();
					tempHelper.setID(Integer.valueOf(id.getValue()));
					new CustomerInfo_start().start(ManageSystemUser_controller.stage);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		return button;
	}
	
	/**
	 * 
	 * @return 删除操作
	 */
	public Button getDelete() {
		Button button = new Button();
		button.setPrefSize(20, 20);
		button.setMaxSize(20, 20);
		button.setMinSize(20, 20);
		button.setCursor(Cursor.HAND);
		button.setBackground(new Background(new BackgroundImage(
				new Image(getClass().getResource("deleteuser.png").toString()), null, null, null, null)));
		button.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				Alert alert = Alert.getInstance();
				Response response = alert.showConfirmDialog(ManageSystemUser_controller.stage, "您是否确认删除该用户？", "删除确认");
				
				if(response == Response.CANCEL){
					return;
				}
				
				UserControllerService userController = new UserControllerImpl();
				userController.deleteUser(Integer.valueOf(getId()));
				ManageSystemUser_start.getInstance().refreshTableView();
			}
		});

		return button;
	}


}
