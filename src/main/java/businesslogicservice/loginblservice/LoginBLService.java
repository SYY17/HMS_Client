package businesslogicservice.loginblservice;

import businesslogicservice.ResultMessage;

public interface LoginBLService {
	
	/**
	 * 
	 * @param username
	 * @param password
	 * @param id
	 * @return 增加新用户
	 */
	public ResultMessage addNewUser(String username,String password,int id);
	
	/**
	 * 
	 * @param username
	 * @param password
	 * @param id
	 * @return 登录
	 */
	public ResultMessage login(String username,String password);
	
	/**
	 * 
	 * @param username
	 * @param password
	 * @param id
	 * @return 注销
	 */
	public ResultMessage logout(String username);
}
