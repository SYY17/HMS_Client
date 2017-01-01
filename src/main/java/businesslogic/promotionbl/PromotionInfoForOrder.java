package businesslogic.promotionbl;

import java.sql.Timestamp;
import java.util.ArrayList;

import businesslogic.hotelbl.HotelController;
import businesslogic.orderbl.PromotionInfo;

public class PromotionInfoForOrder implements PromotionInfo {

	public static ArrayList<String> available;
	
	/**
	 * 
	 * @param roomtype,
	 *            roomNumber, hotelName
	 * @return 获得最终订单价格
	 */
	@Override
	public int getFinalPrice(int userId, int roomNum, String hotelName, Timestamp setTime, int initialPrice) {
		// TODO Auto-generated method stub
		HotelController hc = new HotelController();
		int hotelId = hc.reviewHotelInfo(hotelName).getHotelID();
		PromotionController pc = new PromotionController();

		double finalPrice = pc.searchPromotionPresent(userId, roomNum, hotelId, setTime, initialPrice);

		return (int) finalPrice;
	}

	public static void addString(String s){
		if(available == null){
			available = new ArrayList<String>();
		}
		available.add(s);
	}
	
	public void show(){
		for(int i=0;i<available.size();i++){
			System.out.println(available.get(i));
		}
	}
	
	public void delete(){
		for(int i=0;i<available.size();i++){
			if(available.get(i).contains("9999999")){
				available.remove(available.get(i));
				i--;
			}
		}
	}
	
	/**
	 * 直接调用这个方法就可以了
	 */
	public void output(){
		delete();
		show();
	}
	
	public static void main(String[]args){
		PromotionInfoForOrder a = new PromotionInfoForOrder();
		int ww = a.getFinalPrice(11225001, 9, "盘丝洞",Timestamp.valueOf("2016-12-02 00:00:00"), 1000);
		System.out.println(ww);
		a.output();
	}
}
