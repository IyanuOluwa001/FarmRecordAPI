package com.farmcollector.FarmReportAPI.repository;

import com.farmcollector.FarmReportAPI.model.SeasonRecord;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface SeasonRecordRepo extends JpaRepository<SeasonRecord, Integer> {

    SeasonRecord findByFarm_FarmNameAndSeasonAndCrop(
            String farmName,
            String season,
            String crop
    );

    List<SeasonRecord> findBySeasonAndFarm_FarmName(String season, String farmName);

    List<SeasonRecord> findBySeasonAndCrop(String season, String crop);
}

