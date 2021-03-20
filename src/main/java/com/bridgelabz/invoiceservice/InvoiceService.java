package com.bridgelabz.invoiceservice;

public class InvoiceService {
    private static final int MINIMUM_COST_PER_KM = 10;
    private static final int COST_PER_TIME = 1;
    private static final double MINIMUM_FARE = 5.0;

    public double calculateFare(double distance, int time) {
        return Math.max((distance * MINIMUM_COST_PER_KM + time * COST_PER_TIME), MINIMUM_FARE);
    }
    public InvoiceSummary calculateFare(Ride[] rides, int userID){
        double totalFare = 0;
        for(Ride ride : rides){
           totalFare += this.calculateFare(ride.distance, ride.time);
        }
        InvoiceSummary summary = new InvoiceSummary(rides.length, totalFare) ;
        RideRepository.addRide(userID, summary);
        return summary;
    }

}
