package businesslogic.loginbl;

import java.rmi.RemoteException;

import businesslogicservice.ResultMessage;
import businesslogicservice.loginblservice.LoginBLService;
import po.UserPO;
import rmi.RemoteController;
import runner.DataServiceClientRunner;

public class LoginController implements LoginBLService{

	private RemoteController remoteController;
	
	public LoginController() {
		// TODO Auto-generated constructor stub
		this.startRunner();
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
		try {
			remoteController.getUserDataService().initUserDataService();
			UserPO user = remoteController.getUserDataService().findUser(username);
			
			//如果user数据不为空，表示已有该用户信息，直接返回注册失败
			if(user != null){
				return ResultMessage.FALSE;
			}
			
			user = new UserPO(id, username, password);
			remoteController.getUserDataService().insertUser(user);
			remoteController.getUserDataService().finishUserDataService();
			return ResultMessage.TRUE;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		};
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
	public ResultMessage login(String username, String password) {
		// TODO Auto-generated method stub
		try {
			UserPO user = remoteController.getUserDataService().findUser(username);
			if(user.getPassword().equals(password)){
				return ResultMessage.TRUE;
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResultMessage.FALSE;
	}

	/**
	 * 
	 * @param username
	 * @param password
	 * * @param id
	 * @return 注销
	 */
	@Override
	public ResultMessage logout(String username) {
		// TODO Auto-generated method stub
		if(username != null){
			return ResultMessage.TRUE;
		}
		
		return ResultMessage.FALSE;
	}
	
	/**
	 * 建立连接，待删除
	 */
	private void startRunner(){
		DataServiceClientRunner runner = new DataServiceClientRunner();
		runner.start();
		remoteController = runner.getRemoteController();
		
	}

}
