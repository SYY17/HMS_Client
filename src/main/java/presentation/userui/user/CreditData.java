package presentation.userui.user;

import java.sql.Date;
import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

public class CreditData {

	private final StringProperty time;
	private final StringProperty change;

	public CreditData() {
		this(null, 0);
	}

	public CreditData(Date time, int change) {
		this.time = new SimpleStringProperty(time.toString());
		this.change = new SimpleStringProperty(String.valueOf(change));
	}

	public String getHistory() {
		return change.get();
	}

	public void setHistory(String change) {
		this.change.set(change);
	}

	public String getTime() {
		return time.get();
	}

	public void setTime(String time) {
		this.time.set(time);
	}

}
