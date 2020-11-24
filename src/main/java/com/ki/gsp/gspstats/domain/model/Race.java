package com.ki.gsp.gspstats.domain.model;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@Entity
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
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;
    private String raceName;
    private LocalDateTime raceDate;
    private Mode  raceMode;
    @ManyToOne
    @JoinColumn(name = "trackId")
    private Track track;
    private Integer nbrOfLaps;
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
    }

    public Race(String raceName, LocalDateTime raceDate, Mode raceMode, Track track, Integer nbrOfLaps) {
        this.raceName = raceName;
        this.raceDate = raceDate;
        this.raceMode = raceMode;
        this.track = track;
        this.nbrOfLaps = nbrOfLaps;
    }

    @Override
    public String toString() {
        return "Race{" +
                "id=" + id +
                ", raceName='" + raceName + '\'' +
                ", raceDate=" + raceDate +
                ", raceMode=" + raceMode +
                ", track=" + track +
                ", nbrOfLaps=" + nbrOfLaps +
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
        return Objects.equals(raceName, race.raceName) &&
                Objects.equals(raceDate, race.raceDate) &&
                raceMode == race.raceMode &&
                Objects.equals(track, race.track);
    }

    @Override
    public int hashCode() {
        return Objects.hash(raceName, raceDate, raceMode, track);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getRaceName() {
        return raceName;
    }

    public void setRaceName(String raceName) {
        this.raceName = raceName;
    }

    public LocalDateTime getRaceDate() {
        return raceDate;
    }

    public void setRaceDate(LocalDateTime raceDate) {
        this.raceDate = raceDate;
    }

    public Mode getRaceMode() {
        return raceMode;
    }

    public void setRaceMode(Mode raceMode) {
        this.raceMode = raceMode;
    }

    public Track getTrack() {
        return track;
    }

    public void setTrack(Track track) {
        this.track = track;
    }

    public Integer getNbrOfLaps() {
        return nbrOfLaps;
    }

    public void setNbrOfLaps(Integer nbrOfLaps) {
        this.nbrOfLaps = nbrOfLaps;
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
        return racePositionList;
    }

    public void setRacePositionList(List<RacePosition> racePositionList) {
        this.racePositionList = racePositionList;
    }
}
