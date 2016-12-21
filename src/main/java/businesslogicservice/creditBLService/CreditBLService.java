package businesslogicservice.creditBLService;

import java.util.ArrayList;

import businesslogicservice.ResultMessage;
import vo.CreditMovement;
import vo.CreditVO;
import vo.UserCreditHistoryVO;

public interface CreditBLService {

	/**
	 * 
	 * @param cvo
	 * @param id
	 * @return 添加信用值信息
	 */
	public ResultMessage addCredit(int id, int credit);

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
	public ResultMessage modifyCredit(int id, int credit, CreditMovement creditMovement);

	/**
	 * 
	 * @param id
	 * @return 查看信用值
	 */
	public CreditVO getCredit(int id);

	/**
	 * 
	 * @param userid
	 * @return 查看用户所有历史
	 */
	public ArrayList<UserCreditHistoryVO> getHistory(int userId);
}
