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

	public void showEvents() {
		String line = "-".repeat(67);
		System.out.println(line);
		System.out.printf("|%-65s|%n", "                        List Of Events");
		System.out.println(line);
	
		for (Event event : events) {
			System.out.printf("| %-23s | %-17s | %-17s |%n",
				event.getName(),
				event.getStartDateAndTime(),
				event.getEndDateAndTime());
		}
		System.out.println(line);
	}
}
