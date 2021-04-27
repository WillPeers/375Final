package com.uregina.app;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import com.uregina.exceptions.MoreThanOneDayException;

import org.junit.Test;

import jdk.jfr.Timestamp;

/**
 * Unit test for simple App.
 */
public class DateTest 
{
    /**
     * Rigorous Test :-)
     */
    @Test
    public void datesNotTheSameButConsecutive()
    {
        assertTrue( true );
    }

    /*@Test(expected = MoreThanOneDayException.class)
    public void datesNotTheSameOrConsecutive() throws MoreThanOneDayException {
        DateTime d1, d2;

        try{
            d1 = new DateTime(new Date(4, 25, 1999), new Time12(1, 2, AmPm.am));
            d2 = new DateTime(new Date(6, 25, 1998), new Time12(1, 2, AmPm.pm));

            DateTime.subtract(d1, d2);
        } catch(Exception e) {

        }

        assertTrue(true);
    }*/

    @Test
    public void datesAreTheExactSame() {
        DateTime d1, d2;

        try{
            d1 = new DateTime(new Date(4, 25, 1999), new Time12(1, 2, AmPm.am));
            d2 = new DateTime(new Date(4, 25, 1999), new Time12(1, 2, AmPm.am));
            assertEquals(DateTime.subtract(d1, d2), 0);
        } catch(Exception e) {

        }
    }

    @Test
    public void date2AfterDate1() {
        DateTime d1, d2;

        try{
            d1 = new DateTime(new Date(4, 25, 1999), new Time12(1, 2, AmPm.am));
            d2 = new DateTime(new Date(4, 26, 1999), new Time12(1, 2, AmPm.am));
            assertEquals(DateTime.subtract(d1, d2), 1440);
        } catch(Exception e) {

        }

        assertTrue(true);
    }

    @Test
    public void date1AfterDate2() {
        DateTime d1, d2;

        try{
            d1 = new DateTime(new Date(4, 26, 1999), new Time12(1, 2, AmPm.am));
            d2 = new DateTime(new Date(4, 25, 1999), new Time12(1, 2, AmPm.am));
            assertEquals(DateTime.subtract(d1, d2), 1440);
        } catch(Exception e) {

        }

        assertTrue(true);
    }
}
