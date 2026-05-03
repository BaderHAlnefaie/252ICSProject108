package DEPARTMENTS;
import java.io.FileInputStream;
import java.util.ArrayList;
import java.util.Scanner;

import MAINS.*;



public abstract class DepartmentsManager {
    private static ArrayList<Department> availableDepartments = addAllDepartments();

    // A function to add all the available Departments from the file
    static private ArrayList<Department> addAllDepartments() {
        ArrayList<Department> result = new ArrayList<>();
        try (Scanner fileScnr = new Scanner(new FileInputStream("Departments.txt"))) {
            while (fileScnr.hasNextLine()) {
                String raw = fileScnr.nextLine().trim();
                if (raw.isEmpty()) continue;
                String[] line = raw.split("\\s*,\\s*");
                result.add(new Department(line[0], line[1]));
            }
        } catch (Exception e) {
            System.out.println("File Not Found");
        }

        return result;
    }

        static public void addDepartment(Department department) throws ValidationException {
            for (Department dept : availableDepartments) {
                if (department.getName().toUpperCase().equals(dept.getName())) {
                    throw new ValidationException("Department Hasn't been Addd, A Department with the Same Name Already Exist");
                }
            }
            availableDepartments.add(department);
        }

    public static void showDepartments() {
        int i = 1;
        for (Department dept : availableDepartments) {
            System.out.println((i++) + ". " + dept.getName());
        }
    }

    public static Department departmentSelection(int selection) throws ValidationException {
        if (selection < 1 || selection > availableDepartments.size()) {
            throw new ValidationException("Selection must be from 1 to " + availableDepartments.size() + ", Try Again");
        }
        return availableDepartments.get(selection - 1);
    }

    // This Method returns the Department based on the user input
    // If the the department does not exist it will throw a ValidationException
    // public static Department getDepartment(String name) throws ValidationException {
    //     for (Department dept : availableDepartments) {
    //         if (name.equals(dept.getName())) {
    //             return dept;
    //         }
    //     }
    //     throw new ValidationException("Department \"" + name + "\" was not found, Choose Another Department");
    // }

}   
