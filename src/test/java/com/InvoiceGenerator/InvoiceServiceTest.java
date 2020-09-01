package com.InvoiceGenerator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InvoiceServiceTest {

    InvoiceService invoiceService = null;
    private RideRepository rideRepository = null;
    Ride[] rides = null;

    @Before
    public void setup() {
        invoiceService = new InvoiceService();
        rideRepository = new RideRepository();
        invoiceService.setRideRepository(rideRepository);
        rides = new Ride[]{new Ride(2.0, 5), new Ride(0.1, 1)};
    }

    @Test
    public void givenDistanceAndTime_WhenNormal_ShouldReturnTotalFare() {
        double distance = 2.0;
        int time = 5;
        double totalFare = CabRide.Normal.calculateTotalFare(new Ride(distance, time));
        Assert.assertEquals(25, totalFare, 0.0);
    }

    @Test
    public void givenDistanceAndTime_WhenPremium_ShouldReturnTotalFare() {
        double distance = 2.0;
        int time = 5;
        double totalFare = CabRide.Premium.calculateTotalFare(new Ride(distance, time));
        Assert.assertEquals(40, totalFare, 0.0);
    }

    @Test
    public void givenLessDistanceAndTime_WhenNormal_ShouldReturnMinimumFare() {
        double distance = 0.1;
        int time = 1;
        double totalFare = CabRide.Normal.calculateFare(new Ride(distance, time));
        Assert.assertEquals(5, totalFare, 0.0);
    }

    @Test
    public void givenLessDistanceAndTime_WhenPremium_ShouldReturnMinimumFare() {
        double distance = 0.1;
        int time = 1;
        double totalFare = CabRide.Premium.calculateFare(new Ride(distance, time));
        Assert.assertEquals(20, totalFare, 0.0);
    }
    @Test
    public void givenMultipleRides_WhenNormal_ShouldReturnInvoiceSummary() {
        InvoiceSummary invoiceDetails = invoiceService.generateInvoice(rides, CabRide.Normal);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30);
        Assert.assertEquals(expectedInvoiceSummary, invoiceDetails);
    }

    @Test
    public void givenMultipleRides_WhenPremium_ShouldReturnInvoiceSummary() {
        InvoiceSummary invoiceSummary = invoiceService.generateInvoice(rides, CabRide.Premium);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 60);
        Assert.assertEquals(expectedInvoiceSummary, invoiceSummary);
    }

    @Test
    public void givenUserIdAndRides_WhenNormalType_ShouldReturnInvoiceSummary() {
        String userId = "shreyaswrp";
        rideRepository.addRides(userId, rides);
        InvoiceSummary invoiceSummary = invoiceService.getInvoiceSummary(userId, CabRide.Normal);
        InvoiceSummary expectedSummary = new InvoiceSummary(2, 30);
        Assert.assertEquals(expectedSummary, invoiceSummary);
    }

    @Test
    public void givenUserIdAndRides_WhenPremiumType_ShouldReturnInvoiceSummary() {
        String userId = "shreyaswrp";
        rideRepository.addRides(userId, rides);
        InvoiceSummary invoiceSummary = invoiceService.getInvoiceSummary(userId, CabRide.Premium);
        InvoiceSummary expectedSummary = new InvoiceSummary(2, 60);
        Assert.assertEquals(expectedSummary, invoiceSummary);
    }
}
