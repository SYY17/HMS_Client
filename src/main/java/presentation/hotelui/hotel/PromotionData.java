package presentation.hotelui.hotel;

import java.sql.Date;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class PromotionData {
	
	private final SimpleIntegerProperty promotionID = new SimpleIntegerProperty();
	private final SimpleStringProperty promotionName = new SimpleStringProperty();
	private final SimpleStringProperty promotionDate = new SimpleStringProperty();
	private final SimpleStringProperty promotionStop = new SimpleStringProperty();
	private final SimpleStringProperty promotionContent = new SimpleStringProperty();
	
	public PromotionData( int promotionID, String promotionName, Date promotionDate, Date promotionStop, String promotionContent){
		this.promotionID.set(promotionID);
		this.promotionName.set(promotionName);
		this.promotionDate.set(promotionDate.toString());
		this.promotionStop.set(promotionStop.toString());
		this.promotionContent.set(promotionContent);
	}
	

	public int getPromotionID() {
		return promotionID.get();
	}

	public void setPromotionID(int promotionID) {
		this.promotionID.set(promotionID);
	}
	
	public String getPromotionName() {
		return promotionName.get();
	}

	public void setPromotionName(String promotionName) {
		this.promotionName.set(promotionName);
	}
	
	public String getPromotionDate() {
		return promotionDate.get();
	}

	public void setPromotionDate(Date promotionDate) {
		this.promotionDate.set(promotionDate.toString());
	}
	
	public String getPromotionStop() {
		return promotionStop.get();
	}

	public void setPromotionStop(Date promotionStop) {
		this.promotionStop.set(promotionStop.toString());
	}
	
	public String getPromotionContent() {
		return promotionContent.get();
	}

	public void setPromotionContent(String promotionContent) {
		this.promotionContent.set(promotionContent);
	}
}
