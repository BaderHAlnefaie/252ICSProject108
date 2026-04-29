package VENUES;
public class ConferenceHall extends Venue {
    private int building;

    public ConferenceHall(String name, int capacity, int building) {
        super(name, capacity);
        this.building = building;
        super.setInfo("This is a Conferance Hall in Building " + this.building);
    }

    @Override
    public String toString() {
        return this.name + " @" + this.building + ", Capacity: " + this.capacity;
    }
}
