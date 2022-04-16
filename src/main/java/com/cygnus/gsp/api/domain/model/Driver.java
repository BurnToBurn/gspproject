package com.cygnus.gsp.api.domain.model;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@ToString
@EqualsAndHashCode(exclude = {"driverId","country"})
@Accessors(chain = true)
@NoArgsConstructor
@Entity
@Table(name = "driver")
public class Driver implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long driverId;
    @NotNull
    @Column(nullable = false,unique = true)
    private String inputName;
    @Min(1)
    @Column(nullable = true)
    private String firstName;
    @Min(1)
    @Column(nullable = true)
    private String middleName;
    @Min(1)
    @Column(nullable = true)
    private String lastName;
    @Min(1)
    @Column(nullable = true)
    private String generationCode;
    @Min(1)
    @Column(nullable = true)
    private String country;

    public String getDisplayName() {
        if (firstName != null && lastName != null && !firstName.isEmpty() && !lastName.isEmpty())
            return firstName + " " + middleName + " " + lastName + " " + generationCode;
        else
            return inputName;
    }
}
