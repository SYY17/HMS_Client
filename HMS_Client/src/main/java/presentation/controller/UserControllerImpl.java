package presentation.controller;

import java.util.ArrayList;

import businesslogic.userbl.UserBLService_Stub;
import businesslogicservice.ResultMessage;
import businesslogicservice.userblservice.UserBLService;
import presentation.userui.UserControllerService;
import vo.UserVO;

public class UserControllerImpl implements UserControllerService{
	
	private UserBLService userBlService;
	
	public UserControllerImpl(int i,String u,String p){
		userBlService=new UserBLService_Stub(i,u,p);
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
	public UserVO searchByID(int id) {
		// TODO Auto-generated method stub
		return userBlService.searchByID(id);
	}

	/**
	 * 
	 * @param keywords
	 * @return 按照关键词搜索用户
	 */
	@Override
	public ArrayList<UserVO> searchByKeywords(String keywords) {
		// TODO Auto-generated method stub
		return userBlService.searchByKeywords(keywords);
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

}
