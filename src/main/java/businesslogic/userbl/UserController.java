package businesslogic.userbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogicservice.ResultMessage;
import businesslogicservice.userblservice.UserBLService;
import po.UserPO;
import rmi.RemoteController;
import runner.DataServiceClientRunner;
import vo.UserVO;

public class UserController implements UserBLService{

	private RemoteController remoteController;
	private UserLineItem userLineItem;
	
	public UserController() {
		// TODO Auto-generated constructor stub
		this.startRunner();
		userLineItem = new UserLineItem();
	}
	
	/**
	 * 
	 * @param uvo
	 * @return 增加用户
	 */
	@Override
	public ResultMessage addUser(UserVO uvo) {
		// TODO Auto-generated method stub
		try {
			remoteController.getUserDataService().initUserDataService();
			userLineItem.setUserLineItem(uvo);
			remoteController.getUserDataService().insertUser(userLineItem.getUserPO());
			remoteController.getUserDataService().finishUserDataService();
			return ResultMessage.TRUE;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResultMessage.FALSE;
	}

	/**
	 * 
	 * @param uvo
	 * @return 删除用户
	 */
	@Override
	public ResultMessage deleteUser(int id) {
		// TODO Auto-generated method stub
		try {
			remoteController.getUserDataService().initUserDataService();
			remoteController.getUserDataService().deleteUser(id);
			remoteController.getUserDataService().finishUserDataService();
			return ResultMessage.TRUE;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResultMessage.FALSE;
	}

	/**
	 * 
	 * @param uvo
	 * @return 修改用户
	 */
	@Override
	public ResultMessage modifyUser(UserVO uvo) {
		// TODO Auto-generated method stub
		try {
			remoteController.getUserDataService().initUserDataService();
			userLineItem.setUserLineItem(uvo);
			remoteController.getUserDataService().updateUser(userLineItem.getUserPO());
			remoteController.getUserDataService().finishUserDataService();
			return ResultMessage.TRUE;
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return ResultMessage.FALSE;
	}

	/**
	 * 
	 * @param id
	 * @return 按照用户名搜索用户
	 */
	@Override
	public UserVO searchByUserName(String username) {
		// TODO Auto-generated method stub
		UserVO uvo = null;
		try {
			remoteController.getUserDataService().initUserDataService();
			UserPO upo = remoteController.getUserDataService().findUser(username);
			remoteController.getUserDataService().finishUserDataService();
			
			userLineItem.setUserLineItem(upo);
			uvo = userLineItem.getUserVO();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return uvo;
	}

	/**
	 *
	 * @return 获得所有用户
	 */
	@Override
	public ArrayList<UserVO> getAllUsers() {
		// TODO Auto-generated method stub
		ArrayList<UserVO> list = new ArrayList<UserVO>();
		try {
			remoteController.getUserDataService().initUserDataService();
			ArrayList<UserPO> upoList = remoteController.getUserDataService().findAll();
			remoteController.getUserDataService().finishUserDataService();
			
			for(int i = 0; i<upoList.size(); i++){
				userLineItem.setUserLineItem(upoList.get(i));
				list.add(userLineItem.getUserVO());
			}
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return list;
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
