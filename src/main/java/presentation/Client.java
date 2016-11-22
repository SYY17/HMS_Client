package presentation;
import businesslogic.creditbl.CreditController;
import businesslogic.hotelbl.HotelBLService_Stub;
import businesslogic.promotionbl.PromotionController;
import businesslogic.userbl.UserBLService_Stub;
import businesslogicservice.creditBLService.CreditBLService;
import businesslogicservice.hotelBLService.HotelBLService;
import businesslogicservice.promotionblservice.PromotionBLService;
import businesslogicservice.userblservice.UserBLService;
import presentation.creditui.CreditBLService_Driver;
import presentation.hotelui.HotelBLService_Driver;
import presentation.promotionui.PromotionBLService_Driver;
import presentation.userui.UserBLService_Driver;

public class Client {
	public static void main(String[] args) {
		//user驱动测试
		System.out.println("* User Driver Test:");
		UserBLService userBLService = new UserBLService_Stub(0, null, null);
		UserBLService_Driver userDriver = new UserBLService_Driver();
		userDriver.drive(userBLService);
		System.out.println("* Test Completed");
		
		//hotel驱动测试
		System.out.println("* Hotel Driver Test:");
		HotelBLService hotelBLService = new HotelBLService_Stub(0, null, null, null, null, 0, 0, null, 0, null, null);
		HotelBLService_Driver hotelDriver = new HotelBLService_Driver();
		hotelDriver.drive(hotelBLService);
		System.out.println("* Test Completed");
		
		//credit驱动测试
		System.out.println("* Credit Driver Test:");
		CreditBLService creditBLService = new CreditController();
		CreditBLService_Driver creditDriver = new CreditBLService_Driver();
		creditDriver.drive(creditBLService);
		System.out.println("* Test Completed");
		
		//promotion驱动测试
		System.out.println("* Promotion Driver Test:");
		PromotionBLService promotionBLService = new PromotionController();
		PromotionBLService_Driver promotionDriver = new PromotionBLService_Driver();
		promotionDriver.drive(promotionBLService);
		System.out.println("* Test Completed");
	}
}
