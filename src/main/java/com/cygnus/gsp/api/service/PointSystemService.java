package com.cygnus.gsp.api.service;

import com.cygnus.gsp.api.domain.model.PointSystem;
import com.cygnus.gsp.api.exception.NotFoundException;
import com.cygnus.gsp.api.persistance.repository.PointSystemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.constraints.NotNull;
import java.util.List;

@Service
public class PointSystemService {

    private final PointSystemRepository pointSystemRepository;

    @Autowired
    public PointSystemService(PointSystemRepository pointSystemRepository) {
        this.pointSystemRepository = pointSystemRepository;
    }

    public List<PointSystem> getPointSystems(){
        return pointSystemRepository.findAll();
    }

    public PointSystem getPointSystemById(@NotNull Long pointSystemId){
        return pointSystemRepository.findById(pointSystemId)
                .orElseThrow(() -> new NotFoundException("No matching pointsytem was found"));
    }
}
