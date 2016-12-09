package presentation.promotionui;

import java.util.ArrayList;
import java.sql.Date;

import businesslogicservice.ResultMessage;
import businesslogicservice.promotionblservice.PromotionBLService;
import vo.PromotionType;
import vo.PromotionVO;

public class PromotionBLService_Driver {

	public void drive(PromotionBLService promotionBLService) {
		PromotionVO pvo = new PromotionVO(null, null, null, null, null, 0);
		String promotionName = null;
		String content = null;
		Date start = null;
		Date stop = null;
		PromotionType pt = null;
		int id = 0;
		ResultMessage result = promotionBLService.addPromotion(pvo);
		if (result == ResultMessage.TRUE)
			System.out.println("Promotion added!");
		ArrayList<PromotionVO> list = promotionBLService.getAllPromotion(id);
		if (list != null)
			System.out.println("All Promotions got!");
		result = promotionBLService.deletePromotion(pvo);
		if (list != null)
			System.out.println("Promotion deleted!");
		result = promotionBLService.searchPromotion(pvo);
		if (list != null)
			System.out.println("Promotion exists!");
		list = promotionBLService.searchByContent(id, content);
		if (list != null)
			System.out.println("Promotions contains certain content got!");
		list = promotionBLService.searchByStartTime(id, start);
		if (list != null)
			System.out.println("Promotions with certain start time got!");
	}
}
