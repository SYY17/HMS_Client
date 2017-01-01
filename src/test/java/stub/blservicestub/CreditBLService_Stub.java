//package stub.blservicestub;
//
//import businesslogicservice.ResultMessage;
//import businesslogicservice.creditBLService.CreditBLService;
//import vo.CreditVO;
//
//public class CreditBLService_Stub implements CreditBLService{
//	int id = 0;
//	int credit = 0;
//	
//	public CreditBLService_Stub(int i, int c) {
//		// TODO Auto-generated constructor stub
//		id = i;
//		credit = i;
//	}
//	
//	@Override
//	public ResultMessage addCredit(CreditVO cvo, int id) {
//		// TODO Auto-generated method stub
//		if(cvo != null&&id == 0){
//			return ResultMessage.TRUE;
//		}
//		else return ResultMessage.FALSE;
//	}
//
//	@Override
//	public ResultMessage deleteCredit(int id) {
//		// TODO Auto-generated method stub
//		if(id == 0){
//			return ResultMessage.TRUE;
//		}
//		else return ResultMessage.FALSE;
//	}
//
//	@Override
//	public ResultMessage modifyCredit(CreditVO cvo, int id) {
//		// TODO Auto-generated method stub
//		if(cvo != null&&id == 0){
//			return ResultMessage.TRUE;
//		}
//		else return ResultMessage.FALSE;
//	}
//
//	@Override
//	public CreditVO getCredit(int id) {
//		// TODO Auto-generated method stub
//		CreditVO Credit = new CreditVO(id, credit);
//		return Credit;
//	}
//	
//}
