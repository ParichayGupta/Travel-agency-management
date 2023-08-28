package com.nymble.travelAgency.passenger;

import com.nymble.travelAgency.activity.Activity;

import java.util.ArrayList;
import java.util.List;

public class Passenger {

    private String name;
    private int passengerNumber;
    private double balance;
    private PassengerTypeEnum passengerTypeEnum;
    private List<Activity> activitiesEnrolled = new ArrayList<>();

    public Passenger(String name, int passengerNumber, double balance, PassengerTypeEnum passengerTypeEnum) {
        this.name = name;
        this.passengerNumber = passengerNumber;
        this.balance = balance;
        this.passengerTypeEnum = passengerTypeEnum;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getPassengerNumber() {
        return passengerNumber;
    }

    public void setPassengerNumber(int passengerNumber) {
        this.passengerNumber = passengerNumber;
    }

    public double getBalance() {
        return balance;
    }

    public void setBalance(double balance) {
        this.balance = balance;
    }

    public PassengerTypeEnum getPassengerTypeEnum() {
        return passengerTypeEnum;
    }

    public void setPassengerTypeEnum(PassengerTypeEnum passengerTypeEnum) {
        this.passengerTypeEnum = passengerTypeEnum;
    }

    public List<Activity> getActivitiesEnrolled() {
        return activitiesEnrolled;
    }

    public void setActivitiesEnrolled(List<Activity> activitiesEnrolled) {
        this.activitiesEnrolled = activitiesEnrolled;
    }

    public boolean signUpForActivity(Activity activity) {
        if (activity.getCapacity() > 0) {
            if (passengerTypeEnum.equals(PassengerTypeEnum.STANDARD)) {
                if (PassengerTypeStandard.canSignUp(balance, activity.getCost())) {
                    activitiesEnrolled.add(activity);
                    balance -= activity.getCost();
                    activity.setCapacity(activity.getCapacity() - 1);
                    return true;
                }
            } else if (passengerTypeEnum.equals(PassengerTypeEnum.GOLD)) {
                if (PassengerTypeGold.canSignUp(balance, activity.getCost())) {
                    activitiesEnrolled.add(activity);
                    balance -= PassengerTypeGold.activityCost(activity.getCost());
                    activity.setCapacity(activity.getCapacity() - 1);
                    return true;
                }
            } else if (passengerTypeEnum.equals(PassengerTypeEnum.PREMIUM)) {
                activitiesEnrolled.add(activity);
                activity.setCapacity(activity.getCapacity() - 1);
                return true;
            }
        }
        return false;
    }
}
