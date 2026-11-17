package com.sujal.parking.parkinglot;

import com.sujal.parking.entity.Ticket;
import com.sujal.parking.entity.Vehicle;
import com.sujal.parking.payment.Payment;

public class ParkingLot {
    ParkingLotBuilding parkingLotBuilding;
    ParkingLotEntryGate parkingLotEntryGate;
    ParkingLotExitGate parkingLotExitGate;

    public ParkingLot(ParkingLotBuilding parkingLotBuilding, ParkingLotEntryGate parkingLotEntryGate, ParkingLotExitGate parkingLotExitGate) {
        this.parkingLotBuilding = parkingLotBuilding;
        this.parkingLotEntryGate = parkingLotEntryGate;
        this.parkingLotExitGate = parkingLotExitGate;
    }

    public Ticket vehicleArrives(Vehicle vehicle){
        return parkingLotEntryGate.enter(vehicle, parkingLotBuilding);
    }

    public void vehicleExits(Ticket ticket, Payment payment){
        parkingLotExitGate.exit(parkingLotBuilding, ticket, payment);
    }
}
