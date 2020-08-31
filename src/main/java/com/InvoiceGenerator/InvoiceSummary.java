package com.InvoiceGenerator;

public class InvoiceSummary {

    private final int NO_OF_RIDES;
    private final double TOTAL_FARE;
    private final double AVERAGE;

    public InvoiceSummary(int noOfRides, double totalFare) {
        this.NO_OF_RIDES = noOfRides;
        this.TOTAL_FARE = totalFare;
        this.AVERAGE = this.TOTAL_FARE / this.NO_OF_RIDES;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceSummary that = (InvoiceSummary) o;
        return NO_OF_RIDES == that.NO_OF_RIDES &&
                TOTAL_FARE == that.TOTAL_FARE &&
                AVERAGE == that.AVERAGE;
    }
}

