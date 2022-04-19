package com.cygnus.gsp.api.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.HashMap;
import java.util.Map;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@Entity
@Table(name="point_system")
public class PointSystem {

    public enum GroupCalculation{
        TOP,ALL
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "point_system_id")
    private Long pointSystemId;
    @NotNull
    @Column(unique = true)
    private String pointSystemName;
    @NotNull
    @OneToOne(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "drop_system_Id",nullable = false)
    private DropSystem dropSystem;
    @NotNull
    @ElementCollection
    private Map<Integer,BigDecimal> positionPointMap;
    @NotNull
    @Min(0)
    @Column(nullable = false)
    private BigDecimal fastestLapPoint = BigDecimal.ZERO;
    @NotNull
    @Min(0)
    @Column(nullable = false)
    private BigDecimal polePoint = BigDecimal.ZERO;
    @NotNull
    @Column(nullable = false)
    private GroupCalculation manufacturerCalculation = GroupCalculation.TOP;
    @NotNull
    @Min(1)
    @Column(nullable = false)
    private Integer manufacturerCount = 1;

    //TODO will need a point system builder


    public Map<Integer, BigDecimal> getPositionPointMap() {
        if(positionPointMap == null){
            this.positionPointMap = new HashMap<>();
        }
        return positionPointMap;
    }

    public BigDecimal getPointPosition(Integer rank){
        return this.positionPointMap.entrySet().stream()
                .filter(key -> key.getKey().equals(rank))
                .map(Map.Entry::getValue)
                .findFirst().orElse(BigDecimal.ZERO);
    }
}
