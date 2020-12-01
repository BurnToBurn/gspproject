package com.cygnus.gsp.api.persistance.repository;

import com.cygnus.gsp.api.domain.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface DriverRepository extends JpaRepository<Driver,Long> {

    Optional<Driver> findByDisplayName(String displayName);
}
