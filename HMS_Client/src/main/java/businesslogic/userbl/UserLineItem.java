package businesslogic.userbl;

public class UserLineItem {
	int id;
	String name;
	String password;
	
	public UserLineItem(int i,String n,String p){
		id = i;
		name = n;
		password = p;
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
	 * @param id
	 * @return 设置用户id
	 */
	public void setID(int id){
		this.id = id;
	}
	
	/**
	 * 
	 * @return 获得用户name
	 */
	public String getName(){
		return name;
	}
	
	/**
	 * 
	 * @param name
	 * @return 设置用户name
	 */
	public void setName(String name){
		this.name = name;
	}
	
	/**
	 * 
	 * @return 获得订单对应用户ID
	 */
	public String getPassword(){
		return password;
	}
	
	/**
	 * 
	 * @param password
	 * @return 设置用户password
	 */
	public void setPassword(String password){
		this.password = password;
	}
}
