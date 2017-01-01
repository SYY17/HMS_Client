package businesslogic.loginbl;

import java.rmi.RemoteException;
import dataservice.logindataservice.LoginDataService;

public class LoginDataService_Driver {

	public void drive(LoginDataService loginDataService) throws RemoteException {
//		UserPO upo = new UserPO();
		loginDataService.initLoginDataService();
		loginDataService.finishLoginDataService();
	}
}
