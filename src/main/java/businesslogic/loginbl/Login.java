package businesslogic.loginbl;

import java.util.ArrayList;

public class Login {
	ArrayList<LoginList> login;

	/**
	 * 
	 * @param loginList
	 */
	public void addLoginList(LoginList loginlist) {
		login.add(loginlist);
	}

	/**
	 * 
	 * @param id
	 */
	public void deleteLoginList(int id) {
		login.remove(id);
	}

	/**
	 * 
	 * @param loginList
	 * @param id
	 */
	public void modifyLoginList(LoginList loginlist, int id) {
		login.set(id, loginlist);
	}

	/**
	 * 
	 * @param id
	 */
	public void findLoginList(int id) {
		login.get(id);
	}
}
