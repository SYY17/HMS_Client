package businesslogic.orderbl;

import java.util.ArrayList;

import businesslogicservice.ResultMessage;
import businesslogicservice.orderblservice.OrderBLService;
import vo.HotelVO;
import vo.OrderStatus;
import vo.OrderVO;
import vo.PromotionVO;

public class OrderController implements OrderBLService{

	@Override
	public ArrayList<OrderVO> reviewOrder(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ArrayList<OrderVO> reviewAbnormalOrder(int id) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage cancelOrder(OrderVO ovo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public OrderVO create(HotelVO hvo, int id, PromotionVO pvo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage addOrder(OrderVO ovo) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public ResultMessage complainOrder(int id, OrderStatus status) {
		// TODO Auto-generated method stub
		return null;
	}

}
