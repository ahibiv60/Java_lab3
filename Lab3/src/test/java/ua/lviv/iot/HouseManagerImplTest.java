package ua.lviv.iot;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import ua.lviv.iot.houses.manager.HouseManager;
import ua.lviv.iot.houses.manager.HouseManagerImpl;
import ua.lviv.iot.houses.model.Apartment;
import ua.lviv.iot.houses.model.AvailableHouse;
import ua.lviv.iot.houses.model.House;
import ua.lviv.iot.houses.model.LocatedNear;
import ua.lviv.iot.houses.model.Mansion;
import ua.lviv.iot.houses.model.Penthouse;
import ua.lviv.iot.houses.model.SortOrder;

@DisplayName("Junit case")
class HouseManagerImplTest {

        static HouseManager<House> manager;
        LinkedList<House> list;
        
        List<House> houses = Arrays.asList(new House(155, 11465432, 5, "Warsaw, 5", 6, "Lviv"),
                new House(136, 2383150, 4, "Charles Michelosh, 7", 4, "Kiev"),
                new House(100, 530400, 3, "Solomyanska, 20A", 2, "Odessa"));

        @BeforeAll
        public static void setUp() {
            manager = new HouseManagerImpl();
            manager.addHouse(new Mansion(155, 11465432, 5, "Warsaw, 5", 6, "Lviv"));
            manager.addHouse(new Penthouse(136, 2383150, 4, "Charles Michelosh, 7", 4, "Kiev"));
            manager.addHouse(new Apartment(100, 530400, 3, "Solomyanska, 20A", 2, "Odessa"));
        }

        @Test
        @DisplayName("Sort houses by area test in ascending")
        void testSortByAreaByAscendingInEachHouse() {
            System.out.println("\nAscending-Sort by area:");
            manager.sortByArea(manager.getList(),SortOrder.ASCENDING);
            if(manager.getList().get(0).getArea()<manager.getList().get(1).getArea()) {
                System.out.println("Sort is ascending!");
            }
            manager.printListOfHouses("area");
        }
        
        @Test
        @DisplayName("Sort houses by area test in descending")
        void testSortByAreaByDescendingInEachHouse() {
            System.out.println("\nDescending-Sort by area:");
            manager.sortByArea(manager.getList(),SortOrder.DESCENDING);
            if(manager.getList().get(0).getArea()>manager.getList().get(1).getArea()) {
                System.out.println("Sort is descending!");
            }
            manager.printListOfHouses("area");
        }
        
        @Test
        @DisplayName("Sort houses by price test in ascending")
        void testSortByPriceByAscendingInEachHouse() {
            System.out.println("\nAscending-Sort by price:");
            manager.sortByPrice(manager.getList(),SortOrder.ASCENDING);
            if(manager.getList().get(0).getPrice()<manager.getList().get(1).getPrice()) {
                System.out.println("Sort is ascending!");
            }
            manager.printListOfHouses("price");
        }
        
        @Test
        @DisplayName("Sort houses by price test in descending")
        void testSortByPriceByDescendingInEachHouse() {
            System.out.println("\nDescending-Sort by price:");
            manager.sortByPrice(manager.getList(),SortOrder.DESCENDING);
            if(manager.getList().get(0).getPrice()>manager.getList().get(1).getPrice()) {
                System.out.println("Sort is descending!");
            }
            manager.printListOfHouses("price");
        }
        
        @Test
        @DisplayName("Test PrintListOfHouses with null input parameter")
        void testPrintWithNullInputParameter() {
            manager.printListOfHouses(null);
        }
        
        @Test
        @DisplayName("Check exist enum LocatedNear")
        void testGetEnumLocatedNear() {
            System.out.println("\n~LocatedNear~");
            System.out.println((LocatedNear.SCHOOL).equals(LocatedNear.PARK));
        }
        
        @Test
        @DisplayName("Check exist enum AvailableHouse")
        void testGetEnumAvailableHouse() {
            System.out.println("\n~AvailableHouse~");
            System.out.println((AvailableHouse.ONE_ROOM_APPARTMENT).equals(AvailableHouse.FIVE_ROOM_MANSION));
        }
        
        @Test
        @DisplayName("Test PrintListOfHouses with null input parameter")
        void testfindPropositionByCity() {
            manager.findPropositionByCity(manager.getList(), "Lviv");
        }
        
        @Test
        @DisplayName("Test Set New List Of House")
        void testSetNewListOfHouses() {
            System.out.println("\n~Set New List Of Houses~");
            manager = new HouseManagerImpl();
            list = new LinkedList<House>();
            list.add(new Mansion(155, 11465432, 5, "Warsaw, 5", 6, "Lviv"));
            list.add(new Penthouse(136, 2383150, 4, "Charles Michelosh, 7", 4, "Kiev"));
            list.add(new Apartment(100, 530400, 3, "Solomyanska, 20A", 2, "Odessa"));
            manager.setNewListOfHouses(list);
            manager.printListOfHouses("area");
        }
        
        @AfterAll
        @DisplayName("Sort empty houses by area test in ascending")
        static void testSortEmptyListByAreaInEachHouse() {
            System.out.println("\nEmpty EmptyListByMaxSpeed");
            manager.clearHouseList();
            manager.sortByArea(manager.getList(),SortOrder.ASCENDING);
            manager.printListOfHouses("area");
            manager.sortByArea(manager.getList(),SortOrder.DESCENDING);
            manager.printListOfHouses("area");
        }

        @AfterAll
        @DisplayName("Sort empty houses by price test in descending")
        static void testSortEmptyListByPriceInEachHouse() {
            System.out.println("\nEmpty EmptyListByMaxDistance");
            manager.clearHouseList();
            manager.sortByPrice(manager.getList(),SortOrder.ASCENDING);
            manager.printListOfHouses("price");
            manager.sortByPrice(manager.getList(),SortOrder.DESCENDING);
            manager.printListOfHouses("price");
        }
        
}
