package businesslogictest.creditbl;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;
import businesslogic.creditbl.CreditBLService_Stub;
import businesslogicservice.ResultMessage;
import businesslogicservice.creditBLService.CreditBLService;
import vo.CreditVO;

public class CreditBLServiceTest {

	private CreditBLService creditBLService;
	CreditVO c1;
	CreditVO c2;
	CreditVO c3;
	
	/**
	 * 初始化
	 */
	@Before
	public void setUp() throws Exception {
		c1 = new CreditVO(10926001, 500);
		c2 = new CreditVO(11001016, 1500);
		c3 = new CreditVO(10926001, 1000);
	}

	/**
	 * 添加信用值对象的测试用例套件
	 */
	@Test
	public void testAddCredit() {
		creditBLService = new CreditBLService_Stub();
		ResultMessage message;
		message = creditBLService.addCredit(c1, 10926001);
		assertEquals(ResultMessage.TRUE, message);
		message = creditBLService.addCredit(c2, 11001016);
		assertEquals(ResultMessage.TRUE, message);
		message = creditBLService.addCredit(c3, 10926001);
		assertEquals(ResultMessage.FALSE, message);
	}
	
	/**
	 * 获得信用值的测试用例套件
	 */
	@Test
	public void testGetCredit() {
		creditBLService = new CreditBLService_Stub();
		CreditVO cvo;
		cvo = creditBLService.getCredit(10926001);
		assertEquals(c1.getCredit(), cvo.getCredit());
		assertEquals(c1.getID(), cvo.getID());
	}
	
	/**
	 * 维护信用值的测试用例套件
	 */
	@Test
	public void testModifyCredit() {
		creditBLService = new CreditBLService_Stub();
		ResultMessage message;
		message = creditBLService.modifyCredit(c3, 10926001);
		assertEquals(ResultMessage.TRUE, message);
		message = creditBLService.modifyCredit(c2, 10926001);
		assertEquals(ResultMessage.FALSE, message);
	}
	
	/**
	 * 删除信用值对象的测试用例套件
	 */
	@Test
	public void testDeleteCredit() {
		creditBLService = new CreditBLService_Stub();
		ResultMessage message;
		message = creditBLService.deleteCredit(10926001);
		assertEquals(ResultMessage.TRUE, message);
		message = creditBLService.deleteCredit(10926001);
		assertEquals(ResultMessage.FALSE, message);
		message = creditBLService.deleteCredit(11001016);
		assertEquals(ResultMessage.TRUE, message);
	}

}
