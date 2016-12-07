package businesslogic.promotionbl;

import java.util.ArrayList;
import java.sql.Date;

import businesslogicservice.ResultMessage;
import businesslogicservice.promotionblservice.PromotionBLService;
import vo.DiscountPromotionVO;
import vo.FullCutPromotionVO;
import vo.PromotionType;
import vo.PromotionVO;

public class PromotionBLService_Stub implements PromotionBLService{
	
	String promotionName;
	String content = null;
	Date start = null;
	Date stop = null;
	PromotionType promotionType;
	int id = 0;
	
	double every;
	double cut;
	double discount;
	
	public PromotionBLService_Stub(){
		// TODO Auto-generated constructor stub
	}
	
	public PromotionBLService_Stub( String pn, String ctt, Date s, Date sp, PromotionType pt, int i) {
		// TODO Auto-generated constructor stub
		promotionName = pn;
		content = ctt;
		start = s;
		stop = sp;
		promotionType = pt;
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
		PromotionList.add(new PromotionVO(promotionName,content, start, stop, promotionType, id));
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
		PromotionList.add(new PromotionVO(promotionName, content, start, stop, promotionType, id));
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
		PromotionList.add(new PromotionVO(promotionName, content, start, stop, promotionType, id));
		return PromotionList;
	}
	
	@Override
	public ResultMessage addFullCutPromotion(FullCutPromotionVO fvo) {
		// TODO Auto-generated method stub
		if(fvo != null){
			return ResultMessage.TRUE;
		}
		else return ResultMessage.FALSE;
	}

	@Override
	public ResultMessage addDiscountPromotion(DiscountPromotionVO dvo) {
		// TODO Auto-generated method stub
		if(dvo != null){
			return ResultMessage.TRUE;
		}
		else return ResultMessage.FALSE;
	}

	@Override
	public ResultMessage deletePromotion(FullCutPromotionVO fvo) {
		// TODO Auto-generated method stub
		if(fvo != null){
			return ResultMessage.TRUE;
		}
		else return ResultMessage.FALSE;
	}

	@Override
	public ResultMessage deleteDiscountPromotion(DiscountPromotionVO dvo) {
		// TODO Auto-generated method stub
		if(dvo != null){
			return ResultMessage.TRUE;
		}
		else return ResultMessage.FALSE;
	}
	
}
