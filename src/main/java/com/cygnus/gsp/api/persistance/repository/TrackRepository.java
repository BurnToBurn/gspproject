package com.cygnus.gsp.api.persistance.repository;

import com.cygnus.gsp.api.domain.model.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackRepository extends JpaRepository<Track,Long> {
}
