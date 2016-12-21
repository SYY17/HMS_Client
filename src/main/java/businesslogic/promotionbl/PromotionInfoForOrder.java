package businesslogic.promotionbl;

import java.sql.Timestamp;

import businesslogic.hotelbl.HotelController;
import businesslogic.orderbl.PromotionInfo;
import vo.PromotionVO;

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

		PromotionVO pvo = pc.searchPromotionPresent(userId, roomNum, hotelId, setTime);

		if(pvo==null){
			return initialPrice;
		}
		
		double finalPrice;
		finalPrice = pvo.calculatePayment(initialPrice);

		return (int) finalPrice;
	}

}
