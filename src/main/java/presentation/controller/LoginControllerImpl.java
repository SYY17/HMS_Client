package presentation.controller;

import businesslogic.loginbl.LoginBLService_Stub;
import businesslogicservice.ResultMessage;
import businesslogicservice.loginblservice.LoginBLService;
import presentation.loginui.LoginControllerService;

public class LoginControllerImpl implements LoginControllerService{
	
	private LoginBLService loginBlService;
	
	public LoginControllerImpl(String u, String p, int i){
		loginBlService=new LoginBLService_Stub();
	}
	
	/**
	 * 
	 * @param username
	 * @param password
	 * * @param id
	 * @return 增加新用户
	 */
	@Override
	public ResultMessage addNewUser(String username, String password, int id) {
		// TODO Auto-generated method stub
		return loginBlService.addNewUser(username, password, id);
	}

	/**
	 * 
	 * @param username
	 * @param password
	 * * @param id
	 * @return 登录
	 */
	@Override
	public ResultMessage login(String username, String passwrd, int id) {
		// TODO Auto-generated method stub
		return loginBlService.login(username, passwrd, id);
	}

	/**
	 * 
	 * @param username
	 * @param password
	 * * @param id
	 * @return 注销
	 */
	@Override
	public ResultMessage logout(String username, String passwrd, int id) {
		// TODO Auto-generated method stub
		return loginBlService.logout(username, passwrd, id);
	}

}
