package businesslogictest.promotionbl;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.sql.Date;
import org.junit.Before;
import org.junit.Test;
import businesslogic.promotionbl.PromotionController;
import businesslogicservice.ResultMessage;
import businesslogicservice.promotionblservice.PromotionBLService;
import vo.PromotionType;
import vo.PromotionVO;

public class PromotionBLServiceTest {

	private PromotionBLService promotionBLService;
	PromotionVO p1;
	PromotionVO p2;
	long time;
	long sp;
	
	/**
	 * 初始化
	 */
	@Before
	public void setUp() throws Exception {
		time = System.currentTimeMillis();
		sp = System.currentTimeMillis()+10000;
		p1 = new PromotionVO( "双十一折扣", "双十一下订单八折优惠", new Date(time), new Date(sp), PromotionType.DISCOUNT, 20920010);
		p2 = new PromotionVO( "订单完成满减", "订单完成后获得信用值增加百分之五", new Date(time), new Date(sp), PromotionType.FULL_CUT, 30925005);
	}
	
	/**
	 * 制定营销策略的测试用例套件
	 */
	@Test
	public void testAddPromotion(){
		promotionBLService = new PromotionController();
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
		promotionBLService = new PromotionController();
		ArrayList<PromotionVO> list;
		ResultMessage message;
		list = promotionBLService.searchByContent(20920010, "双十一下订单八折优惠");
		assertEquals(p1.getPromotionName(), list.get(0).getPromotionName());//
		assertEquals(p1.getID(), list.get(0).getID());
		assertEquals(p1.getContent(), list.get(0).getContent());
		assertEquals(p1.getStartTime(), list.get(0).getStartTime());
		assertEquals(p1.getStopTime(), list.get(0).getStopTime());//
		assertEquals(p1.getPromotionType(), list.get(0).getPromotionType());//
		list = promotionBLService.searchByStartTime(20920010, new Date(time));
		assertEquals(p1.getPromotionName(), list.get(0).getPromotionName());
		assertEquals(p1.getID(), list.get(0).getID());
		assertEquals(p1.getContent(), list.get(0).getContent());
		assertEquals(p1.getStartTime(), list.get(0).getStartTime());
		assertEquals(p1.getStopTime(), list.get(0).getStopTime());
		assertEquals(p1.getPromotionType(), list.get(0).getPromotionType());
		message = promotionBLService.searchPromotion(p1);
		assertEquals(ResultMessage.TRUE, message);
	}
	
	/**
	 * 删除营销策略的测试用例套件
	 */
	@Test
	public void testDeletePromotion(){
		promotionBLService = new PromotionController();
		ResultMessage message;
		message = promotionBLService.deletePromotion(p1);
		assertEquals(ResultMessage.TRUE, message);
		message = promotionBLService.deletePromotion(p1);
		assertEquals(ResultMessage.FALSE, message);
		message = promotionBLService.deletePromotion(p2);
		assertEquals(ResultMessage.TRUE, message);
	}
			
}

