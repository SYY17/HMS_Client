package businesslogictest.orderbl;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;

import businesslogic.orderbl.OrderController;
import businesslogicservice.ResultMessage;
import businesslogicservice.orderblservice.OrderBLService;
import vo.HotelVO;
import vo.OrderStatus;
import vo.OrderVO;
import vo.PromotionVO;
import vo.RoomType;

public class OrderBLServiceTest {
	private OrderBLService orderBlService;
	int orderID;
	OrderStatus orderStatus;
	int price;
	int userID;
	Date setTime;
	Date checkIn;
	Date checkOut;
	int roomNumber;
	int hotelID;
	OrderVO orderVO;
	HotelVO hotelVO;
	PromotionVO promotionVO;
	RoomType roomType;
	ArrayList<OrderVO> orderList;

	/**
	 * 初始化
	 */
	@Before
	public void setUp() throws Exception {
		userID = 00000000;
		setTime = null;
		checkIn = null;
		checkOut = null;
		roomNumber = 0;
		hotelID = 00000000;
		orderList = null;
		orderVO = new OrderVO(orderID, userID, hotelID, orderStatus, price, roomType, roomNumber, setTime, checkIn, checkOut);
		hotelVO = new HotelVO(hotelID, null, null, null, null, hotelID, hotelID, null, hotelID, null, null);
		promotionVO = new PromotionVO("双十一下订单八折优惠", new Date(System.currentTimeMillis()), 20920010);
	}
	
	/**
	 * 浏览全部订单的测试用例套件
	 */
	@Test
	public void testReviewOrder() {
		orderBlService = new OrderController();
		assertEquals(orderList, orderBlService.reviewOrder(00000000));
	}
	
	/**
	 * 浏览异常订单的测试用例套件
	 */
	@Test
	public void testReviewAbnormalOrder() {
		orderBlService = new OrderController();
		assertEquals(orderList, orderBlService.reviewAbnormalOrder(00000000));
	}
	
	/**
	 * 取消订单的测试用例套件
	 */
	@Test
	public void testCancelOrder() {
		orderBlService = new OrderController();
		assertEquals(ResultMessage.TRUE, orderBlService.cancelOrder(orderVO));
	}
	
	/**
	 * 创建订单的测试用例套件
	 */
	@Test
	public void testCreate(int userid, int hotelid, OrderStatus orderstatus, RoomType rT, int rn, PromotionVO pvo,
			Date s, Date ci, Date co) {
		orderBlService = new OrderController();
		assertEquals(orderVO, orderBlService.create(userid, hotelid, orderstatus, rT, rn, pvo, s, ci, co));
	}
	
	/**
	 * 增加订单的测试用例套件
	 */
	@Test
	public void testAddOrder() {
		orderBlService = new OrderController();
		assertEquals(ResultMessage.TRUE, orderBlService.addOrder(orderVO));
	}

	/**
	 * 处理异常订单的测试用例套件
	 */
	@Test
	public void testComplainOrder() {
		orderBlService = new OrderController();
		assertEquals(ResultMessage.TRUE, orderBlService.complainOrder(orderID, orderStatus));
	}

}
