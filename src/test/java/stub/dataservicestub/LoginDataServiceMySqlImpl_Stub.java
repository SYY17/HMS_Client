package stub.dataservicestub;
import java.rmi.RemoteException;
import dataservice.logindataservice.LoginDataService;

public class LoginDataServiceMySqlImpl_Stub implements LoginDataService{

	/**
	 * 验证是否存在相应用户
	 */
	@Override
	public boolean isValidateUser(String username, String password, int id) throws RemoteException {
		// TODO Auto-generated method stub
		if(username != null && password != null && id>=10000000 && id<50000000){
			return true;
		}
		else return false;
	}

	/**
	 * 初始化
	 */
	@Override
	public void initLoginDataService() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Init Finished!");
	}

	/**
	 * 结束
	 */
	@Override
	public void finishLoginDataService() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Finish Finished!");
	}

}
