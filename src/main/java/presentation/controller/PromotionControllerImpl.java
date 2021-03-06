package presentation.controller;

import java.util.ArrayList;
import java.sql.Date;
import java.sql.Timestamp;

import businesslogic.promotionbl.PromotionController;
import businesslogicservice.ResultMessage;
import businesslogicservice.promotionblservice.PromotionBLService;
import presentation.promotionui.PromotionControllerService;
import vo.DiscountPromotionVO;
import vo.FullCutPromotionVO;
import vo.PromotionVO;

public class PromotionControllerImpl implements PromotionControllerService {

	private PromotionBLService promotionBLService;

	public PromotionControllerImpl() {
		promotionBLService = new PromotionController();
	}

	/**
	 * 
	 * @param pvo
	 * @return 制定营销策略
	 */
	@Override
	public ResultMessage addPromotion(PromotionVO pvo) {
		// TODO Auto-generated method stub
		return promotionBLService.addPromotion(pvo);
	}

	/**
	 * 
	 * @param id
	 * @return 获取所有营销策略的信息列表
	 */
	@Override
	public ArrayList<PromotionVO> getAllPromotion(int id) {
		// TODO Auto-generated method stub
		return promotionBLService.getAllPromotion(id);
	}

	/**
	 * 
	 * @param pvo
	 * @return 删除营销策略
	 */
	@Override
	public ResultMessage deletePromotion(PromotionVO pvo) {
		// TODO Auto-generated method stub
		return promotionBLService.deletePromotion(pvo);
	}

	/**
	 * 
	 * @param pvo
	 * @return 精确查找营销策略
	 */
	@Override
	public ResultMessage searchPromotion(PromotionVO pvo) {
		// TODO Auto-generated method stub
		return promotionBLService.searchPromotion(pvo);
	}

	/**
	 * 
	 * @param id
	 * @param content
	 * @return 按照内容查找营销策略
	 */
	@Override
	public ArrayList<PromotionVO> searchByContent(int id, String content) {
		// TODO Auto-generated method stub
		return promotionBLService.searchByContent(id, content);
	}

	/**
	 * 
	 * @param id
	 * @param start
	 * @return 按照起始时间查找营销策略
	 */
	@Override
	public ArrayList<PromotionVO> searchByStartTime(int id, Date start) {
		// TODO Auto-generated method stub
		return promotionBLService.searchByStartTime(id, start);
	}

	/**
	 * 
	 * @param fvo
	 * @return 制定满减策略
	 */
	@Override
	public ResultMessage addFullCutPromotion(FullCutPromotionVO fvo) {
		// TODO Auto-generated method stub
		return promotionBLService.addFullCutPromotion(fvo);
	}

	/**
	 * 
	 * @param dvo
	 * @return 制定折扣策略
	 */
	@Override
	public ResultMessage addDiscountPromotion(DiscountPromotionVO dvo) {
		// TODO Auto-generated method stub
		return promotionBLService.addDiscountPromotion(dvo);
	}

	/**
	 * 
	 * @param fvo
	 * @return 删除营销策略
	 */
	@Override
	public ResultMessage deleteFullCutPromotion(FullCutPromotionVO fvo) {
		// TODO Auto-generated method stub
		return promotionBLService.deleteFullCutPromotion(fvo);
	}

	/**
	 * 
	 * @param dvo
	 * @return 删除营销策略
	 */
	@Override
	public ResultMessage deleteDiscountPromotion(DiscountPromotionVO dvo) {
		// TODO Auto-generated method stub
		return promotionBLService.deleteDiscountPromotion(dvo);
	}

	/**
	 * 
	 * @param id
	 * @param presentTime
	 * @return 按照当时时间查找营销策略
	 */
	@Override
	public double searchPromotionPresent(int userId, int roomNum, int id, Timestamp presentTime, int initialPrice) {
		// TODO Auto-generated method stub
		return promotionBLService.searchPromotionPresent(userId, roomNum, id, presentTime, initialPrice);
	}

}
