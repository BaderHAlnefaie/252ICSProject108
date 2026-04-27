public class ConferenceHall extends Venue {
    private int building;

    public ConferenceHall(String name, int capacity, int building) {
        super(name, capacity);
        this.building = building;
        super.setInfo("This is a Conferance Hall in Building " + this.building);
    }
}
