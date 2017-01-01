//package driver.blservicedriver;
//
//import java.util.ArrayList;
//import java.util.Date;
//
//import businesslogicservice.ResultMessage;
//import businesslogicservice.promotionblservice.PromotionBLService;
//import vo.PromotionVO;
//
//public class PromotionBLService_Driver {
//	
//	public void drive(PromotionBLService promotionBLService){
//		PromotionVO pvo = new PromotionVO(null, null, 0);
//		String content = null;
//		Date start = null;
//		ResultMessage result = promotionBLService.addPromotion(pvo);
//		if(result == ResultMessage.TRUE) System.out.println("Promotion added!");
//		ArrayList <PromotionVO> list = promotionBLService.getAllPromotion();
//		if(list != null) System.out.println("All Promotions got!");
//		result = promotionBLService.deletePromotion(pvo);
//		if(list != null) System.out.println("Promotion deleted!");
//		result = promotionBLService.searchPromotion(pvo);
//		if(list != null) System.out.println("Promotion exists!");
//		list = promotionBLService.searchByContent(content);
//		if(list != null) System.out.println("Promotions contains certain content got!");
//		list = promotionBLService.searchByStartTime(start);
//		if(list != null) System.out.println("Promotions with certain start time got!");
//	}
//}
