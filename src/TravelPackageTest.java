import com.nymble.travelAgency.activity.Activity;
import com.nymble.travelAgency.destination.Destination;
import com.nymble.travelAgency.passenger.Passenger;
import com.nymble.travelAgency.passenger.PassengerTypeEnum;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertFalse;

public class TravelPackageTest {

    @Test
    public void testAddPassenger() {
        TravelPackage package1 = new TravelPackage("Mountains and Lakes", 3);
        Passenger pax1 = new Passenger("Raghav", 101, 100, PassengerTypeEnum.STANDARD);
        Passenger pax2 = new Passenger("Ronit", 102, 200, PassengerTypeEnum.GOLD);

        // Test adding passengers to the travel package
        package1.addPassenger(pax1);
        package1.addPassenger(pax2);

        assertEquals(2, package1.getPassengersEnrolled().size());
    }

    @Test
    void testAddDestinationToItinerary() {
        TravelPackage package1 = new TravelPackage("Mountains and Lakes", 3);
        Destination udaipur = new Destination("Udaipur");
        Destination kedarkantha = new Destination("KedarKantha");

        // Test adding destinations to the travel package
        package1.addDestinationToItinerary(udaipur);
        package1.addDestinationToItinerary(kedarkantha);

        assertEquals(2, package1.destinations.size());
    }

    @Test
    void testGoldPassengerSignUpWithInsufficientFunds() {
        Activity cityPalace = new Activity("City Palace", "", 50, 10);
        Destination udaipur = new Destination("Udaipur");
        udaipur.addActivity(cityPalace);

        TravelPackage package1 = new TravelPackage("Mountains and lakes", 3);
        package1.addDestinationToItinerary(udaipur);

        Passenger pax1 = new Passenger("Raghav", 1001, 10, PassengerTypeEnum.GOLD);

        // Test gold passenger sign up with insufficient funds
        boolean signUpResult = pax1.signUpForActivity(cityPalace);

        assertFalse(signUpResult);
        assertEquals(0, pax1.getActivitiesEnrolled().size());
        assertEquals(10, pax1.getBalance());
    }
}
