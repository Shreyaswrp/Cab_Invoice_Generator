package com.InvoiceGenerator;

public enum CabRide {

    Premium(15.0, 2, 20),
    Normal(10.0, 1, 5);

    private final double COST_PER_KM;
    private final int MINIMUM_COST;
    private final int COST_PER_MINUTE;

    CabRide(double costPerKm, int costPerMinute, int minimumCost) {
        this.COST_PER_KM = costPerKm;
        this.COST_PER_MINUTE = costPerMinute;
        this.MINIMUM_COST = minimumCost;
    }

    public double calculateFare(Ride ride) {
        double totalFare = ride.DISTANCE * COST_PER_KM + ride.TIME * COST_PER_MINUTE;
        return Math.max(totalFare, MINIMUM_COST);
    }

    public double calculateTotalFare(Ride ride) {
        double totalFare = ride.DISTANCE * COST_PER_KM + ride.TIME * COST_PER_MINUTE;
        return totalFare;
    }
}
