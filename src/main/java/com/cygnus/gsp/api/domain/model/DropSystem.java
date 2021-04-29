package com.cygnus.gsp.api.domain.model;

import lombok.*;
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
@Table(name = "drop_system")
public class DropSystem {

    public enum Method {
        NONE,HALF,FULL
    }

    public enum Order {
        D,K
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dropSystemId;
    @NotNull
    @Column(nullable = false)
    private Method dropMethod;
    @NotNull
    @Column(nullable = false)
    private Order dropOrder;
    @Min(0)
    @NotNull
    @Column(nullable = false)
    private Integer dropCount;


    public DropSystem(Method dropMethod, Order dropOrder, Integer dropCount) {
        this.dropMethod = dropMethod;
        this.dropOrder = dropOrder;
        this.dropCount = dropCount;
    }

    public void setDropCount(Integer dropCount) {
        if(dropCount == null || dropCount < 0){
            dropCount = 0;
        }
        this.dropCount = dropCount;
    }
}
