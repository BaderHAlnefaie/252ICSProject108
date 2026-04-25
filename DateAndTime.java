//import java.util.Scanner;
public class DateAndTime implements Comparable<DateAndTime>{

	private int day;
	private int month;
	private int year;
	
	
	private int minutes;
	private int hour;
	
	
	public DateAndTime(int day, int month, int year, int minutes, int hour) {
		if (!isValidDate(day, month, year)) {
			throw new IllegalArgumentException("Invalid date: " + day + "/" + month + "/" + year);
		} if (hour < 0 || hour > 23) {
			throw new IllegalArgumentException("Invalid hour: " + hour);
		} if (minutes < 0 || minutes > 59) {
			throw new IllegalArgumentException("Invalid minute: " + minutes);
		} 
		
		this.day = day;
		this.month = month;
		this.year = year;
		this.minutes = minutes;
		this.hour = hour;
	}
	
	// O.dateandtime - this.dateandtime
	public int compareTo(DateAndTime o) {
		long thisDateCombined =  year * 10000 + month * 100 + day;
		long otherDateCombined = o.year * 10000 + month * 100 + day;
		
		return (int) (otherDateCombined - thisDateCombined);
		
	}
	
	private static boolean isLeapYear(int year) {
		if ((year % 4 == 0 && year % 100 != 0) || (year % 400 == 0))
			return true;
		
		return false;
	}
	
	public static int daysInMonth(int month, int year) {
		switch(month) {
		case 1: case 3: case 5: case 7: case 8: case 10: case 12:
			return 31;
		case 4: case 6: case 9: case 11:
			return 30;
		case 2:
			return isLeapYear(year) ? 29 : 28;
		default:
			return -1;
		}
	}
	
	public static boolean isValidDate(int day, int month, int year) {
		if (month < 1 || month > 12) return false;
		if (year < 1) return false;
		return day >= 1 && day <= daysInMonth(month, year);
	}
	
	private String getDate() {
		return day + "/" + month + "/" + year;
	}
	
	private String getTime() {
		return hour + ":" + minutes;
	}
	
	public String toString() {
		return getDate() + " " + getTime();
	}



	
	
}
