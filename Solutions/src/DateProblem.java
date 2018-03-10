import java.util.Calendar;
import java.util.Date;

import Utils.Utils;

public class DateProblem {

	public static void main(String[] args) {
		// Sample Test Case
		
		Date fromDate = Utils.parseDate("2016-09-11");
		Date toDate = Utils.parseDate("2018-03-10");
		System.out.println("FromDate: " +Utils.formatDate(fromDate));
		System.out.println("ToDate: " +Utils.formatDate(toDate));
		System.out.println(DateProblem.dateOutput(toDate, fromDate));
		
	}

	public static OutputDate dateOutput(Date toDate, Date fromDate) {

		OutputDate outputDate = new OutputDate();
		outputDate.setFromDate(Utils.getFirstDay(fromDate));
		outputDate.setToDate(Utils.getLastDay(toDate));
		return outputDate;
	}

	public static Date getTodaysDate(){
		Calendar calendar = Calendar.getInstance();
		return calendar.getTime();
	}
	
	

}
