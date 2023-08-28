package com.nymble.travelAgency.passenger;

public interface PassengerActivities {

    boolean canSignUp(double balance, double cost);

    double activityCost(double cost);
}
