package businesslogic.promotionbl;

import java.sql.Date;

import businesslogic.hotelbl.PromotionInfo;

public class PromotionInfoHotelImpl implements PromotionInfo{

	PromotionLineItem promotionLineItem;

	@Override
	public String getContent() {
		// TODO Auto-generated method stub
		return promotionLineItem.getContent();
	}

	@Override
	public Date getStartTime() {
		// TODO Auto-generated method stub
		return promotionLineItem.getStartTime();
	}

}
