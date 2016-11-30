package businesslogictest.orderbl;

import java.util.ArrayList;
import businesslogic.hotelbl.HotelController;
import businesslogicservice.ResultMessage;
import vo.OrderVO;

public class MockHotel extends HotelController {
	ArrayList<OrderVO> orderList;

	public MockHotel() {
		super();
	}

	public ResultMessage modifyOrderList(int flag, OrderVO orderPO) {
		return ResultMessage.TRUE;
	}

}
