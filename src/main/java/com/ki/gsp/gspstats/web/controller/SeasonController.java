package com.ki.gsp.gspstats.web.controller;

import com.ki.gsp.gspstats.domain.model.Season;
import com.ki.gsp.gspstats.exception.NotFoundException;
import com.ki.gsp.gspstats.persistance.repository.SeasonRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class SeasonController {

    private final SeasonRepository seasonRepository;

    @Autowired
    public SeasonController(SeasonRepository seasonRepository) {
        this.seasonRepository = seasonRepository;
    }

    @GetMapping("/season")
    List<Season> getAllSeasons(){
        return seasonRepository.findAll();
    }

    @PostMapping("/season")
    Season addSeason(@RequestBody Season newSeason){
        return seasonRepository.save(newSeason);
    }

    @GetMapping("/season/{id}")
    Season getSeason(@PathVariable Long id){
        return seasonRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Could not find season " + id));

    }

    @PutMapping("/season/{id}")
    Season replaceSeason(@RequestBody Season newSeason, @PathVariable Long id){
        return seasonRepository.findById(id)
                .map(season -> {
                    season.setName(newSeason.getName());
                    season.setPointSystem(newSeason.getPointSystem());
                    season.setRaceList(newSeason.getRaceList());
                    season.setScheduledRaces(newSeason.getScheduledRaces());
                    return seasonRepository.save(season);
                }).orElseGet(() -> {
                    newSeason.setId(id);
                    return seasonRepository.save(newSeason);
                });
    }

    @DeleteMapping("/season/{id}")
    void deleteSeason(@PathVariable Long id){
        seasonRepository.deleteById(id);
    }
}
