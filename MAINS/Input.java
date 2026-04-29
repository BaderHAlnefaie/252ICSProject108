package MAINS;
import java.util.InputMismatchException;
import java.util.Scanner;

public class Input {
    private Scanner scnr;

    // Constructor
    public Input(Scanner input) {
        this.scnr = input;
    }

    public int nextInt() { return nextInt(""); } // OverLoading
    public int nextInt(String msg) {
        System.out.print(msg);
        while (true) {
            try {
                return scnr.nextInt();
            } catch(InputMismatchException e) {
                System.out.println("Invalid Value, You Must Enter an Integer, Try Again");
                System.out.print(msg);
            } catch(Exception e) {
                System.out.print("Something Went Wrong, Try Again");
                System.out.print(msg);
            } finally {
                scnr.nextLine();
            }
        }
    }

    public String nextLine() { return nextLine(""); } // OverLoading
    public String nextLine(String msg) {
        System.out.print(msg);
        while (true) {
            try {
                return scnr.nextLine();
            } catch(Exception e) {
                scnr.nextLine();
                System.out.println("Invalid Value, Try Again");
                System.out.print(msg);
            }
        }
    }

    public String next(){ return next(""); } // OverLoading
    public String next(String msg) {
        System.out.print(msg);
        while (true) {
            try {
                return scnr.next();
            } catch(Exception e) {
                scnr.nextLine();
                System.out.println("Invalid Value, Try Again");
                System.out.print(msg);
            }
        }
    }
}
