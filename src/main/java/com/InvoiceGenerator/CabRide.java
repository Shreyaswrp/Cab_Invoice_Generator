package com.InvoiceGenerator;

public enum CabRide {

    Premium(15.0, 2, 20),
    Normal(10.0, 1, 5);

    private final double COSTPERKM;
    private final int MINIMUMCOST;
    private final int COSTPERMINUTE;

    CabRide(double costPerKm, int costPerMinute, int minimumCost) {
        this.COSTPERKM = costPerKm;
        this.COSTPERMINUTE = costPerMinute;
        this.MINIMUMCOST = minimumCost;
    }

    public double calculateFare(Ride ride) {
        double totalFare = ride.DISTANCE * COSTPERKM + ride.TIME * COSTPERMINUTE;
        return Math.max(totalFare, MINIMUMCOST);
    }

    public double calculateTotalFare(Ride ride) {
        double totalFare = ride.DISTANCE * COSTPERKM + ride.TIME * COSTPERMINUTE;
        return totalFare;
    }
}
