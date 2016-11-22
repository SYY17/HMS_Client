package po;

import java.io.Serializable;

public class LoginPO implements Serializable{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int id;
	String name;
	String password;
	
	public LoginPO(){
		id=0;
		name="User";
		password="password";
	}
	
	public LoginPO(int i,String n,String p){
		id=i;
		name=n;
		password=p;
	}
	
	/**
	 * 
	 * @return 获得用户名
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * 
	 * @return 获得用户ID
	 */
	public int getID(){
		return id;
	}
	
	/**
	 * 
	 * @return 获得用户密码
	 */
	public String getPassword(){
		return password;
	}
}
