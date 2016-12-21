package presentation.controller;

import businesslogic.creditbl.CreditController;
import businesslogicservice.ResultMessage;
import businesslogicservice.creditBLService.CreditBLService;
import presentation.creditui.CreditControllerService;
import vo.CreditMovement;
import vo.CreditVO;

public class CreditControllerImpl implements CreditControllerService {

	private CreditBLService creditBLService;

	public CreditControllerImpl() {
		creditBLService = new CreditController();
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
		return creditBLService.addCredit(id, credit);
	}

	/**
	 * 
	 * @param id
	 * @return 删除信用值信息
	 */
	@Override
	public ResultMessage deleteCredit(int id) {
		// TODO Auto-generated method stub
		return creditBLService.deleteCredit(id);
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
		return creditBLService.modifyCredit(id, credit,creditMovement);
	}

	/**
	 * 
	 * @param id
	 * @return 查看信用值
	 */
	@Override
	public CreditVO getCredit(int id) {
		// TODO Auto-generated method stub
		return creditBLService.getCredit(id);
	}

}
