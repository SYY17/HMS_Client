package presentation.controller;

import businesslogic.loginbl.LoginController;
import businesslogicservice.ResultMessage;
import businesslogicservice.loginblservice.LoginBLService;
import presentation.loginui.LoginControllerService;

public class LoginControllerImpl implements LoginControllerService {

	private LoginBLService loginBlService;

	public LoginControllerImpl() {
		loginBlService = new LoginController();
	}

	/**
	 * 
	 * @param username
	 * @param password
	 *            * @param id
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
	 *            * @param id
	 * @return 登录
	 */
	@Override
	public ResultMessage login(String username, String password, int id) {
		// TODO Auto-generated method stub
		return loginBlService.login(username, password, id);
	}

	/**
	 * 
	 * @param username
	 * @param password
	 *            * @param id
	 * @return 注销
	 */
	@Override
	public ResultMessage logout(String username, String password, int id) {
		// TODO Auto-generated method stub
		return loginBlService.logout(username);
	}

}
