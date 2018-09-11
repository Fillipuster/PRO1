package customer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

public class CustomerTest {

    public static <T> void printArray(T[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i] + ", ");
        }
        System.out.println();
    }

    public static void insertCustomer1(ArrayList<Customer> customers, Customer customer) {
        for (int i = 0; i < customers.size(); i++) {
            if (customer.compareTo(customers.get(i)) < 0) {
                customers.add(i, customer);
                return;
            }
        }

        customers.add(customer);
    }

    public static void insertCustomer2(Customer[] customers, Customer customer) {
        for (int i = customers.length - 1; i >= 0; i--) {
            if (customers[i] == null) {
                continue;
            }

            // Compare the index with the target.
            int comp = customers[i].compareTo(customer);
            System.out.println(i + ": " + comp);

            // Move the key up.
            customers[i + 1] = customers[i];

            // Check the comparison.
            if (comp < 0) {
                // Insert
                customers[i] = customer;
                return;
            }
        }

        customers[0] = customer;
    }

    public static void main(String[] args) {
        ArrayList<Customer> customers = new ArrayList<>();

        customers.add(new Customer("Andersen", "Jonas", 21));
        customers.add(new Customer("Benson", "Kennet", 25));
        customers.add(new Customer("Charleston", "Frederik", 27));
        customers.add(new Customer("Dalton", "Tom", 23));
        customers.add(new Customer("Effigy", "Alexander", 22));
        customers.add(new Customer("Gidion", "Kent", 69));

        Collections.sort(customers);

        Customer[] custArr = new Customer[customers.size() + 3];
        customers.toArray(custArr);

        System.out.println("Sorted ArrayList:");
        System.out.println(customers + "\n");

        // Opgave 1
        System.out.println("Inserting Customer...\n");
        Customer c = new Customer("Bols", "Anders", 42);
        insertCustomer1(customers, c);

        System.out.println("New ArrayList:");
        System.out.println(customers + "\n");

        System.out.println("\n-------------------ARRAY-------------------\n");

        // Opgave 2
        System.out.println("Sorted Array:");
        printArray(custArr);
        System.out.println();

        System.out.println("Inserting Customer...\n");
        insertCustomer2(custArr, c);

        System.out.println("New Array:");
        printArray(custArr);
    }

}
