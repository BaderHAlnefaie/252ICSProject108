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
	
	// compareTo(other) returns 0 if equal date and time, returns  > 0 if not equal date and time
	public int compareTo(DateAndTime other) {
		return Math.abs(compareTime(other)) + Math.abs(compareDate(other));
	}
	// compareDate(other) returns 0 if both instances this.DateAndTime and other.DateAndTime have equal Dates
	public int compareDate(DateAndTime other){
		long thisDateCombined =  this.year * 10000 + this.month * 100 + this.day;
		long otherDateCombined = other.year * 10000 + other.month * 100 + other.day;
		int dateDifference = (int)(otherDateCombined - thisDateCombined);

		return dateDifference;
	}
	// compareTime(other) returns 0 if this.DateAndTime and other.DateAndTime have equal Times
	public int compareTime(DateAndTime other){
		int thisTimeCombined = this.hour * 100 + this.minutes;
		int othertimeCombined = other.hour * 100 + other.minutes;
		int timeDifference = othertimeCombined - thisTimeCombined;
		return timeDifference;
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
