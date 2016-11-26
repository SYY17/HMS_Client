package presentation.controller;

import java.util.ArrayList;
import java.util.Date;

import businesslogicservice.ResultMessage;
import businesslogicservice.orderblservice.OrderBLService;
import presentation.orderui.OrderControllerService;
import vo.OrderStatus;
import vo.OrderVO;
import vo.PromotionVO;
import vo.RoomType;

public class OrderControllerImpl implements OrderControllerService{
	
	private OrderBLService orderBLService;

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
	public ArrayList<OrderVO> reviewAbnormalOrder(int id) {
		return orderBLService.reviewAbnormalOrder(id);
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
	public OrderVO create(int userid, int hotelid, OrderStatus orderstatus, RoomType rT, int rn, PromotionVO pvo,
			Date s, Date ci, Date co) {
		return orderBLService.create(rn, rn, orderstatus, rT, rn, pvo, co, co, co);
	}
	
	/**
	 * 
	 * @param ovo
	 * @return 增加订单
	 */
	@Override
	public ResultMessage addOrder(OrderVO ovo) {
		return orderBLService.addOrder(ovo);
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
