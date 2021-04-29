package com.cygnus.gsp.api.domain.model;

import com.cygnus.gsp.converter.NullableConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class DriverTest {

    private Driver driver;

    @BeforeEach
    void setUp() {
        this.driver = new Driver();
    }

    @Test
    void splitNamesNull(){
        assertThrows(IllegalArgumentException.class, () -> {
            driver.splitName(null);
        });

    }

    @Test
    void splitNamesEmpty(){
        assertThrows(IllegalArgumentException.class, () -> {
            driver.splitName("");
        });

    }

    @ParameterizedTest
    @CsvSource({
            "D. Hulme, D,Hulme",
            "Bano,Bano,null",
            "Derick Rock, Derick,Rock",
            ". Hulme,'',Hulme",
            "D. , D,''",
            "Could Be a Long Name,Could,Be a Long Name"
    })
    void splitNamesValues(String request, @ConvertWith(NullableConverter.class) String first, @ConvertWith(NullableConverter.class) String last){

        driver.splitName(request);
        assertEquals(driver.getFirstName(),first);
        assertEquals(driver.getLastName(),last);
    }
}