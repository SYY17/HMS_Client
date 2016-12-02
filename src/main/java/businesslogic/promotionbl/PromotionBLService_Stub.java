package businesslogic.promotionbl;

import java.util.ArrayList;
import java.sql.Date;

import businesslogicservice.ResultMessage;
import businesslogicservice.promotionblservice.PromotionBLService;
import vo.PromotionVO;

public class PromotionBLService_Stub implements PromotionBLService{
	String content = null;
	Date start = null;
	int id = 0;
	
	public PromotionBLService_Stub(){
		// TODO Auto-generated constructor stub
	}
	
	public PromotionBLService_Stub(String ctt, Date s, int i) {
		// TODO Auto-generated constructor stub
		content = ctt;
		start = s;
		id = i;
	}
	
	/**
	 * 
	 * @param pvo
	 * @return 制定营销策略
	 */
	@Override
	public ResultMessage addPromotion(PromotionVO pvo) {
		// TODO Auto-generated method stub
		if(pvo != null){
			return ResultMessage.TRUE;
		}
		else return ResultMessage.FALSE;
	}

	/**
	 * 
	 * @param id
	 * @return 获取所有营销策略的信息列表
	 */
	@Override
	public ArrayList<PromotionVO> getAllPromotion(int id) {
		// TODO Auto-generated method stub
		ArrayList<PromotionVO> PromotionList = new ArrayList<PromotionVO>();
		PromotionList.add(new PromotionVO(content, start, id));
		return PromotionList;
	}

	/**
	 * 
	 * @param pvo
	 * @return 删除营销策略
	 */
	@Override
	public ResultMessage deletePromotion(PromotionVO pvo) {
		// TODO Auto-generated method stub
		if(pvo != null){
			return ResultMessage.TRUE;
		}
		else return ResultMessage.FALSE;
	}

	/**
	 * 
	 * @param pvo
	 * @return 精确查找营销策略
	 */
	@Override
	public ResultMessage searchPromotion(PromotionVO pvo) {
		// TODO Auto-generated method stub
		if(pvo != null){
			return ResultMessage.TRUE;
		}
		else return ResultMessage.FALSE;
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
		ArrayList<PromotionVO> PromotionList = new ArrayList<PromotionVO>();
		PromotionList.add(new PromotionVO(content, start, id));
		return PromotionList;
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
		ArrayList<PromotionVO> PromotionList = new ArrayList<PromotionVO>();
		PromotionList.add(new PromotionVO(content, start, id));
		return PromotionList;
	}
	
}
