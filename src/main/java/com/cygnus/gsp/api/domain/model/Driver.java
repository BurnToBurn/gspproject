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
    private String name;
    @Min(1)
    @Column(nullable = false)
    private String firstName;
    @Min(1)
    @Column(nullable = false)
    private String lastName;
    private String country;

    public Driver(@NotNull String name) {
        this.name = name;
        splitName(name);
    }

    void splitName(String displayName){

       if(displayName != null && displayName.length() > 0){
            String[] splitName = displayName.split("\\s+|\\.",2);
            if(splitName.length > 1) {
                this.firstName = splitName[0].trim();
                this.lastName = splitName[1].trim();
            }else {
                this.firstName = displayName;
            }
        }else {
           throw new IllegalArgumentException();
       }
    }
}
