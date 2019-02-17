package ua.lviv.iot.houses.manager;

import java.util.Comparator;
import java.util.List;

import ua.lviv.iot.houses.model.House;

public class HouseManagerImpl implements HouseManager<Object>
{

	@Override
	public List<House> sortByArea(List<House> list, boolean sortOrder) 
	{
		if(sortOrder == true)
		{
			// ascending
			list.sort(Comparator.comparing(House::getArea));
		}
		if(sortOrder == false)
		{
			// descending
			list.sort(Comparator.comparing(House::getArea).reversed());
		}
		return list;
	}
	
	@Override
	public List<House> sortByPrice(List<House> list, boolean sortOrder) 
	{
		if(sortOrder == true)
		{
			// ascending
			list.sort(Comparator.comparing(House::getPrice));
		}
		if(sortOrder == false)
		{
			// descending
			list.sort(Comparator.comparing(House::getPrice).reversed());
		}
		return list;
	}

	@Override
	public List<House> findPropositionByCity(List<House> list, String city) {
		return list;
	}
}
