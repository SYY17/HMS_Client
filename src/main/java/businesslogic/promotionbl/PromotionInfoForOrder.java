package businesslogic.promotionbl;

import java.sql.Timestamp;

import businesslogic.hotelbl.HotelController;
import businesslogic.orderbl.PromotionInfo;

public class PromotionInfoForOrder implements PromotionInfo {

	/**
	 * 
	 * @param roomtype,
	 *            roomNumber, hotelName
	 * @return 获得最终订单价格
	 */
	@Override
	public int getFinalPrice(int userId, int roomNum, String hotelName, Timestamp setTime, int initialPrice) {
		// TODO Auto-generated method stub
		HotelController hc = new HotelController();
		int hotelId = hc.reviewHotelInfo(hotelName).getHotelID();
		PromotionController pc = new PromotionController();

		double finalPrice = pc.searchPromotionPresent(userId, roomNum, hotelId, setTime, initialPrice);

		return (int) finalPrice;
	}

}
