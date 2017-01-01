package stub.blservicestub;

import java.util.ArrayList;
import java.sql.Date;
import java.sql.Timestamp;

import businesslogicservice.ResultMessage;
import businesslogicservice.promotionblservice.PromotionBLService;
import vo.PromotionType;
import vo.DiscountPromotionVO;
import vo.FullCutPromotionVO;
import vo.PromotionVO;

public class PromotionBLService_Stub implements PromotionBLService{
	
	String promotionName;
	String content;
	Date start;
	Date stop;
	PromotionType pt;
	int id = 0;
	double discount;
	double every;
	double cut;
	PromotionVO pvo;
	FullCutPromotionVO fvo;
	DiscountPromotionVO dvo;
	
	public PromotionBLService_Stub( String pn, String ctt, Date s, Date sp, PromotionType p, int i, double e, double c, double d) {
		// TODO Auto-generated constructor stub
		promotionName = pn;
		content = ctt;
		start = s;
		stop = sp;
		pt = p;
		id = i;
		pvo = new PromotionVO( promotionName, content, start, stop, pt, id);
		fvo = new FullCutPromotionVO( promotionName, content, start, stop, pt, id, e, c);
		dvo = new DiscountPromotionVO( promotionName, content, start, stop, pt, id, d);
	}
	
	/**
	 * 增加策略
	 */
	@Override
	public ResultMessage addPromotion(PromotionVO pvo) {
		// TODO Auto-generated method stub
		if(pvo.getPromotionName() != null && pvo.getContent() != null){
			return ResultMessage.TRUE;
		}
		else return ResultMessage.FALSE;
	}

	/**
	 * 获得所有策略
	 */
	@Override
	public ArrayList<PromotionVO> getAllPromotion(int id) {
		// TODO Auto-generated method stub
		ArrayList<PromotionVO> PromotionList = new ArrayList<PromotionVO>();
		PromotionList.add(pvo);
		return PromotionList;
	}

	/**
	 * 删除策略
	 */
	@Override
	public ResultMessage deletePromotion(PromotionVO pvo) {
		// TODO Auto-generated method stub
		if(pvo != null && pvo.getContent() != null){
			return ResultMessage.TRUE;
		}
		else return ResultMessage.FALSE;
	}

	/**
	 * 搜索策略
	 */
	@Override
	public ResultMessage searchPromotion(PromotionVO pvo) {
		// TODO Auto-generated method stub
		if(pvo.getPromotionName() != null && pvo.getContent() != null){
			return ResultMessage.TRUE;
		}
		else return ResultMessage.FALSE;
	}

	/**
	 * 按照内容查找策略
	 */
	@Override
	public ArrayList<PromotionVO> searchByContent(int id, String content) {
		// TODO Auto-generated method stub
		ArrayList<PromotionVO> list = new ArrayList<PromotionVO>();
		if(id !=0 && content != null){
			list.add(pvo);
			return list;
		}
		return null;
	}

	/**
	 * 按照开始时间查找策略
	 */
	@Override
	public ArrayList<PromotionVO> searchByStartTime(int id, Date start) {
		// TODO Auto-generated method stub
		ArrayList<PromotionVO> list = new ArrayList<PromotionVO>();
		if(id !=0 && start != null){
			list.add(pvo);
			return list;
		}
		return null;
	}

	/**
	 * 增加策略
	 */
	@Override
	public ResultMessage addFullCutPromotion(FullCutPromotionVO fvo) {
		// TODO Auto-generated method stub
		if(fvo.getPromotionName() != null && fvo.getContent() != null){
			return ResultMessage.TRUE;
		}
		else return ResultMessage.FALSE;
	}

	/**
	 * 增加策略
	 */
	@Override
	public ResultMessage addDiscountPromotion(DiscountPromotionVO dvo) {
		// TODO Auto-generated method stub
		if(dvo.getPromotionName() != null && dvo.getContent() != null){
			return ResultMessage.TRUE;
		}
		else return ResultMessage.FALSE;
	}

	/**
	 * 删除策略
	 */
	@Override
	public ResultMessage deleteFullCutPromotion(FullCutPromotionVO fvo) {
		// TODO Auto-generated method stub
		if(fvo != null && fvo.getContent() != null){
			return ResultMessage.TRUE;
		}
		else return ResultMessage.FALSE;
	}

	/**
	 * 删除策略
	 */
	@Override
	public ResultMessage deleteDiscountPromotion(DiscountPromotionVO dvo) {
		// TODO Auto-generated method stub
		if(dvo != null && dvo.getContent() != null){
			return ResultMessage.TRUE;
		}
		else return ResultMessage.FALSE;
	}

	/**
	 * 获得价格
	 */
	@Override
	public double searchPromotionPresent(int userId, int roomNum, int id, Timestamp presentTime, int initialPrice) {
		// TODO Auto-generated method stub
		return dvo.calculatePayment(initialPrice);
	}

	/**
	 * 按照内容查找策略
	 */
	@Override
	public ArrayList<FullCutPromotionVO> searchFullCutByContent(int id, String content) {
		// TODO Auto-generated method stub
		ArrayList<FullCutPromotionVO> list = new ArrayList<FullCutPromotionVO>();
		if(id !=0 && content != null){
			list.add(fvo);
			return list;
		}
		return null;
	}

	/**
	 *  按照开始时间查找策略
	 */
	@Override
	public ArrayList<FullCutPromotionVO> searchFullCutByStartTime(int id, Date start) {
		// TODO Auto-generated method stub
		ArrayList<FullCutPromotionVO> list = new ArrayList<FullCutPromotionVO>();
		if(id !=0 && start != null){
			list.add(fvo);
			return list;
		}
		return null;
	}

	/**
	 *  按照内容查找策略
	 */
	@Override
	public ArrayList<DiscountPromotionVO> searchDiscountByContent(int id, String content) {
		// TODO Auto-generated method stub
		ArrayList<DiscountPromotionVO> list = new ArrayList<DiscountPromotionVO>();
		if(id !=0 && content != null){
			list.add(dvo);
			return list;
		}
		return null;
	}

	/**
	 * 按照开始时间查找策略
	 */
	@Override
	public ArrayList<DiscountPromotionVO> searchDiscountByStartTime(int id, Date start) {
		// TODO Auto-generated method stub
		ArrayList<DiscountPromotionVO> list = new ArrayList<DiscountPromotionVO>();
		if(id !=0 && start != null){
			list.add(dvo);
			return list;
		}
		return null;
	}
	
}
