package businesslogictest.loginbl;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import businesslogic.loginbl.LoginController;
import businesslogic.userbl.UserController;
import businesslogicservice.ResultMessage;
import businesslogicservice.loginblservice.LoginBLService;
import businesslogicservice.userblservice.UserBLService;
import vo.UserVO;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class LoginBLServiceTest {
	private LoginBLService loginBLService;
	String username;
	String password;
	int id;

	/**
	 * 初始化
	 */
	@Before
	public void setUp() throws Exception {
		username = "testsaler";
		password = "000000";
		id = 3;
		loginBLService = new LoginController();
	}

	/**
	 * 增加用户的测试用例套件
	 */
	@Test
	public void test1_AddNewUser() {
		assertEquals(ResultMessage.TRUE, loginBLService.addNewUser(username, password, id));
	}

	/**
	 * 登录的测试用例套件
	 */
	@Test
	public void test2_Login() {
		assertEquals(ResultMessage.TRUE, loginBLService.login(username, password, id));
	}

	/**
	 * 注销的测试用例套件
	 */
	@Test
	public void test3_Logout() {
		assertEquals(ResultMessage.TRUE, loginBLService.logout(username));
		UserBLService userBLService = new UserController();
		UserVO uvo = userBLService.searchByUserName(username);
		userBLService.deleteUser(uvo.getID());
	}
	
//	/**
//	 * 删除test用户
//	 */
//	@After
//	public void tearDown(){
//		UserBLService userBLService = new UserController();
//		UserVO uvo = userBLService.searchByUserName(username);
//		userBLService.deleteUser(uvo.getID());
//	}

}
