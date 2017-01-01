//package stub.blservicestub;
//
//import java.util.ArrayList;
//import java.util.Date;
//
//import businesslogicservice.ResultMessage;
//import businesslogicservice.promotionblservice.PromotionBLService;
//import vo.PromotionVO;
//
//public class PromotionBLService_Stub implements PromotionBLService{
//	String content = null;
//	Date start = null;
//	int id = 0;
//	
//	public PromotionBLService_Stub(String ctt, Date s, int i) {
//		// TODO Auto-generated constructor stub
//		content = ctt;
//		start = s;
//		id = i;
//	}
//	
//	@Override
//	public ResultMessage addPromotion(PromotionVO pvo) {
//		// TODO Auto-generated method stub
//		if(pvo != null){
//			return ResultMessage.TRUE;
//		}
//		else return ResultMessage.FALSE;
//	}
//
//	//Ӫ�����Խ���õ�����Ӫ��������Ϣ
//	@Override
//	public ArrayList<PromotionVO> getAllPromotion() {
//		// TODO Auto-generated method stub
//		ArrayList<PromotionVO> PromotionList = new ArrayList<>();
//		PromotionList.add(new PromotionVO(content, start, id));
//		return PromotionList;
//	}
//
//	@Override
//	public ResultMessage deletePromotion(PromotionVO pvo) {
//		// TODO Auto-generated method stub
//		if(pvo != null){
//			return ResultMessage.TRUE;
//		}
//		else return ResultMessage.FALSE;
//	}
//
//	@Override
//	public ResultMessage searchPromotion(PromotionVO pvo) {
//		// TODO Auto-generated method stub
//		if(pvo != null){
//			return ResultMessage.TRUE;
//		}
//		else return ResultMessage.FALSE;
//	}
//
//	//Ӫ�����Խ���õ�Ӫ���������ݰ����������ݵ�Ӫ��������Ϣ
//	@Override
//	public ArrayList<PromotionVO> searchByContent(String content) {
//		// TODO Auto-generated method stub
//		ArrayList<PromotionVO> PromotionList = new ArrayList<>();
//		PromotionList.add(new PromotionVO(content, start, id));
//		return PromotionList;
//	}
//
//	//Ӫ�����Խ���õ�Ӫ��������ʼʱ��Ϊ������ʼʱ���Ӫ��������Ϣ
//	@Override
//	public ArrayList<PromotionVO> searchByStartTime(Date start) {
//		// TODO Auto-generated method stub
//		ArrayList<PromotionVO> PromotionList = new ArrayList<>();
//		PromotionList.add(new PromotionVO(content, start, id));
//		return PromotionList;
//	}
//	
//}
