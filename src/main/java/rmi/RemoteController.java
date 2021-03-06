package rmi;

import java.rmi.Remote;

import dataservice.creditdataservice.CreditDataService;
import dataservice.customerdataservice.CustomerDataService;
import dataservice.datafactoryservice.DataFactoryService;
import dataservice.discountpromotiondataservice.DiscountPromotionDataService;
import dataservice.fullcutpromotiondataservice.FullCutPromotionDataService;
import dataservice.hoteldataservice.HotelDataService;
import dataservice.logindataservice.LoginDataService;
import dataservice.orderdataservice.OrderDataService;
import dataservice.promotiondataservice.PromotionDataService;
import dataservice.roomdataservice.RoomDataService;
import dataservice.usercredithistoryservice.UserCreditHistoryDataService;
import dataservice.userdataservice.UserDataService;

public class RemoteController {
	private Remote remote;
	private static RemoteController remoteController = new RemoteController();

	/**
	 * 单件模式
	 */
	private RemoteController() {
		// 单件模式
	}

	/**
	 * 
	 * @return 返回唯一的实例对象
	 */
	public static RemoteController getInstance() {
		return remoteController;
	}

	/**
	 * 设置链接
	 * 
	 * @param remote
	 */
	public void setRemote(Remote remote) {
		this.remote = remote;
	}
	
	/**
	 * 
	 * @return 获得登录/注册数据信息服务
	 */
	public LoginDataService getLoginDataService() {
		return (LoginDataService) remote;
	}

	/**
	 * 
	 * @return 获得信用值数据信息服务
	 */
	public CreditDataService getCreditDataService() {
		return (CreditDataService) remote;
	}

	/**
	 * 
	 * @return 获得酒店数据信息服务
	 */
	public HotelDataService getHotelDataService() {
		return (HotelDataService) remote;
	}

	/**
	 * 
	 * @return 获得订单数据信息服务
	 */
	public OrderDataService getOrderDataService() {
		return (OrderDataService) remote;
	}

	/**
	 * 
	 * @return 获得营销策略数据信息服务
	 */
	public PromotionDataService getPromotionDataService() {
		return (PromotionDataService) remote;
	}

	/**
	 * 
	 * @return 获得房间数据信息服务
	 */
	public RoomDataService getRoomDataService() {
		return (RoomDataService) remote;
	}

	/**
	 * 
	 * @return 获得用户数据信息服务
	 */
	public UserDataService getUserDataService() {
		return (UserDataService) remote;
	}

	/**
	 * 
	 * @return 获得用户历史信息信息服务
	 */
	public UserCreditHistoryDataService getUserCreditHistoryDataService() {
		return (UserCreditHistoryDataService) remote;
	}

	/**
	 * 
	 * @return 获得满减策略信息服务
	 */
	public FullCutPromotionDataService getFullCutPromotionDataService() {
		return (FullCutPromotionDataService) remote;
	}

	/**
	 * 
	 * @return 获得折扣策略信息服务
	 */
	public DiscountPromotionDataService getDiscountPromotionDataService() {
		return (DiscountPromotionDataService) remote;
	}
	
	/**
	 * 
	 * @return 获得顾客信息服务
	 */
	public CustomerDataService getCustomerDataService() {
		return (CustomerDataService) remote;
	}

	/**
	 * 
	 * @return 获得数据工厂服务
	 */
	public DataFactoryService getDataFactoryService() {
		return (DataFactoryService) remote;
	}
}
