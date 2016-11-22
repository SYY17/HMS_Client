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
	 * @param id
	 * @return 按照id搜索用户
	 */
	public UserVO searchByID(int id);
	
	/**
	 * 
	 * @param keywords
	 * @return 按照关键词搜索用户
	 */
	public ArrayList<UserVO> searchByKeywords(String keywords);
	
	/**
	 * 
	 * @return 获得所有用户
	 */
	public ArrayList<UserVO> getAllUsers();
}