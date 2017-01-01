package driver.blservicedriver;

import java.util.ArrayList;

import businesslogicservice.ResultMessage;
import businesslogicservice.creditBLService.CreditBLService;
import vo.CreditMovement;
import vo.CreditVO;
import vo.UserCreditHistoryVO;

public class CreditBLService_Driver {
	
	public void drive(CreditBLService creditBLService){
		
		int id = 10101001;
		int credit = 1000;
		CreditVO cvo = new CreditVO(10101001, 1000);
		CreditMovement movement = CreditMovement.AddMoney;
		ArrayList<UserCreditHistoryVO> history;
		
		//删除信用值信息
		ResultMessage result = creditBLService.deleteCredit(id);
		if(result == ResultMessage.TRUE) System.out.println("Credit deleted\n");
		
		//添加信用值信息
		result = creditBLService.addCredit(10101001, 1000);
		if(result == ResultMessage.TRUE) System.out.println("Credit added\n");
		
		//查看信用值信息
		cvo = creditBLService.getCredit(id);
		if(cvo != null && cvo.getCredit() == 10101001) System.out.println("Credit got\n");
		
		//修改信用值信息
		result = creditBLService.modifyCredit(id, credit, movement);
		if(result == ResultMessage.TRUE) System.out.println("Credit modified\n");
		
		//查看信用值历史
		history = creditBLService.getHistory(id);
		if(history != null) System.out.println("Credit history got\n");
		
	}
}
