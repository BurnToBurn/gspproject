package com.cygnus.gsp.api.domain.model;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
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
        WOOD
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trackId;
    @NotNull
    private String name;
    @NotNull
    @Column(unique = true)
    private String commonName;
    private String location;
    private String country;
    private Surface surface;
    private Integer turns;

    public Track() {
        super();
        this.surface = Surface.ASPHALT;
    }

    public Track(@NotNull String name, @NotNull String commonName) {
        this();
        this.name = name;
        this.commonName = commonName;
    }

    @Override
    public String toString() {
        return "Track{" +
                "id=" + trackId +
                ", name='" + name + '\'' +
                ", commonName='" + commonName + '\'' +
                ", location='" + location + '\'' +
                ", country='" + country + '\'' +
                ", surface=" + surface +
                ", nbrOfTurns=" + turns +
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

    public Long getTrackId() {
        return trackId;
    }

    public void setTrackId(Long trackId) {
        this.trackId = trackId;
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

    public Integer getTurns() {
        return turns;
    }

    public void setTurns(Integer turns) {
        this.turns = turns;
    }
}
