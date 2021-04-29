package com.cygnus.gsp.api.domain.model;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;

import static org.junit.jupiter.api.Assertions.*;

class DropSystemTest {

    private DropSystem dropSystem;


    @BeforeEach
    void setUp() {
        this.dropSystem = new DropSystem();
    }

    @ParameterizedTest
    @CsvSource({
            ", 0",
            "-1, 0",
            "0, 0",
            "1, 1"
    })
    void setCountTest(Integer value,Integer valid){
        dropSystem.setDropCount(value);
        assertEquals(dropSystem.getDropCount(),valid);
    }
}