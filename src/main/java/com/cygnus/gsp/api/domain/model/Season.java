package com.cygnus.gsp.api.domain.model;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
public class Season {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long seasonId;
    @NotNull
    private String name;
    @OneToMany(fetch = FetchType.LAZY,orphanRemoval = true)
    @JoinColumn(name = "raceId")
    private List<Race> raceList;
    @Min(0)
    private Integer scheduledRaces;
    @NotNull
    @ManyToOne
    @JoinColumn(name = "pointSystemId")
    private PointSystem pointSystem;

    public Season() {
        super();
    }

    public Season(@NotNull String name,@NotNull PointSystem pointSystem) {
        this.name = name;
        this.pointSystem = pointSystem;
    }

    @Override
    public String toString() {
        return "Season{" +
                "id=" + seasonId +
                ", name='" + name + '\'' +
                ", raceList=" + raceList +
                ", scheduledRaces=" + scheduledRaces +
                ", pointSystem=" + pointSystem +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Season season = (Season) o;
        return Objects.equals(name, season.name) &&
                Objects.equals(pointSystem, season.pointSystem);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, pointSystem);
    }

    public Long getSeasonId() {
        return seasonId;
    }

    public void setSeasonId(Long seasonId) {
        this.seasonId = seasonId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Race> getRaceList() {

        if(raceList == null){
            this.raceList = new ArrayList<>();
        }

        return raceList;
    }

    public void setRaceList(List<Race> raceList) {
        this.raceList = raceList;
    }

    public Integer getScheduledRaces() {
        if(getRaceList().size() > scheduledRaces){
            this.scheduledRaces = raceList.size();
        }

        return scheduledRaces;
    }

    public void setScheduledRaces(@NotNull Integer scheduledRaces) {
        if(scheduledRaces == null || scheduledRaces < 0){
            scheduledRaces = 0;
        }
        this.scheduledRaces = scheduledRaces;
    }

    public PointSystem getPointSystem() {
        return pointSystem;
    }

    public void setPointSystem(PointSystem pointSystem) {
        this.pointSystem = pointSystem;
    }
}
