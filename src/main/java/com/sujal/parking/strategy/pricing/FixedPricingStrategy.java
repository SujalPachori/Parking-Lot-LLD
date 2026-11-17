package com.sujal.parking.strategy.pricing;

import com.sujal.parking.entity.Ticket;

public class FixedPricingStrategy implements PricingStrategy{
    @Override
    public double calculate(Ticket ticket) {
        return 150;
    }
}
