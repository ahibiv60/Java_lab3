package ua.lviv.iot.houses.manager;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import ua.lviv.iot.houses.model.Mansion;

@Repository
public interface HouseRepository extends CrudRepository<Mansion, Long> {

}