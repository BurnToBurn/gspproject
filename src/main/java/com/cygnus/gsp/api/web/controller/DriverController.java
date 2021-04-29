package com.cygnus.gsp.api.web.controller;

import com.cygnus.gsp.api.domain.model.Driver;
import com.cygnus.gsp.api.service.DriverService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class DriverController {

    private final DriverService driverService;

    @Autowired
    public DriverController(DriverService driverService) {
        this.driverService = driverService;
    }

    @GetMapping("/drivers")
    public List<Driver> getAllDrivers(){
        return driverService.getAllDrivers();
    }

    @GetMapping("/drivers/{id}")
    public Driver getDriverById(@PathVariable("id") Long driverId){
        return driverService.getDriverById(driverId);

    }

    @GetMapping("/drivers/{name}")
    public Driver getDriverByName(@PathVariable("name") String driverName){
        return driverService.getDriverByName(driverName);
    }

    @PostMapping("/drivers")
    public Driver createDriver(@RequestBody Driver driver){
        return driverService.createDriver(driver);
    }

    @PutMapping("/drivers/{id}")
    public Driver updateDriver(@RequestBody Driver payload, @PathVariable("id") Long driverId){
        return driverService.updateDriverById(driverId,payload);
    }

    @DeleteMapping("/drivers/{id}")
    public void deleteDriver(@PathVariable("id") Long driverId){
        driverService.deleteDriverById(driverId);
    }
}
