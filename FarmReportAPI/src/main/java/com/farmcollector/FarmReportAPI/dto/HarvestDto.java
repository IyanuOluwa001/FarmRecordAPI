package com.farmcollector.FarmReportAPI.dto;


public class HarvestDto {

    private String farmName;
    private String season;
    private String crop;
    private double actualHarvestTons;

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

    public double getActualHarvestTons() {
        return actualHarvestTons;
    }

    public void setActualHarvestTons(double actualHarvestTons) {
        this.actualHarvestTons = actualHarvestTons;
    }

}
