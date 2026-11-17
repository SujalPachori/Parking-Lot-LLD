package com.sujal.parking.entity;

public class ParkingSpot {
    boolean isSpotFree = true;
    String spotId;

    public ParkingSpot(String spotId) {
        this.spotId = spotId;
    }

    public String getSpotId() {
        return spotId;
    }

    public boolean isSpotFree(){
        return isSpotFree;
    }

    public void occupySpot(){
        this.isSpotFree = false;
    }

    public void setSpotFree(){
        this.isSpotFree = true;
    }
}
