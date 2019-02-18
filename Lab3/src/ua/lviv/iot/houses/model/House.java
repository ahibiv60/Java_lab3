package ua.lviv.iot.houses.model;

public class House {
	private double area;
	private int price;
	private int rating;
	private String adress;
	private int numberOfRooms;
	private String city;
	private Heating heating;
	private AvailableHouse availableHouse;
	
	public House() {
	}

	public House(double area, int price, int rating, String adress, int numberOfRooms, String city) {
		this.area = area;
		this.price = price;
		this.rating = rating;
		this.adress = adress;
		this.numberOfRooms = numberOfRooms;
		this.city = city;
	}
	public String toString(){
		return String.format("Adress: %s\nPrice: %d\nRating: %d\nArea: %f\nNumber of Rooms: %d\nCity: %s\n", adress, price, rating, area, numberOfRooms, city);
	}

	public double getArea() {
		return area;
	}

	public void setArea(double area) {
		this.area = area;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public int getRating() {
		return rating;
	}

	public void setRating(int rating) {
		this.rating = rating;
	}

	public String getAdress() {
		return adress;
	}

	public void setAdress(String adress) {
		this.adress = adress;
	}

	public int getNumberOfRooms() {
		return numberOfRooms;
	}

	public void setNumberOfRooms(int numberOfRooms) {
		this.numberOfRooms = numberOfRooms;
	}

	public String getCity() {
		return city;
	}

	public void setCity(String city) {
		this.city = city;
	}

	public Heating getHeating() {
		return heating;
	}

	public void setHeating(Heating heating) {
		this.heating = heating;
	}

	public AvailableHouse getAvailableHouse() {
		return availableHouse;
	}

	public void setAvailableHouse(AvailableHouse availableHouse) {
		this.availableHouse = availableHouse;
	}
}
