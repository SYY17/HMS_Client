package businesslogic.promotionbl;

import java.rmi.RemoteException;
import java.util.ArrayList;
import java.sql.Date;
import dataservice.promotiondataservice.PromotionDataService;
import po.PromotionPO;

public class PromotionDataService_Driver {

	public void drive(PromotionDataService promotionDataService) throws RemoteException{
		PromotionPO ppo = new PromotionPO(null, null, 0);
		String content = null;
		Date start = null;
		int id=0;
		promotionDataService.initPromotionDataService();
		ArrayList <PromotionPO> list = promotionDataService.findsPromotion(id);
		if(list != null) System.out.println("All Promotions got!");
		list = promotionDataService.findsPromotion(id, start);
		if(list != null) System.out.println("Promotions with certain start time got!");
		list = promotionDataService.findsPromotion(id, content);
		if(list != null) System.out.println("Promotions contains certain content got!");
		promotionDataService.insertPromotion(ppo);
		promotionDataService.deletePromotion(ppo);
		promotionDataService.finishPromotionDataService();
	}
}
