package com.uregina.app;

import com.uregina.exceptions.*;
import java.util.ArrayList;
import java.util.Arrays;
import com.uregina.app.Flight;
/**
 * Class Ticket, a List of Flights in ordered sequences
 *
 */
public class Ticket
{
	
	private static final String [] SchengenAirportsCode = new String[] { "VIE","BRU","PRG","CPH","TLL","HEL","CDG","FRA","MUC","ATH","BUD","KEF","CIA","RIX","VNO","LUX","MLA","AMS","OSL","WAW","LIS","LJU","KSC","MAD","ARN","BRN"};
	/**
	 * The function checks the validaity of a ticket
	 * It checks
	 *		1. airports code are in IATA format (any three uppercases letters)
	 *		2. maximum flights Count <= number of flights in the ticket
	 *		3. maximum flight time <= Total flight times ( sum of flight time of each flight)
	 *		4. maximum layover time <= Total layover times ( sum of layover time between each consequative flight)
	 *		5. no flight between two airports in the Schengen area unless the passenger has a valid SchengenVisa
	 *		6. no cyclic trip
	 *		7. The sequence of flights in correct ( the arrival airport of a flight is the departure airport of the next flight)
	 * 		8. any other logical constraints 
	 * @param	ticket				List of ordered sequences of flights
	 * @param	maxFlightsCount		Maximum number of flights in the ticket
	 * @param	maxFlightTime		Maximum allowable total flight times in minutes
	 * @param	maxLayoverTime		Maximum allowable total layover times in minutes
	 * @param	hasSchengenVisa		to indicate if the passenger has a valid Schengen Visa or not
	 * @return	true if the ticket is valid, false otherwise
	 * usefeul functions that you may use
	 * 		(class: Flight , method: getArrivalAirport)
	 * 		(class: Flight , method: getDepatureAirport)
	 * 		(class: Flight , method: calculateFlightTime)
	 * 		(class: Flight , method: calculateLayoverTime)
	 * 		(class: ticket , method: hasCyclicTrip)
	*/
	public static boolean checkTicket( ArrayList<Flight> ticket, int maxFlightsCount, int maxFlightTime, int maxLayoverTime, boolean hasSchengenVisa)throws TooMuchFlightTimeException,IncorrectFlightOrderException
	{
		//Todo: add your code here

		//2
		if(ticket.size() > maxFlightsCount)
			return false;

		int totalFlightTime = 0;
		int totalLayoverTime = 0;

		for(int i = 0; i < ticket.size(); i++) {
			try{
				totalFlightTime += ticket.get(i).calculateFlightTime();
			} catch(Exception e) {
				System.out.println("1");
			}

			if(i + 1 == ticket.size()) {
				//totalLayoverTime += calculateLayoverTime(ticket.get(i), ticket.get(i + 1));

				//7
				if(ticket.get(i).getArrivalAirport() != ticket.get(i+1).getDepatureAirport()) {
					throw new IncorrectFlightOrderException();
				}

				//5
				for(int j = 0; j < SchengenAirportsCode.length; j++) {
					if(!hasSchengenVisa && SchengenAirportsCode[j].equals(ticket.get(i).getArrivalAirport()) && SchengenAirportsCode[j].equals(ticket.get(i).getDepatureAirport())) {
						return false;
					}
				}
				
			}
		}

		//3 & 4
		if(totalFlightTime > maxFlightTime || totalLayoverTime > maxLayoverTime) {
			throw new TooMuchFlightTimeException();
		}

		//6
		if(hasCyclicTrip(ticket)) {
			return false;
		}

		//end of your code
		return true;
	}
		/**
	 * The function checks if the ticket has a cyclic trip
	 * (that is, no passenger can arrive at the same airport more than once within the same ticket)
	 * @param	ticket				List of ordered sequences of flights
	 * @return	true if the ticket has a cyclic trip, false otherwise
	 * usefeul functions that you may use
	 * 		(class: Flight , method: getArrivalAirport)
	 * 		(class: Flight , method: getDepatureAirport)
	*/
	public static boolean hasCyclicTrip(ArrayList<Flight> ticket)
	{
		//Todo : add your code here
		

		//Todo : end of your code
		return false;
	}
}