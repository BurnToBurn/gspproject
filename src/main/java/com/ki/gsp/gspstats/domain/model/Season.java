package com.ki.gsp.gspstats.domain.model;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Entity
public class Season {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String name;
    @OneToMany(orphanRemoval = true)
    @JoinColumn(name = "raceId")
    private List<Race> raceList;
    private Integer scheduledRaces;
    @OneToOne
    @JoinColumn(name = "pointSystemId")
    private PointSystem pointSystem;

    public Season() {
        super();
    }

    public Season(String name, Integer scheduledRaces, PointSystem pointSystem) {
        this.name = name;
        this.scheduledRaces = scheduledRaces;
        this.pointSystem = pointSystem;
    }

    @Override
    public String toString() {
        return "Season{" +
                "id=" + id +
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

    public List<Race> getRaceList() {
        return raceList;
    }

    public void setRaceList(List<Race> raceList) {
        this.raceList = raceList;
    }

    public Integer getScheduledRaces() {
        if(raceList != null && raceList.size() > scheduledRaces){
            this.scheduledRaces = raceList.size();
        }
        return scheduledRaces;
    }

    public void setScheduledRaces(Integer scheduledRaces) {
        this.scheduledRaces = scheduledRaces;
    }

    public PointSystem getPointSystem() {
        return pointSystem;
    }

    public void setPointSystem(PointSystem pointSystem) {
        this.pointSystem = pointSystem;
    }
}
