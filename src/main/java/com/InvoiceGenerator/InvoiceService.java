package com.InvoiceGenerator;

public class InvoiceService {

    private RideRepository rideRepository;

    public void setRideRepository(RideRepository rideRepository){
        this.rideRepository = rideRepository;
    }

    //to generate invoice at the end of the month
    public InvoiceSummary generateInvoice(Ride[] rides, CabRide type) {
        double totalFare = 0;
        for (Ride ride : rides) {
            totalFare += type.calculateFare(ride);
        }
        return new InvoiceSummary(rides.length, totalFare);
    }

    //to get the invoice summary of a user
    public InvoiceSummary getInvoiceSummary(String userId, CabRide type) {
        return this.generateInvoice(rideRepository.getRides(userId), type);
    }
}
