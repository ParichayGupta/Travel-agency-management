package com.nymble.travelAgency.passenger;

import com.nymble.travelAgency.activity.Activity;
import com.nymble.travelAgency.destination.Destination;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

public class PassengerActivitiesTest {

    @Test
    void testSignUpForActivity() {
        Activity frozenLakeSkiing = new Activity("Frozen Lake skiing","Enjoy the skiing of the frozen lake",50, 10);
        Destination kedarKantha = new Destination("KedarKantha");
        kedarKantha.addActivity(frozenLakeSkiing);

        Passenger pax1 = new Passenger("Parichay", 101, 100, PassengerTypeEnum.STANDARD);

        // Test passenger sign up for activity
        boolean signedUp = pax1.signUpForActivity(frozenLakeSkiing);

        assertTrue(signedUp);
        assertEquals(1, pax1.getActivitiesEnrolled().size());
        assertEquals(50, pax1.getBalance());
    }

    @Test
    void testSignUpForActivityInsufficientFunds() {
        Activity trekking = new Activity("trekking", "Trek on the beautiful white snow of Himalayas", 50, 10);
        Destination Kedarkantha = new Destination("Kedar kantha");
        Kedarkantha.addActivity(trekking);

        Passenger pax1 = new Passenger("Ronit", 101, 30, PassengerTypeEnum.STANDARD);

        // Test passenger sign up for activity with insufficient funds
        boolean signedUp = pax1.signUpForActivity(trekking);

        assertFalse(signedUp);
        assertEquals(0, pax1.getActivitiesEnrolled().size());
        assertEquals(30, pax1.getBalance());
    }

    @Test
    void testSignUpForActivityFullCapacity() {
        Activity reachSummit = new Activity("Kedar Kantha Summit", "Enjoy the beautiful sunrise at Kedarkantha Mountain peak", 50, 0);
        Destination Kedarkantha = new Destination("Kedar Kantha");
        Kedarkantha.addActivity(reachSummit);

        Passenger pax1 = new Passenger("Ronit", 101, 100, PassengerTypeEnum.STANDARD);

        // Test passenger sign up for activity with full capacity
        boolean signedUp = pax1.signUpForActivity(reachSummit);

        assertFalse(signedUp);
        assertEquals(0, pax1.getActivitiesEnrolled().size());
        assertEquals(100, pax1.getBalance());
    }

    @Test
    void testGoldPassengerSignUpWithDiscount() {
        Activity reachSummit = new Activity("Kedar Kantha Summit", "Enjoy the beautiful sunrise at kedar Kantha Mountain peak", 50, 10);
        Destination kedarKantha = new Destination("Kedar Kantha");
        kedarKantha.addActivity(reachSummit);

        Passenger pax1 = new Passenger("Ram", 102, 100, PassengerTypeEnum.GOLD);

        // Test gold passenger sign up for activity with discount
        boolean signedUp = pax1.signUpForActivity(reachSummit);

        assertTrue(signedUp);
        assertEquals(1, pax1.getActivitiesEnrolled().size());
        assertEquals(55, pax1.getBalance());
    }
}
