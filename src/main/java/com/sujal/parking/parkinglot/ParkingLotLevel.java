package com.sujal.parking.parkinglot;

import com.sujal.parking.entity.ParkingSpot;
import com.sujal.parking.entity.Vehicle;
import com.sujal.parking.enums.VehicleType;
import com.sujal.parking.exception.ParkingSpotManageraNotFoundException;
import com.sujal.parking.manager.ParkingSpotManager;

import java.util.Map;

public class ParkingLotLevel {
    int levelNumber;
    Map<VehicleType, ParkingSpotManager> parkingSpotManagers;

    public ParkingLotLevel(int levelNumber,  Map<VehicleType, ParkingSpotManager> parkingSpotManagers){
        this.levelNumber = levelNumber;
        this.parkingSpotManagers = parkingSpotManagers;
    }

    public boolean hasAvailability(Vehicle vehicle){
        ParkingSpotManager parkingSpotManager = parkingSpotManagers.get(vehicle.getVehicleType());
        return (parkingSpotManager!=null && parkingSpotManager.hasFreeSpot(vehicle.getVehicleType()));
    }

    public ParkingSpot park(Vehicle vehicle){
        ParkingSpotManager parkingSpotManager = parkingSpotManagers.get(vehicle.getVehicleType());
        if(parkingSpotManager == null){
            throw new ParkingSpotManageraNotFoundException("No parking spot manager found for the vehicle type: " + vehicle.getVehicleType());
        }
        return parkingSpotManager.park();
    }

    public void unpark(ParkingSpot parkingSpot, Vehicle vehicle){
        ParkingSpotManager parkingSpotManager = parkingSpotManagers.get(vehicle.getVehicleType());
        if(parkingSpotManager == null){
            throw new ParkingSpotManageraNotFoundException("No parking spot manager found for the vehicle type: " + vehicle.getVehicleType());
        }
        parkingSpotManager.unpark(parkingSpot);
    }

    public int getLevelNumber() {
        return levelNumber;
    }
}
