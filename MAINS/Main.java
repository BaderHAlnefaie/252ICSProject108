package MAINS;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

import DEPARTMENTS.*;
import EVENTS.*;
import VENUES.*;

public class Main {

	public static void main(String[] args) {
		boolean showMenu;
		String fileName = "Test.txt";
		String sentinel;
		int index;
		EventManager eventManager = new EventManager();

		try {
			Input.setSource(new Scanner(new File(fileName)));
			showMenu = false;
		} catch (FileNotFoundException e) {
			System.out.println("\n\n[ERROR]: File \"" + fileName + "\" Not Found");
			System.out.println("Substituting to Manual Entry!");
			showMenu = true;
		}

		System.out.println("\n\nWelcome To Bader's Event Managing System!\n");

		do {
			if (showMenu) {
				printMenu();
			}

			sentinel = Input.nextLine();

			if (sentinel.equals("C")) {
				try {
					eventManager.addEvent(eventCreation());
				} catch (IllegalArgumentException e) {
					System.out.println("[ERROR]: " + e.getMessage());
					System.out.println("Event was not created. Returning to menu.");
				} catch (Exception e) {
					System.out.println("[ERROR]: Could not create event - " + e.getMessage());
				}
			} else if (sentinel.equals("SE")) {
				System.out.println();
				eventManager.showEvents();
			} else if (sentinel.equals("SI")) {
				index = Input.nextInt("Enter the Event's Index: ");
				eventManager.showEventInfo(index);
			} else if (!sentinel.equals("Q") && !sentinel.isEmpty()) {
				System.out.println("Unknown command: \"" + sentinel + "\". Try C, SE, SI, or Q.");
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
		while (true) {
			try {
				System.out.println();
				return DepartmentsManager.getDepartment(Input.next("Enter the Department Name: "));
			} catch(ValidationException e) {
				System.out.println(e.getMessage());
			} catch(Exception e) {
				System.out.println("Something Went Wrong, Try Again");
			}
		}
	}
	public static Venue getVenue() {
		while (true) {
			try {
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
						throw new ValidationException("Selection must be from 1 to 4, Try Again");
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
			} catch(ValidationException e) {
				System.out.println(e.getMessage());
			} catch (IndexOutOfBoundsException e) {
				System.out.println("\nCould't find the Corresponding Venue, Try Again");
			} catch(Exception e) {
				System.out.println("Something Went Wrong, Try Again");
			}
		}
	}
}
