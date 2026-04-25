import java.util.ArrayList;

public abstract class VenueManager {
    public static ArrayList<Venue> availableVenues = addAllVenues();

    // This method add all the available Venues(wich are 4)
    private static ArrayList<Venue> addAllVenues() {
        ArrayList<Venue> result = new ArrayList<>();

        result.add( new Venue("Sport Area", "This is a Sport Area", 100));
        result.add( new Venue("Lecture Hall", "This is a Lecture Hall", 200));
        result.add( new Venue("Conference Hall", "This is a Sport Area", 150));
        result.add( new Venue("Public Space", "This is a Sport Area", 300));

        return result;
    }

}