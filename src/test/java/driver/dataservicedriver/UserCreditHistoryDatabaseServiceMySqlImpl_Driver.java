package driver.dataservicedriver;

import java.rmi.RemoteException;
import dataservice.usercredithistoryservice.UserCreditHistoryDataService;

public class UserCreditHistoryDatabaseServiceMySqlImpl_Driver {
	public void drive(UserCreditHistoryDataService userCreditHostoryDataService) throws RemoteException {
		//开始连接
		userCreditHostoryDataService.initUserCreditHistoryDataService();
		System.out.println("Service start!");

		//寻找记录
		int size = userCreditHostoryDataService.findCreditHistory(10101001).size();
		if (size > 0) {
			System.out.println("User History get!");
		}
		
		//获得记录
		size = userCreditHostoryDataService.getAllCreditHistory().size();
		if (size > 0) {
			System.out.println("All History get!");
		}

		//结束连接
		userCreditHostoryDataService.finishUserCreditHistoryDataService();
		System.out.println("Service finished!");
	}
}
