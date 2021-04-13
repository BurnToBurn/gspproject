package com.cygnus.gsp.api.domain.model;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "driver")
public class Driver {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    @Column(nullable = false,unique = true)
    private String name;
    @Column(name = "first_name",nullable = false)
    private String firstName;
    @Column(name = "last_name",nullable = false)
    private String lastName;
    @Column()
    private String country;

    public Driver() {
        super();
    }

    public Driver(String name) {
        this();
        this.name = name;
        splitName(name);
    }

    @Override
    public String toString() {
        return "Driver{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", country='" + country + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Driver driver = (Driver) o;
        return name.equals(driver.name) && firstName.equals(driver.firstName) && lastName.equals(driver.lastName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, firstName, lastName);
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
        return firstName + " " + lastName;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    private void splitName(String displayName){

        if(displayName != null && displayName.length() > 0){
            String[] splitName = displayName.trim().split("\\s+");
            if(splitName.length > 1) {
                this.firstName = splitName[0];
                this.lastName = splitName[1];
            }else {
                throw new IllegalArgumentException();
            }
        }
    }
}
