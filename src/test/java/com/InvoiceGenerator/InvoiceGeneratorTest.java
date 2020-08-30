package com.InvoiceGenerator;

import org.junit.Assert;
import org.junit.Test;

public class InvoiceGeneratorTest {

    @Test
    public void givenRideDetails_WhenCorrect_ShouldReturnFare(){

            InvoiceGenerator invoiceGenerator = new InvoiceGenerator();
            int fare = invoiceGenerator.calculateFare(11, 30);
            Assert.assertEquals(140, fare);

    }
}
