package com.InvoiceGenerator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class InvoiceGeneratorTest {

    InvoiceGenerator invoiceGenerator = null;

    @Before
    public void setup() {
        invoiceGenerator = new InvoiceGenerator();
    }

    @Test
    public void givenDistanceAndTime_WhenNormal_ShouldReturnTotalFare() {
        double distance = 2.0;
        int time = 5;
        double totalFare = invoiceGenerator.calculateFare(new RideDetails(distance, time), RideType.Normal);
        Assert.assertEquals(25, totalFare, 0.0);
    }

    @Test
    public void givenLessDistanceAndTime_WhenNormal_ShouldReturnMinimumFare() {
        double distance = 0.1;
        int time = 1;
        double totalFare = invoiceGenerator.calculateFare(new RideDetails(distance, time), RideType.Normal);
        Assert.assertEquals(5, totalFare, 0.0);
    }

    @Test
    public void givenMultipleDistanceAndTime_WhenNormal_ShouldReturnInvoiceSummary() {
        RideDetails[]rides = {new RideDetails(2.0, 5),
                new RideDetails(0.1, 1)};
        InvoiceDetails invoiceDetails = invoiceGenerator.calculateFare(rides, RideType.Normal);
        InvoiceDetails expectedInvoiceSummary = new InvoiceDetails(2, 30);
        Assert.assertEquals(expectedInvoiceSummary, invoiceDetails);
    }

    @Test
    public void givenUserIdAndRides_WhenNormal_ShouldReturnInvoiceSummary() {
        String userId = "himanshu";
        RideDetails[] rides = {new RideDetails(2.0, 5),
                new RideDetails(0.1, 1)};
        invoiceGenerator.addRiders(userId, rides);
        InvoiceDetails invoiceSummary = invoiceGenerator.getInvoiceSummary(userId, RideType.Normal);
        InvoiceDetails expectedSummary = new InvoiceDetails(2, 30);
        Assert.assertEquals(expectedSummary, invoiceSummary);
    }

    @Test
    public void givenDistanceAndTime_WhenPremium_ShouldReturnTotalFare() {
        double distance = 2.0;
        int time = 5;
        double totalFare = invoiceGenerator.calculateFare(new RideDetails(distance, time), RideType.Premium);
        Assert.assertEquals(40,totalFare, 0.0);
    }

    @Test
    public void givenLessDistanceAndTime_WhenPremium_ShouldReturnMinimumFare() {
        double distance = 0.1;
        int time = 1;
        double totalFare = invoiceGenerator.calculateFare(new RideDetails(distance, time), RideType.Premium);
        Assert.assertEquals(20, totalFare, 0.0);
    }

    @Test
    public void givenMultipleDistanceAndTime_WhenPremium_ShouldReturnInvoiceSummary() {
        RideDetails[] rides = {new RideDetails(2.0, 5),
                new RideDetails(0.1, 1)};
        InvoiceDetails invoiceSummary = invoiceGenerator.calculateFare(rides, RideType.Premium);
        InvoiceDetails expectedInvoiceSummary = new InvoiceDetails(2, 60);
        Assert.assertEquals(expectedInvoiceSummary, invoiceSummary);
    }

    @Test
    public void givenUserIdAndRides_WhenPremium_ShouldReturnInvoiceSummary() {
        String userId = "himanshu";
        RideDetails[] rides = {new RideDetails(2.0, 5),
                new RideDetails(0.1, 1)};
        invoiceGenerator.addRiders(userId, rides);
        InvoiceDetails invoiceSummary = invoiceGenerator.getInvoiceSummary(userId, RideType.Premium);
        InvoiceDetails expectedSummary = new InvoiceDetails(2, 60);
        Assert.assertEquals(expectedSummary, invoiceSummary);
    }
}
