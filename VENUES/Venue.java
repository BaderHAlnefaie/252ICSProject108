package VENUES;

import MAINS.ValidationException;

public abstract class Venue implements Comparable<Venue> {
    protected String name;
    protected String info;
    protected int capacity;


    // Constructor
    public Venue(String name, int capacity) {
        this.name = name;
        this.capacity = capacity;
    }

    // This method check's if the capacity of the venue can hold the number of attendees,
    // it will return true if it can, otherwise it will throw a Validation Exception
    public boolean checkCapacity(int attendees) throws ValidationException {
        if (this.capacity >= attendees) {
            return true;
        }
        throw new ValidationException(
            "The Number of Attendees Exceeds the Venue's Capacity,\nTry Again or Choose Another Venue"
        );
    }


    // Getters
    public String getName() {
        return this.name;
    }
    public String getInfo() {
        return this.info;
    }
    public int getCapacity() {
        return this.capacity;
    }

    // Overriding
    @Override
    public String toString() {
        return this.name + ", Capacity: " + this.capacity;
    }
    @Override
    public int compareTo(Venue other) {
        return this.name.compareTo(other.name);
    }

    // Setters
    protected void setInfo(String info) {
        this.info = info;
    }
}