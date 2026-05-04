package MAINS;
import DEPARTMENTS.*;
import EVENTS.*;
import VENUES.*;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Main {

	public static void main(String[] args) {
		boolean showMenu;
		String fileName = "[FILE_NAME_GOES_HERE]";
		String sentinel = "start";
		int index;
		EventManager eventManager = new EventManager();

		try {
			Input.setSource(new Scanner(new File(fileName)));
			showMenu = false;
			Input.showPrompts = false;
		} catch (FileNotFoundException e) {
			System.out.println("\n\n[ERROR]: File \"" + fileName + "\" Not Found");
			System.out.println("Substituting to Manual Entry!");
			showMenu = true;
		}

		System.out.println("\n\nWelcome To ALNEFAIE-ALGHAMDI Event Managing System!\n");

		do {
			try {
				if (showMenu && !sentinel.isEmpty()) {
					printMenu();
				}

				sentinel = Input.nextLine().trim().toUpperCase();

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
				} else if (sentinel.equals("S")) {
					searchforEvent(eventManager);
				} else if (sentinel.equals("AD")) {
					addDepartment();
				} else if (sentinel.equals("AV")) {
					addVenue();
				} else if (!sentinel.equals("Q") && !sentinel.isEmpty()) {
					System.out.println("Unknown command: \"" + sentinel + "\". Try C, SE, SI, or Q.");
				}
			} catch (CancelationException e) {
				System.out.println(e.getMessage());
				sentinel = "again";
				continue;
			}

		} while (!sentinel.equals("Q"));
	}

	// Prints the menu which includes ("create" and "quit")
	public static void printMenu() {
		System.out.println("Enter: \"C\" to create a new event!");
		System.out.println("Enter: \"Q\" to quit the program.");
		System.out.println("Enter \"SE\" to show the events.");
		System.out.println("Enter \"SI\" to show one event in detail");
		System.out.println("Enter \"S\" to Search for Events");
		System.out.println("Enter \"AD\" to Add a New Department");
		System.out.println("Enter \"AV\" to Add a New Venue");
	}

	public static Event eventCreation() {
		return new Event(getName(), getType(), getStartDate(), getEndDate(), getDepartment(), getVenue());
	}

	public static String getName() {
		if (Input.showPrompts) System.out.println();
		return Input.nextLine("Enter the Name of the Event: ").trim();
	}

	public static Type getType() {
		while (true) {
			try {
				if (Input.showPrompts) {
					System.out.println();
					System.out.println("Available Event Types:");
					Type.printAvailableTypes();
				}
				int selection = Input.nextInt("Enter the Number of the Event Type: ");
				if (selection < 1 || selection > Type.availableTypes.size()) {
					throw new ValidationException("Selection must be from 1 to " + Type.availableTypes.size() + ", Try Again");
				}
				return Type.availableTypes.get(selection - 1);
			} catch (ValidationException e) {
				System.out.println(e.getMessage());
			} catch (CancelationException e) {
				throw e;
			} catch (Exception e) {
				System.out.println("Something Went Wrong, Try Again");
			}
		}
	}

	public static DateAndTime getStartDate() {
		if (Input.showPrompts) System.out.println();
		int[] date = parseDate(Input.nextLine("Enter the Start Date of the Event (DD MM YYYY): "));
		int[] time = parseTime(Input.nextLine("Enter the Start Time of the Event (HH MM): "));
		return new DateAndTime(date[0], date[1], date[2], time[1], time[0]);
	}

	public static DateAndTime getEndDate() {
		if (Input.showPrompts) System.out.println();
		int[] date = parseDate(Input.nextLine("Enter the End Date of the Event (DD MM YYYY): "));
		int[] time = parseTime(Input.nextLine("Enter the End Time of the Event (HH MM): "));
		return new DateAndTime(date[0], date[1], date[2], time[1], time[0]);
	}

	// Parses "DD MM YYYY" into {day, month, year}
	private static int[] parseDate(String line) {
		String[] tokens = line.trim().split("\\s+");
		if (tokens.length != 3) {
			throw new IllegalArgumentException("Date must be in the format DD MM YYYY");
		}
		return new int[] {
			Integer.parseInt(tokens[0]),
			Integer.parseInt(tokens[1]),
			Integer.parseInt(tokens[2])
		};
	}

	// Parses "HH MM" into {hour, minute}
	private static int[] parseTime(String line) {
		String[] tokens = line.trim().split("\\s+");
		if (tokens.length != 2) {
			throw new IllegalArgumentException("Time must be in the format HH MM");
		}
		return new int[] {
			Integer.parseInt(tokens[0]),
			Integer.parseInt(tokens[1])
		};
	}
	public static Department getDepartment() {
		while (true) {
			try {
				if (Input.showPrompts) {
					System.out.println();
					System.out.println("Here are the Available Departments:");
					DepartmentsManager.showDepartments();
					System.out.println();
				}
				int choice = Input.nextInt("Enter the Number of Your Selection: ");
				return DepartmentsManager.departmentSelection(choice);
				// return DepartmentsManager.getDepartment(name);
			}
			catch(ValidationException e) {
				System.out.println(e.getMessage());
			}
			catch (CancelationException e) {
				throw e;
			}
			catch(Exception e) {
				System.out.println("Something Went Wrong, Try Again");
			}
		}
	}

	public static Venue getVenue() {
		while (true) {
			try {
				if (Input.showPrompts) {
					System.out.println();

					System.out.println("Here are the Available Venue Types:");
					System.out.println("1. Sport Area");
					System.out.println("2. Lecture Hall");
					System.out.println("3. Conference Hall");
					System.out.println("4. Public Space");
				}

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

				if (Input.showPrompts) {
					System.out.println();
					System.out.println("Here are the Available Venues");
					VenueManager.printVenues(selectedVenueType);
					System.out.println();
				}
				selection = Input.nextInt("Enter the Number of Your Selection: ");
				selectedVenue = selectedVenueType.get(selection-1);

				int attendees = Input.nextInt("Enter the Number of the Attendees of this Event: ");
				System.out.println();
				if (selectedVenue.checkCapacity(attendees)) {
					return selectedVenue;
				}
			}
			catch(ValidationException e) {
				System.out.println(e.getMessage());
			}
			catch (IndexOutOfBoundsException e) {
				System.out.println("\nCouldn't find the Corresponding Venue, Try Again");
			}
			catch (CancelationException e) {
				throw e;
			}
			catch(Exception e) {
				System.out.println("Something Went Wrong, Try Again");
			}
		}
	}



	public static void addVenue() {
		try {
			String name = Input.nextLine("Enter the Name of the Venue: ");
			int capacity = Input.nextInt("Enter the Capacity of the Venue: ");

			System.out.println();

			System.out.println("Here are the Available Venue Types:");
			System.out.println("1. Sport Area");
			System.out.println("2. Lecture Hall");
			System.out.println("3. Conference Hall");
			System.out.println("4. Public Space");
			System.out.println();

			int typeSelection = Input.nextInt("Enter the Number of your Selection: ");
			System.out.println();

			switch (typeSelection) {
				case 1:
					String court = Input.nextLine("Enter the Name of the Court: ");
					VenueManager.addVenue(new SportArea(name, capacity, court));
					break;
				case 2:
					int lecBuilding = Input.nextInt("Enter the Building Number: ");
					int room = Input.nextInt("Enter the Room Number: ");
					VenueManager.addVenue(new LectureHall(name, capacity, lecBuilding, room));
					break;
				case 3:
					int conBuilding = Input.nextInt("Enter the Building Number: ");
					VenueManager.addVenue(new ConferenceHall(name, capacity, conBuilding));
					break;
				case 4:
					String location = Input.nextLine("Enter the Location: ");
					VenueManager.addVenue(new PublicArea(name, capacity, location));
					break;
				default:
					throw new ValidationException("Couldn't Find the Corresponding Venue");
            }
			System.out.println("Venue \"" + name + "\" Added Successfully");
		}
		catch (ValidationException e) {
			System.out.println(e.getMessage());
		}
		catch (CancelationException e) {
			throw e;
		}
		catch (Exception e) {
			System.out.println("Something Went Wrong");
		}
	}

	public static void addDepartment() {
		try {
			String deptName = Input.next("Enter the Name of the Department: ");
			String personName = Input.next("Enter the Name of the Person Responsible for this Department: ");

			DepartmentsManager.addDepartment( new Department(deptName, personName) );
		}
		catch (ValidationException e) {
			System.out.println(e.getMessage());
		}
		catch (CancelationException e) {
				throw e;
		} 
		catch (Exception e) {
			System.out.println("Something Went Wrong");
		}
		finally {
			System.out.println();
		}
	}

	public static void searchforEvent(EventManager eventManager) {
		try {
			System.out.println("Search by:");
			System.out.println("1. Name");
			System.out.println("2. Type");

			int selection = Input.nextInt("Enter the Number of Your Selection: ");
			ArrayList<Event> searchedEvents = new ArrayList<>();

			switch (selection) {
				case 1:
					String name = Input.next("Enter the Name: ");
					searchedEvents = eventManager.searchByName(name);
					break;
			
				case 2:
					Type.printAvailableTypes();
					selection = Input.nextInt("Enter the Number of Your Selection: ");
					searchedEvents = eventManager.searchByType(Type.availableTypes.get(selection-1).getName());
					break;
				default:
					throw new ValidationException("Selection Must be from 1 to 2");
			}

			if (!searchedEvents.isEmpty()) {
				for (int i = 0; i < searchedEvents.size(); i++) {
					System.out.println((i+1) + ". " + searchedEvents.get(i));

				}
				System.out.println();
				selection = Input.nextInt("Enter the Number of the Event to Show it: ");

				if (selection < 1 || selection > searchedEvents.size()) {
					throw new ValidationException("Cannot Find the Corresponding Event");
				}

				System.out.println();
				eventManager.showEventInfo(searchedEvents.get(selection-1));
			} else {
				System.out.println();
				System.out.println("No Events to Show");
				System.out.println();
			}
		}
		catch (ValidationException e) {
			System.out.println(e.getMessage());
		}
		catch (Exception e) {
			System.out.println("Something Went Wrong");
		}
	}

}


