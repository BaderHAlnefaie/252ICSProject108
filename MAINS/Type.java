package MAINS;

import java.util.ArrayList;

public class Type {
// Each event can be classified as sports, social, religious or academic depending on
// the classification; specific event information is stored.

    static ArrayList<Type> avilavbleArrayList = createTypesArray();

    private String name;

    public Type(String name) {
        this.name = name;
    }

    public static ArrayList<Type> createTypesArray() {
        ArrayList<Type> result = new ArrayList<>();

        result.add(new Type("Academic"));
        result.add(new Type("Religious"));
        result.add(new Type("Sport"));
        result.add(new Type("Social"));

        return result;
    }

    // Prints the Available Types of Event to the user, this method will be called from the Main Class
    public static void printAvilableTypes() {
        for (int i = 0; i < avilavbleArrayList.size(); i++) {
            System.out.print(i+1 + ". ");
            System.out.println(avilavbleArrayList.get(i));
        }
    }


    public String getInfo() {
        if (this.name.equals("Academic")) {
            return "This is an " + this.name + " Event";
        }
        return "This is a " + this.name + " Event";
    }

    @Override
    public String toString() {
        return this.name;
    }
}
