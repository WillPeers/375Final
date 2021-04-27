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
    public void AllEqual() {
        try{
            Date d1 = new Time12(4, 25, 1999);
            Date d2 = new Time12(4, 25, 1999);

            assertFalse(Date.lessThan(d1, d2));
        } catch(Exception e) {

        }
    }

    @Test
    public void d1AllSmaller() {
        try{
            Date d1 = new Time12(3, 24, 1998);
            Date d2 = new Time12(4, 25, 1999);

            assertTrue(Date.lessThan(d1, d2));
        } catch(Exception e) {

        }
    }

    @Test
    public void d1AllBigger() {
        try{
            Date d1 = new Time12(5, 26, 2000);
            Date d2 = new Time12(4, 25, 1999);

            assertFalse(Date.lessThan(d1, d2));
        } catch(Exception e) {

        }
    }

    @Test
    public void d1DaySmaller_d1MonthSmaller_d1YearBigger() {
        try{
            Date d1 = new Time12(3, 24, 2000);
            Date d2 = new Time12(4, 25, 1999);

            assertFalse(Date.lessThan(d1, d2));
        } catch(Exception e) {

        }
    }

    @Test
    public void d1DaySmaller_d1MonthSmaller_d1YearSame() {
        try{
            Date d1 = new Time12(3, 24, 1999);
            Date d2 = new Time12(4, 25, 1999);

            assertFalse(Date.lessThan(d1, d2));
        } catch(Exception e) {

        }
    }

    @Test
    public void d1DaySmaller_d1MonthBigger_d1YearSmaller() {
        try{
            Date d1 = new Time12(5, 24, 1998);
            Date d2 = new Time12(4, 25, 1999);

            assertTrue(Date.lessThan(d1, d2));
        } catch(Exception e) {

        }
    }

    @Test
    public void d1DaySmaller_d1MonthBigger_d1YearBigger() {
        try{
            Date d1 = new Time12(5, 24, 2000);
            Date d2 = new Time12(4, 25, 1999);

            assertFalse(Date.lessThan(d1, d2));
        } catch(Exception e) {

        }
    }

    @Test
    public void d1DaySmaller_d1MonthBigger_d1YearSame() {
        try{
            Date d1 = new Time12(5, 24, 1999);
            Date d2 = new Time12(4, 25, 1999);

            assertFalse(Date.lessThan(d1, d2));
        } catch(Exception e) {

        }
    }

    @Test
    public void d1DaySmaller_d1MonthSame_d1YearSmaller() {
        try{
            Date d1 = new Time12(4, 24, 1998);
            Date d2 = new Time12(4, 25, 1999);

            assertTrue(Date.lessThan(d1, d2));
        } catch(Exception e) {

        }
    }

    @Test
    public void d1DaySmaller_d1MonthSame_d1YearBigger() {
        try{
            Date d1 = new Time12(4, 24, 2000);
            Date d2 = new Time12(4, 25, 1999);

            assertFalse(Date.lessThan(d1, d2));
        } catch(Exception e) {

        }
    }

    @Test
    public void d1DaySmaller_d1MonthSame_d1YearSame() {
        try{
            Date d1 = new Time12(4, 24, 1999);
            Date d2 = new Time12(4, 25, 1999);

            assertTrue(Date.lessThan(d1, d2));
        } catch(Exception e) {

        }
    }

    @Test
    public void d1DayBigger_d1MonthSmaller_d1YearBigger() {
        try{
            Date d1 = new Time12(3, 26, 2000);
            Date d2 = new Time12(4, 25, 1999);

            assertFalse(Date.lessThan(d1, d2));
        } catch(Exception e) {

        }
    }

    @Test
    public void d1DayBigger_d1MonthSmaller_d1YearSame() {
        try{
            Date d1 = new Time12(3, 26, 1999);
            Date d2 = new Time12(4, 25, 1999);

            assertFalse(Date.lessThan(d1, d2));
        } catch(Exception e) {

        }
    }

    @Test
    public void d1DayBigger_d1MonthBigger_d1YearSmaller() {
        try{
            Date d1 = new Time12(5, 26, 1998);
            Date d2 = new Time12(4, 25, 1999);

            assertTrue(Date.lessThan(d1, d2));
        } catch(Exception e) {

        }
    }

    @Test
    public void d1DayBigger_d1MonthBigger_d1YearBigger() {
        try{
            Date d1 = new Time12(5, 26, 2000);
            Date d2 = new Time12(4, 25, 1999);

            assertFalse(Date.lessThan(d1, d2));
        } catch(Exception e) {

        }
    }

    @Test
    public void d1DayBigger_d1MonthBigger_d1YearSame() {
        try{
            Date d1 = new Time12(5, 26, 1999);
            Date d2 = new Time12(4, 25, 1999);

            assertFalse(Date.lessThan(d1, d2));
        } catch(Exception e) {

        }
    }

    @Test
    public void d1DayBigger_d1MonthSame_d1YearSmaller() {
        try{
            Date d1 = new Time12(4, 26, 1998);
            Date d2 = new Time12(4, 25, 1999);

            assertTrue(Date.lessThan(d1, d2));
        } catch(Exception e) {

        }
    }

    @Test
    public void d1DayBigger_d1MonthSame_d1YearBigger() {
        try{
            Date d1 = new Time12(4, 26, 2000);
            Date d2 = new Time12(4, 25, 1999);

            assertFalse(Date.lessThan(d1, d2));
        } catch(Exception e) {

        }
    }

    @Test
    public void d1DaySame_d1MonthSmaller_d1YearBigger() {
        try{
            Date d1 = new Time12(3, 26, 2000);
            Date d2 = new Time12(4, 25, 1999);

            assertFalse(Date.lessThan(d1, d2));
        } catch(Exception e) {

        }
    }

    @Test
    public void d1DaySame_d1MonthSmaller_d1YearSame() {
        try{
            Date d1 = new Time12(3, 26, 1999);
            Date d2 = new Time12(4, 25, 1999);

            assertTrue(Date.lessThan(d1, d2));
        } catch(Exception e) {

        }
    }

    @Test
    public void d1DaySame_d1MonthBigger_d1YearSmaller() {
        try{
            Date d1 = new Time12(5, 25, 1998);
            Date d2 = new Time12(4, 25, 1999);

            assertTrue(Date.lessThan(d1, d2));
        } catch(Exception e) {

        }
    }

    @Test
    public void d1DaySame_d1MonthBigger_d1YearBigger() {
        try{
            Date d1 = new Time12(5, 25, 2000);
            Date d2 = new Time12(4, 25, 1999);

            assertFalse(Date.lessThan(d1, d2));
        } catch(Exception e) {

        }
    }

    @Test
    public void d1DaySame_d1MonthBigger_d1YearSame() {
        try{
            Date d1 = new Time12(5, 25, 1999);
            Date d2 = new Time12(4, 25, 1999);

            assertFalse(Date.lessThan(d1, d2));
        } catch(Exception e) {

        }
    }

    @Test
    public void d1DaySame_d1MonthSame_d1YearSmaller() {
        try{
            Date d1 = new Time12(4, 25, 1998);
            Date d2 = new Time12(4, 25, 1999);

            assertTrue(Date.lessThan(d1, d2));
        } catch(Exception e) {

        }
    }

    @Test
    public void d1DaySame_d1MonthSame_d1YearBigger() {
        try{
            Date d1 = new Time12(4, 25, 2000);
            Date d2 = new Time12(4, 25, 1999);

            assertFalse(Date.lessThan(d1, d2));
        } catch(Exception e) {

        }
    }

    @Test
    public void d1DayBigger_d1MonthSame_d1YearSame() {
        try{
            Date d1 = new Time12(4, 26, 1999);
            Date d2 = new Time12(4, 25, 1999);

            assertFalse(Date.lessThan(d1, d2));
        } catch(Exception e) {

        }
    }
}
