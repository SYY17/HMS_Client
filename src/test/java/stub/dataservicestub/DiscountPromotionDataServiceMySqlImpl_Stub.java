package stub.dataservicestub;

import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;

import dataservice.discountpromotiondataservice.DiscountPromotionDataService;
import po.DiscountPromotionPO;
import po.PromotionType;

public class DiscountPromotionDataServiceMySqlImpl_Stub implements DiscountPromotionDataService {

	String promotionName;
	String content;
	Date start;
	Date stop;
	PromotionType pt;
	int id;
	double discount;
	DiscountPromotionPO dpo;
	
	public DiscountPromotionDataServiceMySqlImpl_Stub(String pn, String ctt, Date s, Date sp, PromotionType p, int i, double d){
		promotionName = pn;
		content = ctt;
		start = s;
		stop = sp;
		pt = p;
		id = i;
		discount = d;
		dpo = new DiscountPromotionPO(promotionName, content, start, stop, pt, id, discount);
	}
	
	/**
	 * 按照id和content和startTime查找策略
	 */
	@Override
	public ArrayList<DiscountPromotionPO> findsDiscountPromotion(int id, String content, Date start)
			throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<DiscountPromotionPO> list = new ArrayList<DiscountPromotionPO>();
		if(content!= null && start!= null){
			list.add(dpo);
		}
		return list;
	}

	/**
	 * 按照id查找策略
	 */
	@Override
	public ArrayList<DiscountPromotionPO> findsDiscountPromotion(int id) throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<DiscountPromotionPO> list = new ArrayList<DiscountPromotionPO>();
		if(id>=10000000 && id<50000000){
			list.add(dpo);
		}
		return list;
	}

	/**
	 * 按照id和startTime查找策略
	 */
	@Override
	public ArrayList<DiscountPromotionPO> findsDiscountPromotion(int id, Date start) throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<DiscountPromotionPO> list = new ArrayList<DiscountPromotionPO>();
		if(id>=10000000 && id<50000000 && start != null){
			list.add(dpo);
		}
		return list;
	}

	/**
	 * 按照id和content查找策略
	 */
	@Override
	public ArrayList<DiscountPromotionPO> findsDiscountPromotion(int id, String content) throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<DiscountPromotionPO> list = new ArrayList<DiscountPromotionPO>();
		if(id>=10000000 && id<50000000 && content != null){
			list.add(dpo);
		}
		return list;
	}

	/**
	 * 插入策略
	 */
	@Override
	public void insertDiscountPromotion(DiscountPromotionPO dpo) throws RemoteException {
		// TODO Auto-generated method stub
		if(dpo.getPromotionName() != null && dpo.getContent() != null){
			System.out.println("Insert succeed!");
		}
		else System.out.println("Insert failed!");
	}

	/**
	 * 删除策略
	 */
	@Override
	public void deleteDiscountPromotion(DiscountPromotionPO dpo) throws RemoteException {
		// TODO Auto-generated method stub
		if(dpo.getPromotionName() != null && dpo.getContent() != null){
			System.out.println("Delete succeed!");
		}
		else System.out.println("Delete failed!");
	}

	/**
	 * 初始化
	 */
	@Override
	public void initDiscountPromotionDataService() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Init Finished!");
	}

	/**
	 * 结束
	 */
	@Override
	public void finishDiscountPromotionDataService() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Finish Finished!");
	}

}
