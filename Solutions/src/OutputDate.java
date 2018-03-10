import java.util.Date;

import Utils.Utils;




public class OutputDate {
	
	private Date toDate;
	private Date fromDate;
	
	
	public String getToDate() {
		return Utils.formatDate(toDate);
	}


	public void setToDate(Date toDate) {
		this.toDate = toDate;
	}


	public String getFromDate() {
		return Utils.formatDate(fromDate);
	}


	public void setFromDate(Date fromDate) {
		this.fromDate = fromDate;
	}


	@Override
	public String toString() {
		return String.format("FromDateReturn: %s\nToDateReturn: %s", getFromDate(),getToDate());
	}
	
	

}
