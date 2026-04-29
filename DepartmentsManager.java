import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

public abstract class DepartmentsManager {
    public static ArrayList<Department> availableDepartments = addAllDepartments();

    // A function to add all the available Departments
    static private ArrayList<Department> addAllDepartments() {
        ArrayList<Department> result = new ArrayList<>();
        try (Scanner fileScnr = new Scanner(new FileInputStream("Departments.txt"))) {
            while (fileScnr.hasNextLine()) {
                String[] line = fileScnr.nextLine().split(",");
                result.add(new Department(line[0], line[1]));
            }
        } catch (Exception e) {
            System.out.println("File Not Found");
        }

        return result;
    }

    // This Method returns the Department based on the user input
    // If the the department does not exist it will throw a ValidationException
    public static Department getDepartment(String name) throws ValidationException {
        for (Department dept : availableDepartments) {
            if (name.equals(dept.getName())) {
                return dept;
            }
        }
        throw new ValidationException("Department \"" + name + "\" was not found, Choose Another Department");
    }
    // Example:
    // Enter the name of the department: ICS (In the Main class)
    // This will return the ICS Department (of Type Department)
    // If the user input was "xyz" it will throw an Exception
    // Important: the Exception must be handeled in the main class
}   
