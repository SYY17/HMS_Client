package businesslogic.loginbl;

public class LoginLineItem implements UserInfo {
	int id;
	String name;
	String password;

	public LoginLineItem(int i, String n, String p) {
		id = i;
		name = n;
		password = p;
	}

	/**
	 * 
	 * @return 获得在线用户ID
	 */
	public int getID() {
		return id;
	}

	/**
	 * 
	 * @return 获得在线用户用户名
	 */
	public String getName() {
		return name;
	}

	/**
	 * 
	 * @return 获得在线用户用户密码
	 */
	public String getPassword() {
		return password;
	}

}
