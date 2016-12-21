package presentation.promotionui;

import java.util.ArrayList;
import java.sql.Date;
import java.sql.Timestamp;

import businesslogicservice.ResultMessage;
import vo.DiscountPromotionVO;
import vo.FullCutPromotionVO;
import vo.PromotionVO;

public interface PromotionControllerService {

	/**
	 * 
	 * @param pvo
	 * @return 制定营销策略
	 */
	public ResultMessage addPromotion(PromotionVO pvo);

	/**
	 * 
	 * @param id
	 * @return 获取所有营销策略的信息列表
	 */
	public ArrayList<PromotionVO> getAllPromotion(int id);

	/**
	 * 
	 * @param pvo
	 * @return 删除营销策略
	 */
	public ResultMessage deletePromotion(PromotionVO pvo);

	/**
	 * 
	 * @param pvo
	 * @return 精确查找营销策略
	 */
	public ResultMessage searchPromotion(PromotionVO pvo);

	/**
	 * 
	 * @param id
	 * @param content
	 * @return 按照内容查找营销策略
	 */
	public ArrayList<PromotionVO> searchByContent(int id, String content);

	/**
	 * 
	 * @param id
	 * @param start
	 * @return 按照起始时间查找营销策略
	 */
	public ArrayList<PromotionVO> searchByStartTime(int id, Date start);

	/**
	 * 
	 * @param fvo
	 * @return 制定满减策略
	 */
	public ResultMessage addFullCutPromotion(FullCutPromotionVO fvo);

	/**
	 * 
	 * @param dvo
	 * @return 制定折扣策略
	 */
	public ResultMessage addDiscountPromotion(DiscountPromotionVO dvo);

	/**
	 * 
	 * @param fvo
	 * @return 删除营销策略
	 */
	public ResultMessage deleteFullCutPromotion(FullCutPromotionVO fvo);

	/**
	 * 
	 * @param dvo
	 * @return 删除营销策略
	 */
	public ResultMessage deleteDiscountPromotion(DiscountPromotionVO dvo);

	/**
	 * 
	 * @param id
	 * @param presentTime
	 * @return 按照当时时间查找营销策略
	 */
	public double searchPromotionPresent(int userId, int roomNum, int id, Timestamp presentTime, int initialPrice);
}
