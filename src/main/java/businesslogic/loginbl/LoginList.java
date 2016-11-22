package businesslogic.loginbl;

import java.util.ArrayList;


public class LoginList {
	ArrayList<LoginLineItem> loginList;
	
	/**
	 * 
	 * @param loginList
	 */
	public void setLoginList(ArrayList<LoginLineItem> loginList){
		this.loginList=loginList;
	}
	
	/**
	 * 
	 * @return 获得在线列表
	 */
	public ArrayList<LoginLineItem> getLoginList(){
		return loginList;
	}
	
	/**
	 * 
	 * @param loginLineItem
	 */
	public void add(LoginLineItem loginLineItem){
		loginList.add(loginLineItem);
	}
	
	/**
	 * 
	 * @param id
	 */
	public void delete(int id){
		loginList.remove(id);
	}
	
	/**
	 * 
	 * @param loginLineItem
	 * @param id
	 */
	public void modify(LoginLineItem loginLineItem,int id){
		loginList.set(id, loginLineItem);
	}
	
	/**
	 * 
	 * @param id
	 */
	public void find(int id) {
		loginList.get(id);
	}
}
