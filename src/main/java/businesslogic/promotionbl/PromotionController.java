package businesslogic.promotionbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.sql.Date;
import businesslogicservice.ResultMessage;
import businesslogicservice.promotionblservice.PromotionBLService;
import po.DiscountPromotionPO;
import po.FullCutPromotionPO;
import po.PromotionPO;
import rmi.RemoteController;
import vo.DiscountPromotionVO;
import vo.FullCutPromotionVO;
import vo.PromotionType;
import vo.PromotionVO;

public class PromotionController implements PromotionBLService{
	
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
			
			PromotionPO ppo = new PromotionPO( pvo.getPromotionName(), pvo.getContent(), pvo.getStartTime(), pvo.getStopTime(), pvo.getPromotionType(), pvo.getID());
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
					tmp = new PromotionVO( listPromotion.get(i).getPromotionName(), listPromotion.get(i).getContent(), listPromotion.get(i).getStartTime(),
							listPromotion.get(i).getStopTime(), listPromotion.get(i).getPromotionType(), listPromotion.get(i).getID());
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
			PromotionPO ppo = new PromotionPO(pvo.getPromotionName(), pvo.getContent(), pvo.getStartTime(), pvo.getStopTime(), pvo.getPromotionType(), pvo.getID());
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
					pvo = new PromotionVO( listPromotion.get(i).getPromotionName(), listPromotion.get(i).getContent(), listPromotion.get(i).getStartTime(),
							listPromotion.get(i).getStopTime(), listPromotion.get(i).getPromotionType(), listPromotion.get(i).getID());
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
					tmp = new PromotionVO(listPromotion.get(i).getPromotionName(), listPromotion.get(i).getContent(), listPromotion.get(i).getStartTime(),
							listPromotion.get(i).getStopTime(), listPromotion.get(i).getPromotionType(), listPromotion.get(i).getID());
					list.add(tmp);
				}
			}
		}catch(RemoteException e){
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public ResultMessage addFullCutPromotion(FullCutPromotionVO fvo) {
		// TODO Auto-generated method stub
		try{
			remoteController.getFullCutPromotionDataService().initFullCutPromotionDataService();
			
			FullCutPromotionPO fpo = new FullCutPromotionPO( fvo.getPromotionName(), fvo.getContent(), fvo.getStartTime(), fvo.getStopTime(), fvo.getPromotionType(), fvo.getID(), fvo.getEvery(), fvo.getCut());//....
			
			remoteController.getFullCutPromotionDataService().insertFullCutPromotion(fpo);
			remoteController.getFullCutPromotionDataService().finishFullCutPromotionDataService();
			}catch(RemoteException e){
				e.printStackTrace();
				}
		
		return ResultMessage.TRUE;
	}

	@Override
	public ResultMessage addDiscountPromotion(DiscountPromotionVO dvo) {
		// TODO Auto-generated method stub
		try{
			remoteController.getDiscountPromotionDataService().initDiscountPromotionDataService();
			
			DiscountPromotionPO dpo = new DiscountPromotionPO( dvo.getPromotionName(), dvo.getContent(), dvo.getStartTime(), dvo.getStopTime(), dvo.getPromotionType(), dvo.getID(), dvo.getDiscount());//....
			
			remoteController.getDiscountPromotionDataService().insertDiscountPromotion(dpo);
			remoteController.getDiscountPromotionDataService().finishDiscountPromotionDataService();
			}catch(RemoteException e){
				e.printStackTrace();
				}
		
		return ResultMessage.TRUE;
	}

	@Override
	public ResultMessage deletePromotion(FullCutPromotionVO fvo) {
		// TODO Auto-generated method stub
		try{
			remoteController.getFullCutPromotionDataService().initFullCutPromotionDataService();
			
			FullCutPromotionPO fpo = new FullCutPromotionPO( fvo.getPromotionName(), fvo.getContent(), fvo.getStartTime(), fvo.getStopTime(), fvo.getPromotionType(), fvo.getID(), fvo.getEvery(), fvo.getCut());//....
			
			remoteController.getFullCutPromotionDataService().deleteFullCutPromotion(fpo);
			remoteController.getFullCutPromotionDataService().finishFullCutPromotionDataService();
		}catch(RemoteException e){
			e.printStackTrace();
		}
		
		return ResultMessage.TRUE;
	}

	@Override
	public ResultMessage deleteDiscountPromotion(DiscountPromotionVO dvo) {
		// TODO Auto-generated method stub
		try{
			remoteController.getDiscountPromotionDataService().initDiscountPromotionDataService();
			
			DiscountPromotionPO dpo = new DiscountPromotionPO( dvo.getPromotionName(), dvo.getContent(), dvo.getStartTime(), dvo.getStopTime(), dvo.getPromotionType(), dvo.getID(), dvo.getDiscount());//....
			
			remoteController.getDiscountPromotionDataService().deleteDiscountPromotion(dpo);
			remoteController.getDiscountPromotionDataService().finishDiscountPromotionDataService();
		}catch(RemoteException e){
			e.printStackTrace();
		}
		
		return ResultMessage.TRUE;
	}

}
