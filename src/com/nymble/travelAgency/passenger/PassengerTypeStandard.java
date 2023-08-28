package com.nymble.travelAgency.passenger;

public class PassengerTypeStandard {
    public static boolean canSignUp(double balance, double cost) {
        return balance >= cost;
    }
    public static double activityCost(double cost) {
        return cost;
    }
}
