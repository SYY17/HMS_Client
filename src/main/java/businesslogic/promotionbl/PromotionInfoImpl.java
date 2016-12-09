package businesslogic.promotionbl;

import java.sql.Timestamp;

import businesslogic.hotelbl.HotelController;
import businesslogic.orderbl.PromotionInfo;

public class PromotionInfoImpl implements PromotionInfo {

	/**
	 * 
	 * @param initialPrice
	 * @param hotelName
	 * @param timeStamp
	 * @return 获得最终订单价格
	 */
	@Override
	public int getFinalPrice(String hotelName, Timestamp setTime, int initialPrice) {
		// TODO Auto-generated method stub
		HotelController hc = new HotelController();
		int hotelId = hc.reviewHotelInfo(hotelName).getHotelID();
		PromotionController pc = new PromotionController();
		
		PromotionVO pvo = pc.searchPromotionPresent(hotelId, setTime);
		
		double finalPrice = -1;
		finalPrice = pvo.calculatePayment(initialPrice);
		
		return (int)finalPrice;
	}

}
