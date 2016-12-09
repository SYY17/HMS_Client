package businesslogic.userbl;

import java.rmi.RemoteException;
import java.util.ArrayList;

import businesslogicservice.ResultMessage;
import businesslogicservice.userblservice.UserBLService;
import dataservice.userdataservice.UserDataService;
import po.UserPO;
import rmi.RemoteController;
import runner.DataServiceClientRunner;
import vo.UserVO;

public class UserController implements UserBLService {

	private RemoteController remoteController;
	private UserDataService userdataservice;
	private UserLineItem userLineItem;

	public UserController() {
		// TODO Auto-generated constructor stub
		DataServiceClientRunner runner = new DataServiceClientRunner();
		runner.start();
		remoteController = runner.getRemoteController();
		userdataservice = remoteController.getUserDataService();
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
			userdataservice.initUserDataService();
			userLineItem.setUserLineItem(uvo);
			userdataservice.insertUser(userLineItem.getUserPO());
			userdataservice.finishUserDataService();
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
			userdataservice.initUserDataService();
			userdataservice.deleteUser(id);
			userdataservice.finishUserDataService();
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
			userdataservice.initUserDataService();
			userLineItem.setUserLineItem(uvo);
			userdataservice.updateUser(userLineItem.getUserPO());
			userdataservice.finishUserDataService();
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
			userdataservice.initUserDataService();
			UserPO upo = userdataservice.findUser(username);
			userdataservice.finishUserDataService();

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
			userdataservice.initUserDataService();
			ArrayList<UserPO> upoList = userdataservice.findAll();
			userdataservice.finishUserDataService();

			for (int i = 0; i < upoList.size(); i++) {
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
	 * 
	 * @param userName
	 * @return 根据用户ID查找并返回用户名
	 */
	@Override
	public String searchByUserID(int id) {
		// TODO Auto-generated method stub
		String username = null;

		try {
			userdataservice.initUserDataService();
			username = userdataservice.findUser(id);
			userdataservice.finishUserDataService();
		} catch (RemoteException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		return username;
	}

}
