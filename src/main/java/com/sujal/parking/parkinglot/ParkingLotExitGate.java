package com.sujal.parking.parkinglot;

import com.sujal.parking.billing.CostComputation;
import com.sujal.parking.entity.Ticket;
import com.sujal.parking.exception.PaymentFailureException;
import com.sujal.parking.payment.Payment;

public class ParkingLotExitGate {
    private final CostComputation costComputation;

    public ParkingLotExitGate(CostComputation costComputation) {
        this.costComputation = costComputation;
    }

    public void exit(ParkingLotBuilding parkingLotBuilding, Ticket ticket, Payment payment) {
        double amount = calculatePrice(ticket);
        boolean success = payment.pay(amount);
        if (!success) {
            throw new PaymentFailureException("Payment Failed :/");
        }
        parkingLotBuilding.release(ticket);
        System.out.println("Vehicle Exits. Gates Opened.");
    }

    private double calculatePrice(Ticket ticket){
        return costComputation.compute(ticket);
    }
}
