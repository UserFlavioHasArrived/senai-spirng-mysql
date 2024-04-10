package br.com.senai.controllers;

import br.com.senai.models.Coffee;
import br.com.senai.repositories.CoffeeRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/coffee")
public class CoffeeController {
    @Autowired
    CoffeeRepository coffeeRepository;
    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)

    public List<Coffee>getAllCoffee(){

        return coffeeRepository.findAll();
    }
    @PostMapping (value = "/createCoffee",
                        produces = MediaType.APPLICATION_JSON_VALUE,
                        consumes = MediaType.APPLICATION_JSON_VALUE)
    public Coffee createCoffee(@RequestBody Coffee coffee ){
        Coffee newCoffee = new Coffee();
        newCoffee.setName(coffee.getName());
        newCoffee.setPrice(coffee.getPrice());
        return coffeeRepository.save(newCoffee);
        }

    @PutMapping(value = "/updateCoffee",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Coffee updateCoffee(@RequestBody Coffee coffee ){
        Coffee getCoffee = coffeeRepository.findById(coffee.getId()).orElseThrow();
        Coffee updateCoffee = new Coffee();
        updateCoffee.setId(coffee.getId());
        updateCoffee.setName(coffee.getName());
        updateCoffee.setPrice(coffee.getPrice());
        return coffeeRepository.save(updateCoffee);

}
@DeleteMapping(value ="/deleteCoffee/{id}",
        produces = MediaType.APPLICATION_JSON_VALUE)
 public Coffee deleteCoffee(@PathVariable Long id){
    Coffee getCoffee = coffeeRepository.findById(id).orElseThrow();
    coffeeRepository.delete(getCoffee);
    return getCoffee;
    }
}
