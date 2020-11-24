package com.ki.gsp.gspstats.persistance.repository;

import com.ki.gsp.gspstats.domain.model.Track;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TrackRepository extends JpaRepository<Track,Long> {
}
