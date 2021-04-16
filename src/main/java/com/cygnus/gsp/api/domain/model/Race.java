package com.cygnus.gsp.api.domain.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="race")
public class Race {

    public enum Mode{
        ISHORT("Intermediate - Short"),
        ILONG("Intermediate - Long");

        private final String description;
        Mode(String description) {
            this.description = description;
        }

        public String getDescription() {
            return description;
        }
    }


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String name;
    private LocalDateTime dateTime;
    private Mode mode;
    @ManyToOne
    @JoinColumn(name = "trackId")
    private Track track;
    private Integer laps;
    @OneToOne(fetch = FetchType.LAZY,orphanRemoval = true)
    @JoinColumn(name = "fastLapPositionId")
    private TimedPosition fastLapPosition;
    @OneToOne(fetch = FetchType.LAZY,orphanRemoval = true)
    @JoinColumn(name = "polePositionId")
    private TimedPosition polePosition;
    @OneToMany(fetch = FetchType.LAZY,orphanRemoval = true)
    @JoinColumn(name = "racePositionId")
    private List<RacePosition> racePositionList;

    public Race() {
        super();
        this.laps = 0;
    }

    public Race(String name, LocalDateTime dateTime, Mode mode, Track track, Integer laps) {
        this.name = name;
        this.dateTime = dateTime;
        this.mode = mode;
        this.track = track;
        this.laps = laps;
    }

    @Override
    public String toString() {
        return "Race{" +
                "id=" + id +
                ", raceName='" + name + '\'' +
                ", raceDate=" + dateTime +
                ", raceMode=" + mode +
                ", track=" + track +
                ", nbrOfLaps=" + laps +
                ", fastestLapPosition=" + fastLapPosition +
                ", polePosition=" + polePosition +
                ", racePositionList=" + racePositionList +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Race race = (Race) o;
        return Objects.equals(name, race.name) &&
                Objects.equals(dateTime, race.dateTime) &&
                mode == race.mode &&
                Objects.equals(track, race.track);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, dateTime, mode, track);
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

    public LocalDateTime getDateTime() {
        return dateTime;
    }

    public void setDateTime(LocalDateTime dateTime) {
        this.dateTime = dateTime;
    }

    public Mode getMode() {
        return mode;
    }

    public void setMode(Mode mode) {
        this.mode = mode;
    }

    public Track getTrack() {
        return track;
    }

    public void setTrack(Track track) {
        this.track = track;
    }

    public Integer getLaps() {
        return laps;
    }

    public void setLaps(Integer laps) {
        this.laps = laps;
    }

    public TimedPosition getFastLapPosition() {
        return fastLapPosition;
    }

    public void setFastLapPosition(TimedPosition fastLapPosition) {
        this.fastLapPosition = fastLapPosition;
    }

    public TimedPosition getPolePosition() {
        return polePosition;
    }

    public void setPolePosition(TimedPosition polePosition) {
        this.polePosition = polePosition;
    }

    public List<RacePosition> getRacePositionList() {
        if(racePositionList == null){
            this.racePositionList = new ArrayList<>();
        }
        return racePositionList;
    }

    public void setRacePositionList(List<RacePosition> racePositionList) {
        this.racePositionList = racePositionList;
    }
}
