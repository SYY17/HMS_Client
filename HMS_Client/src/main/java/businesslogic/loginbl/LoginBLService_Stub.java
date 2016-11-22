package businesslogic.loginbl;

import businesslogicservice.ResultMessage;
import businesslogicservice.loginblservice.LoginBLService;

public class LoginBLService_Stub implements LoginBLService{

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
		if(username=="User"){
			return ResultMessage.TRUE;
		}else
			return ResultMessage.FALSE;
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
		return ResultMessage.TRUE;
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
		return ResultMessage.TRUE;
	}
	

}
