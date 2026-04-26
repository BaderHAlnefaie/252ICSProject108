import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		Scanner input;
		boolean showMenu;
		String fileName = "[FILE_NAME_GOES_HERE]";
		String sentinel;
		int index;
		Event event = null;
		EventManager eventManager = new EventManager();
		
		try{
		 	input = new Scanner(new File(fileName));
		 	showMenu = false;
		}catch(FileNotFoundException e){
			System.out.println("\n\n[ERROR]: File \"" + fileName + "\" Not Found");
			System.out.println("Substituting to Manual Entry!");
			input = new Scanner(System.in);
			showMenu = true;
		}
		
		System.out.println("\n\nWelcome To Bader's Event Managing System!\n");
		
		do {
			if(showMenu){
			printMenu();
			}

			sentinel = input.nextLine();
			
			
			if (sentinel.equals("C") && event == null) {
				
				event = eventCreation(input, showMenu);
				eventManager.addEvent(event);
				event = null;
				
			}

			if (sentinel.equals("SE")){
				System.out.println();
				eventManager.showEvents();
			}

			if (sentinel.equals("SI")){
				System.out.println("Enter the Event's Index: ");
				index = Integer.parseInt(input.nextLine().trim());
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

		Venue venue = new Venue(venueName, venueInfo, venueMaxCapacity);

		return new Event(name, Start, End, dep, venue);
	}

}
