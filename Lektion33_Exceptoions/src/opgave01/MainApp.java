package opgave01;

import java.util.InputMismatchException;
import java.util.Scanner;

public class MainApp {

    public static void main(String[] args) {
        int[] prim = { 2, 3, 5, 7, 11, 13, 17, 19, 23, 29 };
        try (Scanner scan = new Scanner(System.in)) {
            System.out.print("Hvilket nr. primtal skal vises?: ");
            int n = scan.nextInt();
            System.out.println("Primtal nr." + n + " er " + prim[n - 1] + "\n");
        } catch (ArrayIndexOutOfBoundsException e) {
            System.out.println("Tallet skal være mellem 1 og 10!");
        } catch (InputMismatchException e) {
            System.out.println("Vi skal bruge et tal.");
        }
    }

}
