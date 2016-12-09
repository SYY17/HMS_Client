package businesslogictest.hotelbl;

import java.util.ArrayList;
import businesslogic.promotionbl.PromotionController;
import businesslogicservice.ResultMessage;
import vo.HotelVO;

public class MockPromotion extends PromotionController {
	int credit;
	ArrayList<HotelVO> hotelList;

	public MockPromotion() {
		super();
	}

	public ResultMessage modifyHotelPrice(int flag, HotelVO hotelVO) {
		return ResultMessage.TRUE;
	}

}