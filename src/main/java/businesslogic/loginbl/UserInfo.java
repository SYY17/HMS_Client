package businesslogic.loginbl;

public interface UserInfo {
	
	/**
	 * 
	 * @return 获得在线用户ID
	 */
	public int getID();
	
	/**
	 * 
	 * @return 获得在线用户name
	 */
	public String getName();
	
	/**
	 * 
	 * @return 获得在线用户password
	 */
	public String getPassword();
	
}
