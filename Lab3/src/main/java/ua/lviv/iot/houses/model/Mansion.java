package ua.lviv.iot.houses.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity()
@Table(name = "mansion")
public class Mansion extends House {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long id;
    @Column(name = "city")
    private String city;

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    //private boolean waterSupply;
    @Column(name = "floors")
    private int floors;

    public Mansion() {
        super();
    }

    public Mansion(String city, int floors) {
        this.city = city;
        this.floors = floors;
    }

    public Mansion(double area, int price, int rating, String adress, int numberOfRooms, String city) {
        super(area, price, rating, adress, numberOfRooms, city);
    }

    /*public boolean isWaterSupply() {
        return waterSupply;
    }

    public void setWaterSupply(boolean waterSupply) {
        this.waterSupply = waterSupply;
    }*/

    public int getFloors() {
        return floors;
    }

    public void setFloors(int floors) {
        this.floors = floors;
    }
}
