package com.cygnus.gsp.api.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
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
        HALF(2),FULL(1);

        private final int split;
        Method(int split) {
            this.split = split;
        }

        public int getSplit() {
            return split;
        }
    }

    public enum Order {
        DROP,KEEP
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long dropSystemId;
    @NotNull
    @Column(nullable = false)
    private Method dropMethod = Method.FULL;
    @NotNull
    @Column(nullable = false)
    private Order dropOrder = Order.DROP;
    @Min(0)
    @NotNull
    @Column(nullable = false)
    private Integer dropCount = 0;


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
