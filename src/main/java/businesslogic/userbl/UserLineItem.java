package businesslogic.userbl;

import po.UserPO;
import vo.UserVO;

public class UserLineItem {
	int id;
	String name;
	String password;
	
	public UserLineItem(int i,String n,String p){
		id = i;
		name = n;
		password = p;
	}
	
	public UserLineItem(UserVO uvo){
		id = uvo.getID();
		name = uvo.getName();
		password = uvo.getPassword();
	}
	
	public UserLineItem(UserPO upo){
		id = upo.getID();
		name = upo.getName();
		password = upo.getPassword();
	}

	public UserLineItem(){
		id = 0;
		name = null;
		password = null;
	}
	
	/**
	 * 
	 * @param uvo
	 */
	public void setUserLineItem(UserVO uvo){
		id = uvo.getID();
		name = uvo.getName();
		password = uvo.getPassword();
	}
	
	public void setUserLineItem(UserPO upo){
		id = upo.getID();
		name = upo.getName();
		password = upo.getPassword();
	}
	
	/**
	 * 
	 * @param i
	 * @param n
	 * @param p
	 */
	public void setUserLineItem(int i, String n, String p){
		id = i;
		name = n;
		password = p;
	}
	
	/**
	 * 
	 * @param id
	 * @return 设置用户id
	 */
	public void setID(int id){
		this.id = id;
	}
	
	/**
	 * 
	 * @return
	 */
	public int getID(){
		return id;
	}

	/**
	 * 
	 * @param name
	 * @return 设置用户name
	 */
	public void setName(String name){
		this.name = name;
	}
	
	public String getName(){
		return name;
	}
	
	/**
	 * 
	 * @param password
	 * @return 设置用户password
	 */
	public void setPassword(String password){
		this.password = password;
	}
	
	/**
	 * 
	 * @return 返回转换成的PO对象
	 */
	public UserPO getUserPO(){
		return new UserPO(id, name, password);
	}
	
	/**
	 * 
	 * @return 返回转换成的VO对象
	 */
	public UserVO getUserVO(){
		return new UserVO(id, name, password);
	}
}
