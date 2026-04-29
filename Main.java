import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		// Scanner input;
		boolean showMenu;
		String fileName = "[TEST File Here]"; // Test.txt
		String sentinel;
		int index;
		Event event = null;
		EventManager eventManager = new EventManager();
		
		try {
		 	Scanner input = new Scanner(new File(fileName));
		 	showMenu = false;
		} catch(FileNotFoundException e){
			System.out.println("\n\n[ERROR]: File \"" + fileName + "\" Not Found");
			System.out.println("Substituting to Manual Entry!");
			// input = new Scanner(System.in);
			showMenu = true;
		}
		
		System.out.println("\n\nWelcome To Bader's Event Managing System!\n");
		
		do {
			if(showMenu) {
				printMenu();
			}

			// sentinel = input.nextLine();
			sentinel = Input.nextLine();
			
			
			if (sentinel.equals("C") && event == null) {
				
				event = eventCreation(/*input, showMenu*/);
				eventManager.addEvent(event);
				event = null;
				
			}

			if (sentinel.equals("SE")){
				System.out.println();
				eventManager.showEvents();
			}

			if (sentinel.equals("SI")) {
				// System.out.println("Enter the Event's Index: ");
				// index = Integer.parseInt(input.nextLine().trim());
				index = Input.nextInt("Enter the Event's Index: ");
				eventManager.showEventInfo(index);
				index = -1;
			}
			
		} while (!sentinel.equals("Q"));
	}

	// Prints the menu which includes ("create" and "quit")
	public static void printMenu() {
		System.out.println("Enter: \"C\" to create a new event!");
		System.out.println("Enter: \"Q\" to quit the program.");
		System.out.println("Enter \"SE\" to show the events.");
		System.out.println("Enter \"SI\" to show one event in detail");

	}

	// Prints the requirements for the event:
	// Name, Start Date and Time, End Date and Time, Department, Venue
	public static Event eventCreation(Scanner input, boolean showMenu) {
		String name;
		int startDay;
		int startMonth;
		int startYear;

		int endDay;
		int endMonth;
		int endYear;

		int startMinutes;
		int startHour;

		int endMinutes;
		int endHour;

		String depName;
		String depPersonName;

		String venueName;
		String venueInfo;
		int venueMaxCapacity;

		String[] tokens;

		if (showMenu)
			System.out.print("Enter the Name of the Event: ");
		name = input.nextLine().trim();

		if (showMenu)
			System.out.print("Enter the Start Date of the Event (DD MM YYYY): ");
		tokens = input.nextLine().split(" ");
		startDay = Integer.parseInt(tokens[0]);
		startMonth = Integer.parseInt(tokens[1]);
		startYear = Integer.parseInt(tokens[2]);

		if (showMenu)
			System.out.print("Enter the End Date of the Event (DD MM YYYY): ");
		tokens = input.nextLine().split(" ");
		endDay = Integer.parseInt(tokens[0]);
		endMonth = Integer.parseInt(tokens[1]);
		endYear = Integer.parseInt(tokens[2]);

		if (showMenu)
			System.out.print("Enter the Start Time of the Event (HH MM):");
		tokens = input.nextLine().split(" ");
		startHour = Integer.parseInt(tokens[0]);
		startMinutes = Integer.parseInt(tokens[1]);

		DateAndTime Start = new DateAndTime(startDay, startMonth, startYear,
				startMinutes, startHour);

		if (showMenu)
			System.out.print("Enter the End Time of the Event (HH:MM):");
		tokens = input.nextLine().split(" ");
		endHour = Integer.parseInt(tokens[0]);
		endMinutes = Integer.parseInt(tokens[1]);

		DateAndTime End = new DateAndTime(endDay, endMonth, endYear,
				endMinutes, endHour);

		if (showMenu)
			System.out.print("Add the Department's Name: ");
		depName = input.nextLine();

		if (showMenu)
			System.out.print("Add The Name Of The Person In Charge Of The Department: ");
		depPersonName = input.nextLine();

		Department dep = new Department(depName, depPersonName);

		if (showMenu)
			System.out.print(("Enter the Name of the Venue: "));
		venueName = input.nextLine();

		if (showMenu)
			System.out.print("Enter The Info Of The Venue: ");
		venueInfo = input.nextLine();

		if (showMenu)
			System.out.print("Enter The Maximum Capacity Of The Venue: ");
		venueMaxCapacity = Integer.parseInt(input.nextLine().trim());

		// Venue venue = new Venue(venueName, venueInfo, venueMaxCapacity);

		return new Event(name, Start, End, dep, null);
	}



	public static Event eventCreation() {
		return new Event(getName(), getStartDate(), getEndDate(), getDepartment(), getVenue());
	}

	public static String getName() {
		System.out.println();
		return Input.nextLine("Enter the Name of the Event: ");
	}
	public static DateAndTime getStartDate() {
		System.out.println();

		System.out.println("Enter the Start Date of the Event: ");
		int startDay = Input.nextInt("Day: ");
		int startMonth = Input.nextInt("Month: ");
		int startYear = Input.nextInt("Year: ");

		System.out.println("Enter the Start Time of the Event: ");
		int startHour = Input.nextInt("Hour: ");
		int startMinute = Input.nextInt("Minutes: ");

		return new DateAndTime(startDay, startMonth, startYear, startMinute, startHour);
	}
	public static DateAndTime getEndDate() {
		System.out.println();

		System.out.println("Enter the End Date of the Event: ");
		int endDay = Input.nextInt("Day: ");
		int endMonth = Input.nextInt("Month: ");
		int endYear = Input.nextInt("Year: ");

		System.out.println("Enter the End Time of the Event: ");
		int endHour = Input.nextInt("Hour: ");
		int endMinute = Input.nextInt("Minutes: ");

		return new DateAndTime(endDay, endMonth, endYear, endMinute, endHour);
	}
	public static Department getDepartment() {
		System.out.println();

		return DepartmentsManager.getDepartment(Input.next("Enter the Department Name: "));
	}
	public static Venue getVenue() {
		System.out.println();

		System.out.println("Here are the Avilable Venues:");
		System.out.println("1. Sport Area");
		System.out.println("2. Lecture Hall");
		System.out.println("3. Conference Hall");
		System.out.println("4. Public Space");

		int selection = Input.nextInt("Enter the Number of Your Selection: ");

		// Sport Area, Lecture Hall, Conference Hall or a Public Space
		ArrayList<Venue> selectedVenueType;
		Venue selectedVenue;

		switch (selection) {
			case 1:
				selectedVenueType = VenueManager.getSportAreas();
				break;
			case 2:
				selectedVenueType = VenueManager.getLectureHalls();
				break;
			case 3:
				selectedVenueType = VenueManager.getConferenceHalls();
				break;
			case 4:
				selectedVenueType = VenueManager.getPublicAreas();
				break;
			default:
				throw new IllegalArgumentException("Selection must be from 1 to 4");
		}

		System.out.println();
		System.out.println("Here are the Available Venues");
		VenueManager.printVenues(selectedVenueType);

		System.out.println();
		selection = Input.nextInt("Enter the Number of Your Selection: ");
		selectedVenue = selectedVenueType.get(selection-1);

		int attendees = Input.nextInt("Enter the Number of the Attendees of this Event: ");

		if (selectedVenue.checkCapacity(attendees)) {
			return selectedVenue;
		}
		else {
			throw new IllegalArgumentException("The Attendees Exceeds the Venue's Capacity");
		}
	}
}
