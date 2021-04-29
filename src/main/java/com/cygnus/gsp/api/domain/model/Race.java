package com.cygnus.gsp.api.domain.model;

import lombok.*;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@ToString
@EqualsAndHashCode(exclude = {"raceId","trackId","laps","fastLapPosition","polePosition","racePositionList"})
@Accessors(chain = true)
@NoArgsConstructor
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
    private Long raceId;
    @NotNull
    private String name;
    @NotNull
    private LocalDateTime dateTime;
    @NotNull
    private Mode mode;
    @NotNull
    private Long trackId;
    @Min(0)
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

    public Race(@NotNull String name,@NotNull LocalDateTime dateTime,@NotNull Mode mode) {
        this.name = name;
        this.dateTime = dateTime;
        this.mode = mode;
    }

    public void setLaps(Integer laps) {
        if(laps == null || laps < 0){
            laps = 0;
        }
        this.laps = laps;
    }

    public List<RacePosition> getRacePositionList() {
        if(racePositionList == null){
            this.racePositionList = new ArrayList<>();
        }
        return racePositionList;
    }

}
