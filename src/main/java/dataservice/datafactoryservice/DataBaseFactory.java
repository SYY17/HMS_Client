package dataservice.datafactoryservice;

import dataservice.creditdataservice.CreditDataService;
import dataservice.hoteldataservice.HotelDataService;
import dataservice.orderdataservice.OrderDataService;
import dataservice.promotiondataservice.PromotionDataService;
import dataservice.userdataservice.UserDataService;

public interface DataBaseFactory {
	public UserDataService getUserData();

	public OrderDataService getOrderData();

	public HotelDataService getHotelData();

	public PromotionDataService getPromotionData();

	public CreditDataService getCreditData();
}
