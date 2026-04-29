package VENUES;
public class SportArea extends Venue {
    private String court;

    // Constructor
    public SportArea(String name, int capacity, String court) {
        super(name, capacity);
        this.court = court;
        super.setInfo( "This is a " + this.court + " Court");
    }

    @Override
    public String toString() {
        return this.name + ", " + this.court + " Court, Capacity: " + this.capacity;
    }
}
