package ua.lviv.iot.houses.manager;

import org.springframework.data.repository.CrudRepository;

import ua.lviv.iot.houses.model.Mansion;

public interface HouseRepository extends CrudRepository<Mansion, Integer> {

}