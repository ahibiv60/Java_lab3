package ua.lviv.iot.houses.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import ua.lviv.iot.houses.exception.ResourceNotFoundException;
import ua.lviv.iot.houses.model.Mansion;

@RestController
public class HouseController {
    
    @Autowired
    HouseRepository repository;

    @RequestMapping("/save")
    public String process() {
        repository.save(new Mansion("Kiev", 3));
        repository.save(new Mansion("Lviv", 1));
        repository.save(new Mansion("Odessa", 2));
        return "Done";
    }

    @RequestMapping("/findall")
    public String findAll() {
        String result = "<html>";

        for (Mansion cust : repository.findAll()) {
            result += "<div>" + cust.getId() + " -> " + cust.getCity() + "</div>";
        }

        return result + "</html>";
    }
    
    @RequestMapping(path = "/save/{city}/{floors}", method = RequestMethod.GET)
    public String createMansion(@PathVariable String city, @PathVariable int floors) {
        repository.save(new Mansion(city, floors));
        return "Done";
    }

    @GetMapping("get/{id}")
    public String getNoteById(@PathVariable(value = "id") Long mansionId) {
        String result = "<html>";
        Mansion cust = repository.findById(mansionId)
                .orElseThrow(() -> new ResourceNotFoundException("Mansion", "id", mansionId));
        result += "<div>" + cust.getId() + " -> " + cust.getCity() + "</div>";

        return result + "</html>";
    }

    @RequestMapping(path = "/update/{id}/{city}/{floors}", method = RequestMethod.GET)
    public String updateNote(@PathVariable(value = "id") Long mansionId, @PathVariable String city,
            @PathVariable int floors) {

        Mansion mansion = repository.findById(mansionId)
                .orElseThrow(() -> new ResourceNotFoundException("Mansion", "id", mansionId));

        mansion.setCity(city);
        mansion.setFloors(floors);

        repository.save(mansion);
        return "Done";
    }

    @RequestMapping(path = "del/{id}", method = RequestMethod.GET)
    //@DeleteMapping("del/{id}")
    public ResponseEntity<?> deleteMansion(@PathVariable(value = "id") Long mansionId) {
        Mansion mansion = repository.findById(mansionId)
                .orElseThrow(() -> new ResourceNotFoundException("Mansion", "id", mansionId));

        repository.delete(mansion);
        return ResponseEntity.ok().build();
    }
    
}