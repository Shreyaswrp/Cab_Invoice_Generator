package com.InvoiceGenerator;

public class InvoiceGenerator {


    public RideStorage rideStorage = new RideStorage();

    public double calculateFare(RideDetails ride, RideType type) {
        return type.calculateFare(ride);
    }

    public InvoiceDetails calculateFare(RideDetails[] rides, RideType type) {
        double totalFare = 0;
        for (RideDetails ride : rides) {
            totalFare += this.calculateFare(ride, type);
        }
        return new InvoiceDetails(rides.length, totalFare);
    }


    public void addRiders(String userId, RideDetails[] rides) {

        rideStorage.addRides(userId, rides);
    }

    public InvoiceDetails getInvoiceSummary(String userId, RideType type) {
        return this.calculateFare(rideStorage.getRiders(userId), type);
    }

}
