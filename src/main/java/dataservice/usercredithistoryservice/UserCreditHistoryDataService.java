package dataservice.usercredithistoryservice;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;

import po.CreditMovement;
import po.UserCreditHistoryPO;

public interface UserCreditHistoryDataService extends Remote {

	/**
	 * 
	 * @param ucpo
	 */
	public void updateHistory(int userID, int change, Date date, CreditMovement creditMovement, int remain) throws RemoteException;

	/**
	 * 
	 * @param userId
	 * @return 根据用户ID查找历史记录
	 */
	public ArrayList<UserCreditHistoryPO> findCreditHistory(int userId) throws RemoteException;

	/**
	 * 
	 * @return 查找所有历史记录
	 */
	public ArrayList<UserCreditHistoryPO> getAllCreditHistory() throws RemoteException;

	/**
	 * 
	 * @throws RemoteException
	 */
	public void initUserCreditHistoryDataService() throws RemoteException;

	/**
	 * 
	 * @throws RemoteException
	 */
	public void finishUserCreditHistoryDataService() throws RemoteException;

}
