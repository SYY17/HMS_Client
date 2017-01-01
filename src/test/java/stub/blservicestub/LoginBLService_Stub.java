package stub.blservicestub;

import businesslogicservice.ResultMessage;
import businesslogicservice.loginblservice.LoginBLService;

public class LoginBLService_Stub implements LoginBLService{

	String username;
	String password;
	int id;
	
	public LoginBLService_Stub(String u, String p, int i) {
		// TODO Auto-generated constructor stub
		username = u;
		password = p;
		id = i;
	}
	
	/**
	 * 添加用户
	 */
	@Override
	public ResultMessage addNewUser(String username, String password, int id) {
		// TODO Auto-generated method stub
		if(username != null && password != null && id>=1 && id<=4){
			return ResultMessage.TRUE;
		}
		else return ResultMessage.FALSE;
	}

	/**
	 * 用户登录
	 */
	@Override
	public ResultMessage login(String username, String password, int id) {
		// TODO Auto-generated method stub
		if(username != null && password != null && id>=1 && id<=4){
			return ResultMessage.TRUE;
		}
		else return ResultMessage.FALSE;
	}

	/**
	 * 用户注销
	 */
	@Override
	public ResultMessage logout(String username) {
		// TODO Auto-generated method stub
		if(username != null){
			return ResultMessage.TRUE;
		}
		else return ResultMessage.FALSE;
	}

}
