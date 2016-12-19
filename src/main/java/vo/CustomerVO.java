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
	String address;
	int member;
	String enterprise;

	public CustomerVO(int i, String n, String p, Date b, String pN, String e, String a, int m, String et) {
		// TODO Auto-generated constructor stub
		super(i, n, p);
		birthday = b;
		phoneNumber = pN;
		email = e;
		address = a;
		member = m;
		enterprise = et;
	}

	public CustomerVO(UserVO uvo, Date b, String pN, String e, String a, int m, String et) {
		this(uvo.getID(), uvo.getName(), uvo.getPassword(), b, pN, e, a, m, et);
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
	
	/**
	 * 
	 * @return 获取用户地址
	 */
	public String getAddress(){
		return address;
	}
	
	/**
	 * 
	 * @return 获取会员种类
	 */
	public int getMember(){
		return member;
	}
	
	/**
	 * 
	 * @return 获取企业名称
	 */
	public String getEnterprise(){
		return enterprise;
	}
}
