package com.cygnus.gsp.api.domain.model;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.time.LocalTime;

@Getter
@Setter
@ToString
@EqualsAndHashCode(exclude = {"timedPositionId"},callSuper = true)
@Accessors(chain = true)
@NoArgsConstructor
@Entity
@Inheritance(strategy= InheritanceType.SINGLE_TABLE)
public class TimedPosition extends Position{

    enum Type{
        FASTLAP,POLE;
    }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long timedPositionId;
    @NotNull
    @Column(nullable = false)
    private LocalTime timing;
    @NotNull
    @Column(nullable = false)
    private Type positionType;

    public TimedPosition(@NotNull Driver driver, @NotNull Manufacturer manufacturer, @NotNull LocalTime timing, @NotNull Type positionType) {
        super(driver, manufacturer);
        this.timing = timing;
        this.positionType = positionType;
    }
}
