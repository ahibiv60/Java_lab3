import java.util.Arrays;
import java.util.EnumSet;
import java.util.LinkedList;
import java.util.List;

import ua.lviv.iot.houses.manager.HouseManagerImpl;
import ua.lviv.iot.houses.model.Apartment;
import ua.lviv.iot.houses.model.House;
import ua.lviv.iot.houses.model.LocatedNear;
import ua.lviv.iot.houses.model.Mansion;
import ua.lviv.iot.houses.model.Penthouse;

public class Main {

	public static void main(String[] args) 
	{
		EnumSet<LocatedNear> Near = EnumSet.allOf( LocatedNear.class );
		
		Mansion Mansion = new Mansion(155, 11465432, 5, "Warsaw, 5", 6, "Lviv");
		Penthouse Penthouse = new Penthouse(136, 2383150, 4, "Charles Michelosh, 7", 4, "Kiev");
		Apartment Apartment = new Apartment(100, 530400, 3, "Solomyanska, 20A", 2, "Odessa");
		
		List<House> Houses = Arrays.asList
		(
			new House(155, 11465432, 5, "Warsaw, 5", 6, "Lviv"),
			new House(136, 2383150, 4, "Charles Michelosh, 7", 4, "Kiev"),
			new House(100, 530400, 3, "Solomyanska, 20A", 2, "Odessa")
        );
		
		LinkedList<House> list = new LinkedList<House>();
		
		list.add(Mansion);
		list.add(Penthouse);
		list.add(Apartment);
		
		HouseManagerImpl manager = new HouseManagerImpl();
		
		System.out.println("List elements (" + list.size() + "):");
		for (int i = 0; i < list.size(); i++) 
		{		
			if (list.get(i) instanceof House) 
			{
				System.out.println(list.get(i).getAdress());
			}
		}
		
		manager.sortByArea(list, true);

		System.out.println("\nSort by area - ascending:");
		for (int i = 0; i < list.size(); i++) 
		{
			if (list.get(i) instanceof House) 
			{
				System.out.println(list.get(i).getAdress() +" = " + list.get(i).getArea());
			}
		}
		
		manager.sortByArea(list, false);
		
		System.out.println("\nSort by area - descending:");
		for (int i = 0; i < list.size(); i++) 
		{
			if (list.get(i) instanceof House) 
			{
				System.out.println(list.get(i).getAdress() +" = "  + list.get(i).getArea());
			}
		}
		
		manager.sortByPrice(list, true);

		System.out.println("\nSort by price - ascending:");
		for (int i = 0; i < list.size(); i++) 
		{
			if (list.get(i) instanceof House) 
			{
				System.out.println(list.get(i).getAdress() +" = " + list.get(i).getPrice());
			}
		}
		
		manager.sortByPrice(list, false);
		
		System.out.println("\nSort by price - descending:");
		for (int i = 0; i < list.size(); i++) 
		{
			if (list.get(i) instanceof House) 
			{
				System.out.println(list.get(i).getAdress() +" = "  + list.get(i).getPrice());
			}
		}
		
		manager.findPropositionByCity(list, "Lviv");
		
		System.out.println("\nProposition in Lviv:");
		
		House result = Houses.stream()                        
                .filter(x -> "Lviv".equals(x.getCity()))       
                .findAny()                                      
                .orElse(null);                                 

        System.out.println("\n" + result);
        System.out.println( "Located Near : " + Near );
	}

}
