package presentation.userui;

import vo.UserVO;

public class SystemUserDataHelper {

	/**
	 * 将UserVO对象转换为SystemUserData对象
	 * @param uvo
	 */
	public SystemUserData toSystemUserData(UserVO uvo){
		String id = String.valueOf(uvo.getID());
		String username = uvo.getName();
		String identity = getIdentity(uvo.getID());
		String operation = "管理";
		
		return new SystemUserData(id, username, identity, operation);
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
	
}
