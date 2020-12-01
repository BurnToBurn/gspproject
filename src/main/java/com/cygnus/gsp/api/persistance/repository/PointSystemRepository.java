package com.cygnus.gsp.api.persistance.repository;

import com.cygnus.gsp.api.domain.model.PointSystem;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PointSystemRepository extends JpaRepository<PointSystem,Long> {
}
