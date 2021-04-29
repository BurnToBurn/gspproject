package com.cygnus.gsp.trackmanager.persistance.repository;

import com.cygnus.gsp.trackmanager.domain.model.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackRepository extends JpaRepository<Track,Long> {
}
