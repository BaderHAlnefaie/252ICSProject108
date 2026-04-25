public class Event {
	private String name;
	private DateAndTime start;
	private DateAndTime end;
	
	
	
	public Event(String name, DateAndTime start, DateAndTime end) {
		this.name = name;
		this.start = start;
		this.end = end;	
	}
	
	
	public String getName() {
		return name;
		}
	
	public DateAndTime getStartDateAndTime() {
		return start;
	}
	
	public DateAndTime getEndDateAndTime() {
	 	return end;
	}
}
