package ua.lviv.iot.houses.manager;

import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.LinkedList;
import java.util.List;
import java.util.stream.Collectors;

import ua.lviv.iot.houses.model.House;
import ua.lviv.iot.houses.model.SortOrder;

public class HouseManagerImpl implements HouseManager<House> {

    private LinkedList<House> list = new LinkedList<House>();

    List<House> houses = Arrays.asList(new House(155, 11465432, 5, "Warsaw, 5", 6, "Lviv"),
            new House(136, 2383150, 4, "Charles Michelosh, 7", 4, "Kiev"),
            new House(100, 530400, 3, "Solomyanska, 20A", 2, "Odessa"));

    @Override
    public List<House> sortByArea(List<House> list, SortOrder order) {
        if (order == SortOrder.ASCENDING) {
            list.sort(Comparator.comparing(House::getArea));
        } else {
            Collections.sort(list, Comparator.comparing(House::getArea).reversed());
        }

        return list;
    }

    @Override
    public List<House> sortByPrice(List<House> list, SortOrder order) {
        if (order == SortOrder.ASCENDING) {
            list.sort(Comparator.comparing(House::getPrice));
        } else {
            Collections.sort(list, Comparator.comparing(House::getPrice).reversed());
        }
        return list;
    }

    @Override
    public List<House> findPropositionByCity(List<House> list, final String city) {
        return houses.stream().filter(x -> city.equals(x.getCity())).collect(Collectors.toList());
    }

    @Override
    public void clearHouseList() {
        list.clear();
    }

    @Override
    public void printListOfHouses(String sortedBy) {
        if (sortedBy == "area") {
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i).getAdress() + " = " + list.get(i).getArea());

            }
        } else if (sortedBy == "price") {
            for (int i = 0; i < list.size(); i++) {
                System.out.println(list.get(i).getAdress() + " = " + list.get(i).getPrice());

            }
        } else {
            System.out.println("\nInput Parameter mast be \"area\" or \"price\" (printListOfHouses)");
        }
    }

    public void setNewListOfHouses(LinkedList<House> newList) {
        setList(newList);
    }

    public void setList(LinkedList<House> list) {
        this.list = list;
    }

    public LinkedList<House> getList() {
        return list;
    }

    @Override
    public void addHouse(House house) {
        System.out.println("You added \"" + house.getAdress() + "\" to list of Houses");
        list.add(house);
    }

}
