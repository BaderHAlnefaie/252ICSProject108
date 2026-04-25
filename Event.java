public class Event {
	private String name;
	private DateAndTime start;
	private DateAndTime end;
	private Department dep;
	private Venue venue;
	
	public Event(String name, DateAndTime start, DateAndTime end, Department dep, Venue venue) {
		this.name = name;
		this.start = start;
		this.end = end;	
		this.dep = dep;
		this.venue = venue;
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
