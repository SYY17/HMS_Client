package businesslogic.creditbl;

import businesslogic.orderbl.CreditInfo;
import businesslogicservice.creditBLService.CreditBLService;

public class CreditInfoForOrder implements CreditInfo {
	CreditBLService creditBLService;

	public CreditInfoForOrder() {
		creditBLService = new CreditController();
	}

	/**
	 * 
	 * @param id
	 * @return 查询用户信用值
	 */
	@Override
	public int getCreditByUserID(int id) {
		// TODO Auto-generated method stub
		return creditBLService.getCredit(id).getCredit();
	}

	/**
	 * 
	 * @param id
	 * @return 更新用户信用值
	 */
	@Override
	public void updateCreditByUserID(int id, int creditValue) {
		creditBLService.addCredit(id, creditValue);
	}
}
