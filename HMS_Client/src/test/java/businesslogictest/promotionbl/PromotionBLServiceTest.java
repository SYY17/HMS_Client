package businesslogictest.promotionbl;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;

import businesslogic.promotionbl.PromotionBLService_Stub;
import businesslogicservice.ResultMessage;
import businesslogicservice.promotionblservice.PromotionBLService;
import vo.PromotionVO;

public class PromotionBLServiceTest {

	private PromotionBLService promotionBLService;
	PromotionVO p1;
	PromotionVO p2;
	long time;
	
	/**
	 * 初始化
	 */
	@Before
	public void setUp() throws Exception {
		time = System.currentTimeMillis();
		p1 = new PromotionVO("双十一下订单八折优惠", new Date(time), 20920010);
		p2 = new PromotionVO("订单完成后获得信用值增加百分之五", new Date(time), 30925005);
	}
	
	/**
	 * 制定营销策略的测试用例套件
	 */
	@Test
	public void testAddPromotion(){
		promotionBLService = new PromotionBLService_Stub();
		ResultMessage message;
		message = promotionBLService.addPromotion(p1);
		assertEquals(ResultMessage.TRUE, message);
		message = promotionBLService.addPromotion(p1);
		assertEquals(ResultMessage.FALSE, message);
		message = promotionBLService.addPromotion(p2);
		assertEquals(ResultMessage.TRUE, message);
	}
	
	/**
	 * 查询营销策略的测试用例套件
	 */
	@Test
	public void testSearchPromotion() {
		promotionBLService = new PromotionBLService_Stub();
		ArrayList<PromotionVO> list;
		ResultMessage message;
		list = promotionBLService.searchByContent(20920010, "双十一下订单八折优惠");
		assertEquals(p1.getID(), list.get(0).getID());
		assertEquals(p1.getContent(), list.get(0).getContent());
		assertEquals(p1.getStartTime(), list.get(0).getStartTime());
		list = promotionBLService.searchByStartTime(20920010, new Date(time));
		assertEquals(p1.getID(), list.get(0).getID());
		assertEquals(p1.getContent(), list.get(0).getContent());
		assertEquals(p1.getStartTime(), list.get(0).getStartTime());
		message = promotionBLService.searchPromotion(p1);
		assertEquals(ResultMessage.TRUE, message);
	}
	
	/**
	 * 删除营销策略的测试用例套件
	 */
	@Test
	public void testDeletePromotion(){
		promotionBLService = new PromotionBLService_Stub();
		ResultMessage message;
		message = promotionBLService.deletePromotion(p1);
		assertEquals(ResultMessage.TRUE, message);
		message = promotionBLService.deletePromotion(p1);
		assertEquals(ResultMessage.FALSE, message);
		message = promotionBLService.deletePromotion(p2);
		assertEquals(ResultMessage.TRUE, message);
	}
			
}
