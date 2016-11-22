package businesslogic.creditbl;

import businesslogicservice.ResultMessage;
import businesslogicservice.creditBLService.CreditBLService;
import vo.CreditVO;

public class CreditBLService_Stub implements CreditBLService{
	int id = 0;
	int credit = 0;
	
	public CreditBLService_Stub(){
		// TODO Auto-generated constructor stub
	}
	
	public CreditBLService_Stub(int i, int c) {
		// TODO Auto-generated constructor stub
		id = i;
		credit = c;
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
		if(cvo != null&&id == 0){
			return ResultMessage.TRUE;
		}
		else return ResultMessage.FALSE;
	}

	/**
	 * 
	 * @param id
	 * @return 删除信用值信息
	 */
	@Override
	public ResultMessage deleteCredit(int id) {
		// TODO Auto-generated method stub
		if(id == 0){
			return ResultMessage.TRUE;
		}
		else return ResultMessage.FALSE;
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
		if(cvo != null&&id == 0){
			return ResultMessage.TRUE;
		}
		else return ResultMessage.FALSE;
	}

	/**
	 * 
	 * @param id
	 * @return 查看信用值
	 */
	@Override
	public CreditVO getCredit(int id) {
		// TODO Auto-generated method stub
		CreditVO Credit = new CreditVO(id, credit);
		return Credit;
	}
	
}
