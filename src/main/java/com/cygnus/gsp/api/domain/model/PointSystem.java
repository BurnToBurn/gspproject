package com.cygnus.gsp.api.domain.model;

import javax.persistence.*;
import java.math.BigDecimal;
import java.util.List;
import java.util.Objects;

@Entity
public class PointSystem {

    public enum GroupCalculation{
        NONE,TOP,ALL
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(unique = true)
    private String name;
    @Column(nullable = false)
    private DropSystem dropSystem;
    @ElementCollection
    private List<BigDecimal> positionPoints;
    @Column(nullable = false)
    private BigDecimal fastLapPoint;
    @Column(nullable = false)
    private BigDecimal polePoint;
    @Column(nullable = false)
    private GroupCalculation manufacturerCalculation;
    @Column(nullable = false)
    private Integer manufacturerCount;

    public PointSystem() {
        super();
        this.dropSystem = new DropSystem();
        this.manufacturerCalculation = GroupCalculation.ALL;
        this.manufacturerCount = 1;
    }
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

    @Override
    public String toString() {
        return "PointSystem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dropSystem=" + dropSystem +
                ", positionPoints=" + positionPoints +
                ", fastLapPoint=" + fastLapPoint +
                ", polePoint=" + polePoint +
                ", manufacturerCalculation=" + manufacturerCalculation +
                ", manufacturerCount=" + manufacturerCount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PointSystem that = (PointSystem) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<BigDecimal> getPositionPoints() {
        return positionPoints;
    }

    public void setPositionPoints(List<BigDecimal> positionPoints) {
        this.positionPoints = positionPoints;
    }

    public BigDecimal getFastLapPoints() {
        return fastLapPoint;
    }

    public void setFastLapPoints(BigDecimal fastLapPoint) {
        this.fastLapPoint = fastLapPoint;
    }

    public BigDecimal getPolePoints() {
        return polePoint;
    }

    public void setPolePoints(BigDecimal polePoint) {
        this.polePoint = polePoint;
    }

    public GroupCalculation getManufacturerCalculation() {
        return manufacturerCalculation;
    }

    public void setManufacturerCalculation(GroupCalculation manufacturerCalculation) {
        this.manufacturerCalculation = manufacturerCalculation;
    }

    public DropSystem getDropSystem() {
        return dropSystem;
    }

    public void setDropSystem(DropSystem dropSystem) {
        this.dropSystem = dropSystem;
    }

    public Integer getManufacturerCount() {
        return manufacturerCount;
    }

    public void setManufacturerCount(Integer manufacturerCount) {
        this.manufacturerCount = manufacturerCount;
    }
}
