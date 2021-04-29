package com.cygnus.gsp.api.persistance.repository;

import com.cygnus.gsp.api.domain.model.RacePosition;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RacePositionRepository extends JpaRepository<RacePosition,Long> {
}
