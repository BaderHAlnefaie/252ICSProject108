package MAINS;
import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Input {
    private static Scanner scnr = new Scanner(System.in);

    public static int nextInt() { return nextInt(""); } // OverLoading
    public static int nextInt(String msg) {
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

    public static String nextLine() { return nextLine(""); } // OverLoading
    public static String nextLine(String msg) {
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

    public static String next(){ return next(""); } // OverLoading
    public static String next(String msg) {
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
