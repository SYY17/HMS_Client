package presentation.creditui;

import businesslogicservice.ResultMessage;
import vo.CreditVO;

public interface CreditControllerService {
	
	/**
	 * 
	 * @param cvo
	 * @param id
	 * @return 添加信用值信息
	 */
	public ResultMessage addCredit(CreditVO cvo, int id);
	
	/**
	 * 
	 * @param id
	 * @return 删除信用值信息
	 */
	public ResultMessage deleteCredit(int id);
	
	/**
	 * 
	 * @param cvo
	 * @param id
	 * @return 维护信用值
	 */
	public ResultMessage modifyCredit(CreditVO cvo, int id);
	
	/**
	 * 
	 * @param id
	 * @return 查看信用值
	 */
	public CreditVO getCredit(int id);
}
