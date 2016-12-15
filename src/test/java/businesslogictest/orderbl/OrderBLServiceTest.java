package businesslogictest.orderbl;

import static org.junit.Assert.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.Test;

import businesslogic.orderbl.OrderController;
import businesslogicservice.orderblservice.OrderBLService;
import vo.OrderStatus;
import vo.OrderVO;
import vo.RoomType;

public class OrderBLServiceTest {
	private OrderBLService orderBlService;
	private String userName;
	private String hotelName;;
	private RoomType roomType;
	private int roomNumber;
	private Timestamp setTime;
	private Date checkIn;
	private Date checkOut;

	@Before
	public void setUp() throws Exception {
		orderBlService = new OrderController();
		userName = "庄刚轻";
		hotelName = "盘丝洞";
		roomType = RoomType.KING_SIZE_ROOM;
		roomNumber = 2;
		setTime = Timestamp.valueOf("2016-12-14 14:47:36.000000");
		checkIn = Date.valueOf("2016-12-15");
		checkOut = Date.valueOf("2016-12-15");
	}

	@Test
	public void testCreate() {
		orderBlService.create(userName, hotelName, roomType, roomNumber, setTime, checkIn, checkOut);
		OrderVO ovoTemp = orderBlService.reviewOrder(21214001).get(0);
		assertEquals(userName, ovoTemp.getUserName());
	}

	/**
	 * 浏览异常订单的测试用例套件
	 */
	@Test
	public void testReviewOrderInt() {
		// 系统管理人员&网站营销人员
		assertNotEquals(null, orderBlService.reviewOrder(40000000).get(0));

		// 顾客&酒店
		OrderVO ovoTemp = orderBlService.reviewOrder(21215001).get(0);
		assertEquals("李四", ovoTemp.getUserName());
		assertEquals("汉庭嘿嘿嘿", ovoTemp.getHotelName());
	}

	@Test
	public void testReviewOrderIntOrderStatus() {
		OrderVO ovoTemp = orderBlService.reviewOrder(21215001, OrderStatus.Finished).get(0);
		assertEquals("李四", ovoTemp.getUserName());
		assertEquals("汉庭嘿嘿嘿", ovoTemp.getHotelName());

		ArrayList<OrderVO> list = orderBlService.reviewOrder(21214001, OrderStatus.Canceled);
		assertEquals(list.size(), 0);
	}
	
	@Test
	public void testCancelOrder() {
		orderBlService.cancelOrder(3);
		int size = orderBlService.reviewOrder(21214001).size();
		assertEquals(0, size);
	}

	@Test
	public void testChangeOrderStatus() {
		orderBlService.changeOrderStatus(2, OrderStatus.Abnormal);
		OrderVO ovoTemp = orderBlService.reviewOrder(21215001).get(0);
		assertEquals(OrderStatus.Abnormal.toString(), ovoTemp.getOrderStatus().toString());
		
		orderBlService.changeOrderStatus(2, OrderStatus.Finished);
		ovoTemp = orderBlService.reviewOrder(21215001).get(0);
		assertEquals(OrderStatus.Finished.toString(), ovoTemp.getOrderStatus().toString());
	}

}
