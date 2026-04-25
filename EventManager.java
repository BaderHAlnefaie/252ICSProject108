import java.util.ArrayList;
public class EventManager {
	ArrayList<Event> events = new ArrayList<>();
	
	public void addEvent(Event event) {
		if (isFree(event)) {
			events.add(event);
		} else {
			System.out.println("Couldn't Add Event Due To Date And Time Class");
		}
	}
	
	public boolean isFree(Event event) {
		for (Event ev : events) {
			if ((ev.getEndDateAndTime().compareTo(event.getStartDateAndTime()) <= 0) &&
					(ev.getStartDateAndTime().compareTo(event.getEndDateAndTime()) >=0) ) {
					
				return false;
			}
		}
		return true;
	}
}
