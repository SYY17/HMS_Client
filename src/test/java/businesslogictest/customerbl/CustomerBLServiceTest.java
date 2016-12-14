package businesslogictest.customerbl;

import static org.junit.Assert.*;

import java.sql.Date;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import businesslogic.customerbl.CustomerController;
import businesslogicservice.customerBLService.CustomerBLService;
import vo.CustomerVO;
import vo.UserVO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
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
		uvo = new UserVO(10912012, name, "000000");
		cvo = new CustomerVO(uvo, birthday, phoneNumber, email, address);
		customerBLService = new CustomerController();
	}
	
	/**
	 * 添加顾客信息的测试用例套件
	 */
	@Test
	public void test1_AddNewCustomer(){
		boolean result = customerBLService.addNewCustomer(name);
		
		//添加成功
		assertTrue(result);
	}
	
	/**
	 * 设置顾客信息的测试用例套件
	 */
	@Test
	public void test2_SetCustomerInfo(){
		boolean result = customerBLService.setCustomerInfo(cvo);
		
		//设置成功
		assertTrue(result);
	}
	
	/**
	 * 获取顾客信息的测试用例套件
	 */
	@Test
	public void test3_GetCustomerInfo(){
		cvo = customerBLService.getCustomerInfo(name);
		
		//信息完全相同
		assertEquals(name, cvo.getName());
		assertEquals(address, cvo.getAddress());
		assertEquals(email, cvo.getEmail());
		assertEquals(phoneNumber, cvo.getPhoneNumber());
	}
	
	/**
	 * 删除顾客信息的测试用例套件
	 */
	@Test
	public void test4_DeleteCustomer(){
		boolean result = customerBLService.deleteCustomer(name);
		
		//删除成功
		assertTrue(result);
	}
}
