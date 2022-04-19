package com.cygnus.gsp.api.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@Accessors(chain = true)
@NoArgsConstructor
@Entity
@Table(name = "finished_position")
public class FinishedPosition implements Position {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "finished_position_id")
    private Long positionId;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "driver_id")
    private Driver driver;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "manufacturer_id")
    private Manufacturer manufacturer;
    @Min(1)
    @NotNull
    @Column(nullable = false)
    private Integer rank;
    @Min(1)
    private String detail;
    @NotNull
    private boolean classified = true;
    @Transient
    private boolean dropped = false;
}
