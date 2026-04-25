public class Department {
    private String name;
    private String person;

    // Still didn't added the departments yet
    private static String[] availableDepartments = new String[28];

    // Throws an Exception if the Department Does not Exist
    public Department(String name, String person) {
        if (isValid(name)) {
            this.name = name;
            this.person = person;
        }
        else {
            throw new IllegalArgumentException("This Department Does not Exist");
        }
    }

    private boolean isValid(String name) {
        for (String dept : availableDepartments) {
            if (name.equals(dept)) {
                return true;
            }
        }
        return false;
    }

    public String getName() {
        return this.name;
    }
    public String getPerson() {
        return this.person;
    }

    @Override
    public String toString() {
        return this.person + " is responsible for " + this.name + "Department";
    }
}
