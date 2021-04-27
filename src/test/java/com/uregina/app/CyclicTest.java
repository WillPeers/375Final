package com.uregina.app;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertEquals;
import java.util.ArrayList;

import com.uregina.exceptions.MoreThanOneDayException;
import com.uregina.exceptions.FlightHasSameArrivalAndDeparture;

import org.junit.Test;

import jdk.jfr.Timestamp;

/**
 * Unit test for simple App.
 */
public class CyclicTest 
{
    @Test
    public void noFlights() {
        try{
            ArrayList<Flight> ticket = new ArrayList<Flight>();

            assertFalse(Ticket.hasCyclicTrip(ticket));
        } catch(Exception e) {

        }
    }

    @Test
    public void oneFlight() {
        try{
            DateTime t1 = new DateTime(new Date(4, 25, 1999), new Time12(5, 30, AmPm.pm));

            Flight f1 = new Flight("YQR", "YYC", t1, t1);

            ArrayList<Flight> ticket = new ArrayList<Flight>();

            ticket.add(f1);

            assertFalse(Ticket.hasCyclicTrip(ticket));
        } catch(Exception e) {

        }
    }

    @Test(expected = FlightHasSameArrivalAndDeparture.class)
    public void oneFlight_Cyclic() {
        try{
            DateTime t1 = new DateTime(new Date(4, 25, 1999), new Time12(5, 30, AmPm.pm));

            Flight f1 = new Flight("YQR", "YQR", t1, t1);

            ArrayList<Flight> ticket = new ArrayList<Flight>();

            ticket.add(f1);

            assertFalse(Ticket.hasCyclicTrip(ticket));
        } catch(Exception e) {

        }
    }

    @Test
    public void multipleFlightsCyclic() {
        try{
            DateTime t1 = new DateTime(new Date(4, 25, 1999), new Time12(5, 30, AmPm.pm));

            Flight f1 = new Flight("YQR", "YYC", t1, t1);
            Flight f2 = new Flight("YYC", "YQR", t1, t1);

            ArrayList<Flight> ticket = new ArrayList<Flight>();

            ticket.add(f1);
            ticket.add(f2);

            assertTrue(Ticket.hasCyclicTrip(ticket));
        } catch(Exception e) {

        }
    }

    @Test
    public void multipleFlightsNonCyclic() {
        try{
            DateTime t1 = new DateTime(new Date(4, 25, 1999), new Time12(5, 30, AmPm.pm));

            Flight f1 = new Flight("YQR", "YYC", t1, t1);
            Flight f2 = new Flight("YYC", "YEG", t1, t1);

            ArrayList<Flight> ticket = new ArrayList<Flight>();

            ticket.add(f1);
            ticket.add(f2);

            assertFalse(Ticket.hasCyclicTrip(ticket));
        } catch(Exception e) {

        }
    }
}
