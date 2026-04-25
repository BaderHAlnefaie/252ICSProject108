import java.util.Scanner;
public class Main {

	public static void main(String[] args) {
		Scanner input = new Scanner(System.in);
		String sentinel;
		Event event = null;
		EventManager eventManager = new EventManager();
		
		
		
		System.out.println("Welcome To Bader's Event Managing System!\n");
		
		do {
			printMenu();
			sentinel = input.nextLine();
			
			if (sentinel.equals("create") && event == null) {
				
				event = eventCreation(input);
				eventManager.addEvent(event);
				event = null;
				
			}
			
		} while (!sentinel.equals("quit"));
		
	}
	// Prints the menu which includes ("create" and "quit")
	public static void printMenu() {
		System.out.println("Enter: \"create\" to create a new event!");
		System.out.println("Enter: \"quit\" to quit the program.");
	}
	
	// Prints the requirements for the event:
	// Name, Start Date and Time, End Date and Time
	public static Event eventCreation(Scanner input) {
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
		
		String [] tokens;
		
		System.out.print("Enter the Name of the Event: ");
		name = input.nextLine();
		
		System.out.print("Enter the Start Date of the Event (DD MM YYYY): ");
		tokens = input.nextLine().split(" ");
		startDay = Integer.parseInt(tokens[0]);
		startMonth = Integer.parseInt(tokens[1]);
		startYear = Integer.parseInt(tokens[2]);
		
		
		System.out.print("Enter the End Date of the Event (DD MM YYYY): ");
		tokens = input.nextLine().split(" ");
		endDay = Integer.parseInt(tokens[0]);
		endMonth = Integer.parseInt(tokens[1]);
		endYear = Integer.parseInt(tokens[2]);
		
		System.out.print("Enter the Start Time of the Event (HH MM):");
		tokens = input.nextLine().split(" ");
		startHour = Integer.parseInt(tokens[0]);
		startMinutes = Integer.parseInt(tokens[1]);


		DateAndTime Start = new DateAndTime(startDay, startMonth, startYear,
			startMinutes, startHour);
		
		System.out.print("Enter the End Time of the Event (HH:MM):");
		tokens = input.nextLine().split(" ");
		endHour = Integer.parseInt(tokens[0]);
		endMinutes = Integer.parseInt(tokens[1]);
		
		DateAndTime End = new DateAndTime(endDay, endMonth, endYear,
				endMinutes, endHour);
		
		return new Event(name, Start, End);	
	}

}
