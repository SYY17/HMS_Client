package driver.dataservicedriver;

import java.rmi.RemoteException;
import dataservice.usercredithistoryservice.UserCreditHistoryDataService;

public class UserCreditHistoryDatabaseServiceMySqlImpl_Driver {
	public void drive(UserCreditHistoryDataService userCreditHostoryDataService) throws RemoteException {
		userCreditHostoryDataService.initUserCreditHistoryDataService();
		System.out.println("Service start!");

		int size = userCreditHostoryDataService.findCreditHistory(10101001).size();
		if (size > 0) {
			System.out.println("User History get!");
		}
		
		size = userCreditHostoryDataService.getAllCreditHistory().size();
		if (size > 0) {
			System.out.println("All History get!");
		}

		userCreditHostoryDataService.finishUserCreditHistoryDataService();
		System.out.println("Service finished!");
	}
}
