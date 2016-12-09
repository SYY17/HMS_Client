package vo;

import java.io.*;

public class UserVO implements Serializable {// can we add a Userole just like
												// the book did
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int id;
	String name;
	String password;

	public UserVO() {
		id = 0;
		name = "User";
		password = "password";
	}

	public UserVO(int i, String n, String p) {
		id = i;
		name = n;
		password = p;
	}

	public String getName() {
		return name;
	}

	public int getID() {
		return id;
	}

	public String getPassword() {
		return password;
	}
}
