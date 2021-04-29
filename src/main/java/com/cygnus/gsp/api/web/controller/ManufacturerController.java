package com.cygnus.gsp.api.web.controller;

import com.cygnus.gsp.api.domain.model.Manufacturer;
import com.cygnus.gsp.api.service.ManufacturerService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ManufacturerController {

    private final ManufacturerService manufacturerService;

    @Autowired
    public ManufacturerController(ManufacturerService manufacturerService) {
        this.manufacturerService = manufacturerService;
    }


    @GetMapping("/manufacturers")
    public List<Manufacturer> getAllManufacturers(){
        return manufacturerService.getAllManufacturers();
    }

    @GetMapping("/manufacturers/{id}")
    public Manufacturer getManufacturerById(@PathVariable("id") Long manufacturerId){
        return manufacturerService.getManufacturerById(manufacturerId);
    }

    @GetMapping("/manufacturers/{abv}")
    public Manufacturer getManufacturerByAbv(@PathVariable("abv") String manufacturerAbv){
        return manufacturerService.getManufacturerByAbv(manufacturerAbv);
    }

    @PostMapping("/manufacturers")
    public Manufacturer createManufacturer(@RequestBody Manufacturer manufacturer){
        return manufacturerService.createManufacturer(manufacturer);
    }

    @PutMapping("/manufacturers/{id}")
    public Manufacturer updateManufacturer(@RequestBody Manufacturer manufacturer, @PathVariable("id") Long manufacturerId){
        return manufacturerService.updateManufacturer(manufacturerId,manufacturer);
    }

    @DeleteMapping("/manufacturers/{id}")
    public void deleteManufacturer(@PathVariable("id") Long manufacturerId){
        manufacturerService.deleteManufacturerById(manufacturerId);
    }
}
