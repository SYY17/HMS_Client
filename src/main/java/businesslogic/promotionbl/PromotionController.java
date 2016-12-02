package businesslogic.promotionbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.sql.Date;
import businesslogicservice.ResultMessage;
import businesslogicservice.promotionblservice.PromotionBLService;
import po.PromotionPO;
import rmi.RemoteController;
import vo.PromotionVO;

public class PromotionController implements PromotionBLService{
	
	//类中待修改语句
	//pvo = new PromotionVO(listPromotion.get(i).getContent(),listPromotion.get(i).getStartTime(),listPromotion.get(i).getID());
	
	private RemoteController remoteController;

	/**
	 * 
	 * @param pvo
	 * @return 制定营销策略
	 */
	@Override
	public ResultMessage addPromotion(PromotionVO pvo) {
		// TODO Auto-generated method stub
		try{
			remoteController.getPromotionDataService().initPromotionDataService();
			ArrayList<PromotionPO> listPromotion = remoteController.getPromotionDataService().findsPromotion(pvo.getID(),pvo.getContent(),pvo.getStartTime());
			
			if(listPromotion!=null){
				return ResultMessage.FALSE;
			}
			
			PromotionPO ppo = new PromotionPO(pvo.getContent(), pvo.getStartTime(), pvo.getID());
			remoteController.getPromotionDataService().insertPromotion(ppo);
			remoteController.getPromotionDataService().finishPromotionDataService();
			return ResultMessage.TRUE;
		}catch(RemoteException e){
			e.printStackTrace();
		}
		return ResultMessage.FALSE;
	}

	/**
	 * 
	 * @param id
	 * @return 获取所有营销策略的信息列表
	 */
	@Override
	public ArrayList<PromotionVO> getAllPromotion(int id) {
		// TODO Auto-generated method stub
		ArrayList<PromotionVO> list = new ArrayList<PromotionVO>();
		try{
			PromotionVO tmp;
			remoteController.getPromotionDataService().initPromotionDataService();
			ArrayList<PromotionPO> listPromotion = remoteController.getPromotionDataService().findsPromotion(id);
			
			if(listPromotion == null){
				list = null;
			}else{
				for(int i = 0; i<listPromotion.size(); i++){
					tmp = new PromotionVO(listPromotion.get(i).getContent(),listPromotion.get(i).getStartTime(),listPromotion.get(i).getID());
					list.add(tmp);
				}
			}
			
			remoteController.getPromotionDataService().finishPromotionDataService();
		}catch(RemoteException e){
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 
	 * @param pvo
	 * @return 删除营销策略
	 */
	@Override
	public ResultMessage deletePromotion(PromotionVO pvo) {
		// TODO Auto-generated method stub
		try{
			remoteController.getPromotionDataService().initPromotionDataService();
			//待修改
			PromotionPO ppo = new PromotionPO(pvo.getContent(), pvo.getStartTime(), pvo.getID());
			remoteController.getPromotionDataService().deletePromotion(ppo);
			remoteController.getPromotionDataService().finishPromotionDataService();
			return ResultMessage.TRUE;
		}catch(RemoteException e){
			e.printStackTrace();
		}
		return ResultMessage.FALSE;
	}

	/**
	 * 
	 * @param pvo
	 * @return 精确查找营销策略
	 */
	@Override
	public ResultMessage searchPromotion(PromotionVO pvo) {
		// TODO Auto-generated method stub
		try{
			remoteController.getPromotionDataService().initPromotionDataService();
			ArrayList<PromotionPO> listPromotion = remoteController.getPromotionDataService().findsPromotion(pvo.getID(),pvo.getContent(),pvo.getStartTime());
			
			if(listPromotion == null){
				return ResultMessage.FALSE;
			}
			remoteController.getPromotionDataService().finishPromotionDataService();
			
			PromotionPO ppo;
			for(int i = 0; i<listPromotion.size(); i++){
				ppo = listPromotion.get(i);
				if(ppo.getContent().equals(pvo.getContent())){
					return ResultMessage.TRUE;
				}
			}
			
		}catch(RemoteException e){
			e.printStackTrace();
		}
		return ResultMessage.FALSE;
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
		ArrayList<PromotionVO> list = new ArrayList<PromotionVO>();
		try{
			PromotionVO pvo;
			remoteController.getPromotionDataService().initPromotionDataService();
			ArrayList<PromotionPO> listPromotion = remoteController.getPromotionDataService().findsPromotion(id,content);
			
			if(listPromotion == null){
				list = null;
			}else{
				for(int i = 0; i<listPromotion.size(); i++){
					pvo = new PromotionVO(listPromotion.get(i).getContent(),listPromotion.get(i).getStartTime(),listPromotion.get(i).getID());
					list.add(pvo);
				}
			}
			remoteController.getPromotionDataService().finishPromotionDataService();
		}catch(RemoteException e){
			e.printStackTrace();
		}
		return list;
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
		ArrayList<PromotionVO> list = new ArrayList<PromotionVO>();
		try{
			PromotionVO tmp;
			remoteController.getPromotionDataService().initPromotionDataService();
			ArrayList<PromotionPO> listPromotion = remoteController.getPromotionDataService().findsPromotion(id,start);
			remoteController.getPromotionDataService().finishPromotionDataService();
			
			if(listPromotion == null){
				list = null;
			}else{
				for(int i = 0; i<listPromotion.size(); i++){
					tmp = new PromotionVO(listPromotion.get(i).getContent(),listPromotion.get(i).getStartTime(),listPromotion.get(i).getID());
					list.add(tmp);
				}
			}
		}catch(RemoteException e){
			e.printStackTrace();
		}
		return list;
	}

}
