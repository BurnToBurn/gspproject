package com.ki.gsp.gspstats.domain.model;

import springfox.documentation.schema.Enums;

import javax.persistence.*;
import java.util.Objects;

@Entity
public class Track {

    public enum Surface{
        TARTAN,
        ASPHALT,
        CONCRETE,
        DIRT,
        GRASS,
        ICE,
        SAND,
        WOOD;
    }


    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @Column(unique = true)
    private String commonName;
    private String location;
    private String country;
    private Surface surface;
    private Integer nbrOfTurns;

    public Track() {
        super();
    }

    public Track(String name, String commonName) {
        this.name = name;
        this.commonName = commonName;
    }

    @Override
    public String toString() {
        return "Track{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", commonName='" + commonName + '\'' +
                ", location='" + location + '\'' +
                ", country='" + country + '\'' +
                ", surface=" + surface +
                ", nbrOfTurns=" + nbrOfTurns +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Track track = (Track) o;
        return Objects.equals(commonName, track.commonName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(commonName);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCommonName() {
        return commonName;
    }

    public void setCommonName(String commonName) {
        this.commonName = commonName;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }

    public Track.Surface getSurface() {
        return surface;
    }

    public void setSurface(Track.Surface surface) {
        this.surface = surface;
    }

    public Integer getNbrOfTurns() {
        return nbrOfTurns;
    }

    public void setNbrOfTurns(Integer nbrOfTurns) {
        this.nbrOfTurns = nbrOfTurns;
    }
}
