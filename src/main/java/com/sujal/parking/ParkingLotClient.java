package com.sujal.parking;

import com.sujal.parking.billing.CostComputation;
import com.sujal.parking.entity.ParkingSpot;
import com.sujal.parking.entity.Ticket;
import com.sujal.parking.entity.Vehicle;
import com.sujal.parking.enums.VehicleType;
import com.sujal.parking.manager.ParkingSpotManager;
import com.sujal.parking.parkinglot.*;
import com.sujal.parking.payment.CashPayment;
import com.sujal.parking.payment.UPIPayment;
import com.sujal.parking.strategy.parking.ParkingStrategy;
import com.sujal.parking.strategy.parking.RandomLookupStrategy;
import com.sujal.parking.strategy.pricing.FixedPricingStrategy;
import com.sujal.parking.strategy.pricing.VehicleBasedPricingStrategy;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ParkingLotClient {

    public static void main(String[] args) {
        ParkingStrategy parkingStrategy = new RandomLookupStrategy();
        Map<VehicleType,ParkingSpotManager> levelOneParkingSpotManagerMap = new HashMap<>();
        Map<VehicleType,ParkingSpotManager> levelTwoParkingSpotManagerMap = new HashMap<>();

        levelOneParkingSpotManagerMap.put(VehicleType.TWO_WHEELER, new ParkingSpotManager(List.of(new ParkingSpot("L1-S1"), new ParkingSpot("L1-S2")), parkingStrategy));
        levelOneParkingSpotManagerMap.put(VehicleType.FOUR_WHEELER, new ParkingSpotManager(List.of(new ParkingSpot("L1-S3"), new ParkingSpot("L1-S4")), parkingStrategy));

        ParkingLotLevel parkingLotLevel1 = new ParkingLotLevel(1, levelOneParkingSpotManagerMap);

        levelTwoParkingSpotManagerMap.put(VehicleType.FOUR_WHEELER, new ParkingSpotManager(List.of(new ParkingSpot("L2-S1"), new ParkingSpot("L2-S2")), parkingStrategy));
        levelTwoParkingSpotManagerMap.put(VehicleType.TWO_WHEELER, new ParkingSpotManager(List.of(new ParkingSpot("L2-S3"), new ParkingSpot("L2-S4")), parkingStrategy));

        ParkingLotLevel parkingLotLevel2 = new ParkingLotLevel(2, levelTwoParkingSpotManagerMap);

        ParkingLotBuilding parkingLotBuilding = new ParkingLotBuilding(List.of(parkingLotLevel1, parkingLotLevel2));

        ParkingLot parkingLot = new ParkingLot(parkingLotBuilding, new ParkingLotEntryGate(), new ParkingLotExitGate(new CostComputation(new VehicleBasedPricingStrategy())));

        Vehicle bike = new Vehicle("101", VehicleType.TWO_WHEELER);
        Vehicle car = new Vehicle("201", VehicleType.FOUR_WHEELER);

        Ticket t1 = parkingLot.vehicleArrives(bike);
        Ticket t2 = parkingLot.vehicleArrives(car);

        parkingLot.vehicleExits(t1, new CashPayment());
        parkingLot.vehicleExits(t2, new UPIPayment());

    }
}
