package com.cygnus.gsp.api.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@Accessors(chain = true)
@NoArgsConstructor
@Entity
@Table(name = "season")
public class Season {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seasonId;
    @NotNull
    private String seasonName;
    @NotNull
    @ElementCollection
    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "race_id")
    private List<Race> raceList;
    @NotNull
    @Min(1)
    private Integer scheduledEvents;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "driver_point_system_id")
    private PointSystem driverPointSystem;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "manufacturer_point_system_id")
    private PointSystem manufacturerPointSystem;

    public List<Race> getRaceList() {

        if(raceList == null){
            this.raceList = new ArrayList<>();
        }

        return raceList;
    }

    public Integer getScheduledEvents() {
        if(getRaceList().size() > scheduledEvents){
            this.scheduledEvents = raceList.size();
        }

        return scheduledEvents;
    }

    @Override
    public String toString() {
        return "Season{" +
                "seasonId=" + seasonId +
                ", seasonName='" + seasonName + '\'' +
                ", raceList=" + raceList +
                ", scheduledEvents=" + scheduledEvents +
                ", pointSystem=" + driverPointSystem +
                '}';
    }
}
