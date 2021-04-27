package com.uregina.exceptions;
import java.io.*;
/**
 * Hello world!
 *
 */
public class FlightHasSameArrivalAndDeparture extends Exception{
    public FlightHasSameArrivalAndDeparture(){
		super("Flight cannot have same arrival and departure airports");
	}
}
