import com.nymble.travelAgency.activity.Activity;
import com.nymble.travelAgency.destination.Destination;
import com.nymble.travelAgency.passenger.Passenger;
import com.nymble.travelAgency.passenger.PassengerActivities;
import com.nymble.travelAgency.passenger.PassengerTypeEnum;

import java.util.ArrayList;
import java.util.List;

// Press Shift twice to open the Search Everywhere dialog and type `show whitespaces`,
// then press Enter. You can now see whitespace characters in your code.
public class Main {
    public static void main(String[] args) {
        Destination udaipur = new Destination("Udaipur");


        Activity cityPalace = new Activity("City Palace", "The Maratha Empire Palace", 300, 10);
        Activity jagMandir = new Activity("Jag Mandir", "The Temple on an Island dedicated to lord Jagdish", 250, 20);
        List<Activity> udaipurActivities = new ArrayList<>();
        udaipurActivities.add(cityPalace);
        udaipurActivities.add(jagMandir);
        udaipur.setActivities(udaipurActivities);

        Destination kedarKantha = new Destination("Kedar Kantha");
        Activity trekking = new Activity("Trekking", "Trek on the beautiful white snow of Himalayas", 5000, 3);
        Activity frozenLakeSkiing = new Activity("Frozen Lake skiing","Enjoy the skiing of the frozen lake", 400, 3);
        Activity reachSummit = new Activity("Kedar Kantha Summit", "Enjoy the beautiful sunrise at Kedarkantha Mountain peak", 100, 3);
        List<Activity> kedarKanthaActivities = new ArrayList<>();
        kedarKanthaActivities.add(trekking);
        kedarKanthaActivities.add(frozenLakeSkiing);
        kedarKanthaActivities.add((reachSummit));
        kedarKantha.setActivities(kedarKanthaActivities);

        TravelPackage package1 = new TravelPackage("Mountains and the Lakes", 3);
        package1.addDestinationToItinerary(udaipur);
        package1.addDestinationToItinerary(kedarKantha);

        Passenger pax1 = new Passenger("Raghav Gupta",1001,5000, PassengerTypeEnum.PREMIUM);
        Passenger pax2 = new Passenger("Rohin Malhotra", 1002, 4000, PassengerTypeEnum.GOLD);
        Passenger pax3 = new Passenger("Parichay Gupta", 1003, 1000, PassengerTypeEnum.STANDARD);

        package1.addPassenger(pax1);
        package1.addPassenger(pax2);
        package1.addPassenger(pax3);

        pax1.signUpForActivity(cityPalace);
        pax1.signUpForActivity(trekking);
        pax1.signUpForActivity(reachSummit);
        pax2.signUpForActivity(frozenLakeSkiing);
        pax2.signUpForActivity(jagMandir);
        pax3.signUpForActivity(trekking);
        pax3.signUpForActivity(jagMandir);

        package1.printItinerary();
        package1.printPassengers();

    }
}