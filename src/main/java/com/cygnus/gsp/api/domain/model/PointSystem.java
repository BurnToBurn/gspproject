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

    public enum DropMethod {
        NONE,HALF,FULL
    }

    public enum DropOrder {
        DROP,KEEP
    }

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    @Column(unique = true)
    private String name;
    private DropMethod dropMethod;
    private DropOrder dropOrder;
    private Integer dropCount;
    @ElementCollection
    private List<BigDecimal> positionPoints;
    private BigDecimal fastLapPoint;
    private BigDecimal polePoint;
    private GroupCalculation manufacturerCalculation;
    private Integer manufacturerCount;

    public PointSystem() {
        super();
    }
    //TODO will need a point system builder
    public PointSystem(String name, List<BigDecimal> positionPoints, BigDecimal fastLapPoint, BigDecimal polePoint) {
        this.name = name;
        this.dropMethod = DropMethod.NONE;
        this.dropOrder = DropOrder.DROP;
        this.dropCount = 0;
        this.positionPoints = positionPoints;
        this.fastLapPoint = fastLapPoint;
        this.polePoint = polePoint;
        this.manufacturerCalculation = GroupCalculation.ALL;
        this.manufacturerCount = 1;
    }

    @Override
    public String toString() {
        return "PointSystem{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", dropMethod=" + dropMethod +
                ", dropOrder=" + dropOrder +
                ", dropCount=" + dropCount +
                ", positionPoints=" + positionPoints +
                ", fastLapPoints=" + fastLapPoint +
                ", polePoints=" + polePoint +
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

    public DropMethod getDropMethod() {
        return dropMethod;
    }

    public void setDropMethod(DropMethod dropMethod) {
        this.dropMethod = dropMethod;
    }

    public DropOrder getDropOrder() {
        return dropOrder;
    }

    public void setDropOrder(DropOrder dropOrder) {
        this.dropOrder = dropOrder;
    }

    public Integer getDropCount() {
        return dropCount;
    }

    public void setDropCount(Integer dropCount) {
        this.dropCount = dropCount;
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

    public Integer getManufacturerCount() {
        return manufacturerCount;
    }

    public void setManufacturerCount(Integer manufacturerCount) {
        this.manufacturerCount = manufacturerCount;
    }
}
