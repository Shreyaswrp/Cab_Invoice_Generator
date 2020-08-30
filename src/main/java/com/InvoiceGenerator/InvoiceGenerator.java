package com.InvoiceGenerator;

public class InvoiceGenerator {


    double costPrekilometer = 10;
    int minimumCost = 5;
    int costPerMinute = 1;

    public InvoiceDetails calculateTotalFare(RideDetails[] rides) {
        double totalFare = 0;
        for (RideDetails ride : rides) {
            totalFare += calculateFare(ride);
        }
        return new InvoiceDetails(rides.length, totalFare);
    }
    public double calculateFare(RideDetails ride) {
        double totalFare = ride.distance * costPrekilometer + ride.time * costPerMinute;
        return Math.max(totalFare, minimumCost);
    }

}
