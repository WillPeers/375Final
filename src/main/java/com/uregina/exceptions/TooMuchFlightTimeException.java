package com.uregina.exceptions;
import java.io.*;
/**
 * Hello world!
 *
 */
public class TooMuchFlightTimeException extends Exception{
    public TooMuchFlightTimeException(){
		super("Too much flight time!!!!");
	}
}
