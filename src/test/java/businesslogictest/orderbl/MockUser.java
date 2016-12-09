package businesslogictest.orderbl;

import java.util.ArrayList;

import businesslogic.userbl.UserController;
import businesslogicservice.ResultMessage;
import vo.CreditVO;
import vo.OrderVO;

public class MockUser extends UserController {
	int credit;
	ArrayList<OrderVO> orderList;

	public MockUser() {
		super();
	}

	public ResultMessage modifyOrderList(int flag, OrderVO orderVO) {
		return ResultMessage.TRUE;
	}

	public ResultMessage modifyCredit(int flag, CreditVO creditVO) {
		return ResultMessage.TRUE;
	}
}
