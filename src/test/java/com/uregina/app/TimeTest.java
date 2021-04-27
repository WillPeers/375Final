package com.uregina.app;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import com.uregina.exceptions.MoreThanOneDayException;

import org.junit.Test;

import jdk.jfr.Timestamp;

/**
 * Unit test for simple App.
 */
public class TimeTest 
{
    @Test
    public void time1AM_time2PM_ValidTimes() {
        try{
            Time12 t1 = new Time12(10, 30, AmPm.am);
            Time12 t2 = new Time12(5, 40, AmPm.pm);

            int diff = Time12.subtract(t1, t2);

            assertEquals(430, diff);
        } catch(Exception e) {

        }
    }

    @Test
    public void time1PM_time2AM_ValidTimes() {
        try{
            Time12 t1 = new Time12(1, 30, AmPm.pm);
            Time12 t2 = new Time12(5, 40, AmPm.am);

            int diff = Time12.subtract(t1, t2);

            assertEquals(490, diff);
        } catch(Exception e) {

        }
    }

    @Test
    public void bothAM_ValidTimes() {
        try{
            Time12 t1 = new Time12(2, 30, AmPm.am);
            Time12 t2 = new Time12(5, 40, AmPm.am);

            int diff = Time12.subtract(t1, t2);

            assertEquals(190, diff);
        } catch(Exception e) {

        }
    }

    @Test
    public void bothPM_ValidTimes() {
        try{
            Time12 t1 = new Time12(5, 30, AmPm.pm);
            Time12 t2 = new Time12(5, 40, AmPm.pm);

            int diff = Time12.subtract(t1, t2);

            assertEquals(10, diff);
        } catch(Exception e) {

        }
    }
}
