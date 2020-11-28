package com.ki.gsp.gspstats.persistance.repository;

import com.ki.gsp.gspstats.domain.model.Manufacturer;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface ManufacturerRepository extends JpaRepository<Manufacturer,Long> {

    Optional<Manufacturer> findByAbbreviation(String abbreviation);
}
