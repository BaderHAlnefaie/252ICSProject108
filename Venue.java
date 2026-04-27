
// A venue is either a 
// sports area (such as an athletic field), a lecture hall, a conference hall, or a public space.

public abstract class Venue {
    private String name;
    private String info;
    private int capacity;

    // This might be helpful for an idea 
    private String[] venues = {"Sports", "Lecture Hall", "Conference Hall", "Public Space"};

    // Constructor
    public Venue(String name, /*String info,*/ int capacity) {
        this.name = name;
        // this.info = info;
        this.capacity = capacity;
    }


    public String getName() {
        return this.name;
    }
    public String getInfo() {
        return this.info;
    }
    public int getCapacity() {
        return this.capacity;
    }

    // public String printVenues() {
    //     String str = "";

    //     for (int i = 0; i < venues.length; i++){
    //         str += i + "- " + venues[i] + "\n";
    //     }

    //     return str;
    // }

    @Override
    public String toString() {
        return this.name;
    }
    protected void setInfo(String info) {
        this.info = info;
    }
}