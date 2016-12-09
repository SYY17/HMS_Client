package businesslogictest.creditbl;

import static org.junit.Assert.*;
import org.junit.Before;
import org.junit.Test;

import businesslogic.creditbl.CreditController;
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
		creditBLService = new CreditController();
		ResultMessage message;
		message = creditBLService.addCredit(c1.getID(), c1.getCredit());
		assertEquals(ResultMessage.TRUE, message);
		message = creditBLService.addCredit(c2.getID(), c2.getCredit());
		assertEquals(ResultMessage.TRUE, message);
		message = creditBLService.addCredit(c1.getID(), c3.getCredit());
		assertEquals(ResultMessage.FALSE, message);
	}

	/**
	 * 获得信用值的测试用例套件
	 */
	@Test
	public void testGetCredit() {
		creditBLService = new CreditController();
		CreditVO cvo;
		cvo = creditBLService.getCredit(c1.getID());
		assertEquals(c1.getCredit(), cvo.getCredit());
		assertEquals(c1.getID(), cvo.getID());
	}

	/**
	 * 维护信用值的测试用例套件
	 */
	@Test
	public void testModifyCredit() {
		creditBLService = new CreditController();
		ResultMessage message;
		message = creditBLService.modifyCredit(c1.getID(), c3.getCredit());
		assertEquals(ResultMessage.TRUE, message);
		message = creditBLService.modifyCredit(c3.getID(), c1.getCredit());
		assertEquals(ResultMessage.FALSE, message);
	}

	/**
	 * 删除信用值对象的测试用例套件
	 */
	@Test
	public void testDeleteCredit() {
		creditBLService = new CreditController();
		ResultMessage message;
		message = creditBLService.deleteCredit(c1.getID());
		assertEquals(ResultMessage.TRUE, message);
		message = creditBLService.deleteCredit(c1.getID());
		assertEquals(ResultMessage.FALSE, message);
		message = creditBLService.deleteCredit(c2.getID());
		assertEquals(ResultMessage.TRUE, message);
	}

}
