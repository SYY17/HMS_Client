package businesslogicservice.promotionblservice;

import java.util.ArrayList;
import java.util.Date;

import businesslogicservice.ResultMessage;
import vo.PromotionVO;

public interface PromotionBLService {
	
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
	public ArrayList <PromotionVO> getAllPromotion(int id);
	
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
	public ArrayList <PromotionVO> searchByContent(int id, String content);
	
	/**
	 * 
	 * @param id
	 * @param start
	 * @return 按照起始时间查找营销策略
	 */
	public ArrayList <PromotionVO> searchByStartTime(int id, Date start);
}
