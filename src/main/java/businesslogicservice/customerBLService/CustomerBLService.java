package businesslogicservice.customerBLService;

import java.rmi.RemoteException;

import vo.CustomerVO;

public interface CustomerBLService {
	
	/**
	 * 
	 * @param username
	 * @return 添加新的顾客信息
	 */
	public boolean addNewCustomer(String username);
	
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
	public boolean setCustomerInfo(CustomerVO cvo);
	
	/**
	 * 
	 * @param username
	 * @return 删除顾客信息
	 */
	public boolean deleteCustomer(String username);
}
