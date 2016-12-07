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
	private OrderBLService orderBlService;
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
		hotelVO = new HotelVO(orderID, hotelName, hotelName, hotelName, hotelName, orderID, orderID, null, orderID,
				hotelName, hotelName);
		promotionVO = new PromotionVO( "双十一优惠", "双十一下订单八折优惠", new Date(System.currentTimeMillis()), new Date(System.currentTimeMillis()*2), PromotionType.DISCOUNT, 20920010);//
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
	public void testReviewOrder2() {
		orderBlService = new OrderController();
		assertEquals(orderList, orderBlService.reviewOrder(00000000, OrderStatus.Finished));
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
	public void testCreate(String username, String hotelname, OrderStatus orderstatus, RoomType rT, int rn, PromotionVO pvo,
			Timestamp s, Date ci, Date co) {
		orderBlService = new OrderController();
		assertEquals(orderVO, orderBlService.create(username, hotelname, orderstatus, rT, rn, pvo, s, ci, co));
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
