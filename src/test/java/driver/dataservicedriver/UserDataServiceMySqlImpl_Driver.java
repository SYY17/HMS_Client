package driver.dataservicedriver;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.userdataservice.UserDataService;
import po.UserPO;

public class UserDataServiceMySqlImpl_Driver {
	
	public void drive(UserDataService userDataService) throws RemoteException{
		int id = 10101001;
		String username = "user";
		String password = "000000";
		UserPO upo = new UserPO(id, username, password);
		
		//初始化UserDataService
		userDataService.initUserDataService();
		System.out.println("UserDataService initialized\n");
		
		//删除用户
		userDataService.deleteUser(id);
		System.out.println("User deleted\n");
		
		//添加用户
		userDataService.insertUser(upo);
		System.out.println("User inserted\n");
		
		//更新用户
		userDataService.updateUser(upo);
		System.out.println("User updated\n");
		
		//根据ID查找并返回用户名
		String name = userDataService.findUser(id);
		if(name.equals(username)) System.out.println("User with certain id found\n");
		
		//根据用户名查找并返回用户信息
		upo = userDataService.findUser(username);
		if(upo != null && upo.getName().equals(username)) System.out.println("User with certain name found\n");
		
		//查找并返回全部用户信息
		ArrayList<UserPO> list = userDataService.findAll();
		if(list != null) System.out.println("All user got\n");
		
		//结束UserDataService
		userDataService.finishUserDataService();
		System.out.println("UserDataService finished\n");
	}
}
