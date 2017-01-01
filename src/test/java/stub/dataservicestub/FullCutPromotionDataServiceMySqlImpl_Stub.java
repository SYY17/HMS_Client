package stub.dataservicestub;

import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;

import dataservice.fullcutpromotiondataservice.FullCutPromotionDataService;
import po.FullCutPromotionPO;
import po.PromotionType;

public class FullCutPromotionDataServiceMySqlImpl_Stub implements FullCutPromotionDataService {

	String promotionName;
	String content;
	Date start;
	Date stop;
	PromotionType pt;
	int id;
	double every;
	double cut;
	FullCutPromotionPO fpo;
	
	public FullCutPromotionDataServiceMySqlImpl_Stub(String pn, String ctt, Date s, Date sp, PromotionType p, int i, double e, double c){
		promotionName = pn;
		content = ctt;
		start = s;
		stop = sp;
		pt = p;
		id = i;
		every = e;
		cut = c;
		fpo = new FullCutPromotionPO(promotionName, content, start, stop, pt, id, every, cut);
	}
	
	/**
	 * 按照id和content和startTime查找策略
	 */
	@Override
	public ArrayList<FullCutPromotionPO> findsFullPromotion(int id, String content, Date start) throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<FullCutPromotionPO> list = new ArrayList<FullCutPromotionPO>();
		if(content!= null && start!= null){
			list.add(fpo);
		}
		return list;
	}

	/**
	 * 按照id查找策略
	 */
	@Override
	public ArrayList<FullCutPromotionPO> findsFullPromotion(int id) throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<FullCutPromotionPO> list = new ArrayList<FullCutPromotionPO>();
		if(id>=10000000 && id<50000000){
			list.add(fpo);
		}
		return list;
	}

	/**
	 * 按照id和startTime查找策略
	 */
	@Override
	public ArrayList<FullCutPromotionPO> findsFullPromotion(int id, Date start) throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<FullCutPromotionPO> list = new ArrayList<FullCutPromotionPO>();
		if(id>=10000000 && id<50000000 && start!= null){
			list.add(fpo);
		}
		return list;
	}

	/**
	 * 按照id和content查找策略
	 */
	@Override
	public ArrayList<FullCutPromotionPO> findsFullPromotion(int id, String content) throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<FullCutPromotionPO> list = new ArrayList<FullCutPromotionPO>();
		if(content!= null && id>=10000000 && id<50000000){
			list.add(fpo);
		}
		return list;
	}
	
	/**
	 * 插入策略
	 */
	@Override
	public void insertFullCutPromotion(FullCutPromotionPO fpo) throws RemoteException {
		// TODO Auto-generated method stub
		if(fpo.getPromotionName() != null && fpo.getContent() != null){
			System.out.println("Insert succeed!");
		}
		else System.out.println("Insert failed!");
	}

	/**
	 * 删除策略
	 */
	@Override
	public void deleteFullCutPromotion(FullCutPromotionPO fpo) throws RemoteException {
		// TODO Auto-generated method stub
		if(fpo.getPromotionName() != null && fpo.getContent() != null){
			System.out.println("Delete succeed!");
		}
		else System.out.println("Delete failed!");
	}

	/**
	 * 初始化
	 */
	@Override
	public void initFullCutPromotionDataService() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Init Finished!");
	}

	/**
	 * 结束
	 */
	@Override
	public void finishFullCutPromotionDataService() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Finish Finished!");
	}

}
