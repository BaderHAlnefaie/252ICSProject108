package VENUES;
public class PublicArea extends Venue {
    private String location;

    public PublicArea(String name, int capacity, String location) {
        super(name, capacity);
        this.location = location;
        setInfo();
    }

    private void setInfo() {
        super.setInfo("This is a Public Area Located in " + this.location);
    }

    @Override
    public String toString() {
        return this.name + " @" + this.location + ", Capacity: " + this.capacity;
    }
}
