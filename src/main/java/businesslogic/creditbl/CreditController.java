package businesslogic.creditbl;

import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;

import businesslogicservice.ResultMessage;
import businesslogicservice.creditBLService.CreditBLService;
import dataservice.creditdataservice.CreditDataService;
import dataservice.usercredithistoryservice.UserCreditHistoryDataService;
import po.CreditPO;
import po.UserCreditHistoryPO;
import rmi.RemoteController;
import runner.DataServiceClientRunner;
import vo.CreditMovement;
import vo.CreditVO;
import vo.UserCreditHistoryVO;

public class CreditController implements CreditBLService {

	private RemoteController remoteController;
	private CreditDataService creditDataService;
	private UserCreditHistoryDataService userCreditHistoryDataService;

	public CreditController() {
		DataServiceClientRunner runner = new DataServiceClientRunner();
		runner.start();
		remoteController = runner.getRemoteController();
		creditDataService = remoteController.getCreditDataService();
		userCreditHistoryDataService = remoteController.getUserCreditHistoryDataService();
	}

	/**
	 * 
	 * @param cvo
	 * @param id
	 * @return 添加信用值信息
	 */
	@Override
	public ResultMessage addCredit(int id, int credit) {
		// TODO Auto-generated method stub
		try {
			creditDataService.initCreditDataService();
			CreditPO cpo = creditDataService.findCredit(id);
			cpo = new CreditPO(id, credit);
			creditDataService.insertCredit(cpo);
			creditDataService.finishCreditDataService();

			userCreditHistoryDataService.initUserCreditHistoryDataService();
			userCreditHistoryDataService.updateHistory(id, 0, new Date(System.currentTimeMillis()), null, 0);
			userCreditHistoryDataService.finishUserCreditHistoryDataService();
			return ResultMessage.TRUE;
		} catch (RemoteException e) {
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
		try {
			creditDataService.initCreditDataService();
			creditDataService.deleteCredit(id);
			creditDataService.finishCreditDataService();
			return ResultMessage.TRUE;
		} catch (RemoteException e) {
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
	public ResultMessage modifyCredit(int id, int credit, CreditMovement creditMovement) {
		// TODO Auto-generated method stub
		try {
			creditDataService.initCreditDataService();
			int remain = creditDataService.findCredit(id).getCredit();

			creditDataService.updateCredit(new CreditPO(id, credit + remain));
			creditDataService.finishCreditDataService();

			userCreditHistoryDataService.initUserCreditHistoryDataService();
			userCreditHistoryDataService.updateHistory(id, credit, new Date(System.currentTimeMillis()),
					po.CreditMovement.valueOf(creditMovement.toString()), credit + remain);
			userCreditHistoryDataService.finishUserCreditHistoryDataService();
			return ResultMessage.TRUE;
		} catch (RemoteException e) {
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
		try {
			creditDataService.initCreditDataService();
			CreditPO cpo = creditDataService.findCredit(id);
			cvo = new CreditVO(id, cpo.getCredit());
			creditDataService.finishCreditDataService();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return cvo;
	}

	@Override
	public ArrayList<UserCreditHistoryVO> getHistory(int userId) {
		// TODO Auto-generated method stub
		ArrayList<UserCreditHistoryVO> list = new ArrayList<UserCreditHistoryVO>();
		try {
			ArrayList<UserCreditHistoryPO> poList;

			userCreditHistoryDataService.initUserCreditHistoryDataService();
			poList = userCreditHistoryDataService.findCreditHistory(userId);

			UserCreditHistoryPO tmp;
			for (int i = 0; i < poList.size(); i++) {
				tmp = poList.get(i);
				list.add(new UserCreditHistoryVO(tmp.getUserId(), tmp.getChange(), tmp.getTime(),
						tmp.getCreditMovement(), tmp.getRemain()));
			}

			userCreditHistoryDataService.finishUserCreditHistoryDataService();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

}
