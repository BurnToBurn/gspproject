package com.cygnus.gsp.api.domain.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String firstName;
    private String lastName;
    @Column(unique = true)
    private String displayName;
    private String country;

    public Driver() {
        super();
    }

    public Driver(String displayName) {
        this.displayName = displayName;
        splitDisplayName(displayName);
    }

    public Driver(String firstName, String lastName) {
        this.firstName = firstName;
        this.lastName = lastName;
        this.setDisplayName(firstName + " " + lastName);
    }

    @Override
    public String toString() {
        return "Driver{" +
                "id=" + id +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", displayName='" + displayName + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return Objects.equals(firstName, driver.firstName) &&
                Objects.equals(lastName, driver.lastName) &&
                Objects.equals(displayName, driver.displayName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(firstName, lastName, displayName);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String getDisplayName() {
        return displayName;
    }

    public void setDisplayName(String displayName) {
        this.displayName = displayName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    private void splitDisplayName(String displayName){

        if(displayName != null && displayName.length() > 0){
            String[] splitName = displayName.trim().split("\\s+");
            if(splitName.length > 1) {
                this.firstName = splitName[0];
                this.lastName = splitName[1];
            }
        }
    }
}
