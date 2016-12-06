package presentation.userui;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import presentation.controller.UserControllerImpl;

public class SystemUserData {
	private final SimpleStringProperty id = new SimpleStringProperty();
	private final SimpleStringProperty username = new SimpleStringProperty();
	private final SimpleStringProperty identity = new SimpleStringProperty();
	private final SimpleStringProperty operation = new SimpleStringProperty();
	
	public SystemUserData(String id, String username, String identity, String operation) {
		// TODO Auto-generated constructor stub
		this.id.set(id);
		this.username.set(username);
		this.identity.set(identity);
		this.operation.set(operation);
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
	 * @return 操作
	 */
	public Button getOperation() {
		Button button = new Button();
		button.setPrefSize(20, 20);
		button.setMaxSize(20, 20);
		button.setMinSize(20, 20);
		button.setCursor(Cursor.HAND);
		button.setBackground(new Background(new BackgroundImage(new Image(getClass().getResource("deleteuser.png").toString()), null, null, null, null)));
		button.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				UserControllerService userController = new UserControllerImpl();
				userController.deleteUser(Integer.valueOf(getId()));
			}
		});
		
		return button;
	}
	
	/**
	 * 
	 * @param id
	 */
	public void setId(String id){
		this.id.set(id);
	}
	
	/**
	 * 
	 * @param username
	 */
	public void setUsername(String username){
		this.username.set(username);
	}
	
	/**
	 * 
	 * @param identity
	 */
	public void setIdentity(String identity){
		this.identity.set(identity);
	}
	
	/**
	 * 
	 * @param operation
	 */
	public void setOperation(String operation){
		this.operation.set(operation);
	}
	
}
