package businesslogictest.hotelbl;

import static org.junit.Assert.*;

import java.util.ArrayList;
import org.junit.Before;
import org.junit.Test;

import businesslogic.hotelbl.HotelController;
import businesslogicservice.ResultMessage;
import businesslogicservice.hotelBLService.HotelBLService;
import vo.HotelVO;
import vo.RoomVO;

public class HotelBLServiceTest {

	private HotelBLService hotelBLService;
	HotelVO h1;
	HotelVO h2;
	ArrayList<RoomVO> rooms;
	
	/**
	 * 初始化
	 */
	@Before
	public void setUp() throws Exception {
		rooms = new ArrayList<RoomVO>();
		//h1 = new HotelVO(00001, "xxhotel", "", "新街口", "暂无简介", 4, 816, rooms, 3.5, "李四", "13333333333");
		//h2 = new HotelVO(01001, "学生宿舍6栋", "南京市栖霞区南京大学仙林校区", "仙林大学城", "普通的学生宿舍", 5, 314, rooms, 4.5, "王五", "13888888888");
	}
	
	/**
	 * 创建酒店基本信息的测试用例套件
	 */
	@Test
	public void testCreateHotel(){
		hotelBLService = new HotelController();
		ResultMessage message;
		message = hotelBLService.createHotel(h1);
		assertEquals(ResultMessage.TRUE, message);
		message = hotelBLService.createHotel(h1);
		assertEquals(ResultMessage.FALSE, message);
		message = hotelBLService.createHotel(h2);
		assertEquals(ResultMessage.TRUE, message);
	}
	
	/**
	 * 查询酒店的测试用例套件
	 */
	@Test
	public void testSearchHotel() {
		hotelBLService = new HotelController();
		ArrayList<HotelVO> list1;
		list1 = hotelBLService.searchHotel("xxhotel");
		assertEquals(h1.getHotelID(), list1.get(0).getHotelID());
		assertEquals(h1.getHotelName(), list1.get(0).getHotelName());
		assertEquals(h1.getHotelAddress(), list1.get(0).getHotelAddress());
		assertEquals(h1.getBusinessArea(), list1.get(0).getBusinessArea());
		assertEquals(h1.getHotelDescription(), list1.get(0).getHotelDescription());
		assertEquals(h1.getStarLevel(), list1.get(0).getStarLevel());
		//assertEquals(h1.getRoomNumber(), list1.get(0).getRoomNumber());
		//assertEquals(h1.getRooms(), list1.get(0).getRooms());
		assertEquals(Double.valueOf(h1.getRating()), Double.valueOf(list1.get(0).getRating()));
		assertEquals(h1.getStaffName(), list1.get(0).getStaffName());
		assertEquals(h1.getPhoneNumber(), list1.get(0).getPhoneNumber());
	}
	
	/**
	 * 删除酒店的测试用例套件
	 */
	@Test
	public void testDeleteHotel(){
		hotelBLService = new HotelController();
		ResultMessage message;
		message = hotelBLService.deleteHotel(h1.getHotelID());
		assertEquals(ResultMessage.TRUE, message);
		message = hotelBLService.deleteHotel(h1.getHotelID());
		assertEquals(ResultMessage.FALSE, message);
		message = hotelBLService.deleteHotel(h2.getHotelID());
		assertEquals(ResultMessage.TRUE, message);
	}
	
	/**
	 * 修改酒店信息的测试用例套件
	 */
	@Test
	public void testModifyHotel(){
		hotelBLService = new HotelController();
		ResultMessage message;
		message = hotelBLService.modifyHotel(h1);
		assertEquals(ResultMessage.TRUE, message);
		message = hotelBLService.modifyHotel(h1);
		assertEquals(ResultMessage.FALSE, message);
	}
	
	/**
	 * 评价酒店的测试用例套件
	 */
	 @Test
	 public void testGradeHotel(){
		hotelBLService = new HotelController();
		ResultMessage message;
		message = hotelBLService.gradeHotel(h1);
		assertEquals(ResultMessage.TRUE, message);
		message = hotelBLService.gradeHotel(h1);
		assertEquals(ResultMessage.FALSE, message);
	 }
	 
	 /**
	  * 浏览酒店基本信息的测试用例套件
	  */
	 @Test
	 public void testReviewHotelInfo(){
		hotelBLService = new HotelController();
		HotelVO hvo;
		hvo = hotelBLService.reviewHotelInfo("xxhotel");
		assertEquals(h1.getHotelID(), hvo.getHotelID());
		assertEquals(h1.getHotelName(), hvo.getHotelName());
		assertEquals(h1.getHotelAddress(), hvo.getHotelAddress());
		assertEquals(h1.getBusinessArea(), hvo.getBusinessArea());
		assertEquals(h1.getHotelDescription(), hvo.getHotelDescription());
		assertEquals(h1.getStarLevel(), hvo.getStarLevel());
		assertEquals(Double.valueOf(h1.getRating()), Double.valueOf(hvo.getRating()));
		assertEquals(h1.getStaffName(), hvo.getStaffName());
		assertEquals(h1.getPhoneNumber(), hvo.getPhoneNumber());
	 }
	  
	 /**
	  * 浏览酒店列表的测试用例套件
	  */
	 @Test
	 public void testReviewHotelList(){
		hotelBLService = new HotelController();
		ArrayList<HotelVO> list;
		list = hotelBLService.reviewHotelList();
		assertEquals(h1.getHotelID(), list.get(0).getHotelID());
		assertEquals(h1.getHotelName(), list.get(0).getHotelName());
		assertEquals(h1.getHotelAddress(), list.get(0).getHotelAddress());
		assertEquals(h1.getBusinessArea(), list.get(0).getBusinessArea());
	 }
}