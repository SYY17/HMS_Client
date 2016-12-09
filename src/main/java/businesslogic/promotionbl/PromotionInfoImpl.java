package businesslogic.promotionbl;

import java.sql.Timestamp;

import businesslogic.orderbl.PromotionInfo;

public class PromotionInfoImpl implements PromotionInfo {

	/**
	 * 
	 * @param initialPrice
	 * @param hotelName
	 * @param timeStamp
	 * @return 获得最终订单价格
	 */
	/*@Override
	public double getFinalPrice(double initialPrice, PromotionVO pvo) {
		// TODO Auto-generated method stub
		double finalPrice = -1;
		finalPrice = pvo.calculatePayment(initialPrice);
		
		return finalPrice;
	}*/

	@Override
	public int getFinalPrice(String hotelName, Timestamp setTime, int initialPrice) {
		// TODO Auto-generated method stub
		return 0;
	}

}
