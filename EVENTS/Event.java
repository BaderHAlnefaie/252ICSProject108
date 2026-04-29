package EVENTS;

import DEPARTMENTS.*;
import MAINS.Type;
import VENUES.*;


public class Event {
	private String name;
	private Type type;
	private DateAndTime start;
	private DateAndTime end;
	private Department dep;
	private Venue venue;

	public Event(String name, Type type, DateAndTime start, DateAndTime end, Department dep, Venue venue) {
		if (start.compareTo(end) >= 0){
			throw new IllegalArgumentException("[ERROR]: Invalid Start And End Dates - [Required]: Start Date < End Date");
		}
		this.name = name;
		this.type = type;
		this.start = start;
		this.end = end;
		this.dep = dep;
		this.venue = venue;
	}

	public String getName() {
		return name;
		}

	public Type getType() {
		return type;
	}

	public DateAndTime getStartDateAndTime() {
		return start;
	}

	public DateAndTime getEndDateAndTime() {
	 	return end;
	}

	public Department getDepartment(){
		return dep;
	}

	public Venue getVenue(){
		return venue;
	}

	public String toString(){
		return "Name: " + name + "\tStart: " + start.toString() + "\tEnd: " + end.toString();
	}
}
