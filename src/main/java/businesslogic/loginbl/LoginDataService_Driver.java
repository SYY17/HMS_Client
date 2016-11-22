package businesslogic.loginbl;

import java.rmi.RemoteException;
import dataservice.logindataservice.LoginDataService;
import po.UserPO;

public class LoginDataService_Driver {
	
	public void drive(LoginDataService loginDataService) throws RemoteException{
		UserPO upo=new UserPO();
		loginDataService.initLoginDataService();
		loginDataService.insertUser(null, null, 0);
		upo = loginDataService.findUser(0);
		if(upo!=null) System.out.println("User found!");
		loginDataService.finishLoginDataService();
	}
}
