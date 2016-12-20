package businesslogic.userbl;

import businesslogic.orderbl.UserInfo;
import businesslogicservice.userblservice.UserBLService;

public class UserInfoForOrder implements UserInfo {

	UserBLService userController;

	public UserInfoForOrder() {
		// TODO Auto-generated constructor stub
		userController = new UserController();
	}

	/**
	 * 
	 * @param userName
	 * @return 根据用户ID查找并返回用户名
	 */
	@Override
	public String searchByUserID(int id) {
		// TODO Auto-generated method stub

		return userController.searchByUserID(id);
	}

	/**
	 * 
	 * @param ID
	 * @return 根据用户名查找并返回用户ID
	 */
	@Override
	public int searchByUserName(String userName) {
		// TODO Auto-generated method stub

		return userController.searchByUserName(userName).getID();
	}
}
