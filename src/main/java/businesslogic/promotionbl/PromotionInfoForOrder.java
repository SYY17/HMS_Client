package businesslogic.promotionbl;

import java.sql.Timestamp;

import businesslogic.orderbl.PromotionInfo;

public class PromotionInfoForOrder implements PromotionInfo {

	/**
	 * 
	 * @param roomtype,
	 *            roomNumber, hotelName
	 * @return 获得最终订单价格
	 */
	@Override
	public int getFinalPrice(String hotelName, Timestamp setTime, int initialPrice) {
		// TODO Auto-generated method stub
		return 0;
	}

}
