package stub.dataservicestub;

import java.rmi.RemoteException;
import java.util.ArrayList;

import dataservice.userdataservice.UserDataService;
import po.UserPO;

public class UserDataServiceMySqlImpl_Stub implements UserDataService{

	String username;
	UserPO upo;
	
	public UserDataServiceMySqlImpl_Stub(String u, UserPO upo) {
		// TODO Auto-generated constructor stub
		username = u;
		this.upo = upo;
	}
	
	/**
	 * 添加用户
	 */
	@Override
	public void insertUser(UserPO upo) throws RemoteException {
		// TODO Auto-generated method stub
		if(upo != null && upo.getName() != null && upo.getPassword() != null && upo.getID()>=10000000 && upo.getID()<50000000){
			System.out.println("Insert succeed!");
		}
		else System.out.println("Insert failed!");
	}

	/**
	 * 删除用户
	 */
	@Override
	public void deleteUser(int id) throws RemoteException {
		// TODO Auto-generated method stub
		if(id>=10000000 && id<50000000){
			System.out.println("Delete succeed!");
		}
		else System.out.println("Delete failed!");
	}

	/**
	 * 更新用户
	 */
	@Override
	public void updateUser(UserPO upo) throws RemoteException {
		// TODO Auto-generated method stub
		if(upo != null && upo.getName() != null && upo.getPassword() != null && upo.getID()>=10000000 && upo.getID()<50000000){
			System.out.println("Update succeed!");
		}
		else System.out.println("Update failed!");
	}

	/**
	 * 根据用户名查找并返回用户信息
	 */
	@Override
	public UserPO findUser(String username) throws RemoteException {
		// TODO Auto-generated method stub
		if(username != null){
			return upo;
		}
		else return null;
	}

	/**
	 * 根据ID查找并返回用户名
	 */
	@Override
	public String findUser(int id) throws RemoteException {
		// TODO Auto-generated method stub
		if(id>=10000000 && id<50000000){
			return username;
		}
		else return null;
	}

	/**
	 * 查找并返回全部用户信息
	 */
	@Override
	public ArrayList<UserPO> findAll() throws RemoteException {
		// TODO Auto-generated method stub
		ArrayList<UserPO> list = new ArrayList<>();
		list.add(upo);
		return list;
	}

	/**
	 * 初始化
	 */
	@Override
	public void initUserDataService() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Init Finished!");
	}

	/**
	 * 结束
	 */
	@Override
	public void finishUserDataService() throws RemoteException {
		// TODO Auto-generated method stub
		System.out.println("Finish Finished!");
	}
	
}
