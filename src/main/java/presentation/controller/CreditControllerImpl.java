package presentation.controller;

import businesslogic.creditbl.CreditBLService_Stub;
import businesslogicservice.ResultMessage;
import businesslogicservice.creditBLService.CreditBLService;
import presentation.creditui.CreditControllerService;
import vo.CreditVO;

public class CreditControllerImpl implements CreditControllerService{

	private int id;
	private int credit;
	private CreditBLService creditBLService;
	
	public CreditControllerImpl(int i, int c){
		// TODO Auto-generated constructor stub
		id = i;
		credit = c;
		creditBLService = new CreditBLService_Stub(id, credit);
	}
	
	/**
	 * 
	 * @param cvo
	 * @param id
	 * @return 添加信用值信息
	 */
	@Override
	public ResultMessage addCredit(CreditVO cvo, int id) {
		// TODO Auto-generated method stub
		return creditBLService.addCredit(cvo, id);
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
	public ResultMessage modifyCredit(CreditVO cvo, int id) {
		// TODO Auto-generated method stub
		return creditBLService.modifyCredit(cvo, id);
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
