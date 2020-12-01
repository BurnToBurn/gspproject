package com.cygnus.gsp.api.web.controller;

import com.cygnus.gsp.api.domain.model.Track;
import com.cygnus.gsp.api.exception.NotFoundException;
import com.cygnus.gsp.api.persistance.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class TrackController {
    private final TrackRepository trackRepository;

    @Autowired
    public TrackController(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    @GetMapping("/track")
    List<Track> getAllTrack(){
        return trackRepository.findAll();
    }

    @PostMapping("/track")
    Track addTrack(@RequestBody Track newTrack){
        return trackRepository.save(newTrack);
    }

    @GetMapping("/track/{id}")
    Track getTrack(@PathVariable Long id){
        return trackRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("Could not find track " + id));

    }

    @PutMapping("/track/{id}")
    Track replaceTrack(@RequestBody Track newTrack, @PathVariable Long id){
        return trackRepository.findById(id)
                .map(track -> {
                    track.setCommonName(newTrack.getCommonName());
                    track.setCountry(newTrack.getCountry());
                    track.setLocation(newTrack.getLocation());
                    track.setName(newTrack.getName());
                    track.setNbrOfTurns(newTrack.getNbrOfTurns());
                    track.setSurface(newTrack.getSurface());
                    return trackRepository.save(track);
                }).orElseGet(() -> {
                    newTrack.setId(id);
                    return trackRepository.save(newTrack);
                });
    }

    @DeleteMapping("/track/{id}")
    void deleteTrack(@PathVariable Long id){
        trackRepository.deleteById(id);
    }
}
