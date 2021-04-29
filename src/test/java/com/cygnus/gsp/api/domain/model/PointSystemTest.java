package com.cygnus.gsp.api.domain.model;

import com.cygnus.gsp.converter.NullableConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;

import java.util.*;


import static org.junit.jupiter.api.Assertions.*;

class PointSystemTest {

    private PointSystem pointSystem;

    @BeforeEach
    void setUp(){

        this.pointSystem = new PointSystem(
                "1955",
                Arrays.asList(new BigDecimal(8), new BigDecimal(6), new BigDecimal(4), new BigDecimal(3), new BigDecimal(2)),
                new BigDecimal(0),
                new BigDecimal(0),
                PointSystem.GroupCalculation.NONE,
                0,
                new DropSystem(DropSystem.Method.NONE, DropSystem.Order.D,0));
    }

    @ParameterizedTest
    @CsvSource({
            "1, 8",
            "2, 6",
            "3, 4",
            "4, 3",
            "5, 2",
            "0, 0",
            "10, 0",
            "null, 0"
    })
    void setPointPositionTest(@ConvertWith(NullableConverter.class) Integer value, BigDecimal valid){

        assertEquals(valid,pointSystem.getPositionPoint(value));
    }
}