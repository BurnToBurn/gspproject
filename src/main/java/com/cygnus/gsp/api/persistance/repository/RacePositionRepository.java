package com.cygnus.gsp.api.persistance.repository;

import com.cygnus.gsp.api.domain.model.FinishedPosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface RacePositionRepository extends JpaRepository<FinishedPosition,Long> {

}
