package businesslogic.promotionbl;

import businesslogic.orderbl.PromotionInfo;
import vo.PromotionVO;

public class PromotionInfoImpl implements PromotionInfo {

	/**
	 * 
	 * @param initialPrice,pvo
	 * @return 获得最终订单价格
	 */
	@Override
	public double getFinalPrice(double initialPrice, PromotionVO pvo) {
		// TODO Auto-generated method stub
		double finalPrice = -1;
		finalPrice = pvo.calculatePayment(initialPrice);
		
		return finalPrice;
	}

}
