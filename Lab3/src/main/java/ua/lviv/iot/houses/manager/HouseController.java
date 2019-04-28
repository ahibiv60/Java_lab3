package ua.lviv.iot.houses.manager;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import ua.lviv.iot.houses.model.Mansion;

@RestController
public class HouseController {
    @Autowired
    HouseRepository repository;
    
    @RequestMapping("/save")
     public String process(){
        repository.save(new Mansion("Kiev", 3, true));
        repository.save(new Mansion("Lviv", 1, false));
        repository.save(new Mansion("Odessa", 2, true));
        return "Done";
    }
    
    @RequestMapping("/findall")
    public String findAll(){
        String result = "<html>";
          
        for(Mansion cust : repository.findAll()){
            result += "<div>" + cust.getId()+" -> "+ cust.getCity() + "</div>";
        }
          
        return result + "</html>";
    }
       
}
