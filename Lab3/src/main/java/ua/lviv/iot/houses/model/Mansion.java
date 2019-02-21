package ua.lviv.iot.houses.model;

public class Mansion extends House {
    private boolean waterSupply;
    private int floors;

    public Mansion(double area, int price, int rating, String adress, int numberOfRooms, String city) {
        super(area, price, rating, adress, numberOfRooms, city);
    }

    public boolean isWaterSupply() {
        return waterSupply;
    }

    public void setWaterSupply(boolean waterSupply) {
        this.waterSupply = waterSupply;
    }

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }
}
