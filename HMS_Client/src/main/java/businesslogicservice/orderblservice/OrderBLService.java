package businesslogicservice.orderblservice;

import java.util.ArrayList;
import businesslogicservice.ResultMessage;
import vo.HotelVO;
import vo.OrderStatus;
import vo.OrderVO;
import vo.PromotionVO;

public interface OrderBLService {
	
	/**
	 * 
	 * @param id
	 * @return 浏览全部订单
	 */
	public ArrayList<OrderVO> reviewOrder(int id);	
	
	/**
	 * 
	 * @param id
	 * @return 浏览异常订单
	 */
	public ArrayList<OrderVO> reviewAbnormalOrder(int id);	
	
	/**
	 * 
	 * @param ovo
	 * @return 取消订单
	 */
	public ResultMessage cancelOrder(OrderVO ovo);	
	
	/**
	 * 
	 * @param hvo
	 * @param id
	 * @param pvo
	 * @return 创建订单
	 */
	public OrderVO create(HotelVO hvo,int id,PromotionVO pvo);	
	
	/**
	 * 
	 * @param ovo
	 * @return 增加订单
	 */
	public ResultMessage addOrder(OrderVO ovo);	
	
	/**
	 * 
	 * @param cvo
	 * @param id
	 * @return 处理异常订单
	 */
	public ResultMessage complainOrder(int id, OrderStatus status);		
}
