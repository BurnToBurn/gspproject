package com.ki.gsp.gspstats.web.controller;

import com.ki.gsp.gspstats.domain.model.Driver;
import com.ki.gsp.gspstats.exception.NotFoundException;
import com.ki.gsp.gspstats.persistance.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DriverController {

    private final DriverRepository driverRepository;

    @Autowired
    public DriverController(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    @GetMapping("/driver")
    List<Driver> getAllDrivers(){
        return driverRepository.findAll();
    }

    @PostMapping("/driver")
    Driver addDriver(@RequestBody Driver newDriver){
        return driverRepository.save(newDriver);
    }

    @GetMapping("/driver/{id}")
    Driver getDriver(@PathVariable Long id){
        return driverRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Could not find driver " + id));

    }

    @PutMapping("/driver/{id}")
    Driver replaceDriver(@RequestBody Driver newDriver, @PathVariable Long id){
        return driverRepository.findById(id)
                .map(driver -> {
                    driver.setDisplayName(newDriver.getDisplayName());
                    driver.setCountry(newDriver.getCountry());
                    driver.setFirstName(newDriver.getFirstName());
                    driver.setLastName(newDriver.getLastName());
                    return driverRepository.save(driver);
                }).orElseGet(() -> {
                    newDriver.setId(id);
                    return driverRepository.save(newDriver);
                });
    }

    @DeleteMapping("/driver/{id}")
    void deleteDriver(@PathVariable Long id){
        driverRepository.deleteById(id);
    }
}
