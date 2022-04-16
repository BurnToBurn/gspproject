package com.cygnus.gsp.api.domain.model;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

@Getter
@Setter
@ToString
@EqualsAndHashCode(exclude = {"pointSystemId","dropSystem","positionPoints","fastLapPoint","polePoint","manufacturerCalculation","manufacturerCount"})
@Accessors(chain = true)
@NoArgsConstructor
@Entity
@Table(name="point_system")
public class PointSystem {

    public enum GroupCalculation{
        NONE,TOP,ALL
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long pointSystemId;
    @NotNull
    @Column(unique = true)
    private String name;
    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "drop_system_Id",nullable = false)
    private DropSystem dropSystem;
    @NotNull
    @ElementCollection
    private List<BigDecimal> positionPoints;
    @NotNull
    @Min(0)
    @Column(nullable = false)
    private BigDecimal fastLapPoint;
    @NotNull
    @Min(0)
    @Column(nullable = false)
    private BigDecimal polePoint;
    @NotNull
    @Column(nullable = false)
    private GroupCalculation manufacturerCalculation;
    @NotNull
    @Column(nullable = false)
    private Integer manufacturerCount;

    //TODO will need a point system builder
    public PointSystem(String name, List<BigDecimal> positionPoints, BigDecimal fastLapPoint, BigDecimal polePoint,GroupCalculation manufacturerCalculation,Integer manufacturerCount,DropSystem dropSystem) {
        this.name = name;
        this.positionPoints = positionPoints;
        this.fastLapPoint = fastLapPoint;
        this.polePoint = polePoint;
        this.manufacturerCalculation = manufacturerCalculation;
        this.manufacturerCount = manufacturerCount;
        this.dropSystem = dropSystem;
    }

    public List<BigDecimal> getPositionPoints() {
        if(positionPoints == null){
            this.positionPoints = new ArrayList<>();
        }
        return positionPoints;
    }

    public BigDecimal getPositionPoint(@NotNull @Min(1) Integer positionNbr){

        if(positionNbr != null) {
            return IntStream
                    .range(0, getPositionPoints().size())
                    .filter(i -> i == positionNbr - 1)
                    .mapToObj(item -> getPositionPoints().get(item))
                    .findFirst()
                    .orElse(new BigDecimal(0));
        } else{
            return new BigDecimal(0);
        }
    }
}
