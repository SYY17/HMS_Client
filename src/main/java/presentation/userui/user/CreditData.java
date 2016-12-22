package presentation.userui.user;

import java.sql.Date;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;
import vo.CreditMovement;

public class CreditData {

	private final StringProperty time;
	private final StringProperty change;
	private final StringProperty id;
	private final StringProperty creditmovement;
	private final StringProperty remain;

	public CreditData() {
		this(0, null, 0, null, 0);
	}

	public CreditData(int id ,Date time, int change,String creditMovement,int remain) {
		this.time = new SimpleStringProperty(time.toString());
		this.change = new SimpleStringProperty(String.valueOf(change));
		this.id = new SimpleStringProperty(String.valueOf(id));
		this.creditmovement = new SimpleStringProperty(creditMovement);
		this.remain = new SimpleStringProperty(String.valueOf(remain));
	}

	public String getChange() {
		return change.get();
	}

	public void setChange(String change) {
		this.change.set(change);
	}

	public String getTime() {
		return time.get();
	}

	public void setTime(String time) {
		this.time.set(time);
	}
	
	public String getID() {
		return id.get();
	}

	public void setID(String id) {
		this.id.set(id);
	}
	
	public String getCreditMovement() {
		return creditmovement.get();
	}

	public void setCreditMovement(String creditmovement) {
		if(creditmovement.equals(CreditMovement.AbnormalOrder.toString())){
			this.creditmovement.set("异常订单");
		} else if(creditmovement.equals(CreditMovement.AddMoney.toString())){
			this.creditmovement.set("充值操作");
		} else if(creditmovement.equals(CreditMovement.CancelOrder.toString())){
			this.creditmovement.set("取消订单");
		} else if(creditmovement.equals(CreditMovement.ExecuteOrder.toString())){
			this.creditmovement.set("执行订单");
		}
	}

	public String getRemain() {
		return remain.get();
	}

	public void setRemain(String remain) {
		this.remain.set(remain);
	}
}
