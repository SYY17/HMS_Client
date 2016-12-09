package businesslogic.hotelbl;

import java.util.ArrayList;

public class Hotel {
	ArrayList<HotelList> hotel;

	/**
	 * 
	 * @param hotelList
	 */
	public void addHotelList(HotelList hotellist) {
		hotel.add(hotellist);
	}

	/**
	 * 
	 * @param id
	 */
	public void deleteHotelList(int id) {
		hotel.remove(id);
	}

	/**
	 * 
	 * @param hotelList
	 * @param id
	 */
	public void modifyHotelList(HotelList hotellist, int id) {
		hotel.set(id, hotellist);
	}

	/**
	 * 
	 * @param id
	 */
	public void findHotelList(int id) {
		hotel.get(id);
	}
}
