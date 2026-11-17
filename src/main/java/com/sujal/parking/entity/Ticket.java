package com.sujal.parking.entity;

import com.sujal.parking.parkinglot.ParkingLotLevel;

public class Ticket {
    ParkingSpot parkingSpot;
    ParkingLotLevel parkingLotLevel;
    Vehicle vehicle;

    public Ticket(ParkingSpot parkingSpot, ParkingLotLevel parkingLotLevel, Vehicle vehicle) {
        this.parkingSpot = parkingSpot;
        this.parkingLotLevel = parkingLotLevel;
        this.vehicle = vehicle;
    }

    public ParkingSpot getParkingSpot() {
        return parkingSpot;
    }

    public void setParkingSpot(ParkingSpot parkingSpot) {
        this.parkingSpot = parkingSpot;
    }

    public ParkingLotLevel getParkingLotLevel() {
        return parkingLotLevel;
    }

    public void setParkingLotLevel(ParkingLotLevel parkingLotLevel) {
        this.parkingLotLevel = parkingLotLevel;
    }

    public Vehicle getVehicle() {
        return vehicle;
    }

    public void setVehicle(Vehicle vehicle) {
        this.vehicle = vehicle;
    }
}
