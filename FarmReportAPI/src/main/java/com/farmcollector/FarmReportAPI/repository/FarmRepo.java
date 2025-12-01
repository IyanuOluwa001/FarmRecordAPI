package com.farmcollector.FarmReportAPI.repository;

import com.farmcollector.FarmReportAPI.model.Farm;
import org.springframework.data.jpa.repository.JpaRepository;

public interface FarmRepo extends JpaRepository<Farm, Integer> {
    Farm findByFarmName(String farmName);
}

