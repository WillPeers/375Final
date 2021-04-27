package com.uregina.exceptions;
import java.io.*;
/**
 * Hello world!
 *
 */
public class InvalidIATAException extends Exception{
    public InvalidIATAException(){
		super("Airport codes must be three letters");
	}
}
