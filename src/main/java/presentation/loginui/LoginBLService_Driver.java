package presentation.loginui;

import businesslogicservice.ResultMessage;
import businesslogicservice.loginblservice.LoginBLService;

public class LoginBLService_Driver {
	
	public void drive(LoginBLService loginBLService){
		ResultMessage resultMessage=loginBLService.addNewUser("User", null, 0);
		if(resultMessage==ResultMessage.TRUE) System.out.println("New user added!");
		resultMessage=loginBLService.login(null, null);
		if(resultMessage==ResultMessage.TRUE) System.out.println("Log in!");
	}
}
