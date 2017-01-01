package driver.blservicedriver;

import java.util.ArrayList;

import businesslogicservice.ResultMessage;
import businesslogicservice.userblservice.UserBLService;
import vo.UserVO;

public class UserBLService_Driver {
	
	public void drive(UserBLService userBLService){
		
		String username = "newsaler";
		String password = "000000";
		int id = 3;
		UserVO uvo = new UserVO(id, username, password);
		
		//删除用户
		ResultMessage resultMessage = userBLService.deleteUser(id);
		if(resultMessage == ResultMessage.TRUE) System.out.println("User deleted\n");
		
		//增加用户
		resultMessage = userBLService.addUser(uvo);
		if(resultMessage == ResultMessage.TRUE) System.out.println("User added\n");
		
		//修改用户
		resultMessage = userBLService.modifyUser(uvo);
		if(resultMessage == ResultMessage.TRUE) System.out.println("User modified\n");
		
		//根据用户ID查找并返回用户名
		String name = userBLService.searchByUserID(id);
		if(name.equals(username)) System.out.println("User with certain id found\n");
		
		//按照username搜索用户
		UserVO temp = userBLService.searchByUserName(username);
		if(temp != null && temp.getName().equals(username)) System.out.println("User with certain name found\n");
		
		//获得所有用户
		ArrayList<UserVO> list = userBLService.getAllUsers();
		if(list != null) System.out.println("All Users got\n");
	}
}
