package driver.dataservicedriver;

import java.rmi.RemoteException;

import dataservice.creditdataservice.CreditDataService;
import po.CreditPO;

public class CreditDataServiceMySqlImpl_Driver {
	
	public void drive(CreditDataService creditDataService) throws RemoteException{
		int id = 10101001;
		int credit = 1000;
		CreditPO cpo = new CreditPO(id, credit);
		
		//初始化CreditDataService
		creditDataService.initCreditDataService();
		System.out.println("CreditDataService initialized\n");
		
		//删除Credit对象
		creditDataService.deleteCredit(id);
		System.out.println("Credit deleted\n");
		
		//插入Credit对象
		creditDataService.insertCredit(cpo);
		System.out.println("Credit inserted\n");
		
		//更新Credit对象
		creditDataService.updateCredit(cpo);
		System.out.println("Credit updated\n");
		
		//根据ID查找并获得信用值信息
		cpo = creditDataService.findCredit(id);
		if(cpo != null) System.out.println("Credit found\n");
		
		//结束CreditDataService
		creditDataService.finishCreditDataService();
		System.out.println("CreditDataService finished\n");
	}
}
