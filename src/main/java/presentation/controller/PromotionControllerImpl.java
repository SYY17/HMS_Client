package presentation.controller;

import java.util.ArrayList;
import java.util.Date;
import businesslogic.promotionbl.PromotionBLService_Stub;
import businesslogicservice.ResultMessage;
import businesslogicservice.promotionblservice.PromotionBLService;
import presentation.promotionui.PromotionControllerService;
import vo.PromotionVO;

public class PromotionControllerImpl implements PromotionControllerService{

	private String content;
	private Date start;
	private int id;
	private PromotionBLService promotionBLService;
	
	public PromotionControllerImpl(String ctt, Date s, int i) {
		// TODO Auto-generated constructor stub
		content = ctt;
		start = s;
		id = i;
		promotionBLService = new PromotionBLService_Stub(content, start, id);
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

}
