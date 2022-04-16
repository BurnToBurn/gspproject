package com.cygnus.gsp.api.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.io.Serializable;

@Getter
@Setter
@ToString
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
    @Column(nullable = false)
    private String firstName;
    @Min(1)
    private String middleName;
    @Min(1)
    @Column(nullable = false)
    private String lastName;
    @Min(1)
    private String generationCode;
    @Min(1)
    private String country;

    public String getDisplayName() {
        if (firstName != null && lastName != null)
            return firstName + " " + middleName + " " + lastName + " " + generationCode;
        else
            return inputName;
    }

    void splitName(String inputName){

        if(inputName != null && inputName.length() > 0){
            String[] splitName = inputName.trim().split("\\s+");
            if(splitName.length > 1) {
                this.firstName = splitName[0];
                this.lastName = splitName[1];
            }else {
                throw new IllegalArgumentException();
            }
        }
    }
}
