package businesslogic.promotionbl;

import java.sql.Date;

import businesslogic.hotelbl.PromotionInfo;
import vo.PromotionType;

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

	@Override
	public Date getStopTime() {
		// TODO Auto-generated method stub
		return promotionLineItem.getStopTime();
	}

	@Override
	public String getPromotionName() {
		// TODO Auto-generated method stub
		return promotionLineItem.getPromotionName();
	}

	@Override
	public PromotionType getPromotionType() {
		// TODO Auto-generated method stub
		return promotionLineItem.getPromotionType();
	}

}
