package com.cygnus.gsp.api.domain.model;

import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import java.util.Objects;

public class DropSystem {

    public enum Method {
        NONE,HALF,FULL
    }

    public enum Order {
        DROP,KEEP
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false)
    private Method method;
    @Column(nullable = false)
    private Order order;
    @Column(nullable = false)
    private Integer dropCount;

    public DropSystem() {
        super();
        this.method = Method.NONE;
        this.order = Order.DROP;
        this.dropCount = 0;
    }

    public DropSystem(Method method, Order order, Integer dropCount) {
        this.method = method;
        this.order = order;
        this.dropCount = dropCount;
    }

    @Override
    public String toString() {
        return "DropSystem{" +
                "id=" + id +
                ", method=" + method +
                ", order=" + order +
                ", dropCount=" + dropCount +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DropSystem that = (DropSystem) o;
        return method == that.method && order == that.order && dropCount.equals(that.dropCount);
    }

    @Override
    public int hashCode() {
        return Objects.hash(method, order, dropCount);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Method getMethod() {
        return method;
    }

    public void setMethod(Method method) {
        this.method = method;
    }

    public Order getOrder() {
        return order;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public Integer getDropCount() {
        return dropCount;
    }

    public void setDropCount(Integer dropCount) {
        this.dropCount = dropCount;
    }
}
