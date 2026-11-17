package com.sujal.parking.parkinglot;

import com.sujal.parking.entity.Ticket;
import com.sujal.parking.entity.Vehicle;

public class ParkingLotEntryGate {
    public Ticket enter(Vehicle vehicle, ParkingLotBuilding parkingLotBuilding){
        return parkingLotBuilding.allocate(vehicle);
    }
}
