package businesslogic.orderbl;

import java.sql.Timestamp;


public interface PromotionInfo {
	/**
	 * 
	 * @param roomtype,
	 *            roomNumber, hotelName
	 * @return 获得最终订单价格
	 */
	public int getFinalPrice(String hotelName, Timestamp setTime, int initialPrice);
}
