package com.sujal.parking.strategy.pricing;

import com.sujal.parking.entity.Ticket;

public interface PricingStrategy {
    public double calculate(Ticket ticket);
}
