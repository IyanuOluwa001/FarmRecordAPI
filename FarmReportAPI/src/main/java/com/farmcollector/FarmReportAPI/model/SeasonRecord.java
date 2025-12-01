package com.farmcollector.FarmReportAPI.model;


import jakarta.persistence.*;

@Entity
public class SeasonRecord {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String season;
    private String crop;

    private double plantingAreaAcres;
    private double expectedHarvestTons;

    private Double actualHarvestTons;

    @ManyToOne
    @JoinColumn(name = "farm_id")
    private Farm farm;


    public int getId() {
        return id;
    }
    public void setId(int id) {
        this.id = id;
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
    public void setExpectedHarvestTons(double expectedProduct) {
        this.expectedHarvestTons = expectedProduct;
    }


    public Double getActualHarvestTons() {
        return actualHarvestTons;
    }
    public void setActualHarvestTons(Double actualHarvestTons) {
        this.actualHarvestTons = actualHarvestTons;
    }

    public Farm getFarm() {
        return farm;
    }
    public void setFarm(Farm farm) {
        this.farm = farm;
    }
}

