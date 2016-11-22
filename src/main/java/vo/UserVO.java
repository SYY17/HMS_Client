package vo;
import java.io.*;
public class UserVO implements Serializable{//can we add a Userole just like the book did
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	int id;
	String name;
	String password;
	
	public UserVO(){
		id=0;
		name="User";
		password="password";
	}
	
	public UserVO(int i,String n,String p){
		id=i;
		name=n;
		password=p;
	}
	
	public String getName(){
		return name;
	}
	
	public int getID(){
		return id;
	}
	
	public String getPassword(){
		return password;
	}
}

class CustomerPO extends UserVO{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	String address;
	String phoneNumber;
	String defaultQuestion;
	String answerToQues;
	int credit=0;
	
	public CustomerPO(int i,String n,String p,String add,String pn,String d,String ans){
		super(i,n,p);
		address=add;
		phoneNumber=pn;
		defaultQuestion=d;
		answerToQues=ans;
	}
	
	public String getAddress(){
		return address;
	}
	
	public String getPhoneNumber(){
		return phoneNumber;
	}
	
	public String getDefaultQuestion(){
		return defaultQuestion;
	}
	
	public String getAnsToAns(){
		return answerToQues;
	}
	
	public int getCredit(){
		return credit;
	}
}

class HotelWorkerVO extends UserVO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}

class WebsitePromoteVO extends UserVO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}

class WebsiteManagerVO extends UserVO{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
}