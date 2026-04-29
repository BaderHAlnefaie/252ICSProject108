package MAINS;
import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Input {
    private static Scanner scnr = new Scanner(System.in);
    public static boolean showPrompts = true;

    public static void setSource(Scanner input) {
        scnr = input;
    }

    private static void prompt(String msg) {
        if (showPrompts) System.out.print(msg);
    }

    public static int nextInt() { return nextInt(""); } // OverLoading
    public static int nextInt(String msg) {
        prompt(msg);
        while (true) {
            try {
                return scnr.nextInt();
            } catch(InputMismatchException e) {
                System.out.println("Invalid Value, You Must Enter an Integer, Try Again");
                prompt(msg);
            } catch(Exception e) {
                System.out.print("Something Went Wrong, Try Again");
                prompt(msg);
            } finally {
                scnr.nextLine();
            }
        }
    }

    public static String nextLine() { return nextLine(""); } // OverLoading
    public static String nextLine(String msg) {
        prompt(msg);
        while (true) {
            try {
                return scnr.nextLine();
            } catch(Exception e) {
                scnr.nextLine();
                System.out.println("Invalid Value, Try Again");
                prompt(msg);
            }
        }
    }

    public static String next(){ return next(""); } // OverLoading
    public static String next(String msg) {
        prompt(msg);
        while (true) {
            try {
                return scnr.next();
            } catch(Exception e) {
                scnr.nextLine();
                System.out.println("Invalid Value, Try Again");
                prompt(msg);
            }
        }
    }
}
