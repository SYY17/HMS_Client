package businesslogictest.userbl;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

import businesslogic.userbl.UserController;
import businesslogicservice.ResultMessage;
import businesslogicservice.userblservice.UserBLService;
import vo.UserVO;

public class UserBLServiceTest {
	UserBLService userBLService;
	String name;
	String password;
	int id;
	UserVO uvo;

	/**
	 * 初始化
	 */
	@Before
	public void setUp() throws Exception {
		name = "testuser";
		password = "000000";
		id = 1;
		uvo = new UserVO(id, name, password);
		userBLService = new UserController();
	}

	/**
	 * 增加用户的测试用例套件
	 */
	@Test
	public void testAddUser() {
		assertEquals(ResultMessage.TRUE, userBLService.addUser(uvo));
		uvo = userBLService.searchByUserName(name);
		id = uvo.getID();
	}
	
	/**
	 * 按照用户名搜索用户的测试用例套件
	 */
	@Test
	public void testSearchByUserName() {
		uvo = userBLService.searchByUserName(name);
		assertTrue(uvo != null);
	}
	
	/**
	 * 按照ID搜索用户的测试用例套件
	 */
	@Test
	public void testSearchByID() {
		uvo = userBLService.searchByUserName(name);
		id = uvo.getID();
		String username = userBLService.searchByUserID(id);
		assertEquals(name, username);
	}
	
	/**
	 * 修改用户的测试用例套件
	 */
	@Test
	public void modifyUser() {
		password = "666666";
		uvo = new UserVO(id, name, password);
		assertEquals(ResultMessage.TRUE, userBLService.modifyUser(uvo));
	}
	
	/**
	 * 获得所有用户的测试用例套件
	 */
	@Test
	public void testGetAllUsers() {
		uvo = userBLService.searchByUserName(name);
		id = uvo.getID();
		ArrayList<UserVO> list = userBLService.getAllUsers();
		assertTrue(list != null);
		
		UserVO temp = null;
		boolean flag = false;
		for(int i = 0; i < list.size(); i++){
			temp = list.get(i);
			if(temp.getName().equals(name)){
				flag = true;
				break;
			}
		}
		
		assertTrue(flag);
		if(flag == true){
			assertEquals(id, temp.getID());
		}
	}

	/**
	 * 删除用户的测试用例套件
	 */
	@Test
	public void deleteUser() {
		assertEquals(ResultMessage.TRUE, userBLService.deleteUser(id));
		
		//删除后信息不存在
		assertTrue(userBLService.searchByUserID(id) == null);
	}

}
