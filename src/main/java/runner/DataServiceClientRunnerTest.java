package runner;

import static org.junit.Assert.*;

import java.rmi.RemoteException;

import org.junit.Before;
import org.junit.Test;

import po.CreditPO;
import rmi.RemoteController;

public class DataServiceClientRunnerTest {

	DataServiceClientRunner runner;
	
	@Before
	public void setUp() throws Exception {
		runner = new DataServiceClientRunner();
		runner.start();
	}

	@Test
	public void test(){
		RemoteController remoteController = runner.getRemoteController();
		try {
			remoteController.getCreditDataService().initCreditDataService();
			remoteController.getCreditDataService().insertCredit(new CreditPO(11002166, 2000));
			
			CreditPO credit = remoteController.getCreditDataService().findCredit(11002166);
			assertEquals(11002166, credit.getID());
			assertEquals(2000, credit.getCredit());
			
			remoteController.getCreditDataService().deleteCredit(11002166);;
			credit = remoteController.getCreditDataService().findCredit(11002166);
			assertEquals(null, credit);
			remoteController.getCreditDataService().finishCreditDataService();
		} catch (RemoteException e) {
			e.printStackTrace();
		}
	}

}
