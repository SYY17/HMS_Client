package dataservice.customerdataservice;

import java.rmi.Remote;
import java.rmi.RemoteException;

import po.CustomerPO;

public interface CustomerDataService extends Remote{
	
	/**
	 * 
	 * @param username
	 * @return 根据用户名查找并返回顾客信息
	 * @throws RemoteException
	 */
	public CustomerPO findUser(String username) throws RemoteException;
}
