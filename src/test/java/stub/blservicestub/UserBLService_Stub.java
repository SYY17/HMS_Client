package stub.blservicestub;

import java.util.ArrayList;

import businesslogicservice.ResultMessage;
import businesslogicservice.userblservice.UserBLService;
import vo.UserVO;

public class UserBLService_Stub implements UserBLService{

	int id;
	String username;
	UserVO uvo;
	
	public UserBLService_Stub(int i, String u, UserVO vo) {
		// TODO Auto-generated constructor stub
		id = i;
		username = u;
		uvo = vo;
	}
	
	/**
	 * 添加用户
	 */
	@Override
	public ResultMessage addUser(UserVO uvo) {
		// TODO Auto-generated method stub
		if(uvo != null && uvo.getName() != null && uvo.getPassword() != null && uvo.getID()>=1 && uvo.getID()<=4){
			return ResultMessage.TRUE;
		}
		else return ResultMessage.FALSE;
	}

	/**
	 * 删除用户
	 */
	@Override
	public ResultMessage deleteUser(int id) {
		// TODO Auto-generated method stub
		if(id>=10000000 && id<50000000){
			return ResultMessage.TRUE;
		}
		else return ResultMessage.FALSE;
	}

	/**
	 * 修改用户
	 */
	@Override
	public ResultMessage modifyUser(UserVO uvo) {
		// TODO Auto-generated method stub
		if(uvo != null && uvo.getName() != null && uvo.getPassword() != null){
			return ResultMessage.TRUE;
		}
		else return ResultMessage.FALSE;
	}

	/**
	 * 按照用户名搜索用户
	 */
	@Override
	public UserVO searchByUserName(String username) {
		// TODO Auto-generated method stub
		if(username != null){
			return uvo;
		}
		else return null;
	}

	/**
	 * 获得所有用户
	 */
	@Override
	public ArrayList<UserVO> getAllUsers() {
		// TODO Auto-generated method stub
		ArrayList<UserVO> list = new ArrayList<UserVO>();
		list.add(uvo);
		return list;
	}

	/**
	 * 根据用户ID查找并返回用户名
	 */
	@Override
	public String searchByUserID(int id) {
		// TODO Auto-generated method stub
		if(id>=10000000 && id<50000000){
			return username;
		}
		else return null;
	}
	
}




