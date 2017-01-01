package stub.dataservicestub;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.sql.Date;

import dataservice.promotiondataservice.PromotionDataService;
import po.PromotionPO;
import po.PromotionType;

public class PromotionDataServiceMySqlImpl_Stub implements PromotionDataService{

	String promotionName;
	String content;
	Date start;
	Date stop;
	PromotionType pt;
	int id;
	PromotionPO ppo;
	
	public PromotionDataServiceMySqlImpl_Stub(String pn, String ctt, Date s, Date sp, PromotionType p, int i){
		promotionName = pn;
		content = ctt;
		start = s;
		stop = sp;
		pt = p;
		id = i;
		ppo = new PromotionPO(promotionName, content, start, stop, pt, id);
	}
	
	/**
	 * 按照id和content和startTime查找策略
	 */
	@Override
	public ArrayList<PromotionPO> findsPromotion(int id, String content, java.sql.Date start) throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<PromotionPO> list = new ArrayList<PromotionPO>();
		if(content!= null && start!= null){
			list.add(ppo);
		}
		return list;
	}

	/**
	 * 按照id查找策略
	 */
	@Override
	public ArrayList<PromotionPO> findsPromotion(int id) throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<PromotionPO> list = new ArrayList<PromotionPO>();
		if(id>=10000000 && id<50000000){
			list.add(ppo);
		}
		return list;
	}

	/**
	 * 按照id和startTime查找策略
	 */
	@Override
	public ArrayList<PromotionPO> findsPromotion(int id, java.sql.Date start) throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<PromotionPO> list = new ArrayList<PromotionPO>();
		if(id>=10000000 && id<50000000 && start!= null){
			list.add(ppo);
		}
		return list;
	}

	/**
	 * 按照id和content查找策略
	 */
	@Override
	public ArrayList<PromotionPO> findsPromotion(int id, String content) throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<PromotionPO> list = new ArrayList<PromotionPO>();
		if(content!= null && id>=10000000 && id<50000000){
			list.add(ppo);
		}
		return list;
	}

	/**
	 * 插入策略
	 */
	@Override
	public void insertPromotion(PromotionPO ppo) throws RemoteException {
		// TODO Auto-generated method stub
		if(ppo.getPromotionName() != null && ppo.getContent() != null){
			System.out.println("Insert succeed!");
		}
		else System.out.println("Insert failed!");
	}

	/**
	 * 删除策略
	 */
	@Override
	public void deletePromotion(PromotionPO ppo) throws RemoteException {
		// TODO Auto-generated method stub
		if(ppo.getPromotionName() != null && ppo.getContent() != null){
			System.out.println("Delete succeed!");
		}
		else System.out.println("Delete failed!");
	}

	/**
	 * 初始化
	 */
	@Override
	public void initPromotionDataService() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Init Finished!");
	}

	/**
	 * 结束
	 */
	@Override
	public void finishPromotionDataService() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Finish Finished!");
	}

	/**
	 * 获得全部策略
	 */
	@Override
	public ArrayList<PromotionPO> getAllPromotion() throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<PromotionPO> list = new ArrayList<PromotionPO>();
		list.add(ppo);
		return list;
	}
	

}
