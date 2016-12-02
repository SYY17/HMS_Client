package presentation.userui;

import vo.UserVO;

public class UserDataHelper {

	/**
	 * 将UserVO对象转换为UserData对象
	 * @param uvo
	 */
	public UserData toUserData(UserVO uvo){
		String id = String.valueOf(uvo.getID());
		String username = uvo.getName();
		String identity = getIdentity(uvo.getID());
		String start = getStart(uvo.getID());
		String operation = "管理";
		
		return new UserData(id, username, identity, start, operation);
	}
	
	/**
	 * 
	 * @param id
	 * @return 根据ID查找身份
	 */
	private String getIdentity(int id){
		char c = String.valueOf(id).charAt(0);
		
		if(c == '1'){
			return "客户";
		}else if(c == '2'){
			return "酒店工作人员";
		}else if(c == '3'){
			return "网站营销人员";
		}
		return "网站管理人员";
	}
	
	/**
	 * 
	 * @param id
	 * @return 根据ID查找创建时间
	 */
	private String getStart(int id){
		String temp = String.valueOf(id);
		String result = temp.substring(1, 3)+"-"+temp.substring(3, 5);
		return result;
	}
}
