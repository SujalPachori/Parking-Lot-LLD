package com.sujal.parking.manager;

import com.sujal.parking.entity.ParkingSpot;
import com.sujal.parking.enums.VehicleType;
import com.sujal.parking.strategy.parking.ParkingStrategy;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.locks.ReentrantLock;

public class ParkingSpotManager {
    List<ParkingSpot> parkingSpots;
    ParkingStrategy parkingStrategy;
    private final ReentrantLock reentrantLock = new ReentrantLock(true);

    public ParkingSpotManager(List<ParkingSpot> parkingSpots, ParkingStrategy parkingStrategy){
        this.parkingSpots = parkingSpots;
        this.parkingStrategy = parkingStrategy;
    }

    public ParkingSpot park(){
        reentrantLock.lock();
        try {
            ParkingSpot parkingSpot = parkingStrategy.selectSpot(parkingSpots);
            if(parkingSpot==null){
                return null;
            }
            parkingSpot.occupySpot();
            return parkingSpot;
        }
        finally {
            reentrantLock.unlock();
        }
    }

    public void unpark(ParkingSpot parkingSpot){
        reentrantLock.lock();
        try {
            parkingSpot.setSpotFree();
        }
        finally {
            reentrantLock.unlock();
        }
    }

    public boolean hasFreeSpot(VehicleType vehicleType){
        reentrantLock.lock();
        try{
            return parkingSpots.stream().anyMatch(ParkingSpot::isSpotFree);
        }
        finally {
            reentrantLock.unlock();
        }
    }


}
