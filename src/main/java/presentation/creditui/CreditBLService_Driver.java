package presentation.creditui;

import businesslogicservice.ResultMessage;
import businesslogicservice.creditBLService.CreditBLService;
import vo.CreditVO;

public class CreditBLService_Driver {
	
	public void drive(CreditBLService creditBLService){
		CreditVO cvo = new CreditVO(0, 0);
		int id = 0;
		ResultMessage result = creditBLService.addCredit(cvo, id);
		if(result == ResultMessage.TRUE) System.out.println("Credit added!");
		result = creditBLService.deleteCredit(id);
		if(result == ResultMessage.TRUE) System.out.println("Credit deleted!");
		result = creditBLService.modifyCredit(cvo, id);
		if(result == ResultMessage.TRUE) System.out.println("Credit modified!");
		cvo = creditBLService.getCredit(id);
		if(cvo != null) System.out.println("Credit got!");
	}
}
