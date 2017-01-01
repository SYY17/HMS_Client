package driver.blservicedriver;

import businesslogicservice.ResultMessage;
import businesslogicservice.loginblservice.LoginBLService;

public class LoginBLService_Driver {
	
	public void drive(LoginBLService loginBLService){
		
		String username = "newuser";
		String password = "000000";
		int id = 2;
		
		//增加新用户
		ResultMessage resultMessage = loginBLService.addNewUser(username, password, id);
		if(resultMessage == ResultMessage.TRUE) System.out.println("New user added\n");
		
		//验证登录
		resultMessage = loginBLService.login(username, password, id);
		if(resultMessage == ResultMessage.TRUE) System.out.println("User log in\n");
		
		//验证注销
		resultMessage = loginBLService.logout(username);
		if(resultMessage == ResultMessage.TRUE) System.out.println("User log out\n");
	}
}
