package com.sujal.parking.billing;

import com.sujal.parking.entity.Ticket;
import com.sujal.parking.strategy.pricing.PricingStrategy;

public class CostComputation {
    private final PricingStrategy pricingStrategy;

    public CostComputation(PricingStrategy pricingStrategy) {
        this.pricingStrategy = pricingStrategy;
    }

    public double compute(Ticket ticket){
        return pricingStrategy.calculate(ticket);
    }
}
