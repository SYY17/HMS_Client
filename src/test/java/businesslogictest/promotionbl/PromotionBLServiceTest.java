package businesslogictest.promotionbl;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.sql.Date;
import org.junit.Before;
import org.junit.Test;
import businesslogic.promotionbl.PromotionController;
import businesslogicservice.promotionblservice.PromotionBLService;
import vo.PromotionType;
import vo.PromotionVO;

public class PromotionBLServiceTest {

	private PromotionBLService promotionBLService;
	private String promotionName;
	private String content;
	private PromotionType promotionType;
	private Date start;
	private Date stop;
	private int id;
	private PromotionVO promotionVO;

	/**
	 * 初始化
	 */
	@Before
	public void setUp() throws Exception {
		promotionBLService = new PromotionController();
		id = 30161215;
		promotionName = "两年后的满减";
		content = "2019年即可满减";
		promotionType = PromotionType.FULL_CUT;
		start = Date.valueOf("2019-11-01");
		stop = Date.valueOf("2019-12-01");
		promotionVO = new PromotionVO(promotionName, content, start, stop, promotionType, id);
	}

	/**
	 * 制定营销策略的测试用例套件
	 */
	@Test
	public void testAddPromotion() {
		
	}

	/**
	 * 查询营销策略的测试用例套件
	 */
	@Test
	public void testSearchPromotion() {
		
	}

	/**
	 * 删除营销策略的测试用例套件
	 */
	@Test
	public void testDeletePromotion() {
		
	}
	
	/**
	 * @return 获取所有营销策略的信息列表
	 */
	@Test
	public void testGetAllPromotion() {
		
	}
	
	/**
	 * @return 按照内容查找营销策略
	 */
	@Test
	public void testSearchPromotionByContent() {
		
	}

	/**
	 * @return 按照起始时间查找营销策略
	 */
	@Test
	public void testSearchPromotionByStartTime() {
		
	}
	
	/**
	 * @return 制定满减策略
	 */
	@Test
	public void testAddFullCutPromotion() {
		
	}
	
	/**
	 * @return 删除营销策略
	 */
	@Test
	public void testDeleteFullCutPromotion() {
		
	}
	
	/**
	 * @return 制定折扣策略
	 */
	@Test
	public void testAddDiscountPromotion() {
		
	}
	
	/**
	 * @return 删除营销策略
	 */
	@Test
	public void testDeleteDiscountPromotion() {
		
	}

	/**
	 * @return 按照当时时间查找营销策略
	 */
	@Test
	public void testSearchPresentPromotion() {
		
	}
}
