package com.cygnus.gsp.api.domain.model;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@EqualsAndHashCode(exclude = {"manufacturerId","country","displayName"})
@Accessors(chain = true)
@NoArgsConstructor
@Entity
@Table(name = "manufacturer")
public class Manufacturer {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long manufacturerId;
    private String displayName;
    @NotNull
    @Column(nullable = false)
    private String name;
    @NotNull
    @Column(unique = true, nullable = false)
    private String abbreviation;
    private String country;

    public Manufacturer(@NotNull String name, @NotNull String abbreviation) {
        this.name = name;
        this.abbreviation = abbreviation;
    }
}
