package com.uregina.app;

import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertEquals;

import com.uregina.exceptions.MoreThanOneDayException;

import org.junit.Test;

import jdk.jfr.Timestamp;

/**
 * Unit test for simple App.
 */
public class Time24Test 
{
    @Test
    public void BothAM() {
        try{
            Time24 expected1 = new Time24(5, 30);
            Time24 expected2 = new Time24(5, 40);

            Time12 t1 = new Time12(5, 30, AmPm.am);
            Time12 t2 = new Time12(5, 40, AmPm.am);

            Time24 time1 = t1.toTime24();
            Time24 time2 = t2.toTime24();

            assertEquals(expected1.getMinutes(), time1.getMinutes());
            assertEquals(expected1.getHours(), time1.getHours());
            assertEquals(expected2.getMinutes(), time2.getMinutes());
            assertEquals(expected2.getHours(), time2.getHours());
        } catch(Exception e) {

        }
    }

    @Test
    public void BothPM() {
        try{
            Time24 expected1 = new Time24(19, 34);
            Time24 expected2 = new Time24(17, 40);

            Time12 t1 = new Time12(7, 34, AmPm.pm);
            Time12 t2 = new Time12(5, 40, AmPm.pm);

            Time24 time1 = t1.toTime24();
            Time24 time2 = t2.toTime24();

            assertEquals(expected1.getMinutes(), time1.getMinutes());
            assertEquals(expected1.getHours(), time1.getHours());
            assertEquals(expected2.getMinutes(), time2.getMinutes());
            assertEquals(expected2.getHours(), time2.getHours());
        } catch(Exception e) {

        }
    }

    @Test
    public void Am_Pm() {
        try{
            Time24 expected1 = new Time24(5, 30);
            Time24 expected2 = new Time24(17, 40);

            Time12 t1 = new Time12(5, 30, AmPm.am);
            Time12 t2 = new Time12(5, 40, AmPm.pm);

            Time24 time1 = t1.toTime24();
            Time24 time2 = t2.toTime24();

            assertEquals(expected1.getMinutes(), time1.getMinutes());
            assertEquals(expected1.getHours(), time1.getHours());
            assertEquals(expected2.getMinutes(), time2.getMinutes());
            assertEquals(expected2.getHours(), time2.getHours());
        } catch(Exception e) {

        }
    }

    @Test
    public void Pm_Am() {
        try{
            Time24 expected1 = new Time24(17, 30);
            Time24 expected2 = new Time24(5, 40);

            Time12 t1 = new Time12(5, 30, AmPm.pm);
            Time12 t2 = new Time12(5, 40, AmPm.am);

            Time24 time1 = t1.toTime24();
            Time24 time2 = t2.toTime24();

            assertEquals(expected1.getMinutes(), time1.getMinutes());
            assertEquals(expected1.getHours(), time1.getHours());
            assertEquals(expected2.getMinutes(), time2.getMinutes());
            assertEquals(expected2.getHours(), time2.getHours());
        } catch(Exception e) {

        }
    }
}
