package com.sujal.parking.strategy.parking;

import com.sujal.parking.entity.ParkingSpot;

import java.util.List;

public interface ParkingStrategy {
    public ParkingSpot selectSpot(List<ParkingSpot> parkingSpots);
}
