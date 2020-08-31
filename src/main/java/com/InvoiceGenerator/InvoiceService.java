package com.InvoiceGenerator;

public class InvoiceService {

    public RideRepository rideStorage = new RideRepository();

    //to calculate fare based on ride type
    public double calculateFare(Ride ride, CabRide type) {
        return type.calculateFare(ride);
    }

    //to generate invoice at the end of the month
    public InvoiceSummary generateInvoice(Ride[] rides, CabRide type) {
        double totalFare = 0;
        for (Ride ride : rides) {
            totalFare += this.calculateFare(ride, type);
        }
        return new InvoiceSummary(rides.length, totalFare);
    }

    //to add rides to the ride repository of a given user id
    public void addRides(String userId, Ride[] rides) {
        rideStorage.addRides(userId, rides);
    }

    //to get the invoice summary of a user
    public InvoiceSummary getInvoiceSummary(String userId, CabRide type) {
        return this.generateInvoice(rideStorage.getRides(userId), type);
    }
}
