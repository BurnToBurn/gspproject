package com.cygnus.gsp.api.web.controller;

import com.cygnus.gsp.api.domain.model.Track;
import com.cygnus.gsp.api.service.TrackService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.constraints.NotNull;
import java.util.List;

@RestController
public class TrackController {

    private final TrackService trackService;

    @Autowired
    public TrackController(TrackService trackService) {
        this.trackService = trackService;
    }


    @GetMapping("/track")
    public List<Track> getAllTrack(){
        return trackService.getAllTrack();
    }

    @PostMapping("/track")
    public Track createTrack(@RequestBody @NotNull Track track){
        return trackService.createTrack(track);
    }

    @GetMapping("/track/{id}")
    public Track getTrack(@PathVariable @NotNull Long id){

        return trackService.getTrackById(id);
    }

    @PutMapping("/track/{id}")
    public Track replaceTrack(@RequestBody @NotNull Track track, @PathVariable @NotNull Long id){

        return trackService.updateTrackById(track,id);
    }

    @DeleteMapping("/track/{id}")
    public void deleteTrack(@PathVariable @NotNull Long id){
        trackService.deleteTrackById(id);
    }
}
