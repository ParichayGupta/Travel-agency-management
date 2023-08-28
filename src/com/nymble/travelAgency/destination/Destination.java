package com.nymble.travelAgency.destination;

import com.nymble.travelAgency.activity.Activity;

import java.util.ArrayList;
import java.util.List;

public class Destination {
    String destinationName;
    List<Activity> activities = new ArrayList<>();

    public Destination(String destinationName) {
        this.destinationName = destinationName;
    }

    public Destination(String destinationName, List<Activity> activities) {
        this.destinationName = destinationName;
        this.activities = activities;
    }

    public String getDestinationName() {
        return destinationName;
    }

    public void setDestinationName(String destinationName) {
        this.destinationName = destinationName;
    }

    public List<Activity> getActivities() {
        return activities;
    }

    public void setActivities(List<Activity> activities) {
        this.activities = activities;
    }

    public void addActivity(Activity activity) {
        activities.add(activity);
    }
}
