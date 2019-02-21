package ua.lviv.iot.houses.model;

public class Apartment extends House {
    private int flour;

    public Apartment(double area, int price, int rating, String adress, int numberOfRooms, String city) {
        super(area, price, rating, adress, numberOfRooms, city);
    }

    public int getFlour() {
        return flour;
    }

    public void setFlour(int flour) {
        this.flour = flour;
    }
}
