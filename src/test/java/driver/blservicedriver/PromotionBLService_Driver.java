package driver.blservicedriver;

import java.util.ArrayList;
import java.sql.Date;

import businesslogicservice.ResultMessage;
import businesslogicservice.promotionblservice.PromotionBLService;
import vo.DiscountPromotionVO;
import vo.FullCutPromotionVO;
import vo.PromotionType;
import vo.PromotionVO;

public class PromotionBLService_Driver {
	
	public void drive(PromotionBLService promotionBLService){
		
		String promotionName = "红丝绒优惠";
		String content = "红丝绒优惠：打折";
		PromotionType promotionType = PromotionType.DISCOUNT;
		Date start = Date.valueOf("2017-12-01");
		Date stop = Date.valueOf("2017-12-31");
		int id = 21214001;
		double discount = 0.8;
		double every = 100;
		double cut = 10;
		PromotionVO pvo = new PromotionVO(promotionName, content, start, stop, promotionType, id);
		DiscountPromotionVO dvo = new DiscountPromotionVO(promotionName, content, start, stop, promotionType, id, discount);
		FullCutPromotionVO fvo = new FullCutPromotionVO(promotionName, content, start, stop, promotionType, id, every, cut);
		
		//策略增加
		ResultMessage resultMessage = promotionBLService.addPromotion(pvo);
		if(resultMessage == ResultMessage.TRUE) System.out.println("Promotion added\n");
		
		//获得全部策略
		ArrayList <PromotionVO> list = promotionBLService.getAllPromotion(id);
		if(list != null) System.out.println("All Promotions got\n");
		
		//搜索策略
		resultMessage = promotionBLService.searchPromotion(pvo);
		if(resultMessage == ResultMessage.TRUE) System.out.println("Promotion found\n");
		
		//按照内容搜索策略
		list = promotionBLService.searchByContent(id, content);
		if(list != null) System.out.println("All Promotions with certain id and content got\n");
		
		//按照开始时间搜索策略
		list = promotionBLService.searchByStartTime(id, start);
		if(list != null) System.out.println("All Promotions with certain id and start time got\n");
		
		//策略删除
		resultMessage = promotionBLService.deletePromotion(pvo);
		if(resultMessage == ResultMessage.TRUE) System.out.println("Promotion deleted\n");

		//策略增加
		resultMessage = promotionBLService.addPromotion(fvo);
		if(resultMessage == ResultMessage.TRUE) System.out.println("FullCutPromotion added\n");
		
		//策略增加
		resultMessage = promotionBLService.addPromotion(dvo);
		if(resultMessage == ResultMessage.TRUE) System.out.println("DiscountPromotion added\n");
		
		//按照内容搜索策略
		ArrayList<FullCutPromotionVO> fList = promotionBLService.searchFullCutByContent(id, content);
		if(fList != null) System.out.println("All FullCutPromotions with certain id and content got\n");
		
		//按照开始时间搜索策略
		fList = promotionBLService.searchFullCutByStartTime(id, start);
		if(fList != null) System.out.println("All FullCutPromotions with certain id and start time got\n");
				
		//按照内容搜索策略
		ArrayList<DiscountPromotionVO> dList = promotionBLService.searchDiscountByContent(id, content);
		if(dList != null) System.out.println("All DiscountPromotions with certain id and content got\n");
		
		//按照开始时间搜索策略
		dList = promotionBLService.searchDiscountByStartTime(id, start);
		if(dList != null) System.out.println("All DiscountPromotions with certain id and start time got\n");
				
		//策略删除
		resultMessage = promotionBLService.deletePromotion(fvo);
		if(resultMessage == ResultMessage.TRUE) System.out.println("FullCutPromotion deleted\n");
				
		//策略删除
		resultMessage = promotionBLService.deletePromotion(dvo);
		if(resultMessage == ResultMessage.TRUE) System.out.println("DiscountPromotion deleted\n");
	}
}
