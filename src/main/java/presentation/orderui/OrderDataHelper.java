package presentation.orderui;

import vo.OrderVO;

public class OrderDataHelper {

	public OrderData toOrderData(OrderVO ovo) {
		return new OrderData(ovo.getOrderID(), ovo.getUserName(), ovo.getOrderStatus(), ovo.getHotelName(),
				ovo.getSetTime(), ovo.getCheckIn(), ovo.getCheckOut(), ovo.getRoomType(), ovo.getRoomNumber(),
				ovo.getPrice());
	}

}
