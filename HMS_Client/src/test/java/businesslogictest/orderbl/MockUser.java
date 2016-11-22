package businesslogictest.orderbl;

import java.util.ArrayList;

import businesslogic.userbl.UserBLService_Stub;
import businesslogicservice.ResultMessage;
import vo.CreditVO;
import vo.OrderVO;

public class MockUser extends UserBLService_Stub {
	int credit;
	ArrayList<OrderVO> orderList;

	public MockUser(int i, String n, String p) {
		super(i, n, p);
	}

	public ResultMessage modifyOrderList(int flag, OrderVO orderVO) {
		return ResultMessage.TRUE;
	}
	
	public ResultMessage modifyCredit(int flag, CreditVO creditVO){
		return ResultMessage.TRUE;
	}
}
