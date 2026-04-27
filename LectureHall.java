public class LectureHall extends Venue {
    private int building;
    private int room;

    public LectureHall(String name, int capacity, int building, int room) {
        super(name, capacity);
        this.building = building;
        this.room = room;
        super.setInfo("This is a Lecture Hall in Building " + this.building + ", Room " + this.room);
    }   
}
