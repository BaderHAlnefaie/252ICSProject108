package EVENTS;

import DEPARTMENTS.*;
import VENUES.*;


import java.util.ArrayList;
public class EventManager {
	private ArrayList<Event> events = new ArrayList<>();
	
	public void addEvent(Event event) {
		if (!isFree(event)) {
			System.out.println("Couldn't Add Event \"" + event.getName() + "\" Due To Date And Time Clash");
			return;
		}
		// Find the first event that starts after the new one and insert before it
		for (int i = 0; i < events.size(); i++) {
			if (event.getStartDateAndTime().compareTo(events.get(i).getStartDateAndTime()) < 0) {
				events.add(i, event);
				return;
			}
		}
		// Either list was empty, or new event is the latest — append at the end
		events.add(event);
	}
	
	public boolean isFree(Event other) {
		for (Event ev : events) {
			if ((ev.getEndDateAndTime().compareTo(other.getStartDateAndTime())  > 0) &&
				(ev.getStartDateAndTime().compareTo(other.getEndDateAndTime())  < 0)) {
					return false;
				}
		}
		return true;
	}

	@Override 
	public String toString(){
		return events.toString();
	}

	public void showEvents() {
		String line = "-".repeat(71); // 67
		System.out.println(line);
		System.out.printf("|%-69s|%n", "                        List Of Events");
		System.out.println(line);
		int i = 0;
		for (Event event : events) {
			System.out.printf("| %01d | %-23s | %-17s | %-17s |%n",
				i++,
				event.getName(),
				event.getStartDateAndTime(),
				event.getEndDateAndTime());
		}
		System.out.println(line);
	}

	public void showEventInfo(int index){
		if (index < 0 || index > events.size() - 1){
			System.out.println("[Error]: Invalid index. Has to be >= 0 and <= " + (events.size() - 1));
		}
		showEventInfo(events.get(index));
	}

	public void showEventInfo(Event event) {
		if (event == null) {
			System.out.println("No event to display.");
			return;
		}
	
		String line = "-".repeat(72);
		Department dep = event.getDepartment();
		Venue venue = event.getVenue();
	
		System.out.println(line);
		System.out.printf("|%-70s|%n", "                          Event Details");
		System.out.println(line);
	
		System.out.printf("| %-12s : %-54s|%n", "Name",       event.getName());
		System.out.printf("| %-12s : %-54s|%n", "Start",      event.getStartDateAndTime());
		System.out.printf("| %-12s : %-54s|%n", "End",        event.getEndDateAndTime());
		System.out.printf("| %-12s : %-54s|%n", "Department", dep   != null ? dep.getName()   : "(not set)");
		System.out.printf("| %-12s : %-54s|%n", "In Charge",  dep   != null ? dep.getPerson() : "(not set)");
		System.out.printf("| %-12s : %-54s|%n", "Venue",      venue != null ? venue.getName() : "(not set)");
		System.out.printf("| %-12s : %-54s|%n", "Venue Info", venue != null ? venue.getInfo() : "(not set)");
		System.out.printf("| %-12s : %-54s|%n", "Capacity",   venue != null ? String.valueOf(venue.getCapacity()) : "(not set)");
	
		System.out.println(line);
	}
}
