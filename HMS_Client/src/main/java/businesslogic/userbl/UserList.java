package businesslogic.userbl;

import java.util.ArrayList;

public class UserList {
	ArrayList<UserLineItem> userList;
	
	/**
	 * 
	 * @param userList
	 */
	public void setUserList(ArrayList<UserLineItem> userList){
		this.userList = userList;
	}
	
	/**
	 * 
	 * @return 获得用户列表
	 */
	public ArrayList<UserLineItem> getUserList(){
		return userList;
	}
	
	/**
	 * 
	 * @param userlineItem
	 */
	public void add(UserLineItem userLineItem){
		userList.add(userLineItem);
	}
	
	/**
	 * 
	 *@param id
	 */
	public void delete(int id){
		userList.remove(id);
	}
	
	/**
	 * 
	 * @param userLineItem
	 * @param id
	 */
	public void modify(UserLineItem userLineItem,int id){
		userList.set(id, userLineItem);
	}
	
	/**
	 * 
	 * @param id
	 */
	public void find(int id) {
		userList.get(id);
	}
}
