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
	
	private String getDate() {
		return String.format("%02d/%02d/%04d", day, month, year);
	}
	
	private String getTime() {
		return String.format("%02d:%02d", hour,  minutes);
	}
	
	public String toString() {
		return getDate() + "  " + getTime();
	}


	// compareTo(other) returns 0 if the two objects have equal dates and times
	public int compareTo(DateAndTime other) {
		if (this.year != other.year){
			return this.year - other.year;
		}if (this.month != other.month){
			return this.month - other.month;
		}if (this.day != other.day){
			return this.day - other.day;
		}if (this.hour != other.hour){
			return this.hour - other.hour;
		} 
		return this.minutes - other.minutes;
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
	
}
