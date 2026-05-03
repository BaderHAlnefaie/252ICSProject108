package MAINS;
// import java.util.InputMismatchException;
import java.util.Scanner;

public abstract class Input {
    private static Scanner scnr = new Scanner(System.in);
    public static boolean showPrompts = true;

    public static void setSource(Scanner input) {
        scnr.close();
        scnr = input;
    }

    private static void prompt(String msg) {
        if (showPrompts) System.out.print(msg);
    }

    public static int nextInt() throws CancelationException { return nextInt(""); } // OverLoading
    public static int nextInt(String msg) throws CancelationException {
        prompt(msg);
        while (true) {
            String text = scnr.next();
            if (text.equals("CANCEL")) {
                throw new CancelationException();
            }
            try {
                return Integer.parseInt(text);
                // return scnr.nextInt();
            } catch(NumberFormatException e) {
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

    public static String nextLine() throws CancelationException { return nextLine(""); } // OverLoading
    public static String nextLine(String msg) throws CancelationException {
        prompt(msg);
        while (true) {
            String text = scnr.nextLine();
            if (text.equals("CANCEL")) {
                throw new CancelationException();
            }
            try {
                return text;
            } catch(Exception e) {
                scnr.nextLine();
                System.out.println("Invalid Value, Try Again");
                prompt(msg);
            }
        }
    }

    public static String next() throws CancelationException { return next(""); } // OverLoading
    public static String next(String msg) throws CancelationException {
        prompt(msg);
        while (true) {
            String text = scnr.next();
            if (text.equals("CANCEL")) {
                throw new CancelationException();
            }
            try {
                return text;
            } catch(Exception e) {
                scnr.nextLine();
                System.out.println("Invalid Value, Try Again");
                prompt(msg);
            }
        }
    }
}
