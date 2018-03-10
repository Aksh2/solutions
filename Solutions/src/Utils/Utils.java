package Utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class Utils {
	
	/**
	 * Converts a String object to a Date Object.
	 * @param date
	 * @return Date object in the YYYY-MM-DD format.
	 */

	public static Date parseDate(String date) {
		try {
			return new SimpleDateFormat("yyyy-MM-dd").parse(date);
		} catch (ParseException e) {
			return null;
		}
	}

	public static Date getFirstDay(Date toDate){
		Calendar returnToDate, toDateCalendar;
		toDateCalendar=Utils.getCalendarObject(toDate);
				
		returnToDate = Calendar.getInstance();
		returnToDate.set(Calendar.DAY_OF_MONTH, toDateCalendar.getActualMinimum(Calendar.DAY_OF_MONTH));
		returnToDate.set(Calendar.MONTH,toDateCalendar.get(Calendar.MONTH));
		returnToDate.set(Calendar.YEAR,toDateCalendar.get(Calendar.YEAR));
		
		return returnToDate.getTime();
	}

	/**
	 * Converts a Date Object to a String Object.
	 * @param date
	 * @return A String of a date object in the format YYYY-MM-DD
	 */
	
	public static String formatDate(Date date){
		return new SimpleDateFormat("yyyy-MM-dd").format(date);
	}

	public static Date getLastDay(Date toDate){
		Calendar todaysDate,returnFromDate;
		todaysDate= Calendar.getInstance();
		returnFromDate=Calendar.getInstance();
		todaysDate = Utils.getCalendarObject(todaysDate.getTime());
		Calendar fromDateCal= Utils.getCalendarObject(toDate);
		if(todaysDate.get(Calendar.MONTH)>fromDateCal.get(Calendar.MONTH)||
				todaysDate.get(Calendar.YEAR)>fromDateCal.get(Calendar.YEAR)){
			returnFromDate.set(Calendar.DAY_OF_MONTH,fromDateCal.getActualMaximum(Calendar.DAY_OF_MONTH));
			returnFromDate.set(Calendar.MONTH,fromDateCal.get(Calendar.MONTH));
			returnFromDate.set(Calendar.YEAR,fromDateCal.get(Calendar.YEAR));
		}
		return returnFromDate.getTime();
	}

	/**
	 * Converts a Date object to a Calendar Object
	 * @param date
	 * @return Calendar object for the given date object.
	 */
	public static Calendar getCalendarObject(Date date){
		Calendar calendar = Calendar.getInstance();
		calendar.setTime(date);
		return calendar;
	}

}
