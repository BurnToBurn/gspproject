package com.cygnus.gsp.api.domain.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "drop_system")
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
    @Column(name = "drop_method",nullable = false)
    private Method method;
    @Column(name = "drop_order",nullable = false)
    private Order order;
    @Column(name = "drop_count", nullable = false)
    private Integer count;

    public DropSystem() {
        super();
        this.method = Method.NONE;
        this.order = Order.DROP;
        this.count = 0;
    }

    public DropSystem(Method method, Order order, Integer count) {
        this.method = method;
        this.order = order;
        this.count = count;
    }

    @Override
    public String toString() {
        return "DropSystem{" +
                "id=" + id +
                ", method=" + method +
                ", order=" + order +
                ", count=" + count +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        DropSystem that = (DropSystem) o;
        return method == that.method && order == that.order && count.equals(that.count);
    }

    @Override
    public int hashCode() {
        return Objects.hash(method, order, count);
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

    public Integer getCount() {
        return count;
    }

    public void setCount(Integer count) {
        this.count = count;
    }
}
