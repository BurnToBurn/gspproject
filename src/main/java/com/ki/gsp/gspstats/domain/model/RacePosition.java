package com.ki.gsp.gspstats.domain.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class RacePosition extends Position{

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private Integer positionNbr;

    public RacePosition() {
        super();
    }

    public RacePosition(Driver driver, Manufacturer manufacturer, Integer positionNbr) {
        super(driver, manufacturer);
        this.positionNbr = positionNbr;
    }

    @Override
    public String toString() {
        return "RacePosition{" +
                "id=" + id +
                ", positionNbr=" + positionNbr +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        RacePosition that = (RacePosition) o;
        return Objects.equals(positionNbr, that.positionNbr);
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), positionNbr);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Integer getPositionNbr() {
        return positionNbr;
    }

    public void setPositionNbr(Integer positionNbr) {
        this.positionNbr = positionNbr;
    }
}
