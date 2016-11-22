package businesslogic.loginbl;

import businesslogicservice.ResultMessage;
import businesslogicservice.loginblservice.LoginBLService;

public class LoginController implements LoginBLService{

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
		return null;
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
		return null;
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
		return null;
	}

}
