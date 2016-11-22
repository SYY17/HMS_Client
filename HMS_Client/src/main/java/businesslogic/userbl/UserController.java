package businesslogic.userbl;

import java.util.ArrayList;

import businesslogicservice.ResultMessage;
import businesslogicservice.userblservice.UserBLService;
import vo.UserVO;

public class UserController implements UserBLService{

	/**
	 * 
	 * @param uvo
	 * @return 增加用户
	 */
	@Override
	public ResultMessage addUser(UserVO uvo) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 
	 * @param uvo
	 * @return 删除用户
	 */
	@Override
	public ResultMessage deleteUser(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 
	 * @param uvo
	 * @return 修改用户
	 */
	@Override
	public ResultMessage modifyUser(UserVO uvo) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 
	 * @param id
	 * @return 按照id搜索用户
	 */
	@Override
	public UserVO searchByID(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 * 
	 * @param keywords
	 * @return 按照关键词搜索用户
	 */
	@Override
	public ArrayList<UserVO> searchByKeywords(String keywords) {
		// TODO Auto-generated method stub
		return null;
	}

	/**
	 *
	 * @return 获得所有用户
	 */
	@Override
	public ArrayList<UserVO> getAllUsers() {
		// TODO Auto-generated method stub
		return null;
	}

}
