package com.bridgelabz.invoiceservice;

public class InvoiceService {
    private static final int MINIMUM_COST_PER_KM [] = new int[]{10,15};
    private static final int COST_PER_TIME [] = new int[]{1, 2};
    private static final double MINIMUM_FARE []= new double[]{5.0, 20.0};

    public static final int NORMAL_RIDE = 0, PREMIUM_RIDE = 1;


    public double calculateFare(double distance, int time, int rideType) {
        return Math.max((distance * MINIMUM_COST_PER_KM[rideType] + time * COST_PER_TIME[rideType]), MINIMUM_FARE[rideType]);
    }
    public InvoiceSummary calculateFare(Ride[] rides, int userID, int rideType){
        double totalFare = 0;
        for(Ride ride : rides){
           totalFare += this.calculateFare(ride.distance, ride.time, rideType);
        }
        InvoiceSummary summary = new InvoiceSummary(rides.length, totalFare) ;
        RideRepository.addRide(userID, summary);
        return summary;
    }

}
