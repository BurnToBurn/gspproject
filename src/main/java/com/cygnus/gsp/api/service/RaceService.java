package com.cygnus.gsp.api.service;

import com.cygnus.gsp.api.domain.model.Race;
import com.cygnus.gsp.api.exception.NotFoundException;
import com.cygnus.gsp.api.persistance.repository.RaceRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;

@Service
public class RaceService {
    private final RaceRepository raceRepository;

    @Autowired
    public RaceService(RaceRepository raceRepository) {
        this.raceRepository = raceRepository;
    }

    public List<Race> getAllRaces(){
        return raceRepository.findAll();
    }

    public Race getRaceById(@NotNull Long raceId){
        return raceRepository.findById(raceId)
                .orElseThrow(() -> new NotFoundException("No matching race was found"));
    }

    public Race createRace(@NotNull Race race){
        return raceRepository.save(race);
    }

    public Race updateRace(@NotNull Long raceId, @NotNull Race race){
        return raceRepository.findById(raceId)
                .map(newRace -> {
                    newRace.setLaps(race.getLaps());
                    newRace.setMode(race.getMode());
                    newRace.setDate(race.getDate());
                    newRace.setFastestLap(race.getFastestLap());
                    newRace.setFinishedPositionList(race.getFinishedPositionList());
                    newRace.setQualifiedPositionList(race.getQualifiedPositionList());
                    newRace.setRound(race.getRound());
                    newRace.setTime(race.getTime());
                    newRace.setTrack(race.getTrack());
                    return raceRepository.save(newRace);
                }).orElseThrow(() -> new NotFoundException("No matching race was found"));
    }

    public void deleteRaceById(Long raceId){
        raceRepository.findById(raceId).orElseThrow(() -> new NotFoundException("No matching race was found"));
        raceRepository.deleteById(raceId);
    }
}
