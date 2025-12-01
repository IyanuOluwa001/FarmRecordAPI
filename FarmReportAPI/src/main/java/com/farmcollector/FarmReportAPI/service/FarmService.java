package com.farmcollector.FarmReportAPI.service;



import com.farmcollector.FarmReportAPI.model.Farm;
import com.farmcollector.FarmReportAPI.repository.FarmRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class FarmService {

    @Autowired
    private FarmRepo farmRepo;

    public Farm getOrCreateFarm(String farmName) {
        Farm farm = farmRepo.findByFarmName(farmName);
        if (farm == null) {
            farm = new Farm();
            farm.setFarmName(farmName);
            farmRepo.save(farm);
        }
        return farm;
    }
}
