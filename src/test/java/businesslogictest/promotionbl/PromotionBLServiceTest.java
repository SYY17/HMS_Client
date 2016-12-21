package businesslogictest.promotionbl;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.sql.Date;
import java.sql.Timestamp;

import org.junit.Before;
import org.junit.Test;
import businesslogic.promotionbl.PromotionController;
import businesslogicservice.promotionblservice.PromotionBLService;
import vo.DiscountPromotionVO;
import vo.FullCutPromotionVO;
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
	private Timestamp presentTime;
	private PromotionVO promotionVO;
	private FullCutPromotionVO fullCutPromotionVO;
	private DiscountPromotionVO discountPromotionVO;
	private double every;
	private double cut;
	private double discount;

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
		presentTime = Timestamp.valueOf("2019-11-21 00:00:00");
		every = 200;
		cut = 20;
		discount = 0.9;
		promotionVO = new PromotionVO(promotionName, content, start, stop, promotionType, id);
		fullCutPromotionVO = new FullCutPromotionVO(promotionName, content, start, stop, promotionType, id, every, cut);
		discountPromotionVO = new DiscountPromotionVO(promotionName, content, start, stop, promotionType, id, discount);
	}

	/**
	 * 制定营销策略的测试用例套件
	 */
	@Test
	public void testAddPromotion() {
		promotionVO = new PromotionVO( promotionName, content, start, stop, promotionType, id);
		promotionBLService.addPromotion(promotionVO);
		
		PromotionVO pvo = promotionBLService.searchByContent(id, content).get(0);
		
		assertEquals( promotionName, pvo.getPromotionName());
		assertEquals( content, pvo.getContent());
		assertEquals( start, pvo.getStartTime());
		assertEquals( stop, pvo.getStopTime());
		assertEquals( promotionType, pvo.getPromotionType());
		assertEquals(id, pvo.getID());
		promotionBLService.deletePromotion(promotionVO);
	}

	/*
	@Test
	public void testSearchPromotion() {
		promotionVO = new PromotionVO( promotionName, content, start, stop, promotionType, id);
		promotionBLService.addPromotion(promotionVO);
		
		PromotionVO pvo = promotionBLService.searchPromotion(promotionVO);
		
		assertEquals( promotionName, pvo.getPromotionName());
		assertEquals( content, pvo.getContent());
		assertEquals( start, pvo.getStartTime());
		assertEquals( stop, pvo.getStopTime());
		assertEquals( promotionType, pvo.getPromotionType());
		assertEquals(id, pvo.getID());
		promotionBLService.deletePromotion(promotionVO);
	}*/

	/**
	 * 删除营销策略的测试用例套件
	 */
	@Test
	public void testDeletePromotion() {
		promotionVO = new PromotionVO( promotionName, content, start, stop, promotionType, id);
		promotionBLService.addPromotion(promotionVO);
		promotionBLService.deletePromotion(promotionVO);
		
		ArrayList<PromotionVO> pvoList = promotionBLService.searchByContent(id, content);
		ArrayList<PromotionVO> pvoList2 = new ArrayList<PromotionVO>();
		assertEquals(pvoList, pvoList2);
	}
	
	/**
	 * @return 获取所有营销策略的信息列表
	 */
	@Test
	public void testGetAllPromotion() {
		promotionVO = new PromotionVO( promotionName, content, start, stop, promotionType, id);
		promotionBLService.addPromotion(promotionVO);
		
		ArrayList<PromotionVO> pvoList = promotionBLService.getAllPromotion(id);
		PromotionVO pvo = pvoList.get(0);
		
		assertEquals( promotionName, pvo.getPromotionName());
		assertEquals( content, pvo.getContent());
		assertEquals( start, pvo.getStartTime());
		assertEquals( stop, pvo.getStopTime());
		assertEquals( promotionType, pvo.getPromotionType());
		assertEquals(id, pvo.getID());
		promotionBLService.deletePromotion(promotionVO);
	}
	
	/**
	 * @return 按照内容查找营销策略
	 */
	@Test
	public void testSearchPromotionByContent() {
		promotionVO = new PromotionVO( promotionName, content, start, stop, promotionType, id);
		promotionBLService.addPromotion(promotionVO);
		
		ArrayList<PromotionVO> pvoList = promotionBLService.searchByContent(id, content);
		PromotionVO pvo = pvoList.get(0);
		
		assertEquals( promotionName, pvo.getPromotionName());
		assertEquals( content, pvo.getContent());
		assertEquals( start, pvo.getStartTime());
		assertEquals( stop, pvo.getStopTime());
		assertEquals( promotionType, pvo.getPromotionType());
		assertEquals(id, pvo.getID());
		promotionBLService.deletePromotion(promotionVO);
	}

	/**
	 * @return 按照起始时间查找营销策略
	 */
	@Test
	public void testSearchPromotionByStartTime() {
		promotionVO = new PromotionVO( promotionName, content, start, stop, promotionType, id);
		promotionBLService.addPromotion(promotionVO);
		
		ArrayList<PromotionVO> pvoList = promotionBLService.searchByStartTime(id, start);
		PromotionVO pvo = pvoList.get(0);
		
		assertEquals( promotionName, pvo.getPromotionName());
		assertEquals( content, pvo.getContent());
		assertEquals( start, pvo.getStartTime());
		assertEquals( stop, pvo.getStopTime());
		assertEquals( promotionType, pvo.getPromotionType());
		assertEquals(id, pvo.getID());
		promotionBLService.deletePromotion(promotionVO);
	}

	/**
	 * @return 按照当时时间查找营销策略
	 */
	/*@Test
	public void testSearchPresentPromotion() {
		promotionVO = new PromotionVO( promotionName, content, start, stop, promotionType, id);
		promotionBLService.addPromotion(promotionVO);
		
		PromotionVO pvo = promotionBLService.searchPromotionPresent(id, presentTime);
		
		assertEquals( promotionName, pvo.getPromotionName());
		assertEquals( content, pvo.getContent());
		assertEquals( start, pvo.getStartTime());
		assertEquals( stop, pvo.getStopTime());
		assertEquals( promotionType, pvo.getPromotionType());
		assertEquals(id, pvo.getID());
		promotionBLService.deletePromotion(promotionVO);
	}*/
	
	/**
	 * @return 制定满减策略
	 */
	/*@Test
	public void testAddFullCutPromotion(){
		fullCutPromotionVO = new FullCutPromotionVO( promotionName, content, start, stop, promotionType, id, every, cut);
		promotionBLService.addFullCutPromotion(fullCutPromotionVO);
		
		FullCutPromotionVO fvo = promotionBLService.searchFullCutByContent(id, content).get(0);
		
		assertEquals( promotionName, fvo.getPromotionName());
		assertEquals( content, fvo.getContent());
		assertEquals( start, fvo.getStartTime());
		assertEquals( stop, fvo.getStopTime());
		assertEquals( promotionType, fvo.getPromotionType());
		assertEquals(id, fvo.getID());
		promotionBLService.deleteFullCutPromotion(fullCutPromotionVO);
	}*/
	
	/**
	 * @return 制定折扣策略
	 */
	/*@Test
	public void testAddDiscountPromotion(){
		discountPromotionVO = new DiscountPromotionVO( promotionName, content, start, stop, promotionType, id, discount);
		promotionBLService.addDiscountPromotion(discountPromotionVO);
		
		DiscountPromotionVO fvo = promotionBLService.searchDiscountByContent(id, content).get(0);
		
		assertEquals( promotionName, fvo.getPromotionName());
		assertEquals( content, fvo.getContent());
		assertEquals( start, fvo.getStartTime());
		assertEquals( stop, fvo.getStopTime());
		assertEquals( promotionType, fvo.getPromotionType());
		assertEquals(id, fvo.getID());
		promotionBLService.deleteDiscountPromotion(discountPromotionVO);
	}*/
	
	/**
	 * @return 删除营销策略
	 */
	/*@Test
	public void testDeleteFullCutPromotion(){
		fullCutPromotionVO = new FullCutPromotionVO( promotionName, content, start, stop, promotionType, id, every, cut);
		promotionBLService.addFullCutPromotion(fullCutPromotionVO);
		promotionBLService.deleteFullCutPromotion(fullCutPromotionVO);
		
		ArrayList<FullCutPromotionVO> pvoList = promotionBLService.searchFullCutByContent(id, content);
		ArrayList<FullCutPromotionVO> pvoList2 = new ArrayList<FullCutPromotionVO>();
		assertEquals(pvoList, pvoList2);
	}*/
	
	/**
	 * @return 删除营销策略
	 */
	/*@Test
	public void testDeleteDiscountPromotion(){
		discountPromotionVO = new DiscountPromotionVO( promotionName, content, start, stop, promotionType, id, discount);
		promotionBLService.addDiscountPromotion(discountPromotionVO);
		promotionBLService.deleteDiscountPromotion(discountPromotionVO);
		
		ArrayList<DiscountPromotionVO> pvoList = promotionBLService.searchDiscountByContent(id, content);
		ArrayList<DiscountPromotionVO> pvoList2 = new ArrayList<DiscountPromotionVO>();
		assertEquals(pvoList, pvoList2);
	}*/
	
	/**
	 * 
	 * @param id
	 * @param presentTime
	 * @return 按照当时时间查找营销策略
	 */
	@Test
	public void testGetPromotionPresent(){
		String dateStr = "2019-11-20 22:22:22";  
		Timestamp p = Timestamp.valueOf(dateStr);  
		
		promotionVO = new PromotionVO( promotionName, content, start, stop, promotionType, id);
		promotionBLService.addPromotion(promotionVO);
		
		PromotionVO fvo = promotionBLService.searchPromotionPresent(0,0,id, p);//又要改
		
		assertEquals( promotionName, fvo.getPromotionName());
		assertEquals( content, fvo.getContent());
		assertEquals( start, fvo.getStartTime());
		assertEquals( stop, fvo.getStopTime());
		assertEquals( promotionType, fvo.getPromotionType());
		assertEquals(id, fvo.getID());
		
		promotionBLService.deletePromotion(promotionVO);
	}
}
