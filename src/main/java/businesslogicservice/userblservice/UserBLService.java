package businesslogicservice.userblservice;

import java.util.ArrayList;

import businesslogicservice.ResultMessage;
import vo.UserVO;

public interface UserBLService{
	
	/**
	 * 
	 * @param uvo
	 * @return 增加用户
	 */
	public ResultMessage addUser(UserVO uvo);
	
	/**
	 * 
	 * @param uvo
	 * @return 删除用户
	 */
	public ResultMessage deleteUser(int id);
	
	/**
	 * 
	 * @param uvo
	 * @return 修改用户
	 */
	public ResultMessage modifyUser(UserVO uvo);
	
	/**
	 * 
	 * @param username
	 * @return 按照username搜索用户
	 */
	public UserVO searchByUserName(String username);
	
	/**
	 * 
	 * @return 获得所有用户
	 */
	public ArrayList<UserVO> getAllUsers();
	
	/**
	 * 
	 * @param userName
	 * @return 根据用户ID查找并返回用户名
	 */
	public String searchByUserID(int id);
}