package com.cygnus.gsp.api.domain.model;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import lombok.experimental.Accessors;

import javax.persistence.*;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotNull;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@Getter
@Setter
@ToString
@Accessors(chain = true)
@NoArgsConstructor
@Entity
@Table(name="race")
public class Race {

    public enum Mode{
        NOVICE("Novice"),
        ISHORT("Intermediate - Short"),
        ILONG("Intermediate - Long"),
        PSHORT("Pro - Short"),
        PLONG("Pro - Long"),
        GRANDPRIX("Grand Prix");

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
    @Column(name = "race_id")
    private Long raceId;
    @NotNull
    @Min(1)
    private Integer round;
    @ManyToOne
    @JoinColumn(name = "track_id")
    private Track track;
    private Mode mode;
    private LocalDate date;
    @OneToOne
    @JoinColumn(name = "fastest_lap_position_id")
    private FastestLap fastestLap;
    @ElementCollection
    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "qualified_position_id")
    private List<QualifiedPosition> qualifiedPositionList;
    @ElementCollection
    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name = "finished_position_id")
    private List<FinishedPosition> finishedPositionList;
    @NotNull
    @Min(1)
    private Integer laps;
    private LocalTime time;


    public List<QualifiedPosition> getQualifiedPositionList() {
        if(qualifiedPositionList == null){
            this.qualifiedPositionList = new ArrayList<>();
        }
        return qualifiedPositionList;
    }

    public List<FinishedPosition> getFinishedPositionList() {
        if(finishedPositionList == null){
            this.finishedPositionList = new ArrayList<>();
        }
        return finishedPositionList;
    }

    public Optional<QualifiedPosition> getPolePosition(){
        return this.getQualifiedPositionList().stream()
                .filter(position -> position.getRank() == 1)
                .findFirst();
    }

}
