package businesslogictest.hotelbl;

import java.util.ArrayList;
import java.util.Date;

import businesslogic.promotionbl.PromotionBLService_Stub;
import businesslogicservice.ResultMessage;
import vo.HotelVO;

public class MockPromotion extends PromotionBLService_Stub {
	int credit;
	ArrayList<HotelVO> hotelList;

	public MockPromotion(String ctt, Date s, int i) {
		super(ctt, s, i);
	}

	public ResultMessage modifyHotelPrice(int flag, HotelVO hotelVO) {
		return ResultMessage.TRUE;
	}
	
}