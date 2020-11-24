package com.ki.gsp.gspstats.domain.model;

import javax.persistence.*;
import java.time.LocalTime;
import java.util.Objects;

@Entity
@Inheritance(strategy=InheritanceType.SINGLE_TABLE)
public class TimedPosition extends Position{

    public enum Type{
        FASTLAP,POLE;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private LocalTime timing;
    private Type positionType;

    public TimedPosition() {
        super();
    }

    public TimedPosition(Driver driver, Manufacturer manufacturer, LocalTime timing, Type positionType) {
        super(driver, manufacturer);
        this.timing = timing;
        this.positionType = positionType;
    }

    @Override
    public String toString() {
        return "TimedPosition{" +
                "Id=" + id +
                ", timing=" + timing +
                ", positionType=" + positionType +
                "} " + super.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        if (!super.equals(o)) return false;
        TimedPosition that = (TimedPosition) o;
        return Objects.equals(timing, that.timing) &&
                positionType == that.positionType;
    }

    @Override
    public int hashCode() {
        return Objects.hash(super.hashCode(), timing, positionType);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalTime getTiming() {
        return timing;
    }

    public void setTiming(LocalTime timing) {
        this.timing = timing;
    }

    public Type getPositionType() {
        return positionType;
    }

    public void setPositionType(Type positionType) {
        this.positionType = positionType;
    }
}
