package businesslogictest.orderbl;

import static org.junit.Assert.*;
import java.util.ArrayList;
import java.util.Date;
import org.junit.Before;
import org.junit.Test;

import businesslogic.orderbl.OrderBLService_Stub;
import businesslogicservice.ResultMessage;
import businesslogicservice.orderblservice.OrderBLService;
import vo.RoomType;
import vo.HotelVO;
import vo.OrderStatus;
import vo.OrderVO;
import vo.PromotionVO;
import vo.RoomVO;

public class OrderBLServiceTest {
	private OrderBLService orderBlService;
	int orderID;
	OrderStatus orderStatus;
	int price;
	int userID;
	Date setTime;
	Date checkIn;
	Date checkOut;
	RoomType roomType;
	int roomNumber;
	int hotelID;
	OrderVO orderVO;
	HotelVO hotelVO;
	PromotionVO promotionVO;
	ArrayList<OrderVO> orderList;

	/**
	 * 初始化
	 */
	@Before
	public void setUp() throws Exception {
		orderID = 0;
		orderStatus = OrderStatus.Unfilled;
		price = 0;
		userID = 00000000;
		setTime = null;
		checkIn = null;
		checkOut = null;
		roomType = RoomType.KING_SIZE_ROOM;
		roomNumber = 0;
		hotelID = 00000000;
		orderList = null;
		orderVO = new OrderVO(orderID, userID, hotelID, orderStatus, price, roomType, roomNumber, checkIn, checkIn,
				checkIn);
		hotelVO = new HotelVO(hotelID, null, null, null, null, hotelID, hotelID, null, hotelID, null, null);
		promotionVO = new PromotionVO("双十一下订单八折优惠", new Date(System.currentTimeMillis()), 20920010);
	}

	/**
	 * 浏览全部订单的测试用例套件
	 */
	@Test
	public void testReviewOrder() {
		orderBlService = new OrderBLService_Stub(orderID, orderStatus, price, userID, setTime, checkIn, checkIn,
				roomNumber, hotelID, roomType);
		assertEquals(orderList, orderBlService.reviewOrder(00000000));
	}

	/**
	 * 浏览异常订单的测试用例套件
	 */
	@Test
	public void testReviewAbnormalOrder() {
		orderBlService = new OrderBLService_Stub(orderID, orderStatus, price, userID, setTime, checkIn, checkIn,
				roomNumber, hotelID, roomType);
		assertEquals(orderList, orderBlService.reviewAbnormalOrder(00000000));
	}

	/**
	 * 取消订单的测试用例套件
	 */
	@Test
	public void testCancelOrder() {
		orderBlService = new OrderBLService_Stub(orderID, orderStatus, price, userID, setTime, checkIn, checkIn,
				roomNumber, hotelID, roomType);
		assertEquals(ResultMessage.TRUE, orderBlService.cancelOrder(orderVO));
	}

	/**
	 * 创建订单的测试用例套件
	 */
	@Test
	public void testCreate() {
		orderBlService = new OrderBLService_Stub(orderID, orderStatus, price, userID, setTime, checkIn, checkIn,
				roomNumber, hotelID, roomType);
		assertEquals(orderVO, orderBlService.create(hotelID, hotelID, orderStatus, roomType, hotelID, promotionVO,
				checkIn, checkIn, checkIn));
	}

	/**
	 * 增加订单的测试用例套件
	 */
	@Test
	public void testAddOrder() {
		orderBlService = new OrderBLService_Stub(orderID, orderStatus, price, userID, setTime, checkIn, checkIn,
				roomNumber, hotelID, roomType);
		assertEquals(ResultMessage.TRUE, orderBlService.addOrder(orderVO));
	}

	/**
	 * 处理异常订单的测试用例套件
	 */
	@Test
	public void testComplainOrder() {
		orderBlService = new OrderBLService_Stub(orderID, orderStatus, price, userID, setTime, checkIn, checkIn,
				roomNumber, hotelID, roomType);
		assertEquals(ResultMessage.TRUE, orderBlService.complainOrder(orderID, orderStatus));
	}

}
