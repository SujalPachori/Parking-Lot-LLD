package com.sujal.parking.parkinglot;

import com.sujal.parking.entity.ParkingSpot;
import com.sujal.parking.entity.Ticket;
import com.sujal.parking.entity.Vehicle;
import com.sujal.parking.exception.ParkingFullException;

import java.util.List;

public class ParkingLotBuilding {
    List<ParkingLotLevel> parkingLotLevels;

    public ParkingLotBuilding(List<ParkingLotLevel> parkingLotLevels) {
        this.parkingLotLevels = parkingLotLevels;
    }

    public Ticket allocate(Vehicle vehicle) {
        for (ParkingLotLevel parkingLotLevel : parkingLotLevels) {
            if (parkingLotLevel.hasAvailability(vehicle)) {
                ParkingSpot parkingSpot = parkingLotLevel.park(vehicle);
                if (parkingSpot != null) {
                    System.out.println("Parking allocated at level: "
                            + parkingLotLevel.getLevelNumber()
                            + " spot: " + parkingSpot.getSpotId());
                    return new Ticket(parkingSpot, parkingLotLevel, vehicle);
                }
            }
        }
        throw new ParkingFullException("Parking Full :(");
    }

    public void release(Ticket ticket){
        ticket.getParkingLotLevel().unpark(ticket.getParkingSpot(), ticket.getVehicle());
    }
}
