package opgave2;

import java.util.Random;

public class MainApp {

    public static String[] firstnames = { "Jonas", "Kennet", "Alan", "Alexander", "Bent", "Morten", "Peter", "Emil",
            "Ellen", "Torben", "Daniel", "Åse" };
    public static String[] lastnames = { "Madsen", "Jensen", "Petersen", "Andsen", "Markvej", "Mortensen", "Klausen",
            "Damgaard", "Præstegaard", "Brønholt", "Najbjerg", "Philbert", "Mohammad", "Zeeborg" };
    public static Random random = new Random();

    public static void main(String[] args) {
        Customer[] customers = new Customer[100];

        for (int i = 0; i < customers.length; i++) {
            customers[i] = new Customer(firstnames[random.nextInt(firstnames.length - 1)],
                    lastnames[random.nextInt(lastnames.length - 1)], random.nextInt(102) + 18);
        }

        for (int i = 0; i < customers.length; i++) {
            System.out.println(customers[i].toString());
        }

        System.out.println();
        System.out.println(Customer.lastCustomer(customers));

        System.out.println();
        for (Customer c : Customer.afterCustomer(customers, customers[0])) {
            System.out.println(c.toString());
        }
    }

}
