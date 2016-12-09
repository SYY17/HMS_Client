package businesslogic.creditbl;

import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;

import businesslogicservice.ResultMessage;
import businesslogicservice.creditBLService.CreditBLService;
import po.CreditPO;
import po.UserCreditHistoryPO;
import rmi.RemoteController;
import runner.DataServiceClientRunner;
import vo.CreditVO;
import vo.UserCreditHistoryVO;

public class CreditController implements CreditBLService {

	private RemoteController remoteController;

	public CreditController() {
		DataServiceClientRunner runner = new DataServiceClientRunner();
		runner.start();
		remoteController = runner.getRemoteController();
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
			remoteController.getCreditDataService().initCreditDataService();
			CreditPO cpo = remoteController.getCreditDataService().findCredit(id);

			if (cpo != null) {
				return ResultMessage.FALSE;
			}

			cpo = new CreditPO(id, credit);
			remoteController.getCreditDataService().insertCredit(cpo);
			remoteController.getCreditDataService().finishCreditDataService();
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
			remoteController.getCreditDataService().initCreditDataService();
			remoteController.getCreditDataService().deleteCredit(id);
			remoteController.getCreditDataService().finishCreditDataService();
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
	public ResultMessage modifyCredit(int id, int credit) {
		// TODO Auto-generated method stub
		try {
			remoteController.getCreditDataService().initCreditDataService();
			CreditPO cpo = remoteController.getCreditDataService().findCredit(id);

			if (cpo == null) {
				return ResultMessage.FALSE;
			}

			cpo = new CreditPO(id, credit);

			remoteController.getCreditDataService().updateCredit(cpo);
			remoteController.getCreditDataService().finishCreditDataService();
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
			remoteController.getCreditDataService().initCreditDataService();
			CreditPO cpo = remoteController.getCreditDataService().findCredit(id);

			if (cpo != null) {
				cvo = new CreditVO(id, cpo.getCredit());
			}

			remoteController.getCreditDataService().finishCreditDataService();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
		return cvo;
	}

	@Override
	public ArrayList<UserCreditHistoryVO> getHistory(int userId) {
		// TODO Auto-generated method stub
		ArrayList<UserCreditHistoryVO> list = new ArrayList<UserCreditHistoryVO>();
		DataServiceClientRunner cr = new DataServiceClientRunner();
		cr.start();
		RemoteController rc = cr.getRemoteController();
		try {
			ArrayList<UserCreditHistoryPO> poList;

			rc.getUserCreditHistoryDataService().initUserCreditHistoryDataService();
			poList = rc.getUserCreditHistoryDataService().findCreditHistory(userId);

			UserCreditHistoryPO tmp;
			for (int i = 0; i < poList.size(); i++) {
				tmp = poList.get(i);
				list.add(new UserCreditHistoryVO(tmp.getUserId(), tmp.getChange(), tmp.getTime()));
			}

			rc.getUserCreditHistoryDataService().finishUserCreditHistoryDataService();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
	}

	@Override
	public ArrayList<Date> getHistoryDate(int userId) {
		// TODO Auto-generated method stub
		ArrayList<UserCreditHistoryVO> list = getHistory(userId);
		ArrayList<Date> date = new ArrayList<Date>();

		for (int i = 0; i < list.size(); i++) {
			date.add(list.get(i).getTime());
		}
		return date;
	}

	@Override
	public ArrayList<Integer> getHistoryChange(int userId) {
		// TODO Auto-generated method stub
		ArrayList<UserCreditHistoryVO> list = getHistory(userId);
		ArrayList<Integer> change = new ArrayList<Integer>();

		for (int i = 0; i < list.size(); i++) {
			change.add(list.get(i).getChange());
		}
		return change;
	}

}
