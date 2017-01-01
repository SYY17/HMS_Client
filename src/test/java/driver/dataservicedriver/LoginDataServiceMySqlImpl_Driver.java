package driver.dataservicedriver;

import java.rmi.RemoteException;

import dataservice.logindataservice.LoginDataService;

public class LoginDataServiceMySqlImpl_Driver {
	
	public void drive(LoginDataService loginDataService) throws RemoteException{
		
		String username = "user";
		String password = "000000";
		int id = 1;
		
		//初始化LoginDataService
		loginDataService.initLoginDataService();
		System.out.println("LoginDataService initialized\n");
		
		//验证是否存在相应用户
		boolean result = loginDataService.isValidateUser(username, password, id);
		if(result == true) System.out.println("User matches\n");
		
		//初始化LoginDataService
		loginDataService.finishLoginDataService();
		System.out.println("LoginDataService finished\n");
	}
}
