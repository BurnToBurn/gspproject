package com.cygnus.gsp.api.domain.model;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.MappedSuperclass;
import javax.persistence.OneToOne;
import javax.validation.constraints.NotNull;


@MappedSuperclass
@Getter
@Setter
@ToString
@EqualsAndHashCode(exclude = {"dropped"})
@Accessors(chain = true)
@NoArgsConstructor
public abstract class Position {

    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "driverId")
    private Driver driver;
    @NotNull
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manufacturerId")
    private Manufacturer manufacturer;
    private boolean dropped;

    public Position(@NotNull Driver driver,@NotNull Manufacturer manufacturer) {
        this.driver = driver;
        this.manufacturer = manufacturer;
    }


}
