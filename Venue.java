// import java.util.ArrayList;

// A venue is either a 
// sports area (such as an athletic field), a lecture hall, a conference hall, or a public space.

public class Venue {
    private String name;
    private String info;
    private int capacity;

    // Constructor
    public Venue(String name, String info, int capacity) {
        this.name = name;
        this.info = info;
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

    @Override
    public String toString() {
        return this.name;
    }
}