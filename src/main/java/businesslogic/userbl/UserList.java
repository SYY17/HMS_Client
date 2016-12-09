package businesslogic.userbl;

import java.util.ArrayList;

public class UserList {
	ArrayList<UserLineItem> userList;

	public UserList() {
		// TODO Auto-generated constructor stub
		userList = new ArrayList<UserLineItem>();
	}

	/**
	 * 
	 * @param userList
	 */
	public void setUserList(ArrayList<UserLineItem> userList) {
		this.userList = userList;
	}

	/**
	 * 
	 * @param list
	 */
	public void addAll(ArrayList<UserLineItem> list) {
		userList.addAll(list);
	}

	/**
	 * 
	 * @param userlineItem
	 */
	public void add(UserLineItem userLineItem) {
		userList.add(userLineItem);
	}

	/**
	 * 
	 * @param id
	 */
	public void remove(int id) {
		userList.remove(id);
	}

	/**
	 * 
	 * @param userLineItem
	 * @param id
	 */
	public void modify(int index, UserLineItem userLineItem) {
		userList.set(index, userLineItem);
	}

	/**
	 * 
	 * @param id
	 */
	public UserLineItem get(int index) {
		return userList.get(index);
	}

	/**
	 * 
	 * @return size
	 */
	public int size() {
		return userList.size();
	}

	public void clear() {
		userList.clear();
	}
}
