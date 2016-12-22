package businesslogictest.orderbl;

import static org.junit.Assert.*;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

import org.junit.Before;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

import businesslogic.orderbl.OrderController;
import businesslogic.orderbl.UserInfo;
import businesslogic.userbl.UserInfoForOrder;
import businesslogicservice.orderblservice.OrderBLService;
import vo.CreditMovement;
import vo.OrderStatus;
import vo.OrderVO;
import vo.RoomType;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class OrderBLServiceTest {
	private OrderBLService orderBlService;
	private UserInfo userInfo;
	private String userName;
	private String hotelName;;
	private RoomType roomType;
	private int roomNumber;
	private Timestamp setTime;
	private Date checkIn;
	private Date checkOut;
	private Timestamp deadline;
	private int predictNumber;
	private boolean haveChild;
	public static int orderID;
	public static final int ADMIN_ID = 10916231;

	/**
	 * 初始化
	 */
	@Before
	public void setUp() throws Exception {
		orderBlService = new OrderController();
		userInfo = new UserInfoForOrder();
		userName = userInfo.searchByUserID(ADMIN_ID);
		hotelName = "中国";
		roomType = RoomType.KING_SIZE_ROOM;
		roomNumber = 2;
		setTime = Timestamp.valueOf("2016-12-14 14:47:36.000000");
		checkIn = Date.valueOf("2016-12-15");
		checkOut = Date.valueOf("2016-12-15");
		deadline = Timestamp.valueOf("2016-12-14 14:47:36.000000");
		predictNumber = 10;
		haveChild = true;
	}

	/**
	 * 创建订单的测试用例套件
	 */
	@Test
	public void test1_Create() {
		orderID = orderBlService.create(userName, hotelName, roomType, roomNumber, setTime, checkIn, checkOut, deadline,
				predictNumber, haveChild).getOrderID();
		orderBlService.reviewOrder(ADMIN_ID);
//		assertEquals(0, size);
		OrderVO ovoTemp = orderBlService.reviewOrder(ADMIN_ID).get(0);
		assertEquals(userName, ovoTemp.getUserName());
	}

	/**
	 * 浏览异常订单的测试用例套件
	 */
	@Test
	public void test2_ReviewOrderInt() {
		// 系统管理人员&网站营销人员
		assertNotEquals(null, orderBlService.reviewOrder(40000000).get(0));

		// 顾客&酒店
		OrderVO ovoTemp = orderBlService.reviewOrder(ADMIN_ID).get(0);
		assertEquals("admin", ovoTemp.getUserName());
		assertEquals("中国", ovoTemp.getHotelName());
	}

	/**
	 * 浏览异常订单的测试用例套件
	 */
	@Test
	public void test3_ReviewOrderIntOrderStatus() {
		OrderVO ovoTemp = orderBlService.reviewOrder(ADMIN_ID, OrderStatus.Abnormal).get(0);
		assertEquals("admin", ovoTemp.getUserName());
		assertEquals("中国", ovoTemp.getHotelName());

		ArrayList<OrderVO> list = orderBlService.reviewOrder(ADMIN_ID, OrderStatus.Canceled);
		assertEquals(list.size(), 0);
	}

	/**
	 * 改变订单状态的测试用例套件
	 */
	@Test
	public void test4_ChangeOrderStatus() {
		orderBlService.changeOrderStatus(orderID, OrderStatus.Abnormal,CreditMovement.AbnormalOrder);
		OrderVO ovoTemp = orderBlService.reviewOrder(ADMIN_ID).get(0);
		assertEquals(OrderStatus.Abnormal.toString(), ovoTemp.getOrderStatus().toString());

		orderBlService.changeOrderStatus(orderID, OrderStatus.Finished,CreditMovement.AbnormalOrder);
		ovoTemp = orderBlService.reviewOrder(ADMIN_ID).get(0);
		assertEquals(OrderStatus.Finished.toString(), ovoTemp.getOrderStatus().toString());
	}

	/**
	 * 删除订单的测试用例套件
	 */
	@Test
	public void test5_CancelOrder() {
		orderBlService.cancelOrder(orderID);
		int size = orderBlService.reviewOrder(ADMIN_ID).size();
		assertEquals(0, size);
	}

}
