package businesslogictest.hotelbl;

import java.util.ArrayList;
import businesslogic.orderbl.OrderController;
import businesslogicservice.ResultMessage;
import vo.HotelVO;

public class MockOrder extends OrderController {
	int credit;
	ArrayList<HotelVO> hotelList;

	public MockOrder() {
		super();
	}

	public ResultMessage modifyHotelRoomList(int flag, HotelVO hotelVO) {
		return ResultMessage.TRUE;
	}

}