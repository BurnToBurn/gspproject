package com.ki.gsp.gspstats.persistance.repository;

import com.ki.gsp.gspstats.domain.model.Driver;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DriverRepository extends JpaRepository<Driver,Long> {
}
