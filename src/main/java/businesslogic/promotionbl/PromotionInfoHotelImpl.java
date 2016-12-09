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
		return converse(promotionLineItem.getPromotionType());
	}

	public vo.PromotionType converse(po.PromotionType pt){
		vo.PromotionType pp = vo.PromotionType.FULL_CUT;
		
		if(pt == po.PromotionType.FULL_CUT){
			pp = vo.PromotionType.FULL_CUT;
		}else if(pt == po.PromotionType.DISCOUNT){
			pp = vo.PromotionType.DISCOUNT;
		}
		
		return pp;
	}
	
	public po.PromotionType converse(vo.PromotionType pt){
		po.PromotionType pp = po.PromotionType.FULL_CUT;
		
		if(pt == vo.PromotionType.FULL_CUT){
			pp = po.PromotionType.FULL_CUT;
		}else if(pt == vo.PromotionType.DISCOUNT){
			pp = po.PromotionType.DISCOUNT;
		}
		
		return pp;
	}
}
