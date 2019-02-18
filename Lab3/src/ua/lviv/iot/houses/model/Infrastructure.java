package ua.lviv.iot.houses.model;

import java.awt.List;

public class Infrastructure extends House {
	private boolean parking;
	private List LocatedNear;

	public Infrastructure(double area, int price, int rating, String adress, int numberOfRooms, String city) {
		super(area, price, rating, adress, numberOfRooms, city);
	}

	public boolean isParking() {
		return parking;
	}

	public void setParking(boolean parking) {
		this.parking = parking;
	}

	public List getLocatedNear() {
		return LocatedNear;
	}

	public void setLocatedNear(List locatedNear) {
		LocatedNear = locatedNear;
	}
	
}
