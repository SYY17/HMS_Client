package stub.blservicestub;

import java.sql.Date;
import java.util.ArrayList;

import businesslogicservice.ResultMessage;
import businesslogicservice.creditBLService.CreditBLService;
import vo.CreditMovement;
import vo.CreditVO;
import vo.UserCreditHistoryVO;

public class CreditBLService_Stub implements CreditBLService{
	int id;
	int credit;
	CreditMovement movement;
	Date time;
	int change;
	int remain;
	
	public CreditBLService_Stub(int i, int c, CreditMovement m, Date t, int ch, int r) {
		// TODO Auto-generated constructor stub
		id = i;
		credit = c;
		movement = m;
		time = t;
		change = ch;
		remain = r;
	}
	
	/**
	 * 添加信用值对象
	 */
	@Override
	public ResultMessage addCredit(int id, int credit) {
		// TODO Auto-generated method stub
		if(id == 1){
			return ResultMessage.TRUE;
		}
		else return ResultMessage.FALSE;
	}

	/**
	 * 修改信用值对象
	 */
	@Override
	public ResultMessage modifyCredit(int id, int credit, CreditMovement creditMovement) {
		// TODO Auto-generated method stub
		if(id == 1 && creditMovement != null){
			return ResultMessage.TRUE;
		}
		else return ResultMessage.FALSE;
	}

	/**
	 * 获取信用值历史
	 */
	@Override
	public ArrayList<UserCreditHistoryVO> getHistory(int userId) {
		// TODO Auto-generated method stub
		UserCreditHistoryVO ucho = new UserCreditHistoryVO(id, change, time, po.CreditMovement.AddMoney, remain);
		ArrayList<UserCreditHistoryVO> list = new ArrayList<>();
		list.add(ucho);
		return list;
	}

	/**
	 * 删除信用值对象
	 */
	@Override
	public ResultMessage deleteCredit(int id) {
		// TODO Auto-generated method stub
		if(id > 10000000 && id < 20000000){
			return ResultMessage.TRUE;
		}
		else return ResultMessage.FALSE;
	}

	/**
	 * 获取信用值对象
	 */
	@Override
	public CreditVO getCredit(int id) {
		// TODO Auto-generated method stub
		CreditVO cvo = new CreditVO(id, credit);
		if(id > 10000000 && id < 20000000){
			return cvo;
		}
		else return null;
	}
	
}
