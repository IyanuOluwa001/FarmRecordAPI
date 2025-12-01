package com.farmcollector.FarmReportAPI.dto;


import io.swagger.v3.oas.annotations.media.Schema;

public class PlantedDto {

    private String farmName;
    private String season;
    private String crop;
    @Schema(description = "Planting area measured strictly in acres")
    private double plantingAreaAcres;
    @Schema(description = "Expected harvest amount measured in tons")
    private double expectedHarvestTons;


    public String getFarmName() {
        return farmName;
    }

    public void setFarmName(String farmName) {
        this.farmName = farmName;
    }

    public String getSeason() {
        return season;
    }

    public void setSeason(String season) {
        this.season = season;
    }

    public String getCrop() {
        return crop;
    }

    public void setCrop(String crop) {
        this.crop = crop;
    }

    public double getPlantingAreaAcres() {
        return plantingAreaAcres;
    }

    public void setPlantingAreaAcres(double plantingAreaAcres) {
        this.plantingAreaAcres = plantingAreaAcres;
    }

    public double getExpectedHarvestTons() {
        return expectedHarvestTons;
    }

    public void setExpectedHarvestTons(double expectedHarvestTons) {
        this.expectedHarvestTons = expectedHarvestTons;
    }
}

