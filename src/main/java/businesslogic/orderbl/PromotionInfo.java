package businesslogic.orderbl;

import java.sql.Timestamp;


public interface PromotionInfo {
	/**
	 * 
	 * @param roomtype,
	 *            roomNumber, hotelName
	 * @return 获得最终订单价格
	 */
<<<<<<< HEAD
	public double getFinalPrice(double initialPrice, PromotionVO pvo);
=======
	public int getFinalPrice(String hotelName, Timestamp setTime, int initialPrice);
>>>>>>> origin/master
}
