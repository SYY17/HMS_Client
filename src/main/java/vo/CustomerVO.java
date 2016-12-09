package vo;

public class CustomerVO extends UserVO {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String realName;
	String phoneNumber;
	String email;

	public CustomerVO(int i, String n, String p, String r, String pN, String e) {
		// TODO Auto-generated constructor stub
		super(i, n, p);
		realName = r;
		phoneNumber = pN;
		email = e;
	}

	public CustomerVO(UserVO uvo, String r, String pN, String e) {
		this(uvo.getID(), uvo.getName(), uvo.getPassword(), r, pN, e);
	}

	public String getRealName() {
		return realName;
	}

	public String getPhoneNumber() {
		return phoneNumber;
	}

	public String getEmail() {
		return email;
	}
}
