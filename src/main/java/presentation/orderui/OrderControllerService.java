package presentation.orderui;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

import businesslogicservice.ResultMessage;
import vo.OrderStatus;
import vo.OrderVO;
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
	 * @return 浏览相应状态的订单
	 */
	public ArrayList<OrderVO> reviewOrder(int id, OrderStatus orderStatus);

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
	public OrderVO create(String userName, String hotelName, RoomType roomType, int roomNumber, Timestamp setTime,
			Date checkIn, Date checkOut);


	/**
	 * 
	 * @param id
	 * @param status
	 * @return 处理异常订单
	 */
	public ResultMessage complainOrder(int id, OrderStatus status);
}
