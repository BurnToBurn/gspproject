package com.cygnus.gsp.api.domain.model;

import javax.persistence.FetchType;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
import java.util.Objects;

public abstract class Position {

    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "driverId")
    private Driver driver;
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "manufacturerId")
    private Manufacturer manufacturer;
    private boolean dropped;

    public Position() {
        super();
    }

    public Position(Driver driver, Manufacturer manufacturer) {
        this.driver = driver;
        this.manufacturer = manufacturer;
    }

    @Override
    public String toString() {
        return "Position{" +
                "driver=" + driver +
                ", manufacturer=" + manufacturer +
                ", dropped=" + dropped +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position = (Position) o;
        return Objects.equals(driver, position.driver) &&
                Objects.equals(manufacturer, position.manufacturer);
    }

    @Override
    public int hashCode() {
        return Objects.hash(driver, manufacturer);
    }

    public Driver getDriver() {
        return driver;
    }

    public void setDriver(Driver driver) {
        this.driver = driver;
    }

    public Manufacturer getManufacturer() {
        return manufacturer;
    }

    public void setManufacturer(Manufacturer manufacturer) {
        this.manufacturer = manufacturer;
    }

    public boolean isDropped() {
        return dropped;
    }

    public void setDropped(boolean dropped) {
        this.dropped = dropped;
    }
}
