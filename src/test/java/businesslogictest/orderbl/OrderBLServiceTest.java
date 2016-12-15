package businesslogictest.orderbl;

import static org.junit.Assert.*;

import java.sql.Date;
import java.sql.Timestamp;

import org.junit.Before;
import org.junit.Test;

import businesslogic.orderbl.OrderController;
import businesslogicservice.orderblservice.OrderBLService;
import vo.OrderStatus;
import vo.OrderVO;
import vo.RoomType;

public class OrderBLServiceTest {
	private OrderBLService orderBlService;
	private int orderID;
	private String userName;
	private String hotelName;
	private OrderStatus orderStatus;
	private int price;
	private RoomType roomType;
	private int roomNumber;
	private Timestamp setTime;
	private Date checkIn;
	private Date checkOut;
	@Before
	public void setUp() throws Exception {
		orderBlService = new OrderController();
		orderID = 18;
		userName = "庄刚轻";
		hotelName = "盘丝洞";
		orderStatus = OrderStatus.Abnormal;
		price = 200;
		roomType = RoomType.KING_SIZE_ROOM;
		roomNumber = 2;
		setTime = Timestamp.valueOf("2016-12-14 14:47:36.000000");
		checkIn = Date.valueOf("2016-12-15");
		checkOut = Date.valueOf("2016-12-15");
		new OrderVO(orderID, userName, hotelName, orderStatus, price, roomType, roomNumber, setTime, checkIn,
				checkOut);
	}

	/**
	 * 浏览异常订单的测试用例套件
	 */
	public void testReviewOrderInt() {
		// 系统管理人员&网站营销人员
		assertNotEquals(null, orderBlService.reviewOrder(40000000).get(0));

		// 顾客&酒店
		OrderVO ovoTemp = orderBlService.reviewOrder(21214001).get(0);
		assertEquals(userName, ovoTemp.getUserName());
		assertEquals(hotelName, ovoTemp.getHotelName());
		assertEquals(orderStatus.toString(), ovoTemp.getOrderStatus().toString());
		assertEquals(price, ovoTemp.getPrice());
		assertEquals(roomType.toString(), ovoTemp.getRoomType().toString());
		assertEquals(roomNumber, ovoTemp.getRoomNumber());
		assertEquals(setTime.getTime(), ovoTemp.getSetTime().getTime());
		assertEquals(checkIn.toString(), ovoTemp.getCheckIn().toString());
		assertEquals(checkOut.toString(), ovoTemp.getCheckOut().toString());
	}

	@Test
	public void testReviewOrderIntOrderStatus() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreate(String userName, String hotelName, RoomType roomType, int roomNumber, Timestamp setTime,
			Date checkIn, Date checkOut) {
		fail("Not yet implemented");
	}
	
	@Test
	public void testCancelOrder() {
		fail("Not yet implemented");
	}

	@Test
	public void testCreate() {
		fail("Not yet implemented");
	}

	@Test
	public void testComplainOrder() {
		fail("Not yet implemented");
	}

}
