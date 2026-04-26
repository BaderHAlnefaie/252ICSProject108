import java.util.ArrayList;
public class EventManager {
	ArrayList<Event> events = new ArrayList<>();
	
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
}
