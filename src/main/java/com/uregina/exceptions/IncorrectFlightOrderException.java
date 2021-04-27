package com.uregina.exceptions;
import java.io.*;
/**
 * Hello world!
 *
 */
public class IncorrectFlightOrderException extends Exception{
    public IncorrectFlightOrderException(){
		super("Incorrect Flight Order!");
	}
}
