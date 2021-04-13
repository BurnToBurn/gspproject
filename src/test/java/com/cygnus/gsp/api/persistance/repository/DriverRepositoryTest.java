package com.cygnus.gsp.api.persistance.repository;

import com.cygnus.gsp.api.domain.model.Driver;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.Random;

@SpringBootTest
class DriverRepositoryTest {

    @Autowired
    private DriverRepository driverRepository;

    @Test
    public void findByName(){
        Driver driver = new Driver("D. Kise");
        driver.setId(new Random().nextLong());
        driver.setLastName("Kise");
        driver.setFirstName("Derick");
        driver.setCountry("USA");
        driverRepository.save(driver);
        System.out.println(driverRepository.findByName("D. Kise"));
        System.out.println(driverRepository.findAll());
    }
}