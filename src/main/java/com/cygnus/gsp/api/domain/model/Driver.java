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

    public enum Generation{
        SR,JR,II,III,IV,V,VI,VII,VIII
    }



    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long driverId;
    @NotNull
    @Column(nullable = false,unique = true)
    private String driverName;
    @Min(1)
    @Column(nullable = false)
    private String firstName;
    @Min(1)
    private String middleName;
    @Min(1)
    @Column(nullable = false)
    private String lastName;
    @Min(1)
    private String gender;
    @Min(1)
    private Generation generationCode;
    @Min(1)
    private String country;
    private Integer driverNumber=0;

    public String getDisplayName() {
        splitName(driverName);
        StringBuilder stringBuilder;
        if (firstName != null && lastName != null) {
            stringBuilder = new StringBuilder();
            stringBuilder.append(firstName);
            stringBuilder.append(" ");
            if(middleName != null && !middleName.isEmpty()) {
                stringBuilder.append(middleName);
                stringBuilder.append(" ");
            }
            stringBuilder.append(lastName);
            if(generationCode != null) {
                stringBuilder.append(" ");
                stringBuilder.append(generationCode);
            }
            return stringBuilder.toString();
        }
        return driverName;
    }

    void splitName(String driverName){

        if(driverName != null && !driverName.isEmpty()){
            String[] splitName = driverName.trim().split("\\s+");
            if(splitName.length > 0) {
                this.firstName = splitName[0];
            }
            if(splitName.length > 1) {
                this.lastName = splitName[1];
            }
        }
    }
}
