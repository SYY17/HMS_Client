package businesslogic.creditbl;

import java.rmi.RemoteException;
import dataservice.creditdataservice.CreditDataService;
import po.CreditPO;

public class CreditDataService_Driver {

	public void drive(CreditDataService creditDataService) throws RemoteException {
		CreditPO cpo = new CreditPO(0, 0);
		int id = 0;
		creditDataService.initCreditDataService();
		creditDataService.insertCredit(cpo);
		creditDataService.deleteCredit(id);
		creditDataService.updateCredit(cpo);
		cpo = creditDataService.findCredit(id);
		if (cpo != null)
			System.out.println("Credit found!");
		creditDataService.finishCreditDataService();
	}
}
