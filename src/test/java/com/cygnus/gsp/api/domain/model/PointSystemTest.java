package com.cygnus.gsp.api.domain.model;

import com.cygnus.gsp.converter.NullableConverter;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.converter.ConvertWith;
import org.junit.jupiter.params.provider.CsvSource;

import java.math.BigDecimal;
import java.util.HashMap;

import static org.junit.jupiter.api.Assertions.assertEquals;

class PointSystemTest {

    private PointSystem pointSystem;

    @BeforeEach
    void setUp(){

        HashMap<Integer,BigDecimal> points = new HashMap<>();
        points.put(1,new BigDecimal(8));
        points.put(2,new BigDecimal(6));
        points.put(3,new BigDecimal(4));
        points.put(4,new BigDecimal(3));
        points.put(5,new BigDecimal(2));

        this.pointSystem = new PointSystem()
                .setPointSystemName("1955")
                .setPositionPointMap(points)
                .setDropSystem(new DropSystem(DropSystem.Method.FULL, DropSystem.Order.DROP,0))
                .setPolePoint(BigDecimal.ZERO)
                .setFastestLapPoint(BigDecimal.ZERO)
                .setManufacturerCalculation(PointSystem.GroupCalculation.ALL)
                .setManufacturerCount(0);
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

        assertEquals(valid,pointSystem.getPointPosition(value));
    }
}