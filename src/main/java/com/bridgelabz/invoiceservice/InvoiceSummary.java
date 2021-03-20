package com.bridgelabz.invoiceservice;

public class InvoiceSummary {

    private final int noOfRides;
    public final double totalFare;
    private final double avgFair;

    public InvoiceSummary(int noOfRides, double totalFare) {
    this.noOfRides = noOfRides;
    this.totalFare = totalFare;
    this.avgFair = this.totalFare/this.noOfRides;
    }

    @Override
    public boolean equals(Object obj) {
        if(this == obj) return true;
        if (obj == null || getClass() !=getClass()) return false;
        InvoiceSummary that = (InvoiceSummary)  obj;
        return noOfRides == that.noOfRides && Double.compare(that.totalFare, totalFare) == 0 &&
                Double.compare(that.avgFair, avgFair) == 0;
    }
}
