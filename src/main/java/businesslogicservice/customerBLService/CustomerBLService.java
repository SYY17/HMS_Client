package businesslogicservice.customerBLService;

import java.rmi.RemoteException;

import vo.CustomerVO;

public interface CustomerBLService {
	
	/**
	 * 
	 * @param username
	 * @return 根据用户名查找并返回顾客信息
	 * @throws RemoteException
	 */
	public CustomerVO getCustomerInfo(String username);
	
	/**
	 * 
	 * @param cvo
	 * @return 更新顾客信息
	 * @throws RemoteException
	 */
	public boolean setCustomerInfo(CustomerVO cvo) throws RemoteException;
}
