package businesslogictest.loginbl;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import businesslogic.loginbl.LoginController;
import businesslogicservice.ResultMessage;
import businesslogicservice.loginblservice.LoginBLService;

public class LoginBLServiceTest {
	private LoginBLService loginBlService;
	String username;
	String password;
	int id;
	
	/**
	 * 初始化
	 */
	@Before
	public void setUp() throws Exception {
		username="User";
		password=null;
		id=00000000;
	}

	/**
	 * 增加用户的测试用例套件
	 */
	@Test
	public void testAddNewUser() {
		loginBlService=new LoginController();
		assertEquals(ResultMessage.TRUE, loginBlService.addNewUser(username, password, id));
	}
	
	/**
	 * 登录的测试用例套件
	 */
	@Test
	public void testLogin() {
		loginBlService=new LoginController();
		assertEquals(ResultMessage.TRUE, loginBlService.login(username, password, id));
	}
	
	/**
	 * 注销的测试用例套件
	 */
	@Test
	public void testLogout() {
		loginBlService=new LoginController();
		assertEquals(ResultMessage.TRUE, loginBlService.logout(username));
	}

}
