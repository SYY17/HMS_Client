package presentation.alertui;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Cursor;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.effect.DropShadow;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.paint.Paint;
import javafx.scene.shape.Rectangle;
import javafx.scene.shape.StrokeType;
import javafx.scene.text.Font;
import javafx.stage.Modality;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

public class Alert {
	
//	static ImageView icon = new ImageView();
	
	private static Alert alert;
	
	private Alert() {
		// TODO Auto-generated constructor stub
	}
	
	public static Alert getInstance(){
		if(alert == null){
			alert = new Alert();
		}
		return alert;
	}
	
	public enum Response {
		YES, CANCEL
	};

	private Response buttonSelected = Response.CANCEL;

	static class Dialog extends Stage {
		public Dialog(String title, Stage owner, Scene scene) {
			setTitle(title);
			initStyle(StageStyle.UTILITY);
			initModality(Modality.APPLICATION_MODAL);
			initOwner(owner);
			setResizable(false);
			setScene(scene);
		}

		public void showDialog() {
			sizeToScene();
			centerOnScreen();
			showAndWait();
		}
	}

	/**
	 * 
	 * @param owner
	 * @param message
	 * @param title
	 * @return 返回用户选择的结果
	 */
	public Response showConfirmDialog(Stage owner, String message, String title) {
		String url = this.getClass().getClassLoader().getResource("presentation/alertui/icon/warning.png").toString();
		Pane root = initiatePane(url, "警告", message);
		Scene scene = new Scene(root);
		final Dialog dialog = new Dialog(title, owner, scene);
		
		
		//确认按钮
		Button confirm = new Button("确认(Y)");
		confirm.setFont(new Font("System Bold", 13.0));
		confirm.setEffect(new DropShadow());
		confirm.setLayoutX(85.0);
		confirm.setLayoutY(181.0);
		confirm.setCursor(Cursor.HAND);
		confirm.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				dialog.close();
				buttonSelected = Response.YES;
			}
		});
		
		//取消按钮
		Button cancel = new Button("取消(C)");
		cancel.setFont(new Font("System Bold", 13.0));
		cancel.setEffect(new DropShadow());
		cancel.setLayoutX(214.0);
		cancel.setLayoutY(181.0);
		cancel.setCursor(Cursor.HAND);
		cancel.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				dialog.close();
				buttonSelected = Response.CANCEL;
			}
		});
		
		//在面板中添加按钮
		root.getChildren().addAll(confirm, cancel);
		
		dialog.showDialog();
		return buttonSelected;
	}

	/**
	 * 
	 * @param owner
	 * @param message
	 * @param title
	 */
	public void showMessageDialog(Stage owner, String message, String title) {
		String url = this.getClass().getClassLoader().getResource("presentation/alertui/icon/error.png").toString();
		Pane root = initiatePane(url, "错误", message);
		Scene scene = new Scene(root);
		final Dialog dialog = new Dialog(title, owner, scene);
		
		//确认按钮
		Button confirm = new Button("确认(Y)");
		confirm.setFont(new Font("System Bold", 13.0));
		confirm.setEffect(new DropShadow());
		confirm.setLayoutX(153.0);
		confirm.setLayoutY(181.0);
		confirm.setCursor(Cursor.HAND);
		confirm.setOnAction(new EventHandler<ActionEvent>() {
			@Override
			public void handle(ActionEvent e) {
				dialog.close();
			}
		});
		
		//在面板中添加按钮
		root.getChildren().add(confirm);
		
		dialog.showDialog();
	}
	
	/**
	 * 
	 * @param url
	 * @param type
	 * @return 初始化的面板
	 */
	private static Pane initiatePane(String url, String type, String message){
		Pane root = new Pane();
		root.setMaxSize(380, 238);
		root.setMinSize(380, 238);
		root.setMaxSize(380, 238);
		
		//背景图案
		ImageView background = new ImageView();
		background.setFitHeight(238);
		background.setFitWidth(380);
		
		//矩形装饰框
		Rectangle border = new Rectangle(355, 205);
		border.setLayoutX(13.0);
		border.setLayoutY(18.0);
		border.setArcWidth(5.0);
		border.setArcHeight(5.0);
		border.setFill(Paint.valueOf("WHITE"));
		border.setStroke(Paint.valueOf("BLACK"));
		border.setStrokeWidth(2.0);
		border.setStrokeType(StrokeType.INSIDE);
		border.setOpacity(0.31);
		border.setEffect(new DropShadow());
		
		//图标
		ImageView icon = new ImageView(url);
		icon.setFitHeight(30.0);
		icon.setFitWidth(30.0);
		icon.setLayoutX(138.0);
		icon.setLayoutY(31.0);
		
		//文字
		Label title = new Label(type);
		title.setLayoutX(173.0);
		title.setLayoutY(29.0);
		title.setFont(new Font("System Bold", 24.0));
		
		//信息域
		TextArea text = new TextArea();
		text.setLayoutX(27.0);
		text.setLayoutY(82.0);
		text.setPrefSize(326, 85);
		text.setMaxSize(326, 85);
		text.setMinSize(326, 85);
		text.setFont(new Font("System Bold", 14.0));
		text.setText(message);
		text.setEditable(false);
		text.setEffect(new DropShadow());
		
		root.getChildren().addAll(background, border, icon, title, text);
		
		return root;
	}
}