package presentation.userui;

import javafx.beans.property.SimpleStringProperty;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.layout.Background;
import javafx.scene.layout.BackgroundImage;
import presentation.controller.UserNameHelper;
import presentation.creditui.ManageUserCredit_controller;
import presentation.orderui.ManageAbnormalOrderAndCredit_start;

public class UserDataForManageUserCredit {
	private final SimpleStringProperty id = new SimpleStringProperty();
	private final SimpleStringProperty username = new SimpleStringProperty();
	private final SimpleStringProperty start = new SimpleStringProperty();
	private final SimpleStringProperty credit = new SimpleStringProperty();
	private final SimpleStringProperty operation = new SimpleStringProperty();

	public UserDataForManageUserCredit(String id, String username, String start, String credit) {
		// TODO Auto-generated constructor stub
		this.id.set(id);
		this.username.set(username);
		this.start.set(start);
		this.credit.set(credit);
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
	 * @return 创建时间
	 */
	public String getStart() {
		return start.getValue();
	}

	/**
	 * 
	 * @return 信用值
	 */
	public String getCredit() {
		return credit.getValue();
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

		button.setBackground(new Background(new BackgroundImage(
				new Image(getClass().getResource("orderhandle.png").toString()), null, null, null, null)));
		button.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				try {
					UserNameHelper.getInstance().initialUserName(getUsername());
					ManageAbnormalOrderAndCredit_start.getInstance().start(ManageUserCredit_controller.stage);
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
	 * @param id
	 */
	public void setId(String id) {
		this.id.set(id);
	}

	/**
	 * 
	 * @param username
	 */
	public void setUsername(String username) {
		this.username.set(username);
	}

	/**
	 * 
	 * @param start
	 */
	public void setStart(String start) {
		this.start.set(start);
	}

	/**
	 * 
	 * @param credit
	 */
	public void setCredit(String credit) {
		this.credit.set(credit);
	}

	/**
	 * 
	 * @param operation
	 */
	public void setOperation(String operation) {
		this.operation.set(operation);
	}
}
