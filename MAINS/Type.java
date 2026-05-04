package MAINS;

import java.util.ArrayList;

// Each event can be classified as sports, social, religious or academic depending on
// the classification; specific event information is stored.
public class Type {

    public static final ArrayList<Type> availableTypes = createTypesArray();

    private String name;

    public Type(String name) {
        this.name = name;
    }

    private static ArrayList<Type> createTypesArray() {
        ArrayList<Type> result = new ArrayList<>();

        result.add(new Type("Academic"));
        result.add(new Type("Religious"));
        result.add(new Type("Sport"));
        result.add(new Type("Social"));

        return result;
    }

    // Prints the Available Types of Event to the user, this method is called from the Main Class
    public static void printAvailableTypes() {
        for (int i = 0; i < availableTypes.size(); i++) {
            System.out.print(i+1 + ". ");
            System.out.println(availableTypes.get(i));
        }
    }


    public String getInfo() {
        if (this.name.equals("Academic")) {
            return "This is an " + this.name + " Event";
        }
        return "This is a " + this.name + " Event";
    }
    public String getName() {
        return this.name;
    }

    @Override
    public String toString() {
        return this.name;
    }
}
