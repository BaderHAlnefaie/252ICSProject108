import java.util.ArrayList;
public class EventManager {
	ArrayList<Event> events = new ArrayList<>();
	
	public void addEvent(Event event) {
		if (isFree(event)) {
			events.add(event);
		} else {
			System.out.println("Couldn't Add Event Due To Date And Time Clash");
		}
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

	public String toString(){
		return events.toString();
	}

	public void showEvents(){
		System.out.printf(" ----------------------------------------%n");
		System.out.printf("|   			List Of Events   		    |%n");
		System.out.printf(" ----------------------------------------%n");

		for (Event event : events){
		System.out.printf("| %-10s | %-5s | %-8s |%n", event.getName(), event.getStartDateAndTime(), event.getEndDateAndTime());
		System.out.printf("--------------------%n");
		}
	}
}
