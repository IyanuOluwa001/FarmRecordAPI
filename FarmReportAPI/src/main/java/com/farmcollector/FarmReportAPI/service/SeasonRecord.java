package com.farmcollector.FarmReportAPI.service;



import com.farmcollector.FarmReportAPI.dto.PlantedDto;
import com.farmcollector.FarmReportAPI.dto.HarvestDto;
import com.farmcollector.FarmReportAPI.model.Farm;
import com.farmcollector.FarmReportAPI.repository.SeasonRecordRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class SeasonRecord {

    @Autowired
    private SeasonRecordRepo seasonRecordRepo;

    @Autowired
    private FarmService farmService;

    public com.farmcollector.FarmReportAPI.model.SeasonRecord savePlanted(PlantedDto dto) {

        Farm farm = farmService.getOrCreateFarm(dto.getFarmName());

        com.farmcollector.FarmReportAPI.model.SeasonRecord record =
                seasonRecordRepo.findByFarm_FarmNameAndSeasonAndCrop(
                        dto.getFarmName(), dto.getSeason(), dto.getCrop()
                );

        if (record == null) record = new com.farmcollector.FarmReportAPI.model.SeasonRecord();

        record.setFarm(farm);
        record.setSeason(dto.getSeason());
        record.setCrop(dto.getCrop());
        record.setExpectedHarvestTons(dto.getExpectedHarvestTons());
        record.setPlantingAreaAcres(dto.getPlantingAreaAcres());

        return seasonRecordRepo.save(record);
    }

    public com.farmcollector.FarmReportAPI.model.SeasonRecord saveHarvested(HarvestDto dto) {

        com.farmcollector.FarmReportAPI.model.SeasonRecord record =
                seasonRecordRepo.findByFarm_FarmNameAndSeasonAndCrop(
                        dto.getFarmName(), dto.getSeason(), dto.getCrop()
                );

        if (record == null)
            throw new RuntimeException("Planted record does not exist");

        record.setActualHarvestTons(dto.getActualHarvestTons());
        return seasonRecordRepo.save(record);
    }

    public List<com.farmcollector.FarmReportAPI.model.SeasonRecord> reportByFarm(String season, String farmName) {
        return seasonRecordRepo.findBySeasonAndFarm_FarmName(season, farmName);
    }

    public List<com.farmcollector.FarmReportAPI.model.SeasonRecord> reportByCrop(String season, String crop) {
        return seasonRecordRepo.findBySeasonAndCrop(season, crop);
    }
}
