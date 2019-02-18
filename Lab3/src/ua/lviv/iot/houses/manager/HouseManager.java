package ua.lviv.iot.houses.manager;

import java.util.List;

import ua.lviv.iot.houses.model.House;

public interface HouseManager<H>{
	List<House> sortByPrice(List<House> list, boolean sortOrder);
	List<House> sortByArea(List<House> list, boolean sortOrder);
	List<House> findPropositionByCity(List<House> list, String city);
}
