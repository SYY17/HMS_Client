package businesslogic.userbl;

import java.util.ArrayList;

public class User {
	ArrayList<UserList> user;

	/**
	 * 
	 * @param userList
	 */
	public void addUserList(UserList userlist) {
		user.add(userlist);
	}

	/**
	 * 
	 * @param id
	 */
	public void deleteUserList(int id) {
		user.remove(id);
	}

	/**
	 * 
	 * @param userList
	 * @param id
	 */
	public void modifyUserList(UserList userlist, int id) {
		user.set(id, userlist);
	}

	/**
	 * 
	 * @param id
	 */
	public void findUserList(int id) {
		user.get(id);
	}
}
