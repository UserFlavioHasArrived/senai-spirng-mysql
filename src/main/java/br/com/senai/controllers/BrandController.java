package br.com.senai.controllers;

import br.com.senai.models.Brand;
import br.com.senai.repositories.BrandRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/brand")
public class BrandController {
    @Autowired
    BrandRepository brandRepository;
    @GetMapping(value = "/all", produces = MediaType.APPLICATION_JSON_VALUE)

    public List<Brand>getAllBrand(){

        return brandRepository.findAll();
    }
    @PostMapping (value = "/createBrand",
            produces = MediaType.APPLICATION_JSON_VALUE,
            consumes = MediaType.APPLICATION_JSON_VALUE)
    public Brand createBrand(@RequestBody Brand brand){
        Brand newBrand = new Brand();
        newBrand.setName(brand.getName());
        newBrand.setDescription(brand.getDescription());
        return brandRepository.save(newBrand);
    }


}
