package com.cygnus.gsp.api.domain.prototype;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.HashMap;
@Getter
@Setter
@ToString
public class SeasonIdTotals {

    private Long id;
    private HashMap<Integer,Integer> positionTotals;
    private Integer poleTotal;
    private Integer fastestLapTotal;


}
