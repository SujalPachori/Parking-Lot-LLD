package com.sujal.parking.strategy.parking;

import com.sujal.parking.entity.ParkingSpot;

import java.util.List;

public class RandomLookupStrategy implements ParkingStrategy{
    @Override
    public ParkingSpot selectSpot(List<ParkingSpot> parkingSpots) {
        for(ParkingSpot parkingSpot: parkingSpots){
            if (parkingSpot.isSpotFree()){
                return parkingSpot;
            }
        }
        return null;
    }
}
