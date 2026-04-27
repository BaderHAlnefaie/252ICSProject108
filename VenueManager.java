import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class VenueManager {
    public static ArrayList<Venue> availableVenues = addAllVenues();

    // This method add all the available Venues from the file "Venues.txt"
    private static ArrayList<Venue> addAllVenues() {
        ArrayList<Venue> result = new ArrayList<>();

        try (Scanner fileScnr = new Scanner(new FileInputStream("Venues.txt"))) {
            fileScnr.useDelimiter("\\s*,\\s*|[\\r\\n]+");
            fileScnr.nextLine(); // Just to Ignore the First 2 Lines in the File
            fileScnr.nextLine();
            while (fileScnr.hasNextLine()) {
                // String[] line = fileScnr.nextLine().split(",");
                int num = fileScnr.nextInt();
                String name = fileScnr.next();
                int capacity = fileScnr.nextInt();

                switch (num) {
                    case 1:
                        int conBuilding = fileScnr.nextInt();
                        result.add(new ConferenceHall(name, capacity, conBuilding));
                        break;
                    case 2:
                        int lecBuilding = fileScnr.nextInt();
                        int room = fileScnr.nextInt();
                        result.add(new LectureHall(name, capacity, lecBuilding, room));
                        break;
                    case 3:
                        String court = fileScnr.next();
                        result.add(new SportArea(name, capacity, court));
                        break;
                    case 4:
                        String location = fileScnr.next();
                        result.add(new PublicArea(name, capacity, location));
                        break;
                    default:
                        throw new Exception("Couldn't Find the Correspnding Venue");
                }
            }
        } catch (FileNotFoundException e) {
            System.out.println("File Not Found");
        }
        catch (Exception e) {
            System.out.println("[ERROR]: " + e.getMessage());
            System.out.println("smt is Wrong");
        }

        // result.add( new Venue("Sport Area", "This is a Sport Area", 100));
        // result.add( new Venue("Lecture Hall", "This is a Lecture Hall", 200));
        // result.add( new Venue("Conference Hall", "This is a Sport Area", 150));
        // result.add( new Venue("Public Space", "This is a Sport Area", 300));

        return result;
    }


    public static ArrayList<Venue> getConferenceHalls() {
        ArrayList<Venue> result = new ArrayList<>();

        for (Venue venue : availableVenues) {
            if (venue instanceof ConferenceHall) {
                result.add(venue);
            }
        }

        return result;
    }
    public static ArrayList<Venue> getLectureHalls() {
        ArrayList<Venue> result = new ArrayList<>();

        for (Venue venue : availableVenues) {
            if (venue instanceof LectureHall) {
                result.add(venue);
            }
        }

        return result;
    }
    public static ArrayList<Venue> getPublicAreas() {
        ArrayList<Venue> result = new ArrayList<>();

        for (Venue venue : availableVenues) {
            if (venue instanceof PublicArea) {
                result.add(venue);
            }
        }

        return result;
    }
    public static ArrayList<Venue> getSportAreas() {
        ArrayList<Venue> result = new ArrayList<>();

        for (Venue venue : availableVenues) {
            if (venue instanceof SportArea) {
                result.add(venue);
            }
        }

        return result;
    }


    // public static ArrayList<Venue> searchByBuilding(int num) {
    //     ArrayList<Venue> result = new ArrayList<>();
        
    //     for (Venue venue : availableVenues) {
    //     }
        
    //     return result;
    // }
}