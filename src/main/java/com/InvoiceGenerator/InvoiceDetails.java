package com.InvoiceGenerator;

public class InvoiceDetails {

    private final int noOfRides;
    private final double totalFare;
    private final double average;

    public InvoiceDetails(int noOfRides, double totalFare) {
        this.noOfRides = noOfRides;
        this.totalFare = totalFare;
        this.average = this.totalFare / this.noOfRides;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        InvoiceDetails that = (InvoiceDetails) o;
        return noOfRides == that.noOfRides &&
                totalFare == that.totalFare &&
                average == that.average;
    }
}

