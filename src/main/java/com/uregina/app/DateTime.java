package com.uregina.app;

import com.uregina.exceptions.*;

/**
 * DateTime class that consists of a Date object and a Time12 object
 *
 */
public class DateTime 
{
	Time12 time; // 12-hour time
	Date date; 	 // MM/DD/YYYY 
    /** 
	 * constructor to initial Time24 object
	 * @param time 		12-hour time object (hh:mm am/pm)
	 * @param date		date object (MM/DD/YYYY)
	*/
	public DateTime(Date date,Time12 time)
    {
		this.date=date;
		this.time=time;
    }
	/**
	* returns the 12-hour part (hh:mm am/pm) of the DateTime  
	*/
	public Time12 getTime()
	{
		return time;
	}
	/**
	* returns The date part (MM/DD/YYYY) of the DateTime  
	*/
	public Date getDate()
	{
		return date;
	}
	/**
	 * subtract two DateTimes
	 * @param  d1	a DateTime object (MM/DD/YYYY  hh:mm am/pm)
	 * @param  d2	a DateTime object (MM/DD/YYYY  hh:mm am/pm)
	 * @return 		the value of (d1-d2) in minutes
	 * 				it may be a negative value
	 *				Throws MoreThanOneDayException if d1,d2 are not at the same date or
	 * 						not a consequative days.
	 * usefeul functions that you may use
	 * 		(class: Date , method: equal)
	 * 		(class: Time12 , method: subtract)
	 * 		(class: Date , method: nextDate)
	 */
	public static int subtract(DateTime d1,DateTime d2) throws MoreThanOneDayException
	{
		int diff=0;
		//Todo: add your code here

		//If dates are not the same and are not consecutive
		if(!Date.equal(d1.getDate(), d2.getDate()) && (d1.getDate().getDay() != d2.getDate().nextDate().getDay() || d1.getDate().nextDate().getDay() != d2.getDate().getDay())) {
			throw new MoreThanOneDayException();
		}

		Time24 time1 = d1.getTime().toTime24();
		Time24 time2 = d2.getTime().toTime24();

		if(Date.equal(d1.getDate(), d2.getDate())) {
			//diff = (time1.getMinutes() - time2.getMinutes()) + ((time1.getHours() - time2.getHours()) * 60);
			diff = Time24.subtract(time1, time2);
		} else if(d1.getDate().getDay() == d2.getDate().nextDate().getDay()) { //d1 is day after d2
			try{
				diff = Time24.subtract(new Time24(23, 59), time2) + time1.getMinutes() + (time1.getHours() * 60);	
			} catch(Exception e) {

			}	
		} else if(d1.getDate().nextDate().getDay() == d2.getDate().getDay()) { //d2 is day after d1
			try{
				diff = Time24.subtract(new Time24(23, 59), time1) + time2.getMinutes() + (time2.getHours() * 60);
			} catch(Exception e) {

			}
		}

		//end of your code
		return diff;
	}
	/**
	 * Convert a DateTime object to string
	 * @param  None
	 * @return a string in the fromat MM/DD/YYYY hh:mm am/pm
	*/
	public String toString()
	{
		return date.toString()+" "+time.toString();
	}
	/**
	 * checks if a DateTime is before another one
	 * @param 	d1 a DateTime object
	 * @param 	d2 a DateTime object
	 * @return	true if d1<d2, false otherwise
	*/
	public static boolean lessThan(DateTime d1, DateTime d2)
	{
		return Date.lessThan(d1.date,d2.date) || ( Date.equal(d1.date,d2.date) && Time12.lessThan(d1.time,d2.time)) ;
	}
}
