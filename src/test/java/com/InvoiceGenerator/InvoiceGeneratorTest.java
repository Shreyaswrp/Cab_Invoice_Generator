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
    public void givenMultipleRides_WhenNormal_ShouldReturnInvoiceSummary() {
        RideDetails[] rides = {new RideDetails(2.0, 5),
                new RideDetails(0.1, 1)};
        InvoiceDetails invoiceSummary = invoiceGenerator.calculateTotalFare(rides);
        InvoiceDetails  expectedInvoiceSummary = new InvoiceDetails (2, 30);
        Assert.assertEquals(expectedInvoiceSummary, invoiceSummary);
    }
}
