package presentation.hotelui.hotel;

import java.sql.Date;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;

public class PromotionData {
	
	private final SimpleIntegerProperty promotionID = new SimpleIntegerProperty();
	private final SimpleStringProperty promotionDate = new SimpleStringProperty();
	private final SimpleStringProperty promotionContent = new SimpleStringProperty();
	
	public PromotionData(int promotionID,Date promotionDate,String promotionContent){
		this.promotionID.set(promotionID);
		this.promotionDate.set(promotionDate.toString());
		this.promotionContent.set(promotionContent);
	}
	

	public int getPromotionID() {
		return promotionID.get();
	}

	public void setPromotionID(int promotionID) {
		this.promotionID.set(promotionID);
	}
	
	public String getPromotionDate() {
		return promotionDate.get();
	}

	public void setPromotionDate(Date promotionDate) {
		this.promotionDate.set(promotionDate.toString());
	}
	
	public String getPromotionContent() {
		return promotionContent.get();
	}

	public void setPromotionContent(String promotionContent) {
		this.promotionContent.set(promotionContent);
	}
}
