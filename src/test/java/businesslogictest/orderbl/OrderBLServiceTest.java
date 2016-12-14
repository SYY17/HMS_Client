package businesslogictest.orderbl;

import static org.junit.Assert.*;
import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

import businesslogic.orderbl.OrderController;
import businesslogicservice.ResultMessage;
import businesslogicservice.orderblservice.OrderBLService;
import vo.HotelVO;
import vo.OrderStatus;
import vo.OrderVO;
import vo.PromotionType;
import vo.PromotionVO;
import vo.RoomType;

public class OrderBLServiceTest {
	OrderBLService orderBLService;
	int orderID;
	OrderStatus orderStatus;
	int price;
	String userName;
	Timestamp setTime;
	Date checkIn;
	Date checkOut;
	int roomNumber;
	String hotelName;
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
		userName = null;
		setTime = null;
		checkIn = null;
		checkOut = null;
		roomNumber = 0;
		hotelName = null;
		orderList = null;
		orderVO = new OrderVO(orderID, userName, hotelName, orderStatus, price, roomType, roomNumber, setTime, checkIn,
				checkOut);
		hotelVO = new HotelVO(orderID, hotelName, hotelName, hotelName, hotelName, orderID, orderID, null, hotelName);
		promotionVO = new PromotionVO("双十一优惠", "双十一下订单八折优惠", new Date(System.currentTimeMillis()),
				new Date(System.currentTimeMillis() * 2), PromotionType.DISCOUNT, 20920010);//
	}

	/**
	 * 浏览全部订单的测试用例套件
	 */
	@Test
	public void testReviewOrder() {
		orderBLService = new OrderController();
		assertEquals(orderList, orderBLService.reviewOrder(00000000));
	}

	/**
	 * 浏览异常订单的测试用例套件
	 */
	@Test
	public void testReviewOrder2() {
		orderBLService = new OrderController();
		assertEquals(orderList, orderBLService.reviewOrder(00000000, OrderStatus.Finished));
	}

	/**
	 * 取消订单的测试用例套件
	 */
	@Test
	public void testCancelOrder() {
		orderBLService = new OrderController();
		assertEquals(ResultMessage.TRUE, orderBLService.cancelOrder(orderVO));
	}

	/**
	 * 创建订单的测试用例套件
	 */
	@Test
	public void testCreate(String userName, String hotelName, RoomType roomType, int roomNumber, Timestamp setTime,
			Date checkIn, Date checkOut) {
		orderBLService = new OrderController();
		assertEquals(orderVO,
				orderBLService.create(userName, hotelName, roomType, roomNumber, setTime, checkIn, checkOut));
	}

	/**
	 * 增加订单的测试用例套件
	 */
	@Test
	public void testAddOrder() {
		orderBLService = new OrderController();
		assertEquals(ResultMessage.TRUE, orderBLService.addOrder(orderVO));
	}

	/**
	 * 处理异常订单的测试用例套件
	 */
	@Test
	public void testComplainOrder() {
		orderBLService = new OrderController();
		assertEquals(ResultMessage.TRUE, orderBLService.complainOrder(orderID, orderStatus));
	}

}
