package businesslogic.hotelbl;

import java.util.ArrayList;

public class HotelList {

	ArrayList<HotelLineItem> list;

	public void setHotelList(ArrayList<HotelLineItem> list) {
		this.list = list;
	}

	public ArrayList<HotelLineItem> getHotelList() {
		return list;
	}

	public void addHotelList(HotelLineItem hotelLineItem) {
		list.add(hotelLineItem);
	}

	public void deleteHotelList(int id) {
		list.remove(id);
	}

	public void modifyHotelList(HotelLineItem hotelLineItem, int id) {
		list.set(id, hotelLineItem);
	}

	public void find(int id) {
		list.get(id);
	}
}
