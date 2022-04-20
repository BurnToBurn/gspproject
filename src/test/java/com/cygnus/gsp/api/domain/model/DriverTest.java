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
        driver.splitName(null);
        assertNull(driver.getFirstName());
        assertNull(driver.getLastName());
    }

    @Test
    void splitNamesEmpty(){

        driver.splitName("");
        assertNull(driver.getFirstName());
        assertNull(driver.getLastName());
    }

    @ParameterizedTest
    @CsvSource({
            "D. Hulme,D.,Hulme",
            "Bano,Bano,null",
            "Derick Rock,Derick,Rock",
            ". Hulme,'.',Hulme",
            "D. ,D.,null",
            "Could Be a Long Name,Could,Be"
    })
    void splitNamesValues(String request, @ConvertWith(NullableConverter.class) String first, @ConvertWith(NullableConverter.class) String last){

        driver.splitName(request);
        assertEquals(first,driver.getFirstName());
        assertEquals(last,driver.getLastName());
    }
}