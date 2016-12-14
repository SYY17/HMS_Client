package businesslogictest.customerbl;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Before;
import org.junit.Test;

import businesslogic.customerbl.CustomerController;
import businesslogicservice.customerBLService.CustomerBLService;
import vo.CustomerVO;
import vo.UserVO;

public class CustomerBLServiceTest {
	private CustomerBLService customerBLService;
	Date birthday;
	CustomerVO cvo;
	UserVO uvo;
	String name;
	String phoneNumber;
	String email;
	String address;
	
	@Before
	public void setUp(){
		name = "testuser";
		java.util.Date date = new java.util.Date();
		birthday = new Date(date.getTime());
		phoneNumber = "10000000000";
		email = "test@163.com";
		address = "test address";
		uvo = new UserVO(1, name, "000000");
		cvo = new CustomerVO(uvo, birthday, phoneNumber, email, address);
		customerBLService = new CustomerController();
	}
	
	@Test
	public void testSetCustomerInfo(){
		boolean result = customerBLService.setCustomerInfo(cvo);
		
		//设置成功
		assertEquals(true, result);
	}
	
	@Test
	public void testGetCustomerInfo(){
		cvo = customerBLService.getCustomerInfo(name);
		
		//信息完全相同
		assertEquals(name, cvo.getName());
		assertEquals(address, cvo.getAddress());
		assertEquals(email, cvo.getEmail());
	}
}
