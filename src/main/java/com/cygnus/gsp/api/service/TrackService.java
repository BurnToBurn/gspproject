package com.cygnus.gsp.api.service;

import com.cygnus.gsp.api.domain.model.Track;
import com.cygnus.gsp.api.exception.NotFoundException;
import com.cygnus.gsp.api.persistance.repository.TrackRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;

import javax.validation.constraints.NotNull;
import java.util.List;

@Service
public class TrackService {

    private final TrackRepository trackRepository;

    @Autowired
    public TrackService(TrackRepository trackRepository) {
        this.trackRepository = trackRepository;
    }

    public List<Track> getAllTrack(){
        return trackRepository.findAll();
    }

    public Track createTrack(@RequestBody @NotNull Track track){
        return trackRepository.save(track);
    }

    public Track getTrackById(@PathVariable @NotNull Long id){
        return trackRepository.findById(id)
                .orElseThrow(() -> new NotFoundException("No matching track was found"));

    }

    public Track updateTrackById(@RequestBody @NotNull Track track, @PathVariable @NotNull Long id){
        return trackRepository.findById(id)
                .map(newTrack -> {
                    newTrack.setCommonName(track.getCommonName());
                    newTrack.setCountry(track.getCountry());
                    newTrack.setLocation(track.getLocation());
                    newTrack.setName(track.getName());
                    newTrack.setTurns(track.getTurns());
                    newTrack.setSurface(track.getSurface());
                    return trackRepository.save(track);
                }).orElseThrow(() -> new NotFoundException("No matching track was found"));
    }

    public void deleteTrackById(@PathVariable @NotNull Long id){
        trackRepository.deleteById(id);
    }
}
