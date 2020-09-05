package com.InvoiceGenerator;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class InvoiceServiceTest {

    InvoiceService invoiceService = null;
    private RideRepository rideRepository = null;
    Ride[] rides = null;
    String userId = null;
    @Rule
    public ExpectedException expectedException = ExpectedException.none();

    @Before
    public void setup() {
        invoiceService = new InvoiceService();
        rideRepository = new RideRepository();
        invoiceService.setRideRepository(rideRepository);
        rides = new Ride[]{new Ride(2.0, 5), new Ride(0.1, 1)};
        userId = "shreyaswrp";
        rideRepository.addRides(userId, rides);
    }

    @Test
    public void givenDistanceAndTime_WhenNormal_ShouldReturnTotalFare() {
        double distance = 2.0;
        int time = 5;
        double totalFare = CabRide.Normal.calculateTotalFare(new Ride(distance, time));
        Assert.assertEquals(25, totalFare, 0.0);
    }

    @Test(expected = AssertionError.class)
    public void givenDistanceAndTime_WhenExpectedTotalFareIsWrongForTypeNormal_ShouldThrowAssertionError() {
        double distance = 2.0;
        int time = 5;
        double totalFare = CabRide.Normal.calculateTotalFare(new Ride(distance, time));
        Assert.assertEquals(100, totalFare, 0.0);
    }

    @Test
    public void givenDistanceAndTime_WhenPremium_ShouldReturnTotalFare() {
        double distance = 2.0;
        int time = 5;
        double totalFare = CabRide.Premium.calculateTotalFare(new Ride(distance, time));
        Assert.assertEquals(40, totalFare, 0.0);
    }

    @Test(expected = AssertionError.class)
    public void givenDistanceAndTime_WhenExpectedTotalFareIsWrongForTypePremium_ShouldThrowAssertionError() {
        double distance = 2.0;
        int time = 5;
        double totalFare = CabRide.Premium.calculateTotalFare(new Ride(distance, time));
        Assert.assertEquals(100, totalFare, 0.0);
    }

    @Test
    public void givenLessDistanceAndTime_WhenNormal_ShouldReturnMinimumFare() {
        double distance = 0.1;
        int time = 1;
        double totalFare = CabRide.Normal.calculateFare(new Ride(distance, time));
        Assert.assertEquals(5, totalFare, 0.0);
    }

    @Test(expected = AssertionError.class)
    public void givenLessDistanceAndTime_WhenExpectedMinimumFareIsWrongForTypeNormal_ShouldThrowAssertionError() {
        double distance = 2.0;
        int time = 5;
        double totalFare = CabRide.Normal.calculateFare(new Ride(distance, time));
        Assert.assertEquals(100, totalFare, 0.0);
    }

    @Test
    public void givenLessDistanceAndTime_WhenPremium_ShouldReturnMinimumFare() {
        double distance = 0.1;
        int time = 1;
        double totalFare = CabRide.Premium.calculateFare(new Ride(distance, time));
        Assert.assertEquals(20, totalFare, 0.0);
    }

    @Test(expected = AssertionError.class)
    public void givenLessDistanceAndTime_WhenExpectedMinimumFareIsWrongForTypePremium_ShouldThrowAssertionError() {
        double distance = 2.0;
        int time = 5;
        double totalFare = CabRide.Premium.calculateFare(new Ride(distance, time));
        Assert.assertEquals(100, totalFare, 0.0);
    }

    @Test
    public void givenMultipleRides_WhenNormal_ShouldReturnInvoiceSummary() {
        InvoiceSummary invoiceDetails = invoiceService.generateInvoice(rides, CabRide.Normal);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 30);
        Assert.assertEquals(expectedInvoiceSummary, invoiceDetails);
    }

    @Test(expected = AssertionError.class)
    public void givenMultipleRides_WhenExpectedInvoiceSummaryIsWrongForTypeNormal_ShouldThrowAssertionError() {
        InvoiceSummary invoiceDetails = invoiceService.generateInvoice(rides, CabRide.Normal);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 300);
        Assert.assertEquals(expectedInvoiceSummary, invoiceDetails);
    }

    @Test
    public void givenMultipleRides_WhenPremium_ShouldReturnInvoiceSummary() {
        InvoiceSummary invoiceSummary = invoiceService.generateInvoice(rides, CabRide.Premium);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 60);
        Assert.assertEquals(expectedInvoiceSummary, invoiceSummary);
    }

    @Test(expected = AssertionError.class)
    public void givenMultipleRides_WhenExpectedInvoiceSummaryIsWrongForTypePremium_ShouldThrowAssertionError() {
        InvoiceSummary invoiceDetails = invoiceService.generateInvoice(rides, CabRide.Premium);
        InvoiceSummary expectedInvoiceSummary = new InvoiceSummary(2, 300);
        Assert.assertEquals(expectedInvoiceSummary, invoiceDetails);
    }

    @Test
    public void givenUserIdAndRides_WhenNormalType_ShouldReturnInvoiceSummary() {
        InvoiceSummary invoiceSummary = invoiceService.getInvoiceSummary(userId, CabRide.Normal);
        InvoiceSummary expectedSummary = new InvoiceSummary(2, 30);
        Assert.assertEquals(expectedSummary, invoiceSummary);
    }

    @Test(expected = NullPointerException.class)
    public void givenUserIdAndRides_WhenUserIdIsWrongForTypeNormal_ShouldThrowNullPointerException() {
        InvoiceSummary invoiceSummary = invoiceService.getInvoiceSummary("shreyaswaroop", CabRide.Normal);
        InvoiceSummary expectedSummary = new InvoiceSummary(2, 30);
        Assert.assertEquals(expectedSummary, invoiceSummary);
    }

    @Test(expected = NullPointerException.class)
    public void givenUserIdAndRides_WhenUserIdIsNullForTypeNormal_ShouldThrowNullPointerException() {
        InvoiceSummary invoiceSummary = invoiceService.getInvoiceSummary(null, CabRide.Normal);
        InvoiceSummary expectedSummary = new InvoiceSummary(2, 30);
        Assert.assertEquals(expectedSummary, invoiceSummary);
    }

    @Test(expected = NullPointerException.class)
    public void givenUserIdAndRides_WhenUserIdIsEmptyForTypeNormal_ShouldThrowNullPointerException() {
        InvoiceSummary invoiceSummary = invoiceService.getInvoiceSummary(" ", CabRide.Normal);
        InvoiceSummary expectedSummary = new InvoiceSummary(2, 30);
        Assert.assertEquals(expectedSummary, invoiceSummary);
    }

    @Test
    public void givenUserIdAndRides_WhenPremiumType_ShouldReturnInvoiceSummary() {
        InvoiceSummary invoiceSummary = invoiceService.getInvoiceSummary(userId, CabRide.Premium);
        InvoiceSummary expectedSummary = new InvoiceSummary(2, 60);
        Assert.assertEquals(expectedSummary, invoiceSummary);
    }

    @Test(expected = NullPointerException.class)
    public void givenUserIdAndRides_WhenUserIdIsWrongForTypePremium_ShouldThrowNullPointerException() {
        InvoiceSummary invoiceSummary = invoiceService.getInvoiceSummary("shreyaswaroop", CabRide.Premium);
        InvoiceSummary expectedSummary = new InvoiceSummary(2, 30);
        Assert.assertEquals(expectedSummary, invoiceSummary);
    }

    @Test(expected = NullPointerException.class)
    public void givenUserIdAndRides_WhenUserIdIsNullForTypePremium_ShouldThrowNullPointerException() {
        InvoiceSummary invoiceSummary = invoiceService.getInvoiceSummary(null, CabRide.Premium);
        InvoiceSummary expectedSummary = new InvoiceSummary(2, 30);
        Assert.assertEquals(expectedSummary, invoiceSummary);
    }

    @Test(expected = NullPointerException.class)
    public void givenUserIdAndRides_WhenUserIdIsEmptyForTypePremium_ShouldThrowNullPointerException() {
        InvoiceSummary invoiceSummary = invoiceService.getInvoiceSummary(" ", CabRide.Premium);
        InvoiceSummary expectedSummary = new InvoiceSummary(2, 30);
        Assert.assertEquals(expectedSummary, invoiceSummary);
    }

}
