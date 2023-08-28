import com.nymble.travelAgency.activity.Activity;
import com.nymble.travelAgency.passenger.Passenger;

import com.nymble.travelAgency.destination.Destination;
import java.util.ArrayList;
import java.util.List;

public class TravelPackage {

    String name;
    int capacity;
    List<Destination> destinations = new ArrayList<>();
    List<Passenger> passengersEnrolled = new ArrayList<>();

    public TravelPackage(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getCapacity() {
        return capacity;
    }

    public void setCapacity(int capacity) {
        this.capacity = capacity;
    }

    public List<Destination> getDestinations() {
        return destinations;
    }

    public void setDestinations(List<Destination> destinations) {
        this.destinations = destinations;
    }

    public List<Passenger> getPassengersEnrolled() {
        return passengersEnrolled;
    }

    public void setPassengersEnrolled(List<Passenger> passengersEnrolled) {
        this.passengersEnrolled = passengersEnrolled;
    }

    public void addDestinationToItinerary(Destination destination){
        this.destinations.add(destination);
    }

    public void addPassenger(Passenger passenger){
        if(passengersEnrolled.size() < capacity){
            passengersEnrolled.add(passenger);
        }
    }

    public void printItinerary (){
        System.out.println("Travel Package: " + name);
        int destinationCount = 0;
        for(Destination destination: destinations){
            destinationCount++;
            System.out.println("Destination"+destinationCount+": "+ destination.getDestinationName());
            int activitiesCount = 0;
            for(Activity activity: destination.getActivities()){
                System.out.println("Activity"+ ++activitiesCount +": "+ activity.getName()+
                        ", cost: "+activity.getCost()+
                        ", capacity: "+activity.getCapacity()+
                        ", description: "+activity.getDescription());
            }
        }
    }

    public void printPassengers(){
        System.out.println("Travel Package: " + name);
        System.out.println("Passenger Capacity: "+ capacity);
        System.out.println(("total passenger Enrolled: "+ passengersEnrolled.size()));
        for(Passenger passenger: passengersEnrolled){
            System.out.println("Passenger name: "+ passenger.getName()+
                    ", Passenger Number: "+passenger.getPassengerNumber());
        }
    }
}
