package businesslogic.orderbl;

import vo.PromotionVO;

public interface PromotionInfo {
	/**
	 * 
	 * @param initialPrice,pvo
	 * @return 获得最终订单价格
	 */
	public int getFinalPrice(int initialPrice, PromotionVO pvo);
}
