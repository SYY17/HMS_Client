package businesslogictest.userbl;

import static org.junit.Assert.*;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

import businesslogic.userbl.UserBLService_Stub;
import businesslogicservice.ResultMessage;
import businesslogicservice.userblservice.UserBLService;
import vo.UserVO;

public class UserBLServiceTest {
	private UserBLService userBlService;
	int id;
	String name;
	String password;
	UserVO userVO;
	ArrayList<UserVO> userList;
	
	/**
	 * 初始化
	 */
	@Before
	public void setUp() throws Exception {
		id=00000000;
		name="User";
		password="00000000";
		userVO=new UserVO(id,name,password);
	}

	/**
	 * 增加用户的测试用例套件
	 */
	@Test
	public void testAddUser() {
		userBlService=new UserBLService_Stub(id,name,password);
		assertEquals(ResultMessage.TRUE,userBlService.addUser(userVO) );
	}
	
	/**
	 * 删除用户的测试用例套件
	 */
	@Test
	public void deleteUser() {
		userBlService=new UserBLService_Stub(id,name,password);
		assertEquals(ResultMessage.TRUE,userBlService.deleteUser(userVO.getID()) );
	}
	
	/**
	 * 修改用户的测试用例套件
	 */
	@Test
	public void modifyAddUser() {
		userBlService=new UserBLService_Stub(id,name,password);
		assertEquals(ResultMessage.TRUE,userBlService.modifyUser(userVO) );
	}
	
	/**
	 * 按照ID搜索用户的测试用例套件
	 */
	@Test
	public void testSearchByID() {
		userBlService=new UserBLService_Stub(id,name,password);
		assertEquals(userList,userBlService.searchByID(00000000) );
	}
	
	/**
	 * 按照关键词搜索用户的测试用例套件
	 */
	@Test
	public void testSearchByKeyWords() {
		userBlService=new UserBLService_Stub(id,name,password);
		assertEquals(userList,userBlService.searchByKeywords("00000000") );
	}
	
	/**
	 * 获得所有用户的测试用例套件
	 */
	@Test
	public void testGetAllUsers() {
		userBlService=new UserBLService_Stub(id,name,password);
		assertEquals(userList,userBlService.getAllUsers() );
	}

}
