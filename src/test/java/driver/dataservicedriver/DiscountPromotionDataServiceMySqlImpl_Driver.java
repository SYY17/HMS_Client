package driver.dataservicedriver;

import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;

import dataservice.discountpromotiondataservice.DiscountPromotionDataService;
import po.DiscountPromotionPO;
import po.PromotionType;

public class DiscountPromotionDataServiceMySqlImpl_Driver {
	
	public void drive(DiscountPromotionDataService promotionDataService) throws RemoteException{
		String promotionName = "红丝绒优惠";
		String content = "红丝绒优惠：打折";
		PromotionType promotionType = PromotionType.DISCOUNT;
		Date start = Date.valueOf("2017-12-01");
		Date stop = Date.valueOf("2017-12-31");
		int id = 21214001;
		double discount = 0.8;
		DiscountPromotionPO dpo = new DiscountPromotionPO(promotionName, content, start, stop, promotionType, id, discount);
		
		//初始化DiscountPromotionDataService
		promotionDataService.initDiscountPromotionDataService();
		System.out.println("DiscountPromotionDataService initialized\n");
		
		//增加策略
		promotionDataService.insertDiscountPromotion(dpo);
		System.out.println("DiscountPromotion inserted\n");
		
		//按照id查找策略
		ArrayList<DiscountPromotionPO> list = promotionDataService.findsDiscountPromotion(id);
		if(list != null) System.out.println("All discount promotions with certain id got\n");
		
		//按照id和startTime查找策略
		list = promotionDataService.findsDiscountPromotion(id, start);
		if(list != null) System.out.println("All discount promotions with certain id and start time got\n");
		
		//按照id和content查找策略
		list = promotionDataService.findsDiscountPromotion(id, content);
		if(list != null) System.out.println("All discount promotions with certain id and content got\n");
		
		//按照id和startTime和content查找策略
		list = promotionDataService.findsDiscountPromotion(id, content, start);
		if(list != null) System.out.println("All discount promotions with certain id and content and start time got\n");
		
		//删除策略
		promotionDataService.deleteDiscountPromotion(dpo);
		System.out.println("DiscountPromotion deleted\n");
		
		//结束DiscountPromotionDataService
		promotionDataService.finishDiscountPromotionDataService();
		System.out.println("DiscountPromotionDataService finished\n");
	}
}
