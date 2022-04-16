package com.cygnus.gsp.api.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@Accessors(chain = true)
@NoArgsConstructor
@Entity
@Table(name = "manufacturer")
public class Manufacturer {

    @Id
    private String manufacturerId;
    @Min(1)
    @NotNull
    @Column(nullable = false)
    private String manufacturerGroup;
    @Min(1)
    private String shortName;
    @Min(1)
    private String fullName;
    @Min(1)
    private String country;
}
