package businesslogic.orderbl;

import vo.CreditMovement;

public interface CreditInfo {
	/**
	 * 
	 * @param id
	 * @return 查询用户信用值
	 */
	public int getCreditByUserID(int id);

	/**
	 * 
	 * @param id
	 * @return 更新用户信用值
	 */
	public void updateCreditByUserID(int id, int creditValue, CreditMovement creditMovement);
}
