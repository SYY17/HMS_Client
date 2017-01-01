package stub.dataservicestub;

import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;

import dataservice.usercredithistoryservice.UserCreditHistoryDataService;
import po.CreditMovement;
import po.UserCreditHistoryPO;

public class UserCreditHistoryDatabaseServiceMySqlImpl_Stub implements UserCreditHistoryDataService {
	int userID = 10101001;
	int change = 0;
	Date date = new Date(System.currentTimeMillis());
	CreditMovement creditMovement = CreditMovement.AbnormalOrder;
	int remain = 0;

	@Override
	public void updateHistory(int userID, int change, Date date, CreditMovement creditMovement, int remain)
			throws RemoteException {
		// TODO Auto-generated method stub
		if (userID == 10101001) {
			this.userID = userID;
			this.change = change;
			this.creditMovement = creditMovement;
			this.remain = remain;
			System.out.println("Success!");
		} else {
			System.out.println("Failed!");
		}
	}

	@Override
	public ArrayList<UserCreditHistoryPO> findCreditHistory(int userId) throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<UserCreditHistoryPO> list = new ArrayList<UserCreditHistoryPO>();
		if (userID == 10101001) {
			System.out.println("Success!");
			list.add(new UserCreditHistoryPO(userID, change, date, creditMovement, remain));
		} else {
			System.out.println("Failed!");
		}
		return list;
	}

	@Override
	public ArrayList<UserCreditHistoryPO> getAllCreditHistory() throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<UserCreditHistoryPO> list = new ArrayList<UserCreditHistoryPO>();
		System.out.println("Success!");
		list.add(new UserCreditHistoryPO(userID, change, date, creditMovement, remain));
		return list;

	}

	@Override
	public void initUserCreditHistoryDataService() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Success!");
	}

	@Override
	public void finishUserCreditHistoryDataService() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Success!");
	}

}
