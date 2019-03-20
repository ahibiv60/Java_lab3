package ua.lviv.iot.houses.manager;

import java.util.LinkedList;
import java.util.List;

import ua.lviv.iot.houses.model.House;
import ua.lviv.iot.houses.model.SortOrder;

public interface HouseManager<H> {
    
    List<House> getList();
    
    List<House> sortByPrice(List<House> list, SortOrder order);

    List<House> sortByArea(List<House> list, SortOrder order);

    List<House> findPropositionByCity(List<House> list, String city);

    void addHouse(House house);

    void clearHouseList();

    void printListOfHouses(String sortedBy);

    void setNewListOfHouses(LinkedList<House> list);
}
