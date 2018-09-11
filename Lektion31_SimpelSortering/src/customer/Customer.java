package customer;

import java.util.ArrayList;
import java.util.Collections;

public class Customer implements Comparable<Customer> {
    private String lastName;
    private String firstName;
    private int age;

    public static void selectionSort(ArrayList<Customer> customers) {
        for (int i = 0; i < customers.size(); i++) {
            Customer low = customers.get(i);
            int lowIndex = i;
            for (int j = 0; j < customers.size(); j++) {
                if (low.compareTo(customers.get(j)) < 0) {
                    low = customers.get(j);
                    lowIndex = j;
                }
            }
            Collections.swap(customers, lowIndex, i);
        }
    }

    public Customer(String lastName, String firstName, int age) {
        this.lastName = lastName;
        this.firstName = firstName;
        this.age = age;
    }

    @Override
    public int compareTo(Customer customer) {
        if (lastName.equals(customer.getLastName())) {
            return firstName.compareTo(customer.getFirstName());
        } else {
            return lastName.compareTo(customer.getLastName());
        }
    }

    public int getAge() {
        return age;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFirstName() {
        return firstName;
    }

    @Override
    public String toString() {
        return lastName + " " + firstName + " " + age;
    }
}
