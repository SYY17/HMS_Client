package presentation.controller;

public class UserNameHelper {

	// 单件模式
	private static UserNameHelper userNameHelper;
	private static String userName;

	private UserNameHelper() {

	}

	public void initialUserName(String userName) {
		UserNameHelper.userName = userName;
	}

	public static UserNameHelper getInstance() {
		if (userNameHelper == null) {
			userNameHelper = new UserNameHelper();
		}
		return userNameHelper;
	}

	public String getUserName() {
		return userName;
	}
}
