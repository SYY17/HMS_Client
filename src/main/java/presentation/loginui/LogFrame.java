package presentation.loginui;

import java.io.IOException;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.ChoiceBox;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.effect.DropShadow;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Font;
import javafx.stage.Stage;
import presentation.mainui.Hotel_start;
import presentation.mainui.Manager_start;
import presentation.mainui.Saler_start;
import presentation.mainui.User_start;

public class LogFrame extends Application {

	Pane login;
	Pane register;
	Stage stage;
	
	@Override
	public void start(Stage primaryStage) throws IOException {
		stage = primaryStage;
		Pane root = new Pane();
		root.setId("panel_log");
		Scene scene = new Scene(root, 800, 600);
		scene.getStylesheets().add(this.getClass().getResource("logFrame.css").toExternalForm());
		
		//title
		Label label = new Label("酒店管理系统");
		label.setLayoutX(315.0);
		label.setLayoutY(59.0);
		label.setFont(new Font(30.0));
		label.setId("label_title");
		root.getChildren().add(label);
		
		//rect_Big
		Rectangle rectBig = new Rectangle();
		root.getChildren().add(rectBig);
		rectBig.setArcHeight(5.0);
		rectBig.setArcWidth(5.0);
		rectBig.setFill(Paint.valueOf("#cfd6dd"));
		rectBig.setHeight(400.0);
		rectBig.setWidth(706.0);
		rectBig.setLayoutX(45.0);
		rectBig.setLayoutY(145.0);
		rectBig.setStrokeWidth(2.0);
		rectBig.setEffect(new DropShadow());
		
		//body_Panel
		Pane body = new Pane();
		root.getChildren().add(body);
		body.setLayoutX(93.0);
		body.setLayoutY(151.0);
		body.prefHeight(123.0);
		body.prefWidth(159.0);
		body.setId("panel_body");
		
		//login_Panel
		login = this.initialLoginPane();
		
		//choose_Type
		Label choose = new Label("请选择操作类型");
		body.getChildren().add(choose);
		choose.setLayoutX(-6.0);
		choose.setLayoutY(14.0);
		choose.setFont(new Font(14.0));
		
		//type
		ChoiceBox <String> type = new ChoiceBox<>();
		type.setCursor(Cursor.HAND);
		body.getChildren().add(type);
		type.setLayoutX(7.0);
		type.setLayoutY(48.0);
		type.prefHeight(23.0);
		type.prefWidth(79.0);
		type.setItems(FXCollections.observableArrayList("登录", "注册"));
		type.setValue("登录");
		type.setOnAction(new EventHandler<ActionEvent>() {

			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				if(type.getValue().equals("注册")){
					root.getChildren().remove(login);
					register = initialRegisterPane();
					root.getChildren().add(register);
				}else{
					root.getChildren().remove(register);
					login = initialLoginPane();
					root.getChildren().add(login);
				}
			}
			
		});
		type.setEffect(new DropShadow());
		type.setId("choicebox_type");
		
		//rect_Small
		Rectangle rectSmall = new Rectangle();
		root.getChildren().add(rectSmall);
		rectSmall.setArcHeight(5.0);
		rectSmall.setArcWidth(5.0);
		rectSmall.setFill(Paint.valueOf("#eef2f5"));
		rectSmall.setHeight(324.0);
		rectSmall.setWidth(539.0);
		rectSmall.setLayoutX(169.0);
		rectSmall.setLayoutY(190.0);
		rectSmall.setStrokeWidth(2.0);
		rectSmall.setEffect(new DropShadow());
		
		root.getChildren().add(login);
//		primaryStage.initStyle(StageStyle.DECORATED);
		primaryStage.setTitle("欢迎使用酒店管理系统");
		primaryStage.setScene(scene);
		primaryStage.show();
	}
	
	private Pane initialLoginPane(){
		//login_Panel
		Pane login = new Pane();
		login.setLayoutX(173.0);
		login.setLayoutY(208.0);
		login.prefHeight(184.0);
		login.prefWidth(361.0);
		login.setId("panel_login");
		
		//label_Id
		Label type = new Label("请选择用户类型");
		login.getChildren().add(type);
		type.setLayoutX(65.0);
		type.setLayoutY(10.0);
		type.setFont(new Font(14.0));
		
		//identity
		ChoiceBox <String> id = new ChoiceBox<>();
		id.setCursor(Cursor.HAND);
		login.getChildren().add(id);
		id.setLayoutX(181.0);
		id.setLayoutY(10.0);
		id.prefHeight(23.0);
		id.prefWidth(79.0);
		id.setItems(FXCollections.observableArrayList("客户", "酒店工作人员", "网站营销人员", "网站管理人员"));
		id.setValue("客户");
		id.setEffect(new DropShadow());
		id.setId("choicebox_id");
		
		//Label_Name
		Label name = new Label("用户名");
		login.getChildren().add(name);
		name.setLayoutX(121.0);
		name.setLayoutY(59.0);
		name.setFont(new Font(14.0));
		
		//TextField_Name
		TextField nameField = new TextField();
		login.getChildren().add(nameField);
		nameField.setLayoutX(181.0);
		nameField.setLayoutY(57.0);
		nameField.setCursor(Cursor.HAND);
		nameField.setEffect(new DropShadow());
		nameField.setId("input");
		
		//Label_Password
		Label password = new Label("密码");
		login.getChildren().add(password);
		password.setLayoutX(135.0);
		password.setLayoutY(106.0);
		password.setFont(new Font(14.0));
		
		//PasswordField_Password
		PasswordField passwordField = new PasswordField();
		login.getChildren().add(passwordField);
		passwordField.setLayoutX(181.0);
		passwordField.setLayoutY(104.0);
		passwordField.setCursor(Cursor.HAND);
		passwordField.setEffect(new DropShadow());
		passwordField.setId("input");
		
		//Button_login
		Button loginButton = new Button("登录");
		login.getChildren().add(loginButton);
		loginButton.setMnemonicParsing(false);
		loginButton.setLayoutX(207.0);
		loginButton.setLayoutY(151.0);
		loginButton.setPrefHeight(29.0);
		loginButton.setPrefWidth(64.0);
		loginButton.setFont(new Font(14.0));
		loginButton.setCursor(Cursor.HAND);
		loginButton.setEffect(new DropShadow());
		loginButton.setId("button_login");
		loginButton.setOnAction(new EventHandler<ActionEvent>() {
			
			@Override
			public void handle(ActionEvent event) {
				// TODO Auto-generated method stub
				String i = id.getValue();
				if(i.equals("网站管理人员")){
					new Manager_start().start(stage);
				}else if(i.equals("网站营销人员")){
					new Saler_start().start(stage);
				}else if(i.equals("酒店工作人员")){
					new Hotel_start().start(stage);
				}else{
					new User_start().start(stage);
				}
			}
		});
		
		return login;
	}
	
	private Pane initialRegisterPane(){
		//register_Panel
		Pane register = new Pane();
		register.setLayoutX(173.0);
		register.setLayoutY(208.0);
		register.prefHeight(184.0);
		register.prefWidth(361.0);
		register.setId("panel_register");
		
		//label_Id
		Label type = new Label("请选择用户类型");
		register.getChildren().add(type);
		type.setLayoutX(65.0);
		type.setLayoutY(10.0);
		type.setFont(new Font(14.0));
		
		//identity
		ChoiceBox <String> id = new ChoiceBox<>();
		id.setCursor(Cursor.HAND);
		register.getChildren().add(id);
		id.setLayoutX(181.0);
		id.setLayoutY(10.0);
		id.prefHeight(23.0);
		id.prefWidth(79.0);
		id.setItems(FXCollections.observableArrayList("客户", "酒店工作人员", "网站营销人员", "网站管理人员"));
		id.setValue("客户");
		id.setEffect(new DropShadow());
		id.setId("choicebox_id");
		
		//Label_Name
		Label name = new Label("用户名");
		register.getChildren().add(name);
		name.setLayoutX(121.0);
		name.setLayoutY(57.0);
		name.setFont(new Font(14.0));
		
		//TextField_Name
		TextField nameField = new TextField();
		register.getChildren().add(nameField);
		nameField.setLayoutX(181.0);
		nameField.setLayoutY(57.0);
		nameField.setCursor(Cursor.HAND);
		nameField.setEffect(new DropShadow());
		nameField.setId("input");
		
		//Label_Password
		Label password = new Label("密码");
		register.getChildren().add(password);
		password.setLayoutX(135.0);
		password.setLayoutY(104.0);
		password.setFont(new Font(14.0));
		
		//PasswordField_Password
		PasswordField passwordField = new PasswordField();
		register.getChildren().add(passwordField);
		passwordField.setLayoutX(181.0);
		passwordField.setLayoutY(103.0);
		passwordField.setCursor(Cursor.HAND);
		passwordField.setEffect(new DropShadow());
		passwordField.setId("input");
		
		//Label_PasswordConfirm
		Label passwordConfirm = new Label("密码确认");
		register.getChildren().add(passwordConfirm);
		passwordConfirm.setLayoutX(107.0);
		passwordConfirm.setLayoutY(151.0);
		passwordConfirm.setFont(new Font(14.0));
		
		//PasswordField_PasswordConfirm
		PasswordField passwordConfirmField = new PasswordField();
		register.getChildren().add(passwordConfirmField);
		passwordConfirmField.setLayoutX(181.0);
		passwordConfirmField.setLayoutY(151.0);
		passwordConfirmField.setCursor(Cursor.HAND);
		passwordConfirmField.setEffect(new DropShadow());
		passwordConfirmField.setId("input");
		
		//Button_register
		Button registerButton = new Button("注册");
		register.getChildren().add(registerButton);
		registerButton.setMnemonicParsing(false);
		registerButton.setLayoutX(207.0);
		registerButton.setLayoutY(196.0);
		registerButton.setPrefHeight(29.0);
		registerButton.setPrefWidth(64.0);
		registerButton.setFont(new Font(14.0));
		registerButton.setCursor(Cursor.HAND);
		registerButton.setEffect(new DropShadow());
		registerButton.setId("button_register");
		
		return register;
	}

	public static void main(String[] args) {
		launch(args);
	}
}
