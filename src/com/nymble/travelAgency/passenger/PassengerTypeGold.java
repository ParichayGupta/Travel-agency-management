package com.nymble.travelAgency.passenger;

public class PassengerTypeGold {
    /*
    * A Gold Passenger Type can signup if his balance is more than
    * or equal to the cost after applying 10% discount to the cost.
    *
    * @param double
    * @param double
    * @returns boolean
    * */
    public static boolean canSignUp(double balance, double cost) {
        return balance >= (cost * 0.9);
    }

    /*
    * For Gold Passenger type there should be a
    * discount of 10% on the original cost of the activity.
    *
    * @param double
    * @returns double
    * */

    public static double activityCost(double cost) {
        return cost * 0.9;
    }
}
