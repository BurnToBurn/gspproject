package com.cygnus.gsp.api.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;

@Getter
@Setter
@ToString
@Accessors(chain = true)
@NoArgsConstructor
@Entity
@Table(name = "track")
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

    public enum Layout{
        STREET,
        OVAL,
        ROAD
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long trackId;
    @Min(1)
    private String fullName;
    @NotNull
    @Column(unique = true)
    private String trackName;
    @Min(1)
    private String country;
    private Surface surface = Surface.ASPHALT;
    private Integer turns = 0;
    private Layout layout = Layout.ROAD;

    public String getFullName() {
        if(fullName == null) {
            return trackName;
        }

        return fullName;
    }
}
