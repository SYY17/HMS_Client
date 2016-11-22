package businesslogic.creditbl;

import businesslogicservice.ResultMessage;
import businesslogicservice.creditBLService.CreditBLService;
import vo.CreditVO;

public class CreditController implements CreditBLService{

	/**
	 * 
	 * @param cvo
	 * @param id
	 * @return 添加信用值信息
	 */
	@Override
	public ResultMessage addCredit(CreditVO cvo, int id) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 
	 * @param id
	 * @return 删除信用值信息
	 */
	@Override
	public ResultMessage deleteCredit(int id) {
		// TODO Auto-generated method stub
		return null;
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
		return null;
	}

	/**
	 * 
	 * @param id
	 * @return 查看信用值
	 */
	@Override
	public CreditVO getCredit(int id) {
		// TODO Auto-generated method stub
		return null;
	}

}
