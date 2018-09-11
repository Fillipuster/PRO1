package customer;

import java.util.ArrayList;

public class CustomerTest {

    public static void main(String[] args) {
        ArrayList<Customer> customers = new ArrayList<>();
        customers.add(new Customer("Præstegaard", "Jonas", 21));
        customers.add(new Customer("Neiberg", "Kennet", 25));
        customers.add(new Customer("Sloth", "Frederik", 27));
        customers.add(new Customer("Steinmeier", "Tom", 23));
        customers.add(new Customer("Skou", "Alexander", 22));

        System.out.println(customers);
        Customer.selectionSort(customers);
        System.out.println(customers);
    }

}
