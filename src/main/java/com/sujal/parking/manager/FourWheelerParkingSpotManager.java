package com.sujal.parking.manager;

import com.sujal.parking.entity.ParkingSpot;
import com.sujal.parking.strategy.parking.ParkingStrategy;

import java.util.List;

public class FourWheelerParkingSpotManager extends ParkingSpotManager{
    public FourWheelerParkingSpotManager (List<ParkingSpot> parkingSpots, ParkingStrategy parkingStrategy){
        super(parkingSpots,parkingStrategy);
    }
}
