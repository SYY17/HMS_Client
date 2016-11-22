package businesslogic.userbl;

import java.util.ArrayList;

import businesslogicservice.ResultMessage;
import businesslogicservice.userblservice.UserBLService;
import vo.UserVO;

public class UserBLService_Stub implements UserBLService{
	int id;
	String name;
	String password;
	
	
	public UserBLService_Stub(int i,String n,String p){
		id=i;
		name=n;
		password=p;
	}
	
	/**
	 * 
	 * @param uvo
	 * @return 增加用户
	 */
	@Override
	public ResultMessage addUser(UserVO uvo) {
		// TODO Auto-generated method stub
		if(uvo!=null){
			return ResultMessage.TRUE;
		}else
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
		if(id != 0){
			return ResultMessage.TRUE;
		}else
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
		if(uvo!=null){
			return ResultMessage.TRUE;
		}else
			return ResultMessage.FALSE;
	}

	/**
	 * 
	 * @param id
	 * @return 按照id搜索用户
	 */
	@Override
	public UserVO searchByID(int id) {
		// TODO Auto-generated method stub
		UserVO user=new UserVO();
		return user;
	}

	/**
	 * 
	 * @param keywords
	 * @return 按照关键词搜索用户
	 */
	@Override
	public ArrayList<UserVO> searchByKeywords(String keywords) {
		// TODO Auto-generated method stub
		ArrayList<UserVO> UserList = new ArrayList<>();
		UserList.add(new UserVO(00000000,null,null));
		return UserList;
	}

	/**
	 *
	 * @return 获得所有用户
	 */
	@Override
	public ArrayList<UserVO> getAllUsers() {
		// TODO Auto-generated method stub
		ArrayList<UserVO> userList=new ArrayList<UserVO>();
		return userList;
	}

}