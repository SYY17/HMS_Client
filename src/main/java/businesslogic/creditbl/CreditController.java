package businesslogic.creditbl;

import java.rmi.RemoteException;

import businesslogicservice.ResultMessage;
import businesslogicservice.creditBLService.CreditBLService;
import po.CreditPO;
import rmi.RemoteController;
import vo.CreditVO;

public class CreditController implements CreditBLService{
	
	private RemoteController remoteController;
	
	/**
	 * 
	 * @param cvo
	 * @param id
	 * @return 添加信用值信息
	 */
	@Override
	public ResultMessage addCredit(int id, int credit) {
		// TODO Auto-generated method stub
		try{
			remoteController.getCreditDataService().initCreditDataService();
			CreditPO cpo = remoteController.getCreditDataService().findCredit(id);
			
			if(cpo != null){
				return ResultMessage.FALSE;
			}
			
			cpo = new CreditPO(id, credit);
			remoteController.getCreditDataService().insertCredit(cpo);
			remoteController.getCreditDataService().finishCreditDataService();
			return ResultMessage.TRUE;
		}catch(RemoteException e){
			e.printStackTrace();
		}
		return ResultMessage.FALSE;
	}

	/**
	 * 
	 * @param id
	 * @return 删除信用值信息
	 */
	@Override
	public ResultMessage deleteCredit(int id) {
		// TODO Auto-generated method stub
		try{
			remoteController.getCreditDataService().initCreditDataService();
			remoteController.getCreditDataService().deleteCredit(id);
			remoteController.getCreditDataService().finishCreditDataService();
			return ResultMessage.TRUE;
		}catch(RemoteException e){
			e.printStackTrace();
		}
		return ResultMessage.FALSE;
	}

	/**
	 * 
	 * @param cvo
	 * @param id
	 * @return 维护信用值
	 */
	@Override
	public ResultMessage modifyCredit(int id, int credit) {
		// TODO Auto-generated method stub
		try{
			remoteController.getCreditDataService().initCreditDataService();
			CreditPO cpo = remoteController.getCreditDataService().findCredit(id);
			
			if(cpo == null){
				return ResultMessage.FALSE;
			}
			
			cpo = new CreditPO(id, credit);
			
			remoteController.getCreditDataService().updateCredit(cpo);
			remoteController.getCreditDataService().finishCreditDataService();
			return ResultMessage.TRUE;
		}catch(RemoteException e){
			e.printStackTrace();
		}
		return ResultMessage.FALSE;
	}

	/**
	 * 
	 * @param id
	 * @return 查看信用值
	 */
	@Override
	public CreditVO getCredit(int id) {
		// TODO Auto-generated method stub
		CreditVO cvo = null;
		try{
			remoteController.getCreditDataService().initCreditDataService();
			CreditPO cpo = remoteController.getCreditDataService().findCredit(id);
			
			if(cpo != null){
				cvo = new CreditVO(id, cpo.getCredit());
			}
			
			remoteController.getCreditDataService().finishCreditDataService();
		}catch(RemoteException e){
			e.printStackTrace();
		}
		return cvo;
	}

}
