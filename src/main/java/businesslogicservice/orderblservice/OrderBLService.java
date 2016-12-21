package businesslogicservice.orderblservice;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

import businesslogicservice.ResultMessage;
import vo.CreditMovement;
import vo.OrderStatus;
import vo.OrderVO;
import vo.RoomType;

public interface OrderBLService {

	/**
	 * 
	 * @param id
	 * @return 浏览全部订单
	 */
	public ArrayList<OrderVO> reviewOrder(int id);

	/**
	 * 
	 * @param id,orderStatus
	 * @return 浏览相应状态的订单
	 */
	public ArrayList<OrderVO> reviewOrder(int id, OrderStatus orderStatus);

	/**
	 * 
	 * @param ovo
	 * @return 取消订单
	 */
	public ResultMessage cancelOrder(int id);

	/**
	 * 
	 * @param userName,hotelName,roomType,roomNumber,setTime,checkIn,checkOut
	 * @param id
	 * @param pvo
	 * @return 创建订单
	 */
	public OrderVO create(String userName, String hotelName, RoomType roomType, int roomNumber, Timestamp setTime,
			Date checkIn, Date checkOut, Timestamp deadline, int predictNumber, boolean haveChild);


	/**
	 * 
	 * @param cvo
	 * @param id
	 * @return 改变订单状态
	 */
	public ResultMessage changeOrderStatus(int id, OrderStatus status,CreditMovement creditMovement);
	
	/**
	 * 
	 * @param id
	 * @param room
	 * @return 分配房间号
	 */
	public ResultMessage assignRoom(int id, String room);
}
