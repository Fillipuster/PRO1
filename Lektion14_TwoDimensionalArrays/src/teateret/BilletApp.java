package teateret;

import java.util.Scanner;

public class BilletApp {

    private static Scanner scanner;
    private static String input;

    public static void main(String[] args) {
        TeaterSal sal = new TeaterSal(20, 7);
        sal.generatePrices();
        int[][] salSeats = sal.getSeats();

        scanner = new Scanner(System.in);

        sal.printSal();

        System.out.println();
        System.out.println("Velkommet til NetBillet. Ønsker du at vælge efter pris eller plads?");
        System.out.println("(skriv 'PRIS' eller 'PLADS')");
        System.out.println();

        input = scanner.next();
        if (input.equalsIgnoreCase("plads")) {
            System.out.println("Du har valgt at vælge efter plads.");
            System.out.println("Hvilken række ønskes?");
            int selectedRow = scanner.nextInt();
            if (selectedRow < 1 || selectedRow > sal.getRows()) {
                System.out.println("Så mange pldaser har vi ikke! #000");
            }

            System.out.println("Hvilken plads ønsker de?");
            int selectedColumn = scanner.nextInt();
            if (selectedColumn < 1 || selectedColumn > sal.getColumns()) {
                System.out.println("Så mange pladser har vi ikke! #001");
            }

            System.out.println("Du har valgt række " + selectedRow + ", plads " + selectedColumn);
            if (salSeats[selectedRow - 1][selectedColumn - 1] == 0) {
                System.out.println("Pladsen er optaget. Vi beklager.");
            } else {
                System.out.println("Pris: " + salSeats[selectedRow - 1][selectedColumn - 1]);
            }
        } else {
            System.out.println("Du har valgt at vælge efter pris.");
        }
    }

}
