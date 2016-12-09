package presentation.controller;

import java.util.ArrayList;

import businesslogic.userbl.UserController;
import businesslogicservice.ResultMessage;
import businesslogicservice.userblservice.UserBLService;
import presentation.userui.UserControllerService;
import vo.UserVO;

public class UserControllerImpl implements UserControllerService {

	private UserBLService userBlService;

	public UserControllerImpl() {
		userBlService = new UserController();
	}

	/**
	 * 
	 * @param uvo
	 * @return 增加用户
	 */
	@Override
	public ResultMessage addUser(UserVO uvo) {
		// TODO Auto-generated method stub
		return userBlService.addUser(uvo);
	}

	/**
	 * 
	 * @param id
	 * @return 删除用户
	 */
	@Override
	public ResultMessage deleteUser(int id) {
		// TODO Auto-generated method stub
		return userBlService.deleteUser(id);
	}

	/**
	 * 
	 * @param uvo
	 * @return 修改用户
	 */
	@Override
	public ResultMessage modifyUser(UserVO uvo) {
		// TODO Auto-generated method stub
		return userBlService.modifyUser(uvo);
	}

	/**
	 * 
	 * @param id
	 * @return 按照id搜索用户
	 */
	@Override
	public UserVO searchByUserName(String username) {
		// TODO Auto-generated method stub
		return userBlService.searchByUserName(username);
	}

	/**
	 * 
	 * @return 获得所有用户
	 */
	@Override
	public ArrayList<UserVO> getAllUsers() {
		// TODO Auto-generated method stub
		return userBlService.getAllUsers();
	}

	/**
	 * 
	 * @param userName
	 * @return 根据用户ID查找并返回用户名
	 */
	public String searchByUserID(int id) {
		return userBlService.searchByUserID(id);
	}

}
