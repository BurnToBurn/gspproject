package com.cygnus.gsp.api.domain.prototype;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import java.math.BigDecimal;

@Getter
@Setter
@ToString
@Accessors(chain = true)
@NoArgsConstructor
public class ResultDetails {
    private Integer position;
    private BigDecimal points;
    private boolean drop;
    private BigDecimal fastestLap;
    private BigDecimal pole;
}
