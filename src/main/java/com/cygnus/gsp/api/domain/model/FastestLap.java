package com.cygnus.gsp.api.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalTime;

@Getter
@Setter
@ToString
@Accessors(chain = true)
@NoArgsConstructor
@Entity
@Table(name = "fastest_lap")
public class FastestLap implements Position{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "fastest_lap_position_id")
    private Long positionId;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "driver_id")
    private Driver driver;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "manufacturer_id")
    private Manufacturer manufacturer;
    @NotNull
    @Column(nullable = false)
    private LocalTime time;
}
