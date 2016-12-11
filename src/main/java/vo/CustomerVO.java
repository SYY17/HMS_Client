package vo;

import java.sql.Date;

public class CustomerVO extends UserVO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	Date birthday;
	String phoneNumber;
	String email;

	public CustomerVO(int i, String n, String p, Date b, String pN, String e) {
		// TODO Auto-generated constructor stub
		super(i, n, p);
		birthday = b;
		phoneNumber = pN;
		email = e;
	}

	public CustomerVO(UserVO uvo, Date b, String pN, String e) {
		this(uvo.getID(), uvo.getName(), uvo.getPassword(), b, pN, e);
	}

	/**
	 * 
	 * @return 获取用户生日
	 */
	public Date getBirthday() {
		return birthday;
	}

	/**
	 * 
	 * @return 获取用户电话号码
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * 
	 * @return 获取用户邮箱
	 */
	public String getEmail() {
		return email;
	}
}
