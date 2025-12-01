package com.farmcollector.FarmReportAPI.controller;



import com.farmcollector.FarmReportAPI.dto.HarvestDto;
import com.farmcollector.FarmReportAPI.dto.PlantedDto;
import com.farmcollector.FarmReportAPI.service.SeasonRecord;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


import java.util.List;


@RestController
@RequestMapping("api/")
public class FarmDataAppController {

    @Autowired
    private SeasonRecord seasonRecord;

    @PostMapping("planted")
    @Operation(
            summary = "Create planting record",
            description = "Creating new planting records to include farm name, season, crop, planting area, and expected product"
    )
    @ApiResponse(
            responseCode = "201",
            description = "Http Status 201 created"
    )

    public ResponseEntity<?> planted(@RequestBody PlantedDto dto){
        return new ResponseEntity<>(seasonRecord.savePlanted(dto), HttpStatus.CREATED);
    }

    @PostMapping("harvested")
    @Operation(
            summary = "Create Harvesting record",
            description = "Creating harvesting records to include farmname, season, crop, actual product"
    )
    @ApiResponse(
            responseCode = "201",
            description = "Http Status 201 created"
    )

    public ResponseEntity<?> harvested(@RequestBody HarvestDto dto){
        return new ResponseEntity<>(seasonRecord.saveHarvested(dto), HttpStatus.OK);
    }

    @GetMapping("report/farm/{season}/{farmName}")
    @Operation(
            summary = "Check Farm record",
            description = "Checking the record of specific seasons in a specific farm"
    )
    @ApiResponse(
            responseCode = "201",
            description = "Http Status 201 created"
    )
    public ResponseEntity<List<com.farmcollector.FarmReportAPI.model.SeasonRecord>> reportFarm(
            @PathVariable String season,
            @PathVariable String farmName){
        return ResponseEntity.ok(seasonRecord.reportByFarm(season, farmName));
    }

    @GetMapping("report/crop/{season}/{crop}")
    @Operation(
            summary = "Check Crop record",
            description = "Checking the record of specific season performance of a specific crop"
    )
    @ApiResponse(
            responseCode = "201",
            description = "Http Status 201 created"
    )
    public ResponseEntity<List<com.farmcollector.FarmReportAPI.model.SeasonRecord>> reportCrop(
            @PathVariable String season,
            @PathVariable String crop){
        return ResponseEntity.ok(seasonRecord.reportByCrop(season, crop));
    }
}


//http://localhost:8080/api/report/farm/{season}/{farmName}
//GET http://localhost:8080/api/report/farm/2024/GreenValleyFarm
//http://localhost:8080/api/report/crop/{season}/{crop}
//GET http://localhost:8080/api/report/crop/2024/Maize
