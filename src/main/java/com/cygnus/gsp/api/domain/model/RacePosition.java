package com.cygnus.gsp.api.domain.model;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.Objects;

@Getter
@Setter
@ToString
@EqualsAndHashCode(exclude = {"racePositionId"},callSuper = true)
@Accessors(chain = true)
@NoArgsConstructor
@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class RacePosition extends Position{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long racePositionId;
    @Min(1)
    @NotNull
    @Column(name = "position",nullable = false)
    private Integer positionNbr;

    public RacePosition(@NotNull Driver driver,@NotNull Manufacturer manufacturer,@NotNull Integer positionNbr) {
        super(driver, manufacturer);
        this.positionNbr = positionNbr;
    }

    public void setPositionNbr(@NotNull Integer positionNbr) {
        if(positionNbr == null || positionNbr < 1){
            positionNbr = 1;
        }
        this.positionNbr = positionNbr;
    }
}
