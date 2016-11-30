package presentation.orderui;

import java.sql.Date;
import java.util.ArrayList;

import businesslogicservice.ResultMessage;
import vo.OrderStatus;
import vo.OrderVO;
import vo.PromotionVO;
import vo.RoomType;

public interface OrderControllerService {
	
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
	public OrderVO create(int userid, int hotelid, OrderStatus orderstatus, RoomType rT, int rn, PromotionVO pvo,
			Date s, Date ci, Date co);	
	
	/**
	 * 
	 * @param ovo
	 * @return 增加订单
	 */
	public ResultMessage addOrder(OrderVO ovo);	
	
	/**
	 * 
	 * @param id
	 * @param status
	 * @return 处理异常订单
	 */
	public ResultMessage complainOrder(int id, OrderStatus status);
}
