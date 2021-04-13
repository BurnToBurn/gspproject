package com.cygnus.gsp.api.service;

import com.cygnus.gsp.api.domain.model.Driver;
import com.cygnus.gsp.api.exception.NotFoundException;
import com.cygnus.gsp.api.persistance.repository.DriverRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;

@Service
public class DriverService {

    private final DriverRepository driverRepository;

    @Autowired
    public DriverService(DriverRepository driverRepository) {
        this.driverRepository = driverRepository;
    }

    public List<Driver> getAllDrivers(){
        return driverRepository.findAll();
    }

    public Driver getDriverById(@NotNull Long driverId){
        return driverRepository.findById(driverId)
                .orElseThrow(() -> new NotFoundException("No matching driver was found"));
    }

    public Driver getDriverByName(@NotNull String driverName){
        return driverRepository.findByName(driverName)
                .orElseThrow(() -> new NotFoundException("No matching driver was found"));
    }

    public Driver createDriver(@NotNull Driver driver){
        return driverRepository.save(driver);
    }

    public Driver updateDriverById(@NotNull Long driverId,@NotNull Driver driver){

        return driverRepository.findById(driverId)
                .map(newDriver -> {
                    newDriver.setCountry(driver.getCountry());
                    newDriver.setFirstName(driver.getFirstName());
                    newDriver.setLastName(driver.getLastName());
                    newDriver.setName(driver.getName());
                    return driverRepository.save(newDriver);
                }).orElseThrow(() -> new NotFoundException("No matching driver was found"));

    }

    public void deleteDriverById(Long driverId){
        driverRepository.findById(driverId).orElseThrow(() -> new NotFoundException("No matching driver was found"));
        driverRepository.deleteById(driverId);
    }
}
