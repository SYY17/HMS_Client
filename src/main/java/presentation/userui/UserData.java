package presentation.userui;

import javafx.beans.property.SimpleStringProperty;
import javafx.scene.control.Button;
import javafx.scene.text.Font;

public class UserData {
	private final SimpleStringProperty id = new SimpleStringProperty();
	private final SimpleStringProperty username = new SimpleStringProperty();
	private final SimpleStringProperty identity = new SimpleStringProperty();
	private final SimpleStringProperty start = new SimpleStringProperty();
	private final SimpleStringProperty operation = new SimpleStringProperty();
	
	public UserData(String id, String username, String identity, String start, String operation) {
		// TODO Auto-generated constructor stub
		this.id.set(id);
		this.username.set(username);
		this.identity.set(identity);
		this.start.set(start);
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
	 * @return 创建时间
	 */
	public String getStart() {
		return start.getValue();
	}

	/**
	 * 
	 * @return 操作
	 */
	public Button getOperation() {
		Button button = new Button(operation.getValue());
		button.setFont(new Font(12.0));
		button.setPrefSize(177, 22);
		button.setMinSize(177, 22);
		button.setMaxSize(177, 22);
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
	 * @param start
	 */
	public void setStart(String start){
		this.start.set(start);
	}
	
	/**
	 * 
	 * @param operation
	 */
	public void setOperation(String operation){
		this.operation.set(operation);
	}
}
