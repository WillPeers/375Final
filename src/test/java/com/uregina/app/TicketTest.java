package com.uregina.app;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;
import com.uregina.exceptions.*;

import java.util.ArrayList;

import org.junit.Test;

import jdk.jfr.Timestamp;

/**
 * Unit test for simple App.
 */
public class TicketTest 
{
    @Test(expected = InvalidIATAException.class)
    public void invalidIATA() {
        DateTime d1, d2;

        try{
            d1 = new DateTime(new Date(4, 25, 1999), new Time12(1, 2, AmPm.am));
            d2 = new DateTime(new Date(4, 25, 1999), new Time12(10, 2, AmPm.pm));

            ArrayList<Flight> ticket = new ArrayList<Flight>();
            ticket.add(new Flight("YQRRRRRR", "D", d1, d2));           

            assertFalse(Ticket.checkTicket(ticket, 3, 1, 10000000, true));
        } catch(Exception e) {
            System.out.println("Whoops 0" + e.getMessage());
        }
    }

    @Test
    public void tooManyFlights() {
        DateTime d1, d2;

        try{
            d1 = new DateTime(new Date(4, 25, 1999), new Time12(1, 2, AmPm.am));
            d2 = new DateTime(new Date(4, 25, 1999), new Time12(2, 2, AmPm.pm));

            ArrayList<Flight> ticket = new ArrayList<Flight>();
            ticket.add(new Flight("YQR", "DAA", d1, d2));           

            assertFalse(Ticket.checkTicket(ticket, 0, 1, 1, true));
        } catch(Exception e) {
            System.out.println("Whoops 7" + e.getMessage());
        }
    }

    @Test(expected = TooMuchFlightTimeException.class)
    public void tooMuchFlightTime() {
        DateTime d1, d2;

        try{
            d1 = new DateTime(new Date(4, 25, 1999), new Time12(1, 2, AmPm.am));
            d2 = new DateTime(new Date(4, 25, 1999), new Time12(10, 2, AmPm.pm));

            ArrayList<Flight> ticket = new ArrayList<Flight>();
            ticket.add(new Flight("YQR", "DAA", d1, d2));           

            assertFalse(Ticket.checkTicket(ticket, 3, 1, 10000000, true));
        } catch(Exception e) {
            System.out.println("Whoops 6" + e.getMessage());
        }
    }

    @Test(expected = TooMuchFlightTimeException.class)
    public void tooMuchLayover() {
        DateTime d1, d2, d3, d4;

        try{
            d1 = new DateTime(new Date(4, 25, 1999), new Time12(1, 2, AmPm.am));
            d2 = new DateTime(new Date(4, 25, 1999), new Time12(2, 2, AmPm.pm));

            d3 = new DateTime(new Date(4, 26, 1999), new Time12(1, 2, AmPm.am));
            d4 = new DateTime(new Date(4, 26, 1999), new Time12(2, 2, AmPm.pm));

            ArrayList<Flight> ticket = new ArrayList<Flight>();
            ticket.add(new Flight("YQR", "DAA", d1, d2));
            ticket.add(new Flight("DAA", "BRU", d3, d4));           

            assertFalse(Ticket.checkTicket(ticket, 3, 10000000, 1, true));
        } catch(Exception e) {
            System.out.println("Whoops 5" + e.getMessage());
        }
    }

    @Test(expected = IncorrectFlightOrderException.class)
    public void triggerIncorrectFlightOrder() {
        DateTime d1, d2, d3, d4;

        try{
            d1 = new DateTime(new Date(4, 25, 1999), new Time12(1, 2, AmPm.am));
            d2 = new DateTime(new Date(4, 25, 1999), new Time12(2, 2, AmPm.pm));

            d3 = new DateTime(new Date(4, 26, 1999), new Time12(1, 2, AmPm.am));
            d4 = new DateTime(new Date(4, 26, 1999), new Time12(2, 2, AmPm.pm));

            ArrayList<Flight> ticket = new ArrayList<Flight>();
            ticket.add(new Flight("YQR", "DAA", d1, d2));
            ticket.add(new Flight("VIE", "BRU", d3, d4));           

            assertFalse(Ticket.checkTicket(ticket, 3, 10000000, 1, true));
        } catch(Exception e) {
            System.out.println("Whoops 9" + e.getMessage());
        }
    }

    @Test
    public void noSchengenVisa() {
        //"VIE","BRU"
        DateTime d1, d2;

        try{
            d1 = new DateTime(new Date(4, 25, 1999), new Time12(1, 2, AmPm.am));
            d2 = new DateTime(new Date(4, 25, 1999), new Time12(2, 2, AmPm.pm));

            ArrayList<Flight> ticket = new ArrayList<Flight>();
            ticket.add(new Flight("VIE", "BRU", d1, d2));           

            assertFalse(Ticket.checkTicket(ticket, 100000, 9999999, 10000000, false));
        } catch(Exception e) {
            System.out.println("Whoops 4" + e.getMessage());
        }
    }

    @Test
    public void hasSchengenVisa() {
        //"VIE","BRU"
        DateTime d1, d2;

        try{
            d1 = new DateTime(new Date(4, 25, 1999), new Time12(1, 2, AmPm.am));
            d2 = new DateTime(new Date(4, 25, 1999), new Time12(2, 2, AmPm.pm));

            ArrayList<Flight> ticket = new ArrayList<Flight>();
            ticket.add(new Flight("VIE", "BRU", d1, d2));           

            assertTrue(Ticket.checkTicket(ticket, 100000, 9999999, 10000000, true));
        } catch(Exception e) {
            System.out.println("Whoops 3" + e.getMessage());
        }
    }

    @Test
    public void isCyclicTrip() {
        DateTime d1, d2, d3, d4;

        try{
            d1 = new DateTime(new Date(4, 25, 1999), new Time12(1, 2, AmPm.am));
            d2 = new DateTime(new Date(4, 25, 1999), new Time12(2, 2, AmPm.pm));

            d3 = new DateTime(new Date(4, 26, 1999), new Time12(1, 2, AmPm.am));
            d4 = new DateTime(new Date(4, 26, 1999), new Time12(2, 2, AmPm.pm));

            ArrayList<Flight> ticket = new ArrayList<Flight>();
            ticket.add(new Flight("YQR", "DAA", d1, d2));
            ticket.add(new Flight("DAA", "YQR", d3, d4));           

            assertFalse(Ticket.checkTicket(ticket, 30000, 10000000, 1000000, true));
        } catch(Exception e) {
            System.out.println("Whoops 2" + e.getMessage());
        }
    }

    @Test
    public void validFlights() {
        DateTime d1, d2, d3, d4;

        try{
            d1 = new DateTime(new Date(4, 25, 1999), new Time12(1, 2, AmPm.am));
            d2 = new DateTime(new Date(4, 25, 1999), new Time12(2, 2, AmPm.pm));

            d3 = new DateTime(new Date(4, 26, 1999), new Time12(1, 2, AmPm.am));
            d4 = new DateTime(new Date(4, 26, 1999), new Time12(2, 2, AmPm.pm));

            ArrayList<Flight> ticket = new ArrayList<Flight>();
            ticket.add(new Flight("YQR", "DAA", d1, d2));
            ticket.add(new Flight("DAA", "BRU", d3, d4));           

            assertFalse(Ticket.checkTicket(ticket, 30000, 10000000, 1000000, true));
        } catch(Exception e) {
            System.out.println("Whoops 1" + e.getMessage());
        }
    }
}
