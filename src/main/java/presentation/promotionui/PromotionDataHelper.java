package presentation.promotionui;

import presentation.hotelui.hotel.PromotionData;
import vo.PromotionVO;

public class PromotionDataHelper {

	public PromotionData toPromotionData(PromotionVO pvo) {
		return new PromotionData(pvo.getID(), pvo.getPromotionName(), pvo.getStartTime(), pvo.getStopTime(),
				pvo.getContent());
	}
}
