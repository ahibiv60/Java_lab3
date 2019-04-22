package ua.lviv.iot.houses.model;

public class Penthouse extends House {
    private boolean terrace;

    public Penthouse(double area, int price, int rating, String adress, int numberOfRooms, String city) {
        super(area, price, rating, adress, numberOfRooms, city);
    }

    public boolean isTerrace() {
        return terrace;
    }

    public void setTerrace(boolean terrace) {
        this.terrace = terrace;
    }
}
