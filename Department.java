public class Department {
    private String name;
    private String person;

    // Adding Departments is now handeled by the Department Manager
    public Department(String name, String person) {
            this.name = name;
            this.person = person;
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
