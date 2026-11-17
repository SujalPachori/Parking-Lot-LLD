package com.sujal.parking.strategy.pricing;

import com.sujal.parking.entity.Ticket;
import com.sujal.parking.enums.VehicleType;

public class VehicleBasedPricingStrategy implements PricingStrategy{
    @Override
    public double calculate(Ticket ticket) {
        if(ticket.getVehicle().getVehicleType().equals(VehicleType.FOUR_WHEELER)){
            return 200;
        }
        else{
            return 100;
        }
    }
}
