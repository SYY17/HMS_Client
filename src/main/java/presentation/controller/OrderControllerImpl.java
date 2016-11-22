package presentation.controller;

import java.util.ArrayList;
import businesslogicservice.ResultMessage;
import businesslogicservice.orderblservice.OrderBLService;
import presentation.orderui.OrderControllerService;
import vo.HotelVO;
import vo.OrderStatus;
import vo.OrderVO;
import vo.PromotionVO;

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
	public OrderVO create(HotelVO hvo, int id, PromotionVO pvo) {
		return orderBLService.create(hvo, id, pvo);
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
