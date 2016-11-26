package businesslogic.userbl;

import java.rmi.RemoteException;
import dataservice.userdataservice.UserDataService;
import po.UserPO;

public class UserDataService_Driver {
	
	public void drive(UserDataService userDataService) throws RemoteException{
		UserPO upo = new UserPO();
		int id = 0;
		userDataService.initUserDataService();
		userDataService.insertUser(upo);
		userDataService.updateUser(upo);
		upo = userDataService.findUser(null);
		if(upo != null) System.out.println("User found!");
		userDataService.deleteUser(id);
		userDataService.finishUserDataService();
	}
}
