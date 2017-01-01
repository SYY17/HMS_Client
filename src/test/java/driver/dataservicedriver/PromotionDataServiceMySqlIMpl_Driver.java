package driver.dataservicedriver;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.sql.Date;

import dataservice.promotiondataservice.PromotionDataService;
import po.PromotionPO;
import po.PromotionType;

public class PromotionDataServiceMySqlIMpl_Driver {

	public void drive(PromotionDataService promotionDataService) throws RemoteException{
		String promotionName = "红丝绒优惠";
		String content = "红丝绒优惠：打折";
		PromotionType promotionType = PromotionType.DISCOUNT;
		Date start = Date.valueOf("2017-12-01");
		Date stop = Date.valueOf("2017-12-31");
		int id = 21214001;
		PromotionPO ppo = new PromotionPO(promotionName, content, start, stop, promotionType, id);
		
		//初始化PromotionDataService
		promotionDataService.initPromotionDataService();
		System.out.println("PromotionDataService initialized\n");
		
		//增加策略
		promotionDataService.insertPromotion(ppo);
		System.out.println("Promotion inserted\n");
		
		//获得所有策略
		ArrayList<PromotionPO> list = promotionDataService.getAllPromotion();
		if(list != null) System.out.println("All promotions got\n");
		
		//按照id查找策略
		list = promotionDataService.findsPromotion(id);
		if(list != null) System.out.println("All promotions with certain id got\n");
		
		//按照id和startTime查找策略
		list = promotionDataService.findsPromotion(id, start);
		if(list != null) System.out.println("All promotions with certain id and start time got\n");
		
		//按照id和content查找策略
		list = promotionDataService.findsPromotion(id, content);
		if(list != null) System.out.println("All promotions with certain id and content got\n");
		
		//按照id和startTime和content查找策略
		list = promotionDataService.findsPromotion(id, content, start);
		if(list != null) System.out.println("All promotions with certain id and content and start time got\n");
		
		//删除策略
		promotionDataService.deletePromotion(ppo);
		System.out.println("Promotion deleted\n");
		
		//结束PromotionDataService
		promotionDataService.finishPromotionDataService();
		System.out.println("PromotionDataService finished\n");
	}
}
