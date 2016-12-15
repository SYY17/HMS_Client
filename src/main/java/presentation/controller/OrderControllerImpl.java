package presentation.controller;

import java.sql.Date;
import java.sql.Timestamp;
import java.util.ArrayList;

import businesslogic.orderbl.OrderController;
import businesslogicservice.ResultMessage;
import businesslogicservice.orderblservice.OrderBLService;
import presentation.orderui.OrderControllerService;
import vo.OrderStatus;
import vo.OrderVO;
import vo.RoomType;

public class OrderControllerImpl implements OrderControllerService {

	private OrderBLService orderBLService;

	public OrderControllerImpl() {
		// TODO Auto-generated constructor stub
		orderBLService = new OrderController();
	}

	/**
	 * 
	 * @param id
	 * @return 浏览全部订单
	 */
	@Override
	public ArrayList<OrderVO> reviewOrder(int id) {
		return orderBLService.reviewOrder(id);
	}

	/**
	 * 
	 * @param id
	 * @return 浏览异常订单
	 */
	@Override
	public ArrayList<OrderVO> reviewOrder(int id, OrderStatus orderStatus) {
		return orderBLService.reviewOrder(id, orderStatus);
	}

	/**
	 * 
	 * @param ovo
	 * @return 取消订单
	 */
	@Override
	public ResultMessage cancelOrder(OrderVO ovo) {
		return orderBLService.cancelOrder(ovo);
	}

	/**
	 * 
	 * @param hvo
	 * @param id
	 * @param pvo
	 * @return 创建订单
	 */
	@Override
	public OrderVO create(String userName, String hotelName, RoomType roomType, int roomNumber, Timestamp setTime,
			Date checkIn, Date checkOut) {
		return orderBLService.create(userName, hotelName, roomType, roomNumber, setTime, checkIn, checkOut);
	}


	/**
	 * 
	 * @param id
	 * @param status
	 * @return 处理异常订单
	 */
	@Override
	public ResultMessage complainOrder(int id, OrderStatus status) {
		return orderBLService.complainOrder(id, status);
	}

}
