package businesslogic.orderbl;

import java.util.ArrayList;

public class OrderList {
	ArrayList<OrderLineItem> orderList;

	/**
	 * 
	 * @param orderList
	 */
	public void setOrderList(ArrayList<OrderLineItem> orderList) {
		this.orderList = orderList;
	}

	/**
	 * 
	 * @return 获得订单列表
	 */
	public ArrayList<OrderLineItem> getOrderList() {
		return orderList;
	}

	/**
	 * 
	 * @param orderLineItem
	 */
	public void add(OrderLineItem orderLineItem) {
		orderList.add(orderLineItem);
	}

	/**
	 * 
	 * @param id
	 */
	public void delete(int id) {
		orderList.remove(id);
	}

	/**
	 * 
	 * @param orderLineItem
	 * @param id
	 */
	public void modify(OrderLineItem orderLineItem, int id) {
		orderList.set(id, orderLineItem);
	}

	/**
	 * 
	 * @param id
	 */
	public void find(int id) {
		orderList.get(id);
	}
}
