package ua.lviv.iot.houses.manager;

import java.util.Arrays;
import java.util.EnumSet;
import java.util.LinkedList;
import java.util.List;

import ua.lviv.iot.houses.model.Apartment;
import ua.lviv.iot.houses.model.House;
import ua.lviv.iot.houses.model.LocatedNear;
import ua.lviv.iot.houses.model.Mansion;
import ua.lviv.iot.houses.model.Penthouse;

public class Main {

    public static void main(String[] args) {
        EnumSet<LocatedNear> near = EnumSet.allOf(LocatedNear.class);
        LinkedList<House> list = new LinkedList<House>();
        HouseManagerImpl manager = new HouseManagerImpl();

        Mansion mansion = new Mansion(155, 11465432, 5, "Warsaw, 5", 6, "Lviv");
        Penthouse penthouse = new Penthouse(136, 2383150, 4, "Charles Michelosh, 7", 4, "Kiev");
        Apartment apartment = new Apartment(100, 530400, 3, "Solomyanska, 20A", 2, "Odessa");

        List<House> houses = Arrays.asList(new House(155, 11465432, 5, "Warsaw, 5", 6, "Lviv"),
                new House(136, 2383150, 4, "Charles Michelosh, 7", 4, "Kiev"),
                new House(100, 530400, 3, "Solomyanska, 20A", 2, "Odessa"));

        list.add(mansion);
        list.add(penthouse);
        list.add(apartment);

        System.out.println("Homes list (" + list.size() + "):");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getAdress());
        }

        manager.sortByArea(list, true);

        System.out.println("\n[Ascending]Sort by area:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getAdress() + " = " + list.get(i).getArea());
        }

        manager.sortByArea(list, false);

        System.out.println("\n[Descending]Sort by area:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getAdress() + " = " + list.get(i).getArea());
        }

        manager.sortByPrice(list, true);

        System.out.println("\n[Ascending]Sort by price:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getAdress() + " = " + list.get(i).getPrice());
        }

        manager.sortByPrice(list, false);

        System.out.println("\n[Descending]Sort by price:");
        for (int i = 0; i < list.size(); i++) {
            System.out.println(list.get(i).getAdress() + " = " + list.get(i).getPrice());
        }

        manager.findPropositionByCity(list, "Lviv");

        System.out.println("\nProposition in Lviv:");

        House result = houses.stream().filter(x -> "Lviv".equals(x.getCity())).findAny().orElse(null);

        System.out.println("\n" + result);
        System.out.println("Located Near : " + near);
    }

}
