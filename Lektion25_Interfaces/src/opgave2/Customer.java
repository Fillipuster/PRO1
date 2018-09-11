package opgave2;

import java.util.Arrays;

public class Customer implements Comparable<Customer> {

    private String firstname, lastname;
    private int age;

    public Customer(String firstname, String lastname, int age) {
        setFirstname(firstname);
        setLastname(lastname);
        setAge(age);
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return lastname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public int compareTo(Customer c) {
        int comparisonLastName = lastname.compareToIgnoreCase(c.getLastname());

        if (comparisonLastName == 0) {
            int comparisonFirstName = firstname.compareToIgnoreCase(c.getFirstname());

            if (comparisonFirstName == 0) {
                return age - c.getAge();
            } else {
                return comparisonFirstName;
            }
        } else {
            return comparisonLastName;
        }
    }

    @Override
    public String toString() {
        return lastname + ", " + firstname + " (" + age + ")";
    }

    public static Customer lastCustomer(Customer[] customers) {
        Customer[] sorted = customers.clone();
        Arrays.sort(sorted);

        return sorted[sorted.length - 1];
    }

    public static Customer[] afterCustomer(Customer[] customers, Customer customer) {
        Customer[] sorted = customers.clone();
        Arrays.sort(sorted);

        int after = 0;
        for (int i = 0; i < sorted.length; i++) {
            if (sorted[i].equals(customer)) {
                after = i;
                break; // "Grimt"
            }
        }

        return Arrays.copyOfRange(sorted, after, sorted.length);
    }

}
