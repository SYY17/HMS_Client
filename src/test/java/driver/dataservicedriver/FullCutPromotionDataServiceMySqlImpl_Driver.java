package driver.dataservicedriver;

import java.rmi.RemoteException;
import java.sql.Date;
import java.util.ArrayList;

import dataservice.fullcutpromotiondataservice.FullCutPromotionDataService;
import po.FullCutPromotionPO;
import po.PromotionType;

public class FullCutPromotionDataServiceMySqlImpl_Driver {
	
	public void drive(FullCutPromotionDataService promotionDataService) throws RemoteException{
		String promotionName = "红丝绒优惠";
		String content = "红丝绒优惠：打折";
		PromotionType promotionType = PromotionType.FULL_CUT;
		Date start = Date.valueOf("2017-12-01");
		Date stop = Date.valueOf("2017-12-31");
		int id = 21214001;
		double every = 100;
		double cut = 10;
		FullCutPromotionPO fpo = new FullCutPromotionPO(promotionName, content, start, stop, promotionType, id, every, cut);
	
		//初始化FullCutPromotionDataService
		promotionDataService.initFullCutPromotionDataService();
		System.out.println("FullCutPromotionDataService initialized\n");
		
		//增加策略
		promotionDataService.insertFullCutPromotion(fpo);
		System.out.println("FullCutPromotion inserted\n");
		
		//按照id查找策略
		ArrayList<FullCutPromotionPO> list = promotionDataService.findsFullPromotion(id);
		if(list != null) System.out.println("All fullCut promotions with certain id got\n");
		
		//按照id和startTime查找策略
		list = promotionDataService.findsFullPromotion(id, start);
		if(list != null) System.out.println("All fullCut promotions with certain id and start time got\n");
		
		//按照id和content查找策略
		list = promotionDataService.findsFullPromotion(id, content);
		if(list != null) System.out.println("All fullCut promotions with certain id and content got\n");
		
		//按照id和startTime和content查找策略
		list = promotionDataService.findsFullPromotion(id, content, start);
		if(list != null) System.out.println("All fullCut promotions with certain id and content and start time got\n");
		
		//删除策略
		promotionDataService.deleteFullCutPromotion(fpo);
		System.out.println("FullCutPromotion deleted\n");
		
		//结束FullCutPromotionDataService
		promotionDataService.finishFullCutPromotionDataService();
		System.out.println("FullCutPromotionDataService finished\n");
	}

}
