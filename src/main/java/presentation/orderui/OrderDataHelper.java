package presentation.orderui;

import presentation.userui.user.OrderDataForRating;
import vo.OrderVO;

public class OrderDataHelper {
	public OrderData toOrderData(OrderVO ovo) {
		return new OrderData(ovo.getOrderID(), ovo.getUserName(), ovo.getOrderStatus(), ovo.getHotelName(),
				ovo.getSetTime(), ovo.getCheckIn(), ovo.getCheckOut(), ovo.getRoomType(), ovo.getRoomNumber(),
				ovo.getPrice());
	}

	public OrderDataForSalerUI toOrderDataForSalerUI(OrderVO ovo) {
		return new OrderDataForSalerUI(ovo.getOrderID(), ovo.getUserName(), ovo.getOrderStatus(), ovo.getHotelName(),
				ovo.getSetTime(), ovo.getCheckIn(), ovo.getCheckOut(), ovo.getRoomType(), ovo.getRoomNumber(),
				ovo.getPrice());
	}
	
	public OrderDataForManageAbnormalOrder toOrderDataForManageAbnormalOrder(OrderVO ovo) {
		return new OrderDataForManageAbnormalOrder(ovo.getOrderID(), ovo.getUserName(), ovo.getOrderStatus(), ovo.getHotelName(),
				ovo.getSetTime(), ovo.getCheckIn(), ovo.getCheckOut(), ovo.getRoomType(), ovo.getRoomNumber(),
				ovo.getPrice());
	}

	
	public OrderDataForManageAbnormalOrderAndCredit toOrderDataForManageAbnormalOrderAndCredit(OrderVO ovo) {
		return new OrderDataForManageAbnormalOrderAndCredit(ovo.getOrderID(), ovo.getUserName(), ovo.getOrderStatus(), ovo.getHotelName(),
				ovo.getSetTime(), ovo.getCheckIn(), ovo.getCheckOut(), ovo.getRoomType(), ovo.getRoomNumber(),
				ovo.getPrice());
	}

	public OrderDataForRating toOrderDataForRating(OrderVO ovo){
		return new OrderDataForRating(ovo.getHotelName(), ovo.getCheckIn(), ovo.getCheckOut(), ovo.getRoomType(), ovo.getRoomNumber(),
				ovo.getPrice());
	}

}
