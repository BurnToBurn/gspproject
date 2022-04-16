package com.cygnus.gsp.api.web.controller;

import com.cygnus.gsp.api.domain.model.Season;
import com.cygnus.gsp.api.exception.NotFoundException;
import com.cygnus.gsp.api.persistance.repository.SeasonRepository;
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

    @GetMapping("/seasons")
    public List<Season> getAllSeasons(){
        return seasonRepository.findAll();
    }

    @PostMapping("/seasons")
    public Season addSeason(@RequestBody Season newSeason){
        return seasonRepository.save(newSeason);
    }

    @GetMapping("/seasons/{id}")
    public Season getSeason(@PathVariable Long id){
        return seasonRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Could not find season " + id));

    }

    @PutMapping("/seasons/{id}")
    public Season replaceSeason(@RequestBody Season newSeason, @PathVariable Long id){
        return seasonRepository.findById(id)
                .map(season -> {
                    season.setSeasonName(newSeason.getSeasonName());
                    season.setPointSystem(newSeason.getPointSystem());
                    season.setRaceList(newSeason.getRaceList());
                    season.setScheduledEvents(newSeason.getScheduledEvents());
                    return seasonRepository.save(season);
                }).orElseGet(() -> {
                    newSeason.setSeasonId(id);
                    return seasonRepository.save(newSeason);
                });
    }

    @DeleteMapping("/seasons/{id}")
    public void deleteSeason(@PathVariable Long id){
        seasonRepository.deleteById(id);
    }
}
