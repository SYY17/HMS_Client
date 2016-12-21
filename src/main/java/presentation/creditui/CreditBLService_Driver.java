package presentation.creditui;

import businesslogicservice.ResultMessage;
import businesslogicservice.creditBLService.CreditBLService;
import vo.CreditMovement;
import vo.CreditVO;

public class CreditBLService_Driver {

	public void drive(CreditBLService creditBLService) {
		int credit = 0;
		int id = 0;
		ResultMessage result = creditBLService.addCredit(id, credit);
		if (result == ResultMessage.TRUE)
			System.out.println("Credit added!");
		result = creditBLService.deleteCredit(id);
		if (result == ResultMessage.TRUE)
			System.out.println("Credit deleted!");
		result = creditBLService.modifyCredit(id, credit, CreditMovement.AbnormalOrder);
		if (result == ResultMessage.TRUE)
			System.out.println("Credit modified!");
		CreditVO cvo = creditBLService.getCredit(id);
		if (cvo != null)
			System.out.println("Credit got!");
	}
}
